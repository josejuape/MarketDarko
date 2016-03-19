package com.darko.service;

import java.util.List;

import com.darko.model.Color;
import com.darko.model.Producto;
import com.darko.model.Talla;


public interface ServiceProducto {
	public int registrar(Producto Producto) throws Exception;
	public int actualizar(Producto Producto) throws Exception;
	public int eliminar(Producto Producto) throws Exception;
	public List<Producto> lista() throws Exception;
	public List<Producto> buscar(String nombre) throws Exception;
	public List<Talla> tallasProducto(Producto producto) throws Exception;
	public List<Color> coloresProducto(Producto producto) throws Exception;
}
