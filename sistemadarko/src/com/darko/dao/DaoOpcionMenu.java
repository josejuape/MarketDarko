package com.darko.dao;

import java.util.List;

import com.darko.model.OpcionMenu;

public interface DaoOpcionMenu {
	public int registrar(OpcionMenu opcion) throws Exception;
	public int actualizar(OpcionMenu opcion) throws Exception;
	public int eliminar(OpcionMenu opcion) throws Exception;
	public List<OpcionMenu> listar() throws Exception;
}
