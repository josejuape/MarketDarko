package com.darko.serviceImpl;

import java.util.List;

import com.darko.dao.DaoEstadoVenta;
import com.darko.daoImpl.DaoImplEstadoVenta;
import com.darko.model.EstadoVenta;
import com.darko.service.ServiceEstadoVenta;

public class ServiceImplEstadoVenta implements ServiceEstadoVenta {
	private static ServiceEstadoVenta objInstance;
	
	public static ServiceEstadoVenta getInstance(){
		if(objInstance == null){
			objInstance = new ServiceImplEstadoVenta();
		}
		return objInstance;
	} 

	public int registrar(EstadoVenta estado) throws Exception {
		// TODO Auto-generated method stub
		DaoEstadoVenta service = DaoImplEstadoVenta.getInstance();
		int rpta = service.registrar(estado);
		return rpta;
	}

	public int actualizar(EstadoVenta estado) throws Exception {
		// TODO Auto-generated method stub
		DaoEstadoVenta service = DaoImplEstadoVenta.getInstance();
		int rpta = service.actualizar(estado);
		return rpta;
	}

	public int eliminar(EstadoVenta estado) throws Exception {
		// TODO Auto-generated method stub
		DaoEstadoVenta service = DaoImplEstadoVenta.getInstance();
		int rpta = service.eliminar(estado);
		return rpta;
	}

	public List<EstadoVenta> lista() throws Exception {
		// TODO Auto-generated method stub
		DaoEstadoVenta service = DaoImplEstadoVenta.getInstance();
		List<EstadoVenta> lista = service.listar();
		return lista;
	}

}
