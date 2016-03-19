package com.darko.serviceImpl;

import java.util.List;

import com.darko.dao.DaoMenu;
import com.darko.daoImpl.DaoImplMenu;
import com.darko.model.Menu;
import com.darko.service.ServiceMenu;

public class ServiceImplMenu implements ServiceMenu {
private static ServiceMenu objInstance;
	
	public static ServiceMenu getInstance(){
		if(objInstance == null){
			objInstance = new ServiceImplMenu();
		}
		return objInstance;
	} 

	public int registrar(Menu menu) throws Exception {
		// TODO Auto-generated method stub
		DaoMenu service = DaoImplMenu.getInstance();
		int rpta = service.registrar(menu);
		return rpta;
	}

	public int actualizar(Menu menu) throws Exception {
		// TODO Auto-generated method stub
		DaoMenu service = DaoImplMenu.getInstance();
		int rpta = service.actualizar(menu);
		return rpta;
	}

	public int eliminar(Menu menu) throws Exception {
		// TODO Auto-generated method stub
		DaoMenu service = DaoImplMenu.getInstance();
		int rpta = service.eliminar(menu);
		return rpta;
	}

	public List<Menu> lista() throws Exception {
		// TODO Auto-generated method stub
		DaoMenu service = DaoImplMenu.getInstance();
		List<Menu> lista = service.listar();
		return lista;
	}

	
}
