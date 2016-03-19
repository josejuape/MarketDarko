package com.darko.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.darko.dao.DaoUsuario;
import com.darko.model.Menu;
import com.darko.model.Rol;
import com.darko.model.Usuario;
import com.mysql.jdbc.Statement;

import conexion.Conexion;

public class DaoImplUsuario implements DaoUsuario {
	private static DaoUsuario objInstance;
	private Conexion objCnx;
	
	public static DaoUsuario getInstance(){
		if(objInstance == null){
			objInstance = new DaoImplUsuario();
		}
		return objInstance;
	}

	public int registrar(Usuario user) throws Exception {
		// TODO Metodo para registrar un usuario
		try{
			this.objCnx = new Conexion("MYSQL");
			this.objCnx.conectarBD();
			String sql = "INSERT INTO segtbc_usuario (nombre,user,password,dni,movil,email,idrol) values(?,?,?,?,?,?,?)";
			PreparedStatement ps =  this.objCnx.cnx.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1,user.getNombre());
			ps.setString(2,user.getUser());
			ps.setString(3, user.getPassword());
			ps.setString(4,user.getDni());
			ps.setString(5,user.getMovil());
			ps.setString(6,user.getEmail());
			ps.setInt(7, user.getRol().getIdrol());
			ps.executeUpdate();	
			int newid = -1;
			ResultSet rs = ps.getGeneratedKeys();
	        if (rs.next()){
	            newid=rs.getInt(1);
	        }
	        rs.close();
			ps.close();
			this.objCnx.confirmarDB();
			return newid;
		}catch(Exception ex){
			this.objCnx.deshacerDB();
			throw ex;
		}finally {			
			this.objCnx.closeDB();
			this.objCnx = null;
		}
	}

	public int actualizar(Usuario user) throws Exception {
		// TODO Actualizar un usuario
		try{
			this.objCnx = new Conexion("MYSQL");
			this.objCnx.conectarBD();
			String sql = "UPDATE segtbc_usuario SET nombre=?, user=?, password=?, dni=?, movil=?, email=?, idrol=? WHERE idusuario = ?";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql);
			ps.setString(1,user.getNombre());
			ps.setString(2,user.getUser());
			ps.setString(3, user.getPassword());
			ps.setString(4,user.getDni());
			ps.setString(5,user.getMovil());
			ps.setString(6,user.getEmail());
			ps.setInt(7, user.getRol().getIdrol());
			ps.setInt(8, user.getIdusuario());
			int rpta = ps.executeUpdate();		
			this.objCnx.confirmarDB();
			return rpta;
		}catch(Exception ex){
			this.objCnx.deshacerDB();
			throw ex;
		}finally {			
			this.objCnx.closeDB();
			this.objCnx = null;
		}
	}

	public int eliminar(Usuario user) throws Exception {
		// TODO Eliminar un usuario
		try{
			this.objCnx = new Conexion("MYSQL");
			this.objCnx.conectarBD();
			String sql = "DELETE FROM segtbc_usuario WHERE idusuario = ?";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql);
			ps.setInt(1, user.getIdusuario());
			int rpta = ps.executeUpdate();		
			this.objCnx.confirmarDB();
			return rpta;
		}catch(Exception ex){
			this.objCnx.deshacerDB();
			throw ex;
		}finally {			
			this.objCnx.closeDB();
			this.objCnx = null;
		}
	}
	
	public List<Usuario> listar() throws Exception {
		// TODO Listar la tabla usuario
		try{
			this.objCnx = new Conexion("MYSQL");
			List<Usuario> lista = new ArrayList<Usuario>();
			this.objCnx.conectarBD();
			String sql = "SELECT u.idusuario,u.nombre,u.user,u.password,u.dni,u.movil,u.email,u.idrol,r.desc_rol "
					+ "FROM segtbc_usuario u INNER JOIN segtbc_rol r on u.idrol=r.idrol";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Usuario user = new Usuario();
				user.setIdusuario(rs.getInt("idusuario"));
				user.setNombre(rs.getString("nombre"));
				user.setUser(rs.getString("user"));
				user.setPassword(rs.getString("password"));
				user.setDni(rs.getString("dni"));
				user.setMovil(rs.getString("movil"));
				user.setEmail(rs.getString("email"));
				Rol rol = new Rol();
				rol.setIdrol(rs.getInt("idrol"));
				rol.setDesc_rol(rs.getString("desc_rol"));
				user.setRol(rol);
				lista.add(user);
			}
			return lista;
			
		}catch(Exception ex){
			this.objCnx.deshacerDB();
			throw ex;
		}finally{
			this.objCnx.closeDB();
			this.objCnx = null;
		}
	}	

	public Usuario validar(Usuario user) throws Exception {
		// TODO Validar usuario y password para inicio de sesion
		try{			
			this.objCnx = new Conexion("MYSQL");
			List<Usuario> lista = new ArrayList<Usuario>();
			this.objCnx.conectarBD();
			String sql = "SELECT idusuario,nombre,user,password,dni,movil,email,idrol FROM segtbc_usuario WHERE user=? AND password=?";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql);
			ps.setString(1,user.getUser());
			ps.setString(2,user.getPassword());
			ResultSet rs = ps.executeQuery();
			Usuario usuario = new Usuario();
			if(rs.next()){				
				usuario.setIdusuario(rs.getInt("idusuario"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setUser(rs.getString("user"));
				usuario.setPassword(rs.getString("password"));
				usuario.setDni(rs.getString("dni"));
				usuario.setMovil(rs.getString("movil"));
				usuario.setEmail(rs.getString("email"));
				Rol rol = new Rol();
				rol.setIdrol(rs.getInt("idrol"));
				usuario.setRol(rol);
				lista.add(user);
			}
			return usuario;
			
		}catch(Exception ex){
			//this.objCnx.deshacerDB();
			throw ex;
		}finally{
			//this.objCnx.closeDB();
			//this.objCnx = null;
		}
		
	}

	public List<Menu> cargarMenuUsuario(Usuario user) throws Exception {
		// TODO Metodo para listar las opciones de menu de un usuario
		try{
			this.objCnx = new Conexion("MYSQL");
			List<Menu> lista = new ArrayList<Menu>();
			this.objCnx.conectarBD();
			String sql = "SELECT u.idmenu,desc_menu,url_menu,icon_menu,nodo,nodo_padre FROM segtbc_menu u "
					+ "INNER JOIN segtbd_opciones o on u.idmenu = o.idmenu WHERE o.idusuario = ? ";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql);
			ps.setInt(1, user.getIdusuario());
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Menu menu = new Menu();
				menu.setIdmenu(rs.getInt("idmenu"));
				menu.setDesc_menu(rs.getString("desc_menu"));
				menu.setUrl_menu(rs.getString("url_menu"));
				menu.setIcon_menu(rs.getString("icon_menu"));
				menu.setNodo(rs.getInt("nodo"));
				menu.setNodo_padre(rs.getInt("nodo_padre"));
				lista.add(menu);
			}
			return lista;
			
		}catch(Exception ex){
			this.objCnx.deshacerDB();
			throw ex;
		}finally{
			this.objCnx.closeDB();
			this.objCnx = null;
		}
	}

	

}
