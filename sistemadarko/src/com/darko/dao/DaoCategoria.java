package com.darko.dao;

import java.util.List;

import com.darko.model.Categoria;

public interface DaoCategoria {
	public int registrar(Categoria categoria) throws Exception;
	public int actualizar(Categoria categoria) throws Exception;
	public int eliminar(Categoria categoria) throws Exception;
	public List<Categoria> listar() throws Exception;
}
