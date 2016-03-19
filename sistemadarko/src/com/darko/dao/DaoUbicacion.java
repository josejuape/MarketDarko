package com.darko.dao;

import java.util.List;

import com.darko.model.Ubicacion;

public interface DaoUbicacion {
	public int registrar(Ubicacion ubicacion) throws Exception;
	public int actualizar(Ubicacion ubicacion) throws Exception;
	public int eliminar(Ubicacion ubicacion) throws Exception;
	public List<Ubicacion> listar() throws Exception;
}
