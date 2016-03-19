package com.darko.service;

import java.util.List;

import com.darko.model.EstadoVenta;

public interface ServiceEstadoVenta {
	public int registrar(EstadoVenta estado) throws Exception;
	public int actualizar(EstadoVenta estado) throws Exception;
	public int eliminar(EstadoVenta estado) throws Exception;
	public List<EstadoVenta> lista() throws Exception;
}
