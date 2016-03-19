package com.darko.serviceImpl;

import java.util.List;

import com.darko.dao.DaoRol;
import com.darko.daoImpl.DaoImplRol;
import com.darko.model.Rol;
import com.darko.service.ServiceRol;

public class ServiceImplRol implements ServiceRol {
private static ServiceRol objInstance;
	
	public static ServiceRol getInstance(){
		if(objInstance == null){
			objInstance = new ServiceImplRol();
		}
		return objInstance;
	} 

	public int registrar(Rol rol) throws Exception {
		// TODO Auto-generated method stub
		DaoRol service = DaoImplRol.getInstance();
		int rpta = service.registrar(rol);
		return rpta;
	}

	public int actualizar(Rol rol) throws Exception {
		// TODO Auto-generated method stub
		DaoRol service = DaoImplRol.getInstance();
		int rpta = service.actualizar(rol);
		return rpta;
	}

	public int eliminar(Rol rol) throws Exception {
		// TODO Auto-generated method stub
		DaoRol service = DaoImplRol.getInstance();
		int rpta = service.eliminar(rol);
		return rpta;
	}

	public List<Rol> lista() throws Exception {
		// TODO Auto-generated method stub
		DaoRol service = DaoImplRol.getInstance();
		List<Rol> lista = service.listar();
		return lista;
	}

}
