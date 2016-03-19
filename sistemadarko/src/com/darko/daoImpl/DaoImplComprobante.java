package com.darko.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.darko.dao.DaoComprobante;
import com.darko.model.Comprobante;
import com.mysql.jdbc.Statement;

import conexion.Conexion;

public class DaoImplComprobante implements DaoComprobante {
	private static DaoComprobante objInstance;
	private Conexion objCnx;
	
	public static DaoComprobante getInstance(){
		if(objInstance == null){
			objInstance = new DaoImplComprobante();
		}
		return objInstance;
	}

	public int registrar(Comprobante comp) throws Exception {
		// TODO Auto-generated method stub
		try{
			this.objCnx = new Conexion("MYSQL");
			this.objCnx.conectarBD();
			String sql = "INSERT INTO conftbc_comprobante (nombre,observacion,defecto) values(?,?,?)";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1,comp.getNombre());
			ps.setString(2,comp.getObservacion());
			ps.setInt(3,comp.getDefecto());
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

	public int actualizar(Comprobante comp) throws Exception {
		// TODO Auto-generated method stub
		try{
			this.objCnx = new Conexion("MYSQL");
			this.objCnx.conectarBD();
			String sql = "UPDATE conftbc_comprobante SET nombre=?, observacion=?, defecto=? WHERE idcomprobante = ?";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql);
			ps.setString(1,comp.getNombre());
			ps.setString(2,comp.getObservacion());
			ps.setInt(3,comp.getDefecto());
			ps.setInt(4,comp.getIdcomprobante());
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

	public int eliminar(Comprobante comp) throws Exception {
		// TODO Auto-generated method stub
		try{
			this.objCnx = new Conexion("MYSQL");
			this.objCnx.conectarBD();
			String sql = "DELETE FROM conftbc_comprobante WHERE idcomprobante = ?";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql);
			ps.setInt(1,comp.getIdcomprobante());
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

	public List<Comprobante> listar() throws Exception {
		// TODO Auto-generated method stub
		try{
			this.objCnx = new Conexion("MYSQL");
			List<Comprobante> lista = new ArrayList<Comprobante>();
			this.objCnx.conectarBD();
			String sql = "SELECT idcomprobante, nombre, observacion, defecto FROM conftbc_comprobante";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Comprobante comp = new Comprobante();
				comp.setIdcomprobante(rs.getInt("idcomprobante"));
				comp.setNombre(rs.getString("nombre"));
				comp.setObservacion(rs.getString("observacion"));
				comp.setDefecto(rs.getInt("defecto"));
				lista.add(comp);
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
