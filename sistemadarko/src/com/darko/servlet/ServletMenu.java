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

import com.darko.model.Menu;
import com.darko.service.ServiceMenu;
import com.darko.serviceImpl.ServiceImplMenu;

public class ServletMenu extends HttpServlet {
	private final static long serialVersionUID = 1L;
			
	public void doGet(HttpServletRequest req, HttpServletResponse res){
		try {					
			ServiceMenu service = ServiceImplMenu.getInstance();
			List<Menu> lista = new ArrayList<Menu>();
			lista = service.lista();			
			req.setAttribute("listamenus", lista);
			ServletContext sc = getServletContext();
			sc.getRequestDispatcher("/WEB-INF/seguridad/menu.jsp").forward(req, res);
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
			ServiceMenu service = ServiceImplMenu.getInstance();
			Menu menu = new Menu();
			String control = req.getParameter("control");
			
			if(control.equalsIgnoreCase("eliminar")){
				menu.setIdmenu(Integer.parseInt(req.getParameter("idmenu")));
				service.eliminar(menu);
				out.println("{\"respuesta\":\"Eliminado correctamente\"}");
			}else{			
				menu.setDesc_menu(req.getParameter("txtmenu_desc"));
				menu.setUrl_menu(req.getParameter("txtmenu_url"));
				menu.setIcon_menu(req.getParameter("txtmenu_icon"));
				menu.setNodo(Integer.parseInt(req.getParameter("txtmenu_nodo")));	
				menu.setNodo_padre(Integer.parseInt(req.getParameter("txtmenu_nodopadre")));	
				if(control.equalsIgnoreCase("nuevo")){				
					int idnew = service.registrar(menu);
					out.println("{\"control\":\"nuevo\",\"id\":\""+idnew+"\",\"desc\":\""+menu.getDesc_menu()+"\",\"url\":\""+menu.getUrl_menu()+"\",\"icon\":\""+menu.getIcon_menu()+"\",\"nodo\":\""+menu.getNodo()+"\",\"nodopadre\":\""+menu.getNodo_padre()+"\"}");
				}else if(control.equalsIgnoreCase("modificar")){
					menu.setIdmenu(Integer.parseInt(req.getParameter("idmenu")));
					service.actualizar(menu);
					out.println("{\"control\":\"modificar\",\"id\":\""+menu.getIdmenu()+"\",\"desc\":\""+menu.getDesc_menu()+"\",\"url\":\""+menu.getUrl_menu()+"\",\"icon\":\""+menu.getIcon_menu()+"\",\"nodo\":\""+menu.getNodo()+"\",\"nodopadre\":\""+menu.getNodo_padre()+"\"}");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
