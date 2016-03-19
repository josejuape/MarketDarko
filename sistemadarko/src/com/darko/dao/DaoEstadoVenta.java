package com.darko.dao;

import java.util.List;

import com.darko.model.EstadoVenta;

public interface DaoEstadoVenta {
	public int registrar(EstadoVenta estado) throws Exception;
	public int actualizar(EstadoVenta estado) throws Exception;
	public int eliminar(EstadoVenta estado) throws Exception;
	public List<EstadoVenta> listar() throws Exception;
}
