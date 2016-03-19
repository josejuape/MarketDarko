package com.darko.serviceImpl;

import java.util.List;

import com.darko.dao.DaoComprobante;
import com.darko.daoImpl.DaoImplComprobante;
import com.darko.model.Comprobante;
import com.darko.service.ServiceComprobante;

public class ServiceImplComprobante implements ServiceComprobante {
	private static ServiceComprobante objInstance;
	
	public static ServiceComprobante getInstance(){
		if(objInstance == null){
			objInstance = new ServiceImplComprobante();
		}
		return objInstance;
	} 

	public int registrar(Comprobante comp) throws Exception {
		// TODO Auto-generated method stub
		DaoComprobante service = DaoImplComprobante.getInstance();
		int rpta = service.registrar(comp);
		return rpta;
	}

	public int actualizar(Comprobante comp) throws Exception {
		// TODO Auto-generated method stub
		DaoComprobante service = DaoImplComprobante.getInstance();
		int rpta = service.actualizar(comp);
		return rpta;
	}

	public int eliminar(Comprobante comp) throws Exception {
		// TODO Auto-generated method stub
		DaoComprobante service = DaoImplComprobante.getInstance();
		int rpta = service.eliminar(comp);
		return rpta;
	}

	public List<Comprobante> lista() throws Exception {
		// TODO Auto-generated method stub
		DaoComprobante service = DaoImplComprobante.getInstance();
		List<Comprobante> lista = service.listar();
		return lista;
	}

}
