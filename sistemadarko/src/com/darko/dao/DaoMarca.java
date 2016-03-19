package com.darko.dao;

import java.util.List;

import com.darko.model.Categoria;
import com.darko.model.Marca;

public interface DaoMarca {
	public int registrar(Marca marca) throws Exception;
	public int actualizar(Marca marca) throws Exception;
	public int eliminar(Marca marca) throws Exception;
	public List<Marca> listar() throws Exception;
	public List<Marca> getMarcas(Categoria categoria) throws Exception;
}
