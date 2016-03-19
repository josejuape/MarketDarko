package com.darko.service;

import java.util.List;

import com.darko.model.Rol;

public interface ServiceRol {
	public int registrar(Rol rol) throws Exception;
	public int actualizar(Rol rol) throws Exception;
	public int eliminar(Rol rol) throws Exception;
	public List<Rol> lista() throws Exception;
}
