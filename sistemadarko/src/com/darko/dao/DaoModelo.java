package com.darko.dao;

import java.util.List;

import com.darko.model.Marca;
import com.darko.model.Modelo;

public interface DaoModelo {
	public int registrar(Modelo modelo) throws Exception;
	public int actualizar(Modelo modelo) throws Exception;
	public int eliminar(Modelo modelo) throws Exception;
	public List<Modelo> listar() throws Exception;
	public List<Modelo> getModelos(Marca marca) throws Exception;
}
