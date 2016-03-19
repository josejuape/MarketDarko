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

import com.darko.model.EstadoVenta;
import com.darko.service.ServiceEstadoVenta;
import com.darko.serviceImpl.ServiceImplEstadoVenta;

public class ServletEstadoVenta extends HttpServlet {
	private final static long serialVersionUID = 1L;
		
	public void doGet(HttpServletRequest req, HttpServletResponse res){
		try {			
			ServiceEstadoVenta service = ServiceImplEstadoVenta.getInstance();
			List<EstadoVenta> lista = new ArrayList<EstadoVenta>();
			lista = service.lista();			
			req.setAttribute("listaestados", lista);
			ServletContext sc = getServletContext();
			sc.getRequestDispatcher("/WEB-INF/config/estadoventa.jsp").forward(req, res);
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
			ServiceEstadoVenta service = ServiceImplEstadoVenta.getInstance();
			EstadoVenta estadoventa = new EstadoVenta();
			String control = req.getParameter("control");
			
			if(control.equalsIgnoreCase("eliminar")){
				estadoventa.setIdestadoventa(Integer.parseInt(req.getParameter("idestado")));
				service.eliminar(estadoventa);
				out.println("{\"respuesta\":\"Eliminado correctamente\"}");
			}else{			
				estadoventa.setNombre(req.getParameter("txtestado_desc"));
				estadoventa.setObservacion(req.getParameter("txtestado_obs"));
				estadoventa.setDefecto(Integer.parseInt(req.getParameter("txtestado_defecto")));				
				if(control.equalsIgnoreCase("nuevo")){				
					int idnew = service.registrar(estadoventa);
					out.println("{\"control\":\"nuevo\",\"id\":\""+idnew+"\",\"nombre\":\""+estadoventa.getNombre()+"\",\"observacion\":\""+estadoventa.getObservacion()+"\",\"defecto\":\""+estadoventa.getDefecto()+"\"}");
				}else if(control.equalsIgnoreCase("modificar")){
					estadoventa.setIdestadoventa(Integer.parseInt(req.getParameter("idestado")));
					service.actualizar(estadoventa);
					out.println("{\"control\":\"modificar\",\"id\":\""+estadoventa.getIdestadoventa()+"\",\"nombre\":\""+estadoventa.getNombre()+"\",\"observacion\":\""+estadoventa.getObservacion()+"\",\"defecto\":\""+estadoventa.getDefecto()+"\"}");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
