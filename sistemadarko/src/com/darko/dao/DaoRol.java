package com.darko.dao;

import java.util.List;

import com.darko.model.Rol;

public interface DaoRol {
	public int registrar(Rol rol) throws Exception;
	public int actualizar(Rol rol) throws Exception;
	public int eliminar(Rol rol) throws Exception;
	public List<Rol> listar() throws Exception;
}
