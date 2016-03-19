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
import com.darko.service.ServiceCategoria;
import com.darko.serviceImpl.ServiceImplCategoria;

public class ServletGenerarCompra extends HttpServlet {
	private final static long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse res){		
		try {			
			ServiceCategoria servicecat = ServiceImplCategoria.getInstance();
			List<Categoria> listacat = new ArrayList<Categoria>();
			listacat = servicecat.lista();			
			req.setAttribute("listacategorias", listacat);
			
			ServletContext sc = getServletContext();
			sc.getRequestDispatcher("/WEB-INF/compras/generarcompra.jsp").forward(req, res);
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
		
	}

}
