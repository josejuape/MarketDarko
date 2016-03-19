package com.darko.service;

import java.util.List;

import com.darko.model.Categoria;

public interface ServiceCategoria {
	public int registrar(Categoria categoria) throws Exception;
	public int actualizar(Categoria categoria) throws Exception;
	public int eliminar(Categoria categoria) throws Exception;
	public List<Categoria> lista() throws Exception;
}
