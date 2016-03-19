package com.darko.service;

import com.darko.model.DetalleColor;
import com.darko.model.DetalleTalla;
import com.darko.model.Inventario;

public interface ServiceCompra {
	public int registrarInventario(Inventario inventario) throws Exception;
	public int eliminarInventario(Inventario inventario) throws Exception;
	public int registrarTallasProducto(DetalleTalla obj) throws Exception;
	public int registrarColoresProducto(DetalleColor obj) throws Exception;
}
