package com.darko.dao;

import java.util.List;

import com.darko.model.Talla;

public interface DaoTalla {
	public int registrar(Talla talla) throws Exception;
	public int actualizar(Talla talla) throws Exception;
	public int eliminar(Talla talla) throws Exception;
	public List<Talla> listar() throws Exception;
}
