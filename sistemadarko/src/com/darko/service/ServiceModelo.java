package com.darko.service;

import java.util.List;

import com.darko.model.Marca;
import com.darko.model.Modelo;

public interface ServiceModelo {
	public int registrar(Modelo modelo) throws Exception;
	public int actualizar(Modelo modelo) throws Exception;
	public int eliminar(Modelo modelo) throws Exception;
	public List<Modelo> lista() throws Exception;
	public List<Modelo> getModelos(Marca marca) throws Exception;
}
