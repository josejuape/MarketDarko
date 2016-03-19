package com.darko.service;

import java.util.List;

import com.darko.model.Menu;

public interface ServiceMenu {
	public int registrar(Menu menu) throws Exception;
	public int actualizar(Menu menu) throws Exception;
	public int eliminar(Menu menu) throws Exception;
	public List<Menu> lista() throws Exception;
}
