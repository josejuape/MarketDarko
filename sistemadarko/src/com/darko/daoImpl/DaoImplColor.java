package com.darko.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.darko.dao.DaoColor;
import com.darko.model.Categoria;
import com.darko.model.Color;
import com.darko.model.Marca;
import com.mysql.jdbc.Statement;

import conexion.Conexion;

public class DaoImplColor implements DaoColor {
	private static DaoColor objInstance;
	private Conexion objCnx;
	
	public static DaoColor getInstance(){
		if(objInstance == null){
			objInstance = new DaoImplColor();
		}
		return objInstance;
	}

	public int registrar(Color color) throws Exception {
		// TODO Auto-generated method stub
		try{
			this.objCnx = new Conexion("MYSQL");
			this.objCnx.conectarBD();
			String sql = "INSERT INTO conftbc_color (nombre,observacion,idmarca) values(?,?,?)";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1,color.getNombre());
			ps.setString(2,color.getObservacion());
			ps.setDouble(3,color.getMarca().getIdmarca());
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

	public int actualizar(Color color) throws Exception {
		// TODO Auto-generated method stub
		try{
			this.objCnx = new Conexion("MYSQL");
			this.objCnx.conectarBD();
			String sql = "UPDATE conftbc_color SET nombre=?, observacion=?, idmarca=? WHERE idcolor = ?";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql);
			ps.setString(1,color.getNombre());
			ps.setString(2,color.getObservacion());
			ps.setInt(3,color.getMarca().getIdmarca());
			ps.setInt(4,color.getIdcolor());
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

	public int eliminar(Color color) throws Exception {
		// TODO Auto-generated method stub
		try{
			this.objCnx = new Conexion("MYSQL");
			this.objCnx.conectarBD();
			String sql = "DELETE FROM conftbc_color WHERE idcolor = ?";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql);
			ps.setInt(1,color.getIdcolor());
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

	public List<Color> listar() throws Exception {
		// TODO Auto-generated method stub
		try{
			this.objCnx = new Conexion("MYSQL");
			List<Color> lista = new ArrayList<Color>();
			this.objCnx.conectarBD();
			String sql = "SELECT idcolor, m.nombre, m.observacion, c.idmarca as marca, c.nombre as nommarca "
					+ "FROM conftbc_color m INNER JOIN conftbc_marca c on m.idmarca = c.idmarca ";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Color color = new Color();
				color.setIdcolor(rs.getInt("idcolor"));
				color.setNombre(rs.getString("nombre"));
				color.setObservacion(rs.getString("observacion"));
				Marca marca = new Marca();
				marca.setIdmarca(rs.getInt("marca"));
				marca.setNombre(rs.getString("nommarca"));
				color.setMarca(marca);
				lista.add(color);
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
	
	public List<Color> getColores(Marca marca) throws Exception {
		// TODO Auto-generated method stub
		try{
			this.objCnx = new Conexion("MYSQL");
			List<Color> lista = new ArrayList<Color>();
			this.objCnx.conectarBD();
			String sql = "SELECT m.idcolor, m.nombre, m.observacion, m.idmarca as marca, c.nombre as nommarca "
					+ "FROM conftbc_color m INNER JOIN conftbc_marca c on"
					+ " m.idmarca = c.idmarca WHERE m.idmarca=?";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql);
			ps.setInt(1, marca.getIdmarca());
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Color color = new Color();
				color.setIdcolor(rs.getInt("idcolor"));
				color.setNombre(rs.getString("nombre"));
				color.setObservacion(rs.getString("observacion"));
				Marca mar = new Marca();
				mar.setIdmarca(rs.getInt("marca"));
				mar.setNombre(rs.getString("nommarca"));
				color.setMarca(mar);
				lista.add(color);
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
