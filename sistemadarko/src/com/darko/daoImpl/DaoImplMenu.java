package com.darko.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.darko.dao.DaoMenu;
import com.darko.model.Menu;
import com.mysql.jdbc.Statement;

import conexion.Conexion;

public class DaoImplMenu implements DaoMenu {
	private static DaoMenu objInstance;
	private Conexion objCnx;
	
	public static DaoMenu getInstance(){
		if(objInstance == null){
			objInstance = new DaoImplMenu();
		}
		return objInstance;
	}

	public int registrar(Menu menu) throws Exception {
		// TODO Auto-generated method stub
		try{
			this.objCnx = new Conexion("MYSQL");
			this.objCnx.conectarBD();
			String sql = "INSERT INTO segtbc_menu (desc_menu,url_menu,icon_menu,nodo,nodo_padre) values(?,?,?,?,?)";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1,menu.getDesc_menu());
			ps.setString(2,menu.getUrl_menu());
			ps.setString(3,menu.getIcon_menu());
			ps.setInt(4,menu.getNodo());
			ps.setInt(5,menu.getNodo_padre());
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

	public int actualizar(Menu menu) throws Exception {
		// TODO Auto-generated method stub
		try{
			this.objCnx = new Conexion("MYSQL");
			this.objCnx.conectarBD();
			String sql = "UPDATE segtbc_menu SET desc_menu=?, url_menu=?, icon_menu=?, nodo=?, nodo_padre=? WHERE idmenu = ?";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql);
			ps.setString(1,menu.getDesc_menu());
			ps.setString(2,menu.getUrl_menu());
			ps.setString(3,menu.getIcon_menu());
			ps.setInt(4,menu.getNodo());
			ps.setInt(5,menu.getNodo_padre());
			ps.setInt(6, menu.getIdmenu());
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

	public int eliminar(Menu menu) throws Exception {
		// TODO Auto-generated method stub
		try{
			this.objCnx = new Conexion("MYSQL");
			this.objCnx.conectarBD();
			String sql = "DELETE FROM segtbc_menu WHERE idmenu = ?";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql);
			ps.setInt(1,menu.getIdmenu());
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

	public List<Menu> listar() throws Exception {
		// TODO Auto-generated method stub
		try{
			this.objCnx = new Conexion("MYSQL");
			List<Menu> lista = new ArrayList<Menu>();
			this.objCnx.conectarBD();
			String sql = "SELECT idmenu, desc_menu, url_menu, icon_menu, nodo, nodo_padre FROM segtbc_menu ";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql);
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
