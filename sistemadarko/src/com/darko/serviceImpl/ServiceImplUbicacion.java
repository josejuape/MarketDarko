package com.darko.serviceImpl;

import java.util.List;

import com.darko.dao.DaoUbicacion;
import com.darko.daoImpl.DaoImplUbicacion;
import com.darko.model.Ubicacion;
import com.darko.service.ServiceUbicacion;

public class ServiceImplUbicacion implements ServiceUbicacion {
	private static ServiceUbicacion objInstance;
	
	public static ServiceUbicacion getInstance(){
		if(objInstance == null){
			objInstance = new ServiceImplUbicacion();
		}
		return objInstance;
	} 

	public int registrar(Ubicacion ubicacion) throws Exception {
		// TODO Auto-generated method stub
		DaoUbicacion service = DaoImplUbicacion.getInstance();
		int rpta = service.registrar(ubicacion);
		return rpta;
	}

	public int actualizar(Ubicacion ubicacion) throws Exception {
		// TODO Auto-generated method stub
		DaoUbicacion service = DaoImplUbicacion.getInstance();
		int rpta = service.actualizar(ubicacion);
		return rpta;
	}

	public int eliminar(Ubicacion ubicacion) throws Exception {
		// TODO Auto-generated method stub
		DaoUbicacion service = DaoImplUbicacion.getInstance();
		int rpta = service.eliminar(ubicacion);
		return rpta;
	}

	public List<Ubicacion> lista() throws Exception {
		// TODO Auto-generated method stub
		DaoUbicacion service = DaoImplUbicacion.getInstance();
		List<Ubicacion> lista = service.listar();
		return lista;
	}

}
