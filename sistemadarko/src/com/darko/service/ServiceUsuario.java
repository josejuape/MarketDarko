package com.darko.service;

import java.util.List;

import com.darko.model.Menu;
import com.darko.model.Usuario;

public interface ServiceUsuario {
	public int registrar(Usuario user) throws Exception;
	public int actualizar(Usuario user) throws Exception;
	public int eliminar(Usuario user) throws Exception;
	public List<Usuario> lista() throws Exception;
	public Usuario validarLogin(Usuario user) throws Exception;
	public List<Menu> cargarMenuUsuario(Usuario user) throws Exception;
}
