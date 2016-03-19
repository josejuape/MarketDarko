package com.darko.serviceImpl;

import java.util.List;

import com.darko.dao.DaoTracking;
import com.darko.daoImpl.DaoImplTracking;
import com.darko.model.Tracking;
import com.darko.service.ServiceTracking;

public class ServiceImplTracking implements ServiceTracking {
	private static ServiceTracking objInstance;
	
	public static ServiceTracking getInstance(){
		if(objInstance == null){
			objInstance = new ServiceImplTracking();
		}
		return objInstance;
	}

	public int registrar(Tracking tracking) throws Exception {
		// TODO Auto-generated method stub
		DaoTracking service = DaoImplTracking.getInstance();
		int rpta = service.registrar(tracking);
		return rpta;
	}

	public int actualizar(Tracking tracking) throws Exception {
		// TODO Auto-generated method stub
		DaoTracking service = DaoImplTracking.getInstance();
		int rpta = service.actualizar(tracking);
		return rpta;
	}

	public int eliminar(Tracking tracking) throws Exception {
		// TODO Auto-generated method stub
		DaoTracking service = DaoImplTracking.getInstance();
		int rpta = service.eliminar(tracking);
		return rpta;
	}

	public List<Tracking> listar() throws Exception {
		// TODO Auto-generated method stub
		DaoTracking service = DaoImplTracking.getInstance();
		List<Tracking> lista = service.listar();
		return lista;
	}

	public List<Tracking> getTracking(Tracking tracking) throws Exception {
		// TODO Auto-generated method stub
		DaoTracking service = DaoImplTracking.getInstance();
		List<Tracking> lista = service.getTracking(tracking);
		return lista;
	}
	
}
