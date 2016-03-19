package com.darko.serviceImpl;

import java.util.List;

import com.darko.dao.DaoProducto;
import com.darko.daoImpl.DaoImplProducto;
import com.darko.model.Color;
import com.darko.model.Producto;
import com.darko.model.Talla;
import com.darko.service.ServiceProducto;

public class ServiceImplProducto implements ServiceProducto {
private static ServiceProducto objInstance;
	
	public static ServiceProducto getInstance(){
		if(objInstance == null){
			objInstance = new ServiceImplProducto();
		}
		return objInstance;
	} 

	public int registrar(Producto producto) throws Exception {
		// TODO Auto-generated method stub
		DaoProducto service = DaoImplProducto.getInstance();
		int rpta = service.registrar(producto);
		return rpta;
	}

	public int actualizar(Producto producto) throws Exception {
		// TODO Auto-generated method stub
		DaoProducto service = DaoImplProducto.getInstance();
		int rpta = service.actualizar(producto);
		return rpta;
	}

	public int eliminar(Producto producto) throws Exception {
		// TODO Auto-generated method stub
		DaoProducto service = DaoImplProducto.getInstance();
		int rpta = service.eliminar(producto);
		return rpta;
	}

	public List<Producto> lista() throws Exception {
		// TODO Auto-generated method stub
		DaoProducto service = DaoImplProducto.getInstance();
		List<Producto> lista = service.listar();
		return lista;
	}
	
	public List<Producto> buscar(String nombre) throws Exception {
		// TODO Auto-generated method stub
		DaoProducto service = DaoImplProducto.getInstance();
		List<Producto> lista = service.buscar(nombre);
		return lista;
	}
	
	public List<Talla> tallasProducto(Producto producto) throws Exception {
		// TODO Auto-generated method stub
		DaoProducto service = DaoImplProducto.getInstance();
		List<Talla> lista = service.tallasProducto(producto);
		return lista;
	}
	
	public List<Color>coloresProducto(Producto producto) throws Exception {
		// TODO Auto-generated method stub
		DaoProducto service = DaoImplProducto.getInstance();
		List<Color> lista = service.coloresProducto(producto);
		return lista;
	}
}
