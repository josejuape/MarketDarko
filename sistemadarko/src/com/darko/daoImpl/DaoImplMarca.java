package com.darko.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.darko.dao.DaoMarca;
import com.darko.model.Categoria;
import com.darko.model.Marca;
import com.mysql.jdbc.Statement;

import conexion.Conexion;

public class DaoImplMarca implements DaoMarca {
	private static DaoMarca objInstance;
	private Conexion objCnx;
	
	public static DaoMarca getInstance(){
		if(objInstance == null){
			objInstance = new DaoImplMarca();
		}
		return objInstance;
	}

	public int registrar(Marca marca) throws Exception {
		// TODO Auto-generated method stub
		try{
			this.objCnx = new Conexion("MYSQL");
			this.objCnx.conectarBD();
			String sql = "INSERT INTO conftbc_producto (nombre, imagen, idcategoria, idmarca, idmodelo) values(?,?,?,?,?)";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1,marca.getNombre());
			ps.setString(2,marca.getObservacion());
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

	public int actualizar(Marca marca) throws Exception {
		// TODO Auto-generated method stub
		try{
			this.objCnx = new Conexion("MYSQL");
			this.objCnx.conectarBD();
			String sql = "UPDATE conftbc_marca SET nombre=?, observacion=? WHERE idmarca = ?";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql);
			ps.setString(1,marca.getNombre());
			ps.setString(2,marca.getObservacion());
			ps.setInt(3,marca.getIdmarca());
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

	public int eliminar(Marca marca) throws Exception {
		// TODO Auto-generated method stub
		try{
			this.objCnx = new Conexion("MYSQL");
			this.objCnx.conectarBD();
			String sql = "DELETE FROM conftbc_marca WHERE idmarca = ?";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql);
			ps.setInt(1,marca.getIdmarca());
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

	public List<Marca> listar() throws Exception {
		// TODO Auto-generated method stub
		try{
			this.objCnx = new Conexion("MYSQL");
			List<Marca> lista = new ArrayList<Marca>();
			this.objCnx.conectarBD();
			String sql = "SELECT idmarca, nombre, observacion"
					+ " FROM conftbc_marca";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Marca marca = new Marca();
				marca.setIdmarca(rs.getInt("idmarca"));
				marca.setNombre(rs.getString("nombre"));
				marca.setObservacion(rs.getString("observacion"));				
				lista.add(marca);
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
	
	public List<Marca> getMarcas(Categoria cat) throws Exception {
		// TODO Auto-generated method stub
		try{
			this.objCnx = new Conexion("MYSQL");
			List<Marca> lista = new ArrayList<Marca>();
			this.objCnx.conectarBD();
			String sql = "SELECT idmarca, m.nombre, m.observacion, m.idcategoria as categoria, c.nombre as nomcategoria "
					+ "FROM conftbc_marca m INNER JOIN conftbc_categoria c on"
					+ " m.idcategoria = c.idcategoria WHERE m.idcategoria=?";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql);
			ps.setInt(1, cat.getIdcategoria());
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Marca marca = new Marca();
				marca.setIdmarca(rs.getInt("idmarca"));
				marca.setNombre(rs.getString("nombre"));
				marca.setObservacion(rs.getString("observacion"));
				Categoria categoria = new Categoria();
				categoria.setIdcategoria(rs.getInt("categoria"));
				categoria.setNombre(rs.getString("nomcategoria"));
				//marca.setCategoria(categoria);
				lista.add(marca);
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
