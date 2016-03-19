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

import com.darko.model.Color;
import com.darko.model.Marca;
import com.darko.model.Modelo;
import com.darko.service.ServiceColor;
import com.darko.service.ServiceMarca;
import com.darko.service.ServiceModelo;
import com.darko.serviceImpl.ServiceImplColor;
import com.darko.serviceImpl.ServiceImplMarca;
import com.darko.serviceImpl.ServiceImplModelo;

public class ServletColor extends HttpServlet {
	private final static long serialVersionUID = 1L;
		
	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		try {
			if(req.getParameter("listar") != null){
				res.setContentType("application/x-json;charset=UTF-8");
				PrintWriter out = res.getWriter();
				ServiceColor service = ServiceImplColor.getInstance();
				List<Color> lista = new ArrayList<Color>();			
				Marca marca = new Marca();
				marca.setIdmarca(Integer.parseInt(req.getParameter("marca")));
				lista = service.getColores(marca);
				String c ="";
				for (Color color : lista) {
					c=c+"<option value='"+color.getIdcolor()+"'>"+color.getNombre()+"</option>";
				}
				out.println("{\"opciones\":\""+c+"\"}");
				out.close(); 
			}else{
				ServiceColor service = ServiceImplColor.getInstance();
				List<Color> lista = new ArrayList<Color>();
				lista = service.lista();			
				req.setAttribute("listacolores", lista);
				ServiceMarca servicemar = ServiceImplMarca.getInstance();
				List<Marca> listamarcas = new ArrayList<Marca>();
				listamarcas = servicemar.lista();			
				req.setAttribute("listamarcas", listamarcas);
				ServletContext sc = getServletContext();
				sc.getRequestDispatcher("/WEB-INF/config/color.jsp").forward(req, res);
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
			ServiceColor service = ServiceImplColor.getInstance();
			Marca marca = new Marca();
			Color color = new Color();
			String control = req.getParameter("control");
			
			if(control.equalsIgnoreCase("eliminar")){
				color.setIdcolor(Integer.parseInt(req.getParameter("idcolor")));
				service.eliminar(color);
				out.println("{\"respuesta\":\"Eliminado correctamente\"}");
			}else{			
				color.setNombre(req.getParameter("txtcolor_desc"));
				color.setObservacion(req.getParameter("txtcolor_obs"));
				marca.setIdmarca(Integer.parseInt(req.getParameter("cbomarca")));
				marca.setNombre(req.getParameter("marca"));
				color.setMarca(marca);				
				if(control.equalsIgnoreCase("nuevo")){				
					int idnew = service.registrar(color);
					out.println("{\"control\":\"nuevo\",\"id\":\""+idnew+"\",\"nombre\":\""+color.getNombre()+"\",\"observacion\":\""+color.getObservacion()+"\",\"idmarca\":\""+color.getMarca().getIdmarca()+"\",\"marca\":\""+color.getMarca().getNombre()+"\"}");
				}else if(control.equalsIgnoreCase("modificar")){
					color.setIdcolor(Integer.parseInt(req.getParameter("idcolor")));
					service.actualizar(color);
					out.println("{\"control\":\"modificar\",\"id\":\""+color.getIdcolor()+"\",\"nombre\":\""+color.getNombre()+"\",\"observacion\":\""+color.getObservacion()+"\",\"idmarca\":\""+color.getMarca().getIdmarca()+"\",\"marca\":\""+color.getMarca().getNombre()+"\"}");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
