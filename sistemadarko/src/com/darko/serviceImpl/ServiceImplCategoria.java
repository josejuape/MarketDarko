package com.darko.serviceImpl;

import java.util.List;

import com.darko.dao.DaoCategoria;
import com.darko.daoImpl.DaoImplCategoria;
import com.darko.model.Categoria;
import com.darko.service.ServiceCategoria;

public class ServiceImplCategoria implements ServiceCategoria {
	private static ServiceCategoria objInstance;
	
	public static ServiceCategoria getInstance(){
		if(objInstance == null){
			objInstance = new ServiceImplCategoria();
		}
		return objInstance;
	} 

	public int registrar(Categoria categoria) throws Exception {
		// TODO Auto-generated method stub
		DaoCategoria service = DaoImplCategoria.getInstance();
		int rpta = service.registrar(categoria);
		return rpta;
	}

	public int actualizar(Categoria categoria) throws Exception {
		// TODO Auto-generated method stub
		DaoCategoria service = DaoImplCategoria.getInstance();
		int rpta = service.actualizar(categoria);
		return rpta;
	}

	public int eliminar(Categoria categoria) throws Exception {
		// TODO Auto-generated method stub
		DaoCategoria service = DaoImplCategoria.getInstance();
		int rpta = service.eliminar(categoria);
		return rpta;
	}

	public List<Categoria> lista() throws Exception {
		// TODO Auto-generated method stub
		DaoCategoria service = DaoImplCategoria.getInstance();
		List<Categoria> lista = service.listar();
		return lista;
	}

}
