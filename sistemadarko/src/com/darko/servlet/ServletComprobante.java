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

import com.darko.model.Comprobante;
import com.darko.service.ServiceComprobante;
import com.darko.serviceImpl.ServiceImplComprobante;

public class ServletComprobante extends HttpServlet {
	private final static long serialVersionUID = 1L;
		
	public void doGet(HttpServletRequest req, HttpServletResponse res){
		try {			
			ServiceComprobante service = ServiceImplComprobante.getInstance();
			List<Comprobante> lista = new ArrayList<Comprobante>();
			lista = service.lista();			
			req.setAttribute("listacomprobantes", lista);
			ServletContext sc = getServletContext();
			sc.getRequestDispatcher("/WEB-INF/config/comprobante.jsp").forward(req, res);
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
			ServiceComprobante service = ServiceImplComprobante.getInstance();
			Comprobante comprobante = new Comprobante();
			String control = req.getParameter("control");
			
			if(control.equalsIgnoreCase("eliminar")){
				comprobante.setIdcomprobante(Integer.parseInt(req.getParameter("idcomprobante")));
				service.eliminar(comprobante);
				out.println("{\"respuesta\":\"Eliminado correctamente\"}");
			}else{			
				comprobante.setNombre(req.getParameter("txtcomprobante_desc"));
				comprobante.setObservacion(req.getParameter("txtcomprobante_obs"));
				comprobante.setDefecto(Integer.parseInt(req.getParameter("txtcomprobante_defecto")));				
				if(control.equalsIgnoreCase("nuevo")){				
					int idnew = service.registrar(comprobante);
					out.println("{\"control\":\"nuevo\",\"id\":\""+idnew+"\",\"nombre\":\""+comprobante.getNombre()+"\",\"observacion\":\""+comprobante.getObservacion()+"\",\"defecto\":\""+comprobante.getDefecto()+"\"}");
				}else if(control.equalsIgnoreCase("modificar")){
					comprobante.setIdcomprobante(Integer.parseInt(req.getParameter("idcomprobante")));
					service.actualizar(comprobante);
					out.println("{\"control\":\"modificar\",\"id\":\""+comprobante.getIdcomprobante()+"\",\"nombre\":\""+comprobante.getNombre()+"\",\"observacion\":\""+comprobante.getObservacion()+"\",\"defecto\":\""+comprobante.getDefecto()+"\"}");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
