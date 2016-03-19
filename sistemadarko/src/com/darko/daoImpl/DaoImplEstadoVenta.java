package com.darko.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.darko.dao.DaoEstadoVenta;
import com.darko.model.EstadoVenta;
import com.mysql.jdbc.Statement;

import conexion.Conexion;

public class DaoImplEstadoVenta implements DaoEstadoVenta {
	private static DaoEstadoVenta objInstance;
	private Conexion objCnx;
	
	public static DaoEstadoVenta getInstance(){
		if(objInstance == null){
			objInstance = new DaoImplEstadoVenta();
		}
		return objInstance;
	}

	public int registrar(EstadoVenta estado) throws Exception {
		// TODO Auto-generated method stub
		try{
			this.objCnx = new Conexion("MYSQL");
			this.objCnx.conectarBD();
			String sql = "INSERT INTO conftbc_estadoventa (nombre,observacion,defecto) values(?,?,?)";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1,estado.getNombre());
			ps.setString(2,estado.getObservacion());
			ps.setInt(3,estado.getDefecto());
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

	public int actualizar(EstadoVenta estado) throws Exception {
		// TODO Auto-generated method stub
		try{
			this.objCnx = new Conexion("MYSQL");
			this.objCnx.conectarBD();
			String sql = "UPDATE conftbc_estadoventa SET nombre=?, observacion=?, defecto=? WHERE idestadoventa = ?";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql);
			ps.setString(1,estado.getNombre());
			ps.setString(2,estado.getObservacion());
			ps.setInt(3,estado.getDefecto());
			ps.setInt(4,estado.getIdestadoventa());
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

	public int eliminar(EstadoVenta estado) throws Exception {
		// TODO Auto-generated method stub
		try{
			this.objCnx = new Conexion("MYSQL");
			this.objCnx.conectarBD();
			String sql = "DELETE FROM conftbc_estadoventa WHERE idestadoventa = ?";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql);
			ps.setInt(1,estado.getIdestadoventa());
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

	public List<EstadoVenta> listar() throws Exception {
		// TODO Auto-generated method stub
		try{
			this.objCnx = new Conexion("MYSQL");
			List<EstadoVenta> lista = new ArrayList<EstadoVenta>();
			this.objCnx.conectarBD();
			String sql = "SELECT idestadoventa, nombre, observacion, defecto FROM conftbc_estadoventa";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				EstadoVenta estado = new EstadoVenta();
				estado.setIdestadoventa(rs.getInt("idestadoventa"));
				estado.setNombre(rs.getString("nombre"));
				estado.setObservacion(rs.getString("observacion"));
				estado.setDefecto(rs.getInt("defecto"));
				lista.add(estado);
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
