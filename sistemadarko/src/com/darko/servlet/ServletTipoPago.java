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

import com.darko.model.TipoPago;
import com.darko.service.ServiceTipoPago;
import com.darko.serviceImpl.ServiceImplTipoPago;

public class ServletTipoPago extends HttpServlet {
	private final static long serialVersionUID = 1L;
		
	public void doGet(HttpServletRequest req, HttpServletResponse res){
		try {			
			ServiceTipoPago service = ServiceImplTipoPago.getInstance();
			List<TipoPago> lista = new ArrayList<TipoPago>();
			lista = service.lista();			
			req.setAttribute("listapagos", lista);
			ServletContext sc = getServletContext();
			sc.getRequestDispatcher("/WEB-INF/config/tipospago.jsp").forward(req, res);
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
			ServiceTipoPago service = ServiceImplTipoPago.getInstance();
			TipoPago pago = new TipoPago();
			String control = req.getParameter("control");
			
			if(control.equalsIgnoreCase("eliminar")){
				pago.setIdtipopago(Integer.parseInt(req.getParameter("idpago")));
				service.eliminar(pago);
				out.println("{\"respuesta\":\"Eliminado correctamente\"}");
			}else{			
				pago.setNombre(req.getParameter("txtpago_desc"));
				pago.setObservacion(req.getParameter("txtpago_obs"));
				pago.setDefecto(Integer.parseInt(req.getParameter("txtpago_defecto")));				
				if(control.equalsIgnoreCase("nuevo")){				
					int idnew = service.registrar(pago);
					out.println("{\"control\":\"nuevo\",\"id\":\""+idnew+"\",\"nombre\":\""+pago.getNombre()+"\",\"observacion\":\""+pago.getObservacion()+"\",\"defecto\":\""+pago.getDefecto()+"\"}");
				}else if(control.equalsIgnoreCase("modificar")){
					pago.setIdtipopago(Integer.parseInt(req.getParameter("idpago")));
					service.actualizar(pago);
					out.println("{\"control\":\"modificar\",\"id\":\""+pago.getIdtipopago()+"\",\"nombre\":\""+pago.getNombre()+"\",\"observacion\":\""+pago.getObservacion()+"\",\"defecto\":\""+pago.getDefecto()+"\"}");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
