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

import com.darko.model.Ubicacion;
import com.darko.service.ServiceUbicacion;
import com.darko.serviceImpl.ServiceImplUbicacion;

public class ServletUbicacion extends HttpServlet {
	private final static long serialVersionUID = 1L;
		
	public void doGet(HttpServletRequest req, HttpServletResponse res){
		try {			
			ServiceUbicacion service = ServiceImplUbicacion.getInstance();
			List<Ubicacion> lista = new ArrayList<Ubicacion>();
			lista = service.lista();			
			req.setAttribute("listaubicaciones", lista);
			ServletContext sc = getServletContext();
			sc.getRequestDispatcher("/WEB-INF/config/ubicacion.jsp").forward(req, res);
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
			ServiceUbicacion service = ServiceImplUbicacion.getInstance();
			Ubicacion ubicacion = new Ubicacion();
			String control = req.getParameter("control");
			
			if(control.equalsIgnoreCase("eliminar")){
				ubicacion.setIdubicacion(Integer.parseInt(req.getParameter("idubicacion")));
				service.eliminar(ubicacion);
				out.println("{\"respuesta\":\"Eliminado correctamente\"}");
			}else{			
				ubicacion.setNombre(req.getParameter("txtubicacion_desc"));
				ubicacion.setObservacion(req.getParameter("txtubicacion_obs"));
				ubicacion.setDefecto(Integer.parseInt(req.getParameter("txtubicacion_defecto")));				
				if(control.equalsIgnoreCase("nuevo")){				
					int idnew = service.registrar(ubicacion);
					out.println("{\"control\":\"nuevo\",\"id\":\""+idnew+"\",\"nombre\":\""+ubicacion.getNombre()+"\",\"observacion\":\""+ubicacion.getObservacion()+"\",\"defecto\":\""+ubicacion.getDefecto()+"\"}");
				}else if(control.equalsIgnoreCase("modificar")){
					ubicacion.setIdubicacion(Integer.parseInt(req.getParameter("idubicacion")));
					service.actualizar(ubicacion);
					out.println("{\"control\":\"modificar\",\"id\":\""+ubicacion.getIdubicacion()+"\",\"nombre\":\""+ubicacion.getNombre()+"\",\"observacion\":\""+ubicacion.getObservacion()+"\",\"defecto\":\""+ubicacion.getDefecto()+"\"}");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
