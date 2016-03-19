package com.darko.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.darko.dao.DaoUbicacion;
import com.darko.model.Ubicacion;
import com.mysql.jdbc.Statement;

import conexion.Conexion;

public class DaoImplUbicacion implements DaoUbicacion {
	private static DaoUbicacion objInstance;
	private Conexion objCnx;
	
	public static DaoUbicacion getInstance(){
		if(objInstance == null){
			objInstance = new DaoImplUbicacion();
		}
		return objInstance;
	}

	public int registrar(Ubicacion ubicacion) throws Exception {
		// TODO Auto-generated method stub
		try{
			this.objCnx = new Conexion("MYSQL");
			this.objCnx.conectarBD();
			String sql = "INSERT INTO conftbc_ubicacion (nombre,observacion,defecto) values(?,?,?)";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1,ubicacion.getNombre());
			ps.setString(2,ubicacion.getObservacion());
			ps.setInt(3,ubicacion.getDefecto());
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

	public int actualizar(Ubicacion ubicacion) throws Exception {
		// TODO Auto-generated method stub
		try{
			this.objCnx = new Conexion("MYSQL");
			this.objCnx.conectarBD();
			String sql = "UPDATE conftbc_ubicacion SET nombre=?, observacion=?, defecto=? WHERE idubicacion = ?";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql);
			ps.setString(1,ubicacion.getNombre());
			ps.setString(2,ubicacion.getObservacion());
			ps.setInt(3,ubicacion.getDefecto());
			ps.setInt(4,ubicacion.getIdubicacion());
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

	public int eliminar(Ubicacion ubicacion) throws Exception {
		// TODO Auto-generated method stub
		try{
			this.objCnx = new Conexion("MYSQL");
			this.objCnx.conectarBD();
			String sql = "DELETE FROM conftbc_ubicacion WHERE idubicacion = ?";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql);
			ps.setInt(1,ubicacion.getIdubicacion());
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

	public List<Ubicacion> listar() throws Exception {
		// TODO Auto-generated method stub
		try{
			this.objCnx = new Conexion("MYSQL");
			List<Ubicacion> lista = new ArrayList<Ubicacion>();
			this.objCnx.conectarBD();
			String sql = "SELECT idubicacion, nombre, observacion, defecto FROM conftbc_ubicacion";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Ubicacion ubicacion = new Ubicacion();
				ubicacion.setIdubicacion(rs.getInt("idubicacion"));
				ubicacion.setNombre(rs.getString("nombre"));
				ubicacion.setObservacion(rs.getString("observacion"));
				ubicacion.setDefecto(rs.getInt("defecto"));
				lista.add(ubicacion);
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
