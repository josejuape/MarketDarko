package com.darko.service;

import java.util.List;

import com.darko.model.OpcionMenu;

public interface ServiceOpcionMenu {
	public int registrar(OpcionMenu opcion) throws Exception;
	public int actualizar(OpcionMenu opcion) throws Exception;
	public int eliminar(OpcionMenu opcion) throws Exception;
	public List<OpcionMenu> lista() throws Exception;
}
