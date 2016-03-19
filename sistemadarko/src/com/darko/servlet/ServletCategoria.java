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
import com.darko.service.ServiceCategoria;
import com.darko.serviceImpl.ServiceImplCategoria;

public class ServletCategoria extends HttpServlet {
	private final static long serialVersionUID = 1L;
		
	public void doGet(HttpServletRequest req, HttpServletResponse res){
		try {			
			ServiceCategoria service = ServiceImplCategoria.getInstance();
			List<Categoria> lista = new ArrayList<Categoria>();
			lista = service.lista();			
			req.setAttribute("listacategorias", lista);
			ServletContext sc = getServletContext();
			sc.getRequestDispatcher("/WEB-INF/config/categoria.jsp").forward(req, res);
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
			ServiceCategoria service = ServiceImplCategoria.getInstance();
			Categoria cat = new Categoria();
			String control = req.getParameter("control");
			
			if(control.equalsIgnoreCase("eliminar")){
				cat.setIdcategoria(Integer.parseInt(req.getParameter("idcategoria")));
				service.eliminar(cat);
				out.println("{\"respuesta\":\"Eliminado correctamente\"}");
			}else{			
				cat.setNombre(req.getParameter("txtcat_desc"));
				cat.setObservacion(req.getParameter("txtcat_obs"));
				cat.setValor_flete(Double.parseDouble(req.getParameter("txtcat_valorflete")));				
				if(control.equalsIgnoreCase("nuevo")){				
					int idnew = service.registrar(cat);
					out.println("{\"control\":\"nuevo\",\"id\":\""+idnew+"\",\"nombre\":\""+cat.getNombre()+"\",\"observacion\":\""+cat.getObservacion()+"\",\"flete\":\""+cat.getValor_flete()+"\"}");
				}else if(control.equalsIgnoreCase("modificar")){
					cat.setIdcategoria(Integer.parseInt(req.getParameter("idcategoria")));
					service.actualizar(cat);
					out.println("{\"control\":\"modificar\",\"id\":\""+cat.getIdcategoria()+"\",\"nombre\":\""+cat.getNombre()+"\",\"observacion\":\""+cat.getObservacion()+"\",\"flete\":\""+cat.getValor_flete()+"\"}");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
