package com.darko.dao;

import java.util.List;

import com.darko.model.Menu;
import com.darko.model.Usuario;

public interface DaoUsuario {
	public int registrar(Usuario user) throws Exception;
	public int actualizar(Usuario user) throws Exception;
	public int eliminar(Usuario user) throws Exception;
	public List<Usuario> listar() throws Exception;
	public Usuario validar(Usuario user) throws Exception;	
	public List<Menu> cargarMenuUsuario(Usuario user) throws Exception;
}
