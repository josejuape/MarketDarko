package com.darko.serviceImpl;

import java.util.List;

import com.darko.dao.DaoTalla;
import com.darko.daoImpl.DaoImplTalla;
import com.darko.model.Talla;
import com.darko.service.ServiceTalla;

public class ServiceImplTalla implements ServiceTalla {
	private static ServiceTalla objInstance;
	
	public static ServiceTalla getInstance(){
		if(objInstance == null){
			objInstance = new ServiceImplTalla();
		}
		return objInstance;
	} 

	public int registrar(Talla talla) throws Exception {
		// TODO Auto-generated method stub
		DaoTalla service = DaoImplTalla.getInstance();
		int rpta = service.registrar(talla);
		return rpta;
	}

	public int actualizar(Talla talla) throws Exception {
		// TODO Auto-generated method stub
		DaoTalla service = DaoImplTalla.getInstance();
		int rpta = service.actualizar(talla);
		return rpta;
	}

	public int eliminar(Talla talla) throws Exception {
		// TODO Auto-generated method stub
		DaoTalla service = DaoImplTalla.getInstance();
		int rpta = service.eliminar(talla);
		return rpta;
	}

	public List<Talla> lista() throws Exception {
		// TODO Auto-generated method stub
		DaoTalla service = DaoImplTalla.getInstance();
		List<Talla> lista = service.listar();
		return lista;
	}

}
