package com.darko.dao;

import java.util.List;

import com.darko.model.Menu;

public interface DaoMenu {
	public int registrar(Menu menu) throws Exception;
	public int actualizar(Menu menu) throws Exception;
	public int eliminar(Menu menu) throws Exception;
	public List<Menu> listar() throws Exception;
}
