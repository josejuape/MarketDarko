package com.darko.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.darko.dao.DaoModelo;
import com.darko.model.Categoria;
import com.darko.model.Marca;
import com.darko.model.Modelo;
import com.mysql.jdbc.Statement;

import conexion.Conexion;

public class DaoImplModelo implements DaoModelo {
	private static DaoModelo objInstance;
	private Conexion objCnx;
	
	public static DaoModelo getInstance(){
		if(objInstance == null){
			objInstance = new DaoImplModelo();
		}
		return objInstance;
	}

	public int registrar(Modelo modelo) throws Exception {
		// TODO Auto-generated method stub
		try{
			this.objCnx = new Conexion("MYSQL");
			this.objCnx.conectarBD();
			String sql = "INSERT INTO conftbc_modelo (nombre,observacion,url_imagen) values(?,?,?)";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1,modelo.getNombre());
			ps.setString(2,modelo.getObservacion());
			ps.setString(3, modelo.getUrlImagen());
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

	public int actualizar(Modelo modelo) throws Exception {
		// TODO Auto-generated method stub
		try{
			this.objCnx = new Conexion("MYSQL");
			this.objCnx.conectarBD();
			String sql = "UPDATE conftbc_modelo SET nombre=?, observacion=?,url_imagen=? WHERE idmodelo = ?";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql);
			ps.setString(1,modelo.getNombre());
			ps.setString(2,modelo.getObservacion());
			ps.setString(3, modelo.getUrlImagen());
			ps.setInt(4,modelo.getIdmodelo());
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

	public int eliminar(Modelo modelo) throws Exception {
		// TODO Auto-generated method stub
		try{
			this.objCnx = new Conexion("MYSQL");
			this.objCnx.conectarBD();
			String sql = "DELETE FROM conftbc_modelo WHERE idmodelo = ?";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql);
			ps.setInt(1,modelo.getIdmodelo());
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

	public List<Modelo> listar() throws Exception {
		// TODO Auto-generated method stub
		try{
			this.objCnx = new Conexion("MYSQL");
			List<Modelo> lista = new ArrayList<Modelo>();
			this.objCnx.conectarBD();
			String sql = "SELECT idmodelo, nombre, observacion, url_imagen "
					+ " FROM conftbc_modelo  ";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Modelo modelo = new Modelo();
				modelo.setIdmodelo(rs.getInt("idmodelo"));
				modelo.setNombre(rs.getString("nombre"));
				modelo.setObservacion(rs.getString("observacion"));
				modelo.setUrlImagen(rs.getString("url_imagen"));
				lista.add(modelo);
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

	public List<Modelo> getModelos(Marca marca) throws Exception {
		// TODO Auto-generated method stub
		try{
			this.objCnx = new Conexion("MYSQL");
			List<Modelo> lista = new ArrayList<Modelo>();
			this.objCnx.conectarBD();
			String sql = "SELECT m.idmodelo, m.nombre, m.observacion, m.idmarca as marca, c.nombre as nommarca "
					+ "FROM conftbc_modelo m INNER JOIN conftbc_marca c on"
					+ " m.idmarca = c.idmarca WHERE m.idmarca=?";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql);
			ps.setInt(1, marca.getIdmarca());
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Modelo modelo = new Modelo();
				modelo.setIdmodelo(rs.getInt("idmodelo"));
				modelo.setNombre(rs.getString("nombre"));
				modelo.setObservacion(rs.getString("observacion"));
				Marca mar = new Marca();
				lista.add(modelo);
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
