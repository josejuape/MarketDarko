package com.darko.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.darko.model.Categoria;
import com.darko.model.Marca;
import com.darko.model.Modelo;
import com.darko.model.Producto;
import com.darko.service.ServiceCategoria;
import com.darko.service.ServiceMarca;
import com.darko.service.ServiceModelo;
import com.darko.service.ServiceProducto;
import com.darko.serviceImpl.ServiceImplCategoria;
import com.darko.serviceImpl.ServiceImplMarca;
import com.darko.serviceImpl.ServiceImplModelo;
import com.darko.serviceImpl.ServiceImplProducto;

public class ServletModelo extends HttpServlet {
	private final static long serialVersionUID = 1L;
		
	public void doGet(HttpServletRequest req, HttpServletResponse res){
		try {		
			if(req.getParameter("listar") != null){
				res.setContentType("application/x-json;charset=UTF-8");
				PrintWriter out = res.getWriter();
				ServiceModelo service = ServiceImplModelo.getInstance();
				List<Modelo> lista = new ArrayList<Modelo>();			
				Marca marca = new Marca();
				marca.setIdmarca(Integer.parseInt(req.getParameter("marca")));
				lista = service.getModelos(marca);
				String c ="";
				for (Modelo modelo : lista) {
					c=c+"<option value='"+modelo.getIdmodelo()+"'>"+modelo.getNombre()+"</option>";
				}
				out.println("{\"opciones\":\""+c+"\"}");
				out.close(); 
			}else{
				ServiceProducto service = ServiceImplProducto.getInstance();
				List<Producto> lista = new ArrayList<Producto>();
				lista = service.lista();			
				req.setAttribute("listaproductos", lista);
				// lista de marcas en el select
				ServiceMarca servicemar = ServiceImplMarca.getInstance();
				List<Marca> listamarcas = new ArrayList<Marca>();
				listamarcas = servicemar.lista();			
				req.setAttribute("listamarcas", listamarcas);
				// lista de categorias en el select
				ServiceCategoria servicecat = ServiceImplCategoria.getInstance();
				List<Categoria> listacategorias = new ArrayList<Categoria>();
				listacategorias = servicecat.lista();			
				req.setAttribute("listacategorias", listacategorias);
				
				ServletContext sc = getServletContext();
				sc.getRequestDispatcher("/WEB-INF/config/modelo.jsp").forward(req,res);
			}
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res){
		try {
			res.setContentType("application/x-json;charset=UTF-8");
			PrintWriter out = res.getWriter();
			ServiceModelo service = ServiceImplModelo.getInstance();
			ServiceProducto serviceprod = ServiceImplProducto.getInstance();
			Categoria categoria = new Categoria();
			Marca marca = new Marca();
			Modelo modelo = new Modelo();
			String control = req.getParameter("control");
			
			if(control.equalsIgnoreCase("eliminar")){
				modelo.setIdmodelo(Integer.parseInt(req.getParameter("idmodelo")));
				service.eliminar(modelo);
				Producto product = new Producto();
				product.setModelo(modelo);
				serviceprod.eliminar(product);
				out.println("{\"respuesta\":\"Eliminado correctamente\"}");
			}else{			
				modelo.setNombre(req.getParameter("txtmodelo_desc"));
				modelo.setObservacion(req.getParameter("txtmodelo_obs"));
				marca.setIdmarca(Integer.parseInt(req.getParameter("cbomarca")));
				marca.setNombre(req.getParameter("marca"));
				categoria.setIdcategoria(Integer.parseInt(req.getParameter("cbocategoria")));
				categoria.setNombre(req.getParameter("categoria"));	
				Producto producto = new Producto();
				producto.setNombre(categoria.getNombre()+"/ "+marca.getNombre()+"/ "+modelo.getNombre());				
				producto.setMarca(marca);
				producto.setCategoria(categoria);
				if(control.equalsIgnoreCase("nuevo")){				
					int idnew = service.registrar(modelo);
					modelo.setIdmodelo(idnew);
					producto.setModelo(modelo);
					int idpro = serviceprod.registrar(producto);
					out.println("{\"control\":\"nuevo\",\"id\":\""+idnew+"\",\"nombre\":\""+producto.getNombre()+"\",\"categoria\":\""+categoria.getIdcategoria()+"\",\"marca\":\""+marca.getIdmarca()+"\",\"modelo\":\""+modelo.getNombre()+"\",\"observacion\":\""+modelo.getObservacion()+"\"}");
				}else if(control.equalsIgnoreCase("modificar")){
					modelo.setIdmodelo(Integer.parseInt(req.getParameter("idmodelo")));
					service.actualizar(modelo);
					serviceprod.actualizar(producto);
					out.println("{\"control\":\"modificar\",\"id\":\""+modelo.getIdmodelo()+"\",\"nombre\":\""+producto.getNombre()+"\",\"categoria\":\""+categoria.getIdcategoria()+"\",\"marca\":\""+marca.getIdmarca()+"\",\"modelo\":\""+modelo.getNombre()+"\",\"observacion\":\""+modelo.getObservacion()+"\"}");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
