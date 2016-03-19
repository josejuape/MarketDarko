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
import com.darko.model.Usuario;
import com.darko.service.ServiceRol;
import com.darko.service.ServiceUsuario;
import com.darko.serviceImpl.ServiceImplRol;
import com.darko.serviceImpl.ServiceImplUsuario;

public class ServletUsuario extends HttpServlet {
	private final static long serialVersionUID = 1L;
			
	public void doGet(HttpServletRequest req, HttpServletResponse res){
		try {					
			ServiceRol servicerol = ServiceImplRol.getInstance();
			List<Rol> listarol = new ArrayList<Rol>();
			listarol = servicerol.lista();			
			req.setAttribute("listaroles", listarol);
			ServiceUsuario service = ServiceImplUsuario.getInstance();
			List<Usuario> lista = new ArrayList<Usuario>();
			lista = service.lista();			
			req.setAttribute("listausuarios", lista);			
			ServletContext sc = getServletContext();
			sc.getRequestDispatcher("/WEB-INF/seguridad/usuario.jsp").forward(req, res);
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
			ServiceUsuario service = ServiceImplUsuario.getInstance();
			Usuario user = new Usuario();
			String control = req.getParameter("control");
			
			if(control.equalsIgnoreCase("eliminar")){
				user.setIdusuario(Integer.parseInt(req.getParameter("idusuario")));
				service.eliminar(user);
				out.println("{\"respuesta\":\"Eliminado correctamente\"}");
			}else{			
				user.setNombre(req.getParameter("txtuser_nombre"));
				user.setDni(req.getParameter("txtuser_dni"));
				user.setUser(req.getParameter("txtuser_user"));
				user.setPassword(req.getParameter("txtuser_password"));
				user.setEmail(req.getParameter("txtuser_email"));
				user.setMovil(req.getParameter("txtuser_movil"));
				Rol rol = new Rol();
				rol.setIdrol(Integer.parseInt(req.getParameter("cborol")));
				rol.setDesc_rol(req.getParameter("rol"));
				user.setRol(rol);
				
				if(control.equalsIgnoreCase("nuevo")){				
					int idnew = service.registrar(user);
					out.println("{\"control\":\"nuevo\",\"id\":\""+idnew+"\",\"nombre\":\""+user.getNombre()+"\",\"dni\":\""+user.getDni()+"\",\"user\":\""+user.getUser()+"\",\"password\":\""+user.getPassword()+"\",\"email\":\""+user.getEmail()+"\",\"movil\":\""+user.getMovil()+"\"}");
				}else if(control.equalsIgnoreCase("modificar")){
					user.setIdusuario(Integer.parseInt(req.getParameter("idusuario")));
					service.actualizar(user);
					out.println("{\"control\":\"modificar\",\"id\":\""+user.getIdusuario()+"\",\"nombre\":\""+user.getNombre()+"\",\"dni\":\""+user.getDni()+"\",\"user\":\""+user.getUser()+"\",\"password\":\""+user.getPassword()+"\",\"email\":\""+user.getEmail()+"\",\"movil\":\""+user.getMovil()+"\"}");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
