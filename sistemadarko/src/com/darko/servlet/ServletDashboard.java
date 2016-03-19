package com.darko.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.darko.model.Categoria;
import com.darko.model.Menu;
import com.darko.model.Usuario;
import com.darko.service.ServiceCategoria;
import com.darko.service.ServiceUsuario;
import com.darko.serviceImpl.ServiceImplCategoria;
import com.darko.serviceImpl.ServiceImplUsuario;

public class ServletDashboard extends HttpServlet {
	private final static long serialVersionUID = 1L;
	
	public void processRequest(HttpServletRequest req, HttpServletResponse res){
		// codigo para cargar el cpanel
		
		try {
			Usuario user = (Usuario)req.getSession().getAttribute("usuario");
			//Obtener las opciones de menu del usuario
			ServiceCategoria servicecat = ServiceImplCategoria.getInstance();
			List<Categoria> listacat = new ArrayList<Categoria>();
			listacat = servicecat.lista();			
			req.setAttribute("listacategorias", listacat);
			ServiceUsuario service = ServiceImplUsuario.getInstance();
			List<Menu> opciones = new ArrayList<Menu>();
			opciones = service.cargarMenuUsuario(user);			
			req.setAttribute("listaopciones", opciones);
			ServletContext sc = getServletContext();
			sc.getRequestDispatcher("/WEB-INF/cpanel.jsp").forward(req, res);
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
	
	public void doGet(HttpServletRequest req, HttpServletResponse res){
		processRequest(req,res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res){
		processRequest(req,res);
	}
	
}
