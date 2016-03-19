package com.darko.servlet;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.darko.model.Color;
import com.darko.model.DetalleColor;
import com.darko.model.DetalleTalla;
import com.darko.model.Inventario;
import com.darko.model.Producto;
import com.darko.model.Talla;
import com.darko.model.Tracking;
import com.darko.service.ServiceCompra;
import com.darko.service.ServiceProducto;
import com.darko.service.ServiceTracking;
import com.darko.serviceImpl.ServiceImplCompra;
import com.darko.serviceImpl.ServiceImplProducto;
import com.darko.serviceImpl.ServiceImplTracking;

public class ServletProducto extends HttpServlet {
	private final static long serialVersionUID = 1L;
	private ArrayList<Inventario> listaProductos = new ArrayList<Inventario>();
	private Inventario inventario;
	
	public void doGet(HttpServletRequest req, HttpServletResponse res){
		try {
			res.setContentType("application/x-json;charset=UTF-8");
			PrintWriter out = res.getWriter();
			ServiceProducto service = ServiceImplProducto.getInstance();
			if(req.getParameter("opcion")!= null && req.getParameter("opcion").equals("detalles")){
				// Objeto de inventario
				this.inventario = new Inventario();
				//listamos las tallas y colores relacionados al producto			
				Producto producto = new Producto();
				producto.setIdproducto(Integer.parseInt(req.getParameter("idproducto")));
				producto.setNombre(req.getParameter("producto"));
				this.inventario.setNombre(producto.getNombre());
				this.inventario.setProducto(producto);
				List<Talla> tallas = new ArrayList<Talla>();
				List<Color> colores = new ArrayList<Color>();
				tallas = service.tallasProducto(producto);
				colores = service.coloresProducto(producto);
				String resp_tallas ="";
				String resp_colores ="";
				for(Talla talla : tallas){
					resp_tallas = resp_tallas+"<span id='talla"+talla.getIdtalla()+"' class='itemdetalle' onclick='selectItemDetalle(&quot;talla&quot;,&quot;"+talla.getIdtalla()+"&quot;,&quot;"+talla.getNombre()+"&quot;)'>"+talla.getNombre()+" - "+talla.getObservacion()+"</span>";
				}
				for(Color color : colores){
					resp_colores = resp_colores+"<span id='color"+color.getIdcolor()+"' class='itemdetalle' onclick='selectItemDetalle(&quot;color&quot;,&quot;"+color.getIdcolor()+"&quot;,&quot;"+color.getNombre()+"&quot;)' >"+color.getNombre()+"</span>";
				}
				out.println("{\"tallas\":\""+resp_tallas+"\",\"colores\":\""+resp_colores+"\"}");
			}else{				
				List<Producto> lista = new ArrayList<Producto>();
				String nombre = req.getParameter("nombre");		
				System.out.print("producto: "+nombre);
				lista = service.buscar(nombre);
				String resp = "";
				for(Producto producto: lista ){
					resp = resp+"<li onclick='selectionItem(&quot;"+producto.getIdproducto()+"&quot;,&quot;"+producto.getNombre()+"&quot;)'>"+producto.getNombre()+"</li>";
				}
				out.println("{\"lista\":\""+resp+"\"}");
			}
			out.close(); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res){
		try{
			res.setContentType("application/x-json;charset=UTF-8");
			PrintWriter out = res.getWriter();
			String accion = req.getParameter("accion");
			if(accion.equals("addproducto")){
				double costo = Double.parseDouble(req.getParameter("costo"));
				int cantidad = Integer.parseInt(req.getParameter("cantidad"));
				double costoTotal = costo * cantidad;
				this.inventario.setCostoUnitario(costo);
				this.inventario.setCantidad(cantidad);
				this.inventario.setCostoTotal(costoTotal);
				this.listaProductos.add(this.inventario);
				String row = "<tr id='inv"+this.inventario.getProducto().getIdproducto()+"'><td class='td-center'>"+this.inventario.getCantidad()+"</td><td>"+this.inventario.getNombre()+"</td><td>";
				if(this.inventario.getTallas().size() == 0){
					row = row + " Ninguno ";
				}else{
					for(Talla talla:this.inventario.getTallas()){
						row = row + talla.getNombre() +", ";
					}
				}
				row = row + "</td><td>";
				if(this.inventario.getColores().size() == 0){
					row = row + " Ninguno ";
				}else{
					for(Color color:this.inventario.getColores()){
						row = row + color.getNombre() +", ";
					}
				}
				row = row + " </td><td class='td-center'>"+this.inventario.getCostoTotal()+"</td>"+
                            " <td class='td-center' style='width:40px;'><a href='javascript:quitarInventario(&quot;"+this.inventario.getProducto().getIdproducto()+"&quot;);'>"+
                            " <i class='menu-icon fa fa-times-circle'></i></a></td></row>";
				out.println("{\"row\":\""+row+"\"}");
			}else if(accion.equals("quitarproducto")){
				int idpro = Integer.parseInt(req.getParameter("id"));
				for(int i=0; i < this.listaProductos.size();i++){
					if(idpro == this.listaProductos.get(i).getProducto().getIdproducto()){
						this.listaProductos.remove(i);
						break;
					}
				}
				out.println("{\"success\":\"ok\"}");
			}else if(accion.equals("registrarcompra")){
				// Aqui se registra en la tabla inventario y tablas detalle_talla y detalle_color
				// tracking
				if(this.listaProductos.size() != 0){
					Tracking tracking = new Tracking();
					tracking.setSerie(req.getParameter("tracking"));
					tracking.setFecha(req.getParameter("fecha"));
					ServiceTracking service = ServiceImplTracking.getInstance();
					ServiceCompra servcompra = ServiceImplCompra.getInstance();
					int idtracking = service.registrar(tracking);
					tracking.setIdtracking(idtracking);
					for(Inventario inv: this.listaProductos){
						inv.setTracking(tracking);
						int idinventario =  servcompra.registrarInventario(inv);
						inv.setIdinventario(idinventario);
						// Registramos las tallas asignadas al producto
						for(Talla talla: inv.getTallas()){
							DetalleTalla dt = new DetalleTalla();
							dt.setNombre(talla.getNombre());
							dt.setEstado("Registrado");
							dt.setInventario(inv);
							dt.setTalla(talla);
							servcompra.registrarTallasProducto(dt);
						}
						// Registramos los colores asignados al producto
						for(Color color: inv.getColores()){
							DetalleColor dc = new DetalleColor();
							dc.setNombre(color.getNombre());
							dc.setEstado("Registrado");
							dc.setInventario(inv);
							dc.setColor(color);
							servcompra.registrarColoresProducto(dc);
						}
					}
					out.println("{\"success\":\"ok\"}");
				}else{
					out.println("{\"success\":\"error\"}");
				}
			}else{
				if(req.getParameter("tipo").equals("talla")){
					Talla talla = new Talla();
					talla.setIdtalla(Integer.parseInt(req.getParameter("id")));
					talla.setNombre(req.getParameter("nombre"));
					if(accion.equals("add")){
						this.inventario.getTallas().add(talla);
					}else if(accion.equals("quit")){
						ArrayList<Talla> lista = (ArrayList<Talla>)this.inventario.getTallas();
						for(int i=0;i < lista.size();i++){
							if(lista.get(i).getIdtalla() == talla.getIdtalla()){
								this.inventario.getTallas().remove(i);
								break;
							}
						}
					}
				}else if(req.getParameter("tipo").equals("color")){
					Color color = new Color();
					color.setIdcolor(Integer.parseInt(req.getParameter("id")));
					color.setNombre(req.getParameter("nombre"));
					if(accion.equals("add")){
						this.inventario.getColores().add(color);
					}else if(accion.equals("quit")){
						ArrayList<Color> lista = (ArrayList<Color>)this.inventario.getColores();
						for(int i=0;i < lista.size();i++){
							if(lista.get(i).getIdcolor() == color.getIdcolor()){
								this.inventario.getColores().remove(i);
								break;
							}
						}
					}
				}	
				out.println("{\"success\":\"ok\"}");
			}			
			out.close(); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
