package com.darko.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.darko.dao.DaoRol;
import com.darko.model.Rol;
import com.mysql.jdbc.Statement;

import conexion.Conexion;

public class DaoImplRol implements DaoRol {
	private static DaoRol objInstance;
	private Conexion objCnx;
	
	public static DaoRol getInstance(){
		if(objInstance == null){
			objInstance = new DaoImplRol();
		}
		return objInstance;
	}

	public int registrar(Rol rol) throws Exception {
		// TODO Auto-generated method stub
		try{
			this.objCnx = new Conexion("MYSQL");
			this.objCnx.conectarBD();
			String sql = "INSERT INTO segtbc_rol (desc_rol,obs_rol) values(?,?)";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1,rol.getDesc_rol());
			ps.setString(2,rol.getObs_rol());
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

	public int actualizar(Rol rol) throws Exception {
		// TODO Auto-generated method stub
		try{
			this.objCnx = new Conexion("MYSQL");
			this.objCnx.conectarBD();
			String sql = "UPDATE segtbc_rol SET desc_rol=?, obs_rol=? WHERE idrol = ?";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql);
			ps.setString(1,rol.getDesc_rol());
			ps.setString(2,rol.getObs_rol());
			ps.setInt(3, rol.getIdrol());
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

	public int eliminar(Rol rol) throws Exception {
		// TODO Auto-generated method stub
		try{
			this.objCnx = new Conexion("MYSQL");
			this.objCnx.conectarBD();
			String sql = "DELETE FROM segtbc_rol WHERE idrol = ?";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql);
			ps.setInt(1,rol.getIdrol());
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

	public List<Rol> listar() throws Exception {
		// TODO Auto-generated method stub
		try{
			this.objCnx = new Conexion("MYSQL");
			List<Rol> lista = new ArrayList<Rol>();
			this.objCnx.conectarBD();
			String sql = "SELECT idrol, desc_rol, obs_rol FROM segtbc_rol ";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Rol rol = new Rol();
				rol.setIdrol(rs.getInt("idrol"));
				rol.setDesc_rol(rs.getString("desc_rol"));
				rol.setObs_rol(rs.getString("obs_rol"));
				lista.add(rol);
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
