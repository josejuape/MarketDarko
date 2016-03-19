package com.darko.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.darko.dao.DaoOpcionMenu;
import com.darko.model.Menu;
import com.darko.model.OpcionMenu;
import com.darko.model.Rol;
import com.darko.model.Usuario;
import com.mysql.jdbc.Statement;

import conexion.Conexion;

public class DaoImplOpcionMenu implements DaoOpcionMenu {
	private static DaoOpcionMenu objInstance;
	private Conexion objCnx;
	
	public static DaoOpcionMenu getInstance(){
		if(objInstance == null){
			objInstance = new DaoImplOpcionMenu();
		}
		return objInstance;
	}

	public int registrar(OpcionMenu opcion) throws Exception {
		// TODO Auto-generated method stub
		try{
			this.objCnx = new Conexion("MYSQL");
			this.objCnx.conectarBD();
			String sql = "INSERT INTO segtbd_opciones (idmenu,idusuario) values(?,?)";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1,opcion.getMenu().getIdmenu());
			ps.setInt(2,opcion.getUsuario().getIdusuario());
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

	public int actualizar(OpcionMenu opcion) throws Exception {
		// TODO Auto-generated method stub
		try{
			this.objCnx = new Conexion("MYSQL");
			this.objCnx.conectarBD();
			String sql = "UPDATE segtbd_opciones SET idmenu=?, idusuario=? WHERE idopcion = ?";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql);
			ps.setInt(1,opcion.getMenu().getIdmenu());
			ps.setInt(2,opcion.getUsuario().getIdusuario());
			ps.setInt(3,opcion.getIdopcion());
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

	public int eliminar(OpcionMenu opcion) throws Exception {
		// TODO Auto-generated method stub
		try{
			this.objCnx = new Conexion("MYSQL");
			this.objCnx.conectarBD();
			String sql = "DELETE FROM segtbd_opciones WHERE idopcion = ?";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql);
			ps.setInt(1,opcion.getIdopcion());
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

	public List<OpcionMenu> listar() throws Exception {
		// TODO Auto-generated method stub
		try{
			this.objCnx = new Conexion("MYSQL");
			List<OpcionMenu> lista = new ArrayList<OpcionMenu>();
			this.objCnx.conectarBD();
			String sql = "SELECT o.idopcion,o.idusuario,o.idmenu,m.desc_menu,u.nombre,r.desc_rol"
					+ " FROM segtbd_opciones o INNER JOIN segtbc_usuario u on(o.idusuario=u.idusuario)"
					+ " INNER JOIN  segtbc_menu m on(o.idmenu = m.idmenu)"
					+ " INNER JOIN segtbc_rol r on (r.idrol = u.idusuario) ";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				OpcionMenu opcion = new OpcionMenu();
				opcion.setIdopcion(rs.getInt("idopcion"));
				Usuario user = new Usuario();
				user.setIdusuario(rs.getInt("idusuario"));
				user.setNombre(rs.getString("nombre"));
				Menu menu = new Menu();
				menu.setIdmenu(rs.getInt("idmenu"));
				menu.setDesc_menu(rs.getString("desc_menu"));
				Rol rol = new Rol();
				rol.setDesc_rol(rs.getString("desc_rol"));
				user.setRol(rol);
				
				opcion.setMenu(menu);
				opcion.setUsuario(user);
				lista.add(opcion);
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
