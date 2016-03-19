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
import com.darko.service.ServiceCategoria;
import com.darko.service.ServiceMarca;
import com.darko.serviceImpl.ServiceImplCategoria;
import com.darko.serviceImpl.ServiceImplMarca;

public class ServletMarca extends HttpServlet {
	private final static long serialVersionUID = 1L;
			
	public void doGet(HttpServletRequest req, HttpServletResponse res){
		try {	
			if(req.getParameter("listar") != null){
				res.setContentType("application/x-json;charset=UTF-8");
				PrintWriter out = res.getWriter();
				ServiceMarca service = ServiceImplMarca.getInstance();
				List<Marca> lista = new ArrayList<Marca>();
				Categoria categoria = new Categoria();
				categoria.setIdcategoria(Integer.parseInt(req.getParameter("categoria")));
				lista = service.getMarcas(categoria);
				String c ="";
				for (Marca marca : lista) {
					c=c+"<option value='"+marca.getIdmarca()+"'>"+marca.getNombre()+"</option>";
				}
				out.println("{\"opciones\":\""+c+"\"}");
				out.close(); 
			}else{
				System.out.println("Ingreso aqui..");
				ServiceMarca service = ServiceImplMarca.getInstance();
				List<Marca> lista = new ArrayList<Marca>();
				lista = service.lista();			
				req.setAttribute("listamarcas", lista);
				ServletContext sc = getServletContext();
				sc.getRequestDispatcher("/WEB-INF/config/marca.jsp").forward(req, res);
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
			ServiceMarca service = ServiceImplMarca.getInstance();
			Marca marca = new Marca();
			String control = req.getParameter("control");
			
			if(control.equalsIgnoreCase("eliminar")){
				marca.setIdmarca(Integer.parseInt(req.getParameter("idmarca")));
				service.eliminar(marca);
				out.println("{\"respuesta\":\"Eliminado correctamente\"}");
			}else{			
				marca.setNombre(req.getParameter("txtmarca_desc"));
				marca.setObservacion(req.getParameter("txtmarca_obs"));				
				if(control.equalsIgnoreCase("nuevo")){				
					int idnew = service.registrar(marca);
					out.println("{\"control\":\"nuevo\",\"id\":\""+idnew+"\",\"nombre\":\""+marca.getNombre()+"\",\"observacion\":\""+marca.getObservacion()+"\"}");
				}else if(control.equalsIgnoreCase("modificar")){
					marca.setIdmarca(Integer.parseInt(req.getParameter("idmarca")));
					service.actualizar(marca);
					out.println("{\"control\":\"modificar\",\"id\":\""+marca.getIdmarca()+"\",\"nombre\":\""+marca.getNombre()+"\",\"observacion\":\""+marca.getObservacion()+"\"}");
				}
			}
			 out.close(); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
