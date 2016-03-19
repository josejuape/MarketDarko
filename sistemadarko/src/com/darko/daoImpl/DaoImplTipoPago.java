package com.darko.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.darko.dao.DaoTipoPago;
import com.darko.model.TipoPago;
import com.mysql.jdbc.Statement;

import conexion.Conexion;

public class DaoImplTipoPago implements DaoTipoPago {
	private static DaoTipoPago objInstance;
	private Conexion objCnx;
	
	public static DaoTipoPago getInstance(){
		if(objInstance == null){
			objInstance = new DaoImplTipoPago();
		}
		return objInstance;
	}

	public int registrar(TipoPago tipo) throws Exception {
		// TODO Auto-generated method stub
		try{
			this.objCnx = new Conexion("MYSQL");
			this.objCnx.conectarBD();
			String sql = "INSERT INTO conftbc_tipopago (nombre,observacion,defecto) values(?,?,?)";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1,tipo.getNombre());
			ps.setString(2,tipo.getObservacion());
			ps.setInt(3,tipo.getDefecto());
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

	public int actualizar(TipoPago tipo) throws Exception {
		// TODO Auto-generated method stub
		try{
			this.objCnx = new Conexion("MYSQL");
			this.objCnx.conectarBD();
			String sql = "UPDATE conftbc_tipopago SET nombre=?, observacion=?, defecto=? WHERE idtipopago = ?";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql);
			ps.setString(1,tipo.getNombre());
			ps.setString(2,tipo.getObservacion());
			ps.setInt(3,tipo.getDefecto());
			ps.setInt(4,tipo.getIdtipopago());
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

	public int eliminar(TipoPago tipo) throws Exception {
		// TODO Auto-generated method stub
		try{
			this.objCnx = new Conexion("MYSQL");
			this.objCnx.conectarBD();
			String sql = "DELETE FROM conftbc_tipopago WHERE idtipopago = ?";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql);
			ps.setInt(1,tipo.getIdtipopago());
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

	public List<TipoPago> listar() throws Exception {
		// TODO Auto-generated method stub
		try{
			this.objCnx = new Conexion("MYSQL");
			List<TipoPago> lista = new ArrayList<TipoPago>();
			this.objCnx.conectarBD();
			String sql = "SELECT idtipopago, nombre, observacion, defecto FROM conftbc_tipopago";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				TipoPago tipo = new TipoPago();
				tipo.setIdtipopago(rs.getInt("idtipopago"));
				tipo.setNombre(rs.getString("nombre"));
				tipo.setObservacion(rs.getString("observacion"));
				tipo.setDefecto(rs.getInt("defecto"));
				lista.add(tipo);
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
