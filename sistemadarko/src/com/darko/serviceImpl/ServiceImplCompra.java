package com.darko.serviceImpl;

import com.darko.dao.DaoCompra;
import com.darko.dao.DaoModelo;
import com.darko.daoImpl.DaoImplCompra;
import com.darko.daoImpl.DaoImplModelo;
import com.darko.model.DetalleColor;
import com.darko.model.DetalleTalla;
import com.darko.model.Inventario;
import com.darko.service.ServiceCompra;

public class ServiceImplCompra implements ServiceCompra {
	private static ServiceCompra objInstance;
	
	public static ServiceCompra getInstance(){
		if(objInstance == null){
			objInstance = new ServiceImplCompra();
		}
		return objInstance;
	}

	public int registrarInventario(Inventario inventario) throws Exception {
		// TODO Auto-generated method stub
		DaoCompra service = DaoImplCompra.getInstance();
		int rpta = service.registrarInventario(inventario);
		return rpta;
	}

	public int eliminarInventario(Inventario inventario) throws Exception {
		// TODO Auto-generated method stub
		DaoCompra service = DaoImplCompra.getInstance();
		int rpta = service.eliminarInventario(inventario);
		return rpta;
	}

	public int registrarTallasProducto(DetalleTalla obj) throws Exception {
		// TODO Auto-generated method stub
		DaoCompra service = DaoImplCompra.getInstance();
		int rpta = service.registrarTallasProducto(obj);
		return rpta;
	}

	public int registrarColoresProducto(DetalleColor obj) throws Exception {
		// TODO Auto-generated method stub
		DaoCompra service = DaoImplCompra.getInstance();
		int rpta = service.registrarColoresProducto(obj);
		return rpta;
	}

}
