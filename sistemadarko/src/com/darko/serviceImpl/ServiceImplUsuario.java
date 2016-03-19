package com.darko.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.darko.dao.DaoUsuario;
import com.darko.daoImpl.DaoImplUsuario;
import com.darko.model.Menu;
import com.darko.model.Usuario;
import com.darko.service.ServiceUsuario;

public class ServiceImplUsuario implements ServiceUsuario {
	private static ServiceUsuario objInstance;
	
	public static ServiceUsuario getInstance(){
		if(objInstance == null){
			objInstance = new ServiceImplUsuario();
		}
		return objInstance;
	} 

	public int registrar(Usuario user) throws Exception {
		// TODO Servicio para registrar un usuario
		int rpta = -1;
		if(user.getNombre().matches("[a-z]*")){
			DaoUsuario service = DaoImplUsuario.getInstance();
			rpta = service.registrar(user);
		}
		return rpta;
	}

	public int actualizar(Usuario user) throws Exception {
		// TODO Servicio para actualizar un usuario
		int rpta = -1;
		if(user.getNombre().matches("[a-z]*")){
			DaoUsuario service = DaoImplUsuario.getInstance();
			rpta = service.actualizar(user);
		}
		return rpta;
	}

	public int eliminar(Usuario user) throws Exception {
		// TODO Servicio para eliminar un usuario
		int rpta = -1;
		if(user.getNombre().matches("[a-z]*")){
			DaoUsuario service = DaoImplUsuario.getInstance();
			rpta = service.eliminar(user);
		}
		return rpta;
	}

	public List<Usuario> lista() throws Exception {
		// TODO Servicio para listar los usuarios
		List<Usuario> lista = new ArrayList<Usuario>();
		DaoUsuario service = DaoImplUsuario.getInstance();
		lista = service.listar();
		return lista;
	}

	public Usuario validarLogin(Usuario user) throws Exception {
		// TODO Servicio para validar el inicio de sesión
		DaoUsuario service = DaoImplUsuario.getInstance();
		Usuario user_valido = service.validar(user);
		return user_valido;
	}

	public List<Menu> cargarMenuUsuario(Usuario user) throws Exception {
		// TODO Auto-generated method stub
		List<Menu> lista = new ArrayList<Menu>();
		DaoUsuario service = DaoImplUsuario.getInstance();
		lista = service.cargarMenuUsuario(user);
		return lista;
	}

}
