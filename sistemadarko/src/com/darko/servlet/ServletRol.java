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

import com.darko.model.Rol;
import com.darko.service.ServiceRol;
import com.darko.serviceImpl.ServiceImplRol;

public class ServletRol extends HttpServlet {
	private final static long serialVersionUID = 1L;
			
	public void doGet(HttpServletRequest req, HttpServletResponse res){
		try {					
			ServiceRol service = ServiceImplRol.getInstance();
			List<Rol> lista = new ArrayList<Rol>();
			lista = service.lista();			
			req.setAttribute("listaroles", lista);
			ServletContext sc = getServletContext();
			sc.getRequestDispatcher("/WEB-INF/seguridad/roles.jsp").forward(req, res);
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
			ServiceRol service = ServiceImplRol.getInstance();
			Rol rol = new Rol();
			String control = req.getParameter("control");
			
			if(control.equalsIgnoreCase("eliminar")){
				rol.setIdrol(Integer.parseInt(req.getParameter("idrol")));
				service.eliminar(rol);
				out.println("{\"respuesta\":\"Eliminado correctamente\"}");
			}else{			
				rol.setDesc_rol(req.getParameter("txtrol_desc"));
				rol.setObs_rol(req.getParameter("txtrol_obs"));
				
				if(control.equalsIgnoreCase("nuevo")){				
					int idnew = service.registrar(rol);
					out.println("{\"control\":\"nuevo\",\"id\":\""+idnew+"\",\"desc\":\""+rol.getDesc_rol()+"\",\"obs\":\""+rol.getObs_rol()+"\"}");
				}else if(control.equalsIgnoreCase("modificar")){
					rol.setIdrol(Integer.parseInt(req.getParameter("idrol")));
					service.actualizar(rol);
					out.println("{\"control\":\"modificar\",\"id\":\""+rol.getIdrol()+"\",\"desc\":\""+rol.getDesc_rol()+"\",\"obs\":\""+rol.getObs_rol()+"\"}");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
