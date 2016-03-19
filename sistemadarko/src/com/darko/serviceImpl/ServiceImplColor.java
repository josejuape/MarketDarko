package com.darko.serviceImpl;

import java.util.List;
import com.darko.dao.DaoColor;
import com.darko.daoImpl.DaoImplColor;
import com.darko.model.Color;
import com.darko.model.Marca;
import com.darko.service.ServiceColor;

public class ServiceImplColor implements ServiceColor {
	private static ServiceColor objInstance;
	
	public static ServiceColor getInstance(){
		if(objInstance == null){
			objInstance = new ServiceImplColor();
		}
		return objInstance;
	} 

	public int registrar(Color color) throws Exception {
		// TODO Auto-generated method stub
		DaoColor service = DaoImplColor.getInstance();
		int rpta = service.registrar(color);
		return rpta;
	}

	public int actualizar(Color color) throws Exception {
		// TODO Auto-generated method stub
		DaoColor service = DaoImplColor.getInstance();
		int rpta = service.actualizar(color);
		return rpta;
	}

	public int eliminar(Color color) throws Exception {
		// TODO Auto-generated method stub
		DaoColor service = DaoImplColor.getInstance();
		int rpta = service.eliminar(color);
		return rpta;
	}

	public List<Color> lista() throws Exception {
		// TODO Auto-generated method stub
		DaoColor service = DaoImplColor.getInstance();
		List<Color> lista = service.listar();
		return lista;
	}
	
	public List<Color> getColores(Marca marca) throws Exception {
		// TODO Auto-generated method stub
		DaoColor service = DaoImplColor.getInstance();
		List<Color> lista = service.getColores(marca);
		return lista;
	}

}
