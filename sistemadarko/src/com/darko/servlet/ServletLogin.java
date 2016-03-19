package com.darko.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.darko.model.Usuario;
import com.darko.service.ServiceUsuario;
import com.darko.serviceImpl.ServiceImplUsuario;

public class ServletLogin extends HttpServlet{
	private final static long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest req, HttpServletResponse res){
		try {	
			Usuario user = new Usuario();
			user.setUser(req.getParameter("user"));
			user.setPassword(req.getParameter("password"));			
			ServiceUsuario service = ServiceImplUsuario.getInstance();
			Usuario usuario = null;			
			usuario = service.validarLogin(user);			
			System.out.println("LLego aqui.. "+usuario);
			if(usuario != null && usuario.getIdusuario() > 0 ){
				System.out.println("entro..");
				HttpSession sesion = req.getSession();
				sesion.setAttribute("usuario",usuario);
				
				//ServletContext sc = getServletContext();
				//sc.getRequestDispatcher("/WEB-INF/cpanel.jsp").forward(req, res);
				res.sendRedirect("/sistemadarko/Dashboard");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
