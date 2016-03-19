package com.darko.serviceImpl;

import java.util.List;

import com.darko.dao.DaoOpcionMenu;
import com.darko.daoImpl.DaoImplOpcionMenu;
import com.darko.model.OpcionMenu;
import com.darko.service.ServiceOpcionMenu;

public class ServiceImplOpcionMenu implements ServiceOpcionMenu {
private static ServiceOpcionMenu objInstance;
	
	public static ServiceOpcionMenu getInstance(){
		if(objInstance == null){
			objInstance = new ServiceImplOpcionMenu();
		}
		return objInstance;
	} 

	public int registrar(OpcionMenu opcion) throws Exception {
		// TODO Auto-generated method stub
		DaoOpcionMenu service = DaoImplOpcionMenu.getInstance();
		int rpta = service.registrar(opcion);
		return rpta;
	}

	public int actualizar(OpcionMenu opcion) throws Exception {
		// TODO Auto-generated method stub
		DaoOpcionMenu service = DaoImplOpcionMenu.getInstance();
		int rpta = service.actualizar(opcion);
		return rpta;
	}

	public int eliminar(OpcionMenu opcion) throws Exception {
		// TODO Auto-generated method stub
		DaoOpcionMenu service = DaoImplOpcionMenu.getInstance();
		int rpta = service.eliminar(opcion);
		return rpta;
	}

	public List<OpcionMenu> lista() throws Exception {
		// TODO Auto-generated method stub
		DaoOpcionMenu service = DaoImplOpcionMenu.getInstance();
		List<OpcionMenu> lista = service.listar();
		return lista;
	}

}
