package com.darko.dao;

import java.util.List;

import com.darko.model.Color;
import com.darko.model.Producto;
import com.darko.model.Talla;


public interface DaoProducto {
	public int registrar(Producto producto) throws Exception;
	public int actualizar(Producto producto) throws Exception;
	public int eliminar(Producto producto) throws Exception;
	public List<Producto> listar() throws Exception;
	public List<Producto> getProductos(Producto producto) throws Exception;
	public List<Producto> buscar(String nombre) throws Exception;
	public List<Talla> tallasProducto(Producto producto) throws Exception;
	public List<Color> coloresProducto(Producto producto) throws Exception;
}
