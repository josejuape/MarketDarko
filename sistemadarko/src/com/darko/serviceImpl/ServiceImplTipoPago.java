package com.darko.serviceImpl;

import java.util.List;

import com.darko.dao.DaoTipoPago;
import com.darko.daoImpl.DaoImplTipoPago;
import com.darko.model.TipoPago;
import com.darko.service.ServiceTipoPago;

public class ServiceImplTipoPago implements ServiceTipoPago {
	private static ServiceTipoPago objInstance;
	
	public static ServiceTipoPago getInstance(){
		if(objInstance == null){
			objInstance = new ServiceImplTipoPago();
		}
		return objInstance;
	} 

	public int registrar(TipoPago tipo) throws Exception {
		// TODO Auto-generated method stub
		DaoTipoPago service = DaoImplTipoPago.getInstance();
		int rpta = service.registrar(tipo);
		return rpta;
	}

	public int actualizar(TipoPago tipo) throws Exception {
		// TODO Auto-generated method stub
		DaoTipoPago service = DaoImplTipoPago.getInstance();
		int rpta = service.actualizar(tipo);
		return rpta;
	}

	public int eliminar(TipoPago tipo) throws Exception {
		// TODO Auto-generated method stub
		DaoTipoPago service = DaoImplTipoPago.getInstance();
		int rpta = service.eliminar(tipo);
		return rpta;
	}

	public List<TipoPago> lista() throws Exception {
		// TODO Auto-generated method stub
		DaoTipoPago service = DaoImplTipoPago.getInstance();
		List<TipoPago> lista = service.listar();
		return lista;
	}

}
