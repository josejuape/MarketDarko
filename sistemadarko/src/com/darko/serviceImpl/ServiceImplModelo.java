package com.darko.serviceImpl;

import java.util.List;

import com.darko.dao.DaoMarca;
import com.darko.dao.DaoModelo;
import com.darko.daoImpl.DaoImplMarca;
import com.darko.daoImpl.DaoImplModelo;
import com.darko.model.Categoria;
import com.darko.model.Marca;
import com.darko.model.Modelo;
import com.darko.service.ServiceModelo;

public class ServiceImplModelo implements ServiceModelo {
	private static ServiceModelo objInstance;
	
	public static ServiceModelo getInstance(){
		if(objInstance == null){
			objInstance = new ServiceImplModelo();
		}
		return objInstance;
	} 

	public int registrar(Modelo modelo) throws Exception {
		// TODO Auto-generated method stub
		DaoModelo service = DaoImplModelo.getInstance();
		int rpta = service.registrar(modelo);
		return rpta;
	}

	public int actualizar(Modelo modelo) throws Exception {
		// TODO Auto-generated method stub
		DaoModelo service = DaoImplModelo.getInstance();
		int rpta = service.actualizar(modelo);
		return rpta;
	}

	public int eliminar(Modelo modelo) throws Exception {
		// TODO Auto-generated method stub
		DaoModelo service = DaoImplModelo.getInstance();
		int rpta = service.eliminar(modelo);
		return rpta;
	}

	public List<Modelo> lista() throws Exception {
		// TODO Auto-generated method stub
		DaoModelo service = DaoImplModelo.getInstance();
		List<Modelo> lista = service.listar();
		return lista;
	}
	
	public List<Modelo> getModelos(Marca marca) throws Exception {
		// TODO Auto-generated method stub
		DaoModelo service = DaoImplModelo.getInstance();
		List<Modelo> lista = service.getModelos(marca);
		return lista;
	}

}
