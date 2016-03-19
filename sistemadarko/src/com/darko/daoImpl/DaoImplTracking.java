package com.darko.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.darko.dao.DaoTracking;
import com.darko.model.Compra;
import com.darko.model.Modelo;
import com.darko.model.Tracking;
import com.mysql.jdbc.Statement;

import conexion.Conexion;

public class DaoImplTracking implements DaoTracking {
	private static DaoTracking objInstance;
	private Conexion objCnx;
	
	public static DaoTracking getInstance(){
		if(objInstance == null){
			objInstance = new DaoImplTracking();
		}
		return objInstance;
	}

	public int registrar(Tracking tracking) throws Exception {
		// TODO Auto-generated method stub
		try{
			this.objCnx = new Conexion("MYSQL");
			this.objCnx.conectarBD();
			String sql = "INSERT INTO comtbc_tracking (serie,fecha_recepcion) values(?,?)";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1,tracking.getSerie());
			ps.setString(2,tracking.getFecha());
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

	public int actualizar(Tracking tracking) throws Exception {
		// TODO Auto-generated method stub
		try{
			this.objCnx = new Conexion("MYSQL");
			this.objCnx.conectarBD();
			String sql = "UPDATE comtbc_tracking SET serie=?, fecha_recepcion=?, idcompra=? WHERE idtracking = ?";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql);
			ps.setString(1,tracking.getSerie());
			ps.setString(2,tracking.getFecha());
			ps.setInt(3,tracking.getCompra().getIdcompra());
			ps.setInt(4,tracking.getIdtracking());
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

	public int eliminar(Tracking tracking) throws Exception {
		try{
			this.objCnx = new Conexion("MYSQL");
			this.objCnx.conectarBD();
			String sql = "DELETE FROM comtbc_tracking WHERE idtracking = ?";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql);
			ps.setInt(1,tracking.getIdtracking());
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

	public List<Tracking> listar() throws Exception {
		try{
			this.objCnx = new Conexion("MYSQL");
			List<Tracking> lista = new ArrayList<Tracking>();
			this.objCnx.conectarBD();
			String sql = "SELECT idtracking, serie, fecha_recepcion, idcompra "
					+ " FROM comtbc_tracking  ";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Tracking track = new Tracking();
				track.setIdtracking(rs.getInt("idtracking"));
				track.setSerie(rs.getString("serie"));
				track.setFecha(rs.getString("fecha_recepcion"));
				Compra compra = new Compra();
				compra.setIdcompra(rs.getInt("idcompra"));
				track.setCompra(compra);
				lista.add(track);
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

	public List<Tracking> getTracking(Tracking tracking) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
