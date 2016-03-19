package com.darko.service;

import java.util.List;

import com.darko.model.Talla;

public interface ServiceTalla {
	public int registrar(Talla talla) throws Exception;
	public int actualizar(Talla talla) throws Exception;
	public int eliminar(Talla talla) throws Exception;
	public List<Talla> lista() throws Exception;
}
