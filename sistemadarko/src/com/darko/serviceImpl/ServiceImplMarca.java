package com.darko.serviceImpl;

import java.util.List;
import com.darko.dao.DaoMarca;
import com.darko.daoImpl.DaoImplMarca;
import com.darko.model.Categoria;
import com.darko.model.Marca;
import com.darko.service.ServiceMarca;

public class ServiceImplMarca implements ServiceMarca {
private static ServiceMarca objInstance;
	
	public static ServiceMarca getInstance(){
		if(objInstance == null){
			objInstance = new ServiceImplMarca();
		}
		return objInstance;
	} 

	public int registrar(Marca marca) throws Exception {
		// TODO Auto-generated method stub
		DaoMarca service = DaoImplMarca.getInstance();
		int rpta = service.registrar(marca);
		return rpta;
	}

	public int actualizar(Marca marca) throws Exception {
		// TODO Auto-generated method stub
		DaoMarca service = DaoImplMarca.getInstance();
		int rpta = service.actualizar(marca);
		return rpta;
	}

	public int eliminar(Marca marca) throws Exception {
		// TODO Auto-generated method stub
		DaoMarca service = DaoImplMarca.getInstance();
		int rpta = service.eliminar(marca);
		return rpta;
	}

	public List<Marca> lista() throws Exception {
		// TODO Auto-generated method stub
		DaoMarca service = DaoImplMarca.getInstance();
		List<Marca> lista = service.listar();
		return lista;
	}
	
	public List<Marca> getMarcas(Categoria categoria) throws Exception {
		// TODO Auto-generated method stub
		DaoMarca service = DaoImplMarca.getInstance();
		List<Marca> lista = service.getMarcas(categoria);
		return lista;
	}

}
