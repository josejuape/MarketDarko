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

import com.darko.model.OpcionMenu;
import com.darko.model.Usuario;
import com.darko.model.Menu;
import com.darko.service.ServiceMenu;
import com.darko.service.ServiceOpcionMenu;
import com.darko.service.ServiceUsuario;
import com.darko.serviceImpl.ServiceImplMenu;
import com.darko.serviceImpl.ServiceImplOpcionMenu;
import com.darko.serviceImpl.ServiceImplUsuario;

public class ServletOpcionMenu extends HttpServlet {
	private final static long serialVersionUID = 1L;
			
	public void doGet(HttpServletRequest req, HttpServletResponse res){
		try {					
			ServiceUsuario serviceuser = ServiceImplUsuario.getInstance();
			List<Usuario> listauser = new ArrayList<Usuario>();
			listauser = serviceuser.lista();			
			req.setAttribute("listausuarios", listauser);
			ServiceMenu servicemenu = ServiceImplMenu.getInstance();
			List<Menu> listamenu = new ArrayList<Menu>();
			listamenu = servicemenu.lista();			
			req.setAttribute("listamenus", listamenu);
			ServiceOpcionMenu service = ServiceImplOpcionMenu.getInstance();
			List<OpcionMenu> lista = new ArrayList<OpcionMenu>();
			lista = service.lista();			
			req.setAttribute("listaopciones", lista);
			ServletContext sc = getServletContext();
			sc.getRequestDispatcher("/WEB-INF/seguridad/opciones.jsp").forward(req, res);
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
			ServiceOpcionMenu service = ServiceImplOpcionMenu.getInstance();
			OpcionMenu opcion = new OpcionMenu();
			String control = req.getParameter("control");
			
			if(control.equalsIgnoreCase("eliminar")){
				opcion.setIdopcion(Integer.parseInt(req.getParameter("idopcion")));
				service.eliminar(opcion);
				out.println("{\"respuesta\":\"Eliminado correctamente\"}");
			}else{			
				Menu menu = new Menu();
				menu.setIdmenu(Integer.parseInt(req.getParameter("cbomenu")));
				menu.setDesc_menu(req.getParameter("menu"));
				Usuario user = new Usuario();
				user.setIdusuario(Integer.parseInt(req.getParameter("cbousuario")));
				user.setNombre(req.getParameter("usuario"));
				opcion.setMenu(menu);				
				opcion.setUsuario(user);	
				if(control.equalsIgnoreCase("nuevo")){				
					int idnew = service.registrar(opcion);
					out.println("{\"control\":\"nuevo\",\"id\":\""+idnew+"\",\"idmenu\":\""+opcion.getMenu().getIdmenu()+"\",\"menu\":\""+opcion.getMenu().getDesc_menu()+"\",\"idusuario\":\""+opcion.getUsuario().getIdusuario()+"\",\"usuario\":\""+opcion.getUsuario().getNombre()+"\"}");
				}else if(control.equalsIgnoreCase("modificar")){
					opcion.setIdopcion(Integer.parseInt(req.getParameter("idopcion")));
					service.actualizar(opcion);
					out.println("{\"control\":\"modificar\",\"id\":\""+opcion.getIdopcion()+"\",\"idmenu\":\""+opcion.getMenu().getIdmenu()+"\",\"menu\":\""+opcion.getMenu().getDesc_menu()+"\",\"idusuario\":\""+opcion.getUsuario().getIdusuario()+"\",\"usuario\":\""+opcion.getUsuario().getNombre()+"\"}");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
