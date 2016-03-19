package com.darko.service;

import java.util.List;

import com.darko.model.Ubicacion;

public interface ServiceUbicacion {
	public int registrar(Ubicacion ubicacion) throws Exception;
	public int actualizar(Ubicacion ubicacion) throws Exception;
	public int eliminar(Ubicacion ubicacion) throws Exception;
	public List<Ubicacion> lista() throws Exception;
}
