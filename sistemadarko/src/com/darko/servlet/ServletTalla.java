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
import com.darko.model.Talla;
import com.darko.service.ServiceCategoria;
import com.darko.service.ServiceTalla;
import com.darko.serviceImpl.ServiceImplCategoria;
import com.darko.serviceImpl.ServiceImplTalla;

public class ServletTalla extends HttpServlet {
	private final static long serialVersionUID = 1L;
		
	public void doGet(HttpServletRequest req, HttpServletResponse res){
		try {				
			ServiceCategoria servicecat = ServiceImplCategoria.getInstance();
			List<Categoria> listacat = new ArrayList<Categoria>();
			listacat = servicecat.lista();			
			req.setAttribute("listacategorias", listacat);
			ServiceTalla service = ServiceImplTalla.getInstance();
			List<Talla> lista = new ArrayList<Talla>();
			lista = service.lista();			
			req.setAttribute("listatallas", lista);
			ServletContext sc = getServletContext();
			sc.getRequestDispatcher("/WEB-INF/config/talla.jsp").forward(req, res);
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
			ServiceTalla service = ServiceImplTalla.getInstance();
			Talla talla = new Talla();
			String control = req.getParameter("control");
			
			if(control.equalsIgnoreCase("eliminar")){
				talla.setIdtalla(Integer.parseInt(req.getParameter("idtalla")));
				service.eliminar(talla);
				out.println("{\"respuesta\":\"Eliminado correctamente\"}");
			}else{			
				talla.setNombre(req.getParameter("txttalla_desc"));
				talla.setObservacion(req.getParameter("txttalla_obs"));
				talla.setDefecto(Integer.parseInt(req.getParameter("txttalla_defecto")));
				Categoria cat = new Categoria();
				cat.setIdcategoria(Integer.parseInt(req.getParameter("idcategoria")));
				cat.setNombre(req.getParameter("categoria"));
				talla.setCategoria(cat);
				if(control.equalsIgnoreCase("nuevo")){				
					int idnew = service.registrar(talla);
					out.println("{\"control\":\"nuevo\",\"id\":\""+idnew+"\",\"nombre\":\""+talla.getNombre()+"\",\"observacion\":\""+talla.getObservacion()+"\",\"defecto\":\""+talla.getDefecto()+"\",\"idcategoria\":\""+cat.getIdcategoria()+"\",\"categoria\":\""+cat.getNombre()+"\"}");
				}else if(control.equalsIgnoreCase("modificar")){
					talla.setIdtalla(Integer.parseInt(req.getParameter("idtalla")));
					service.actualizar(talla);
					out.println("{\"control\":\"modificar\",\"id\":\""+talla.getIdtalla()+"\",\"nombre\":\""+talla.getNombre()+"\",\"observacion\":\""+talla.getObservacion()+"\",\"defecto\":\""+talla.getDefecto()+"\",\"idcategoria\":\""+cat.getIdcategoria()+"\",\"categoria\":\""+cat.getNombre()+"\"}");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
