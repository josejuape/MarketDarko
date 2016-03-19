package com.darko.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.darko.dao.DaoCategoria;
import com.darko.model.Categoria;
import com.mysql.jdbc.Statement;

import conexion.Conexion;

public class DaoImplCategoria implements DaoCategoria {
	private static DaoCategoria objInstance;
	private Conexion objCnx;
	
	public static DaoCategoria getInstance(){
		if(objInstance == null){
			objInstance = new DaoImplCategoria();
		}
		return objInstance;
	}

	public int registrar(Categoria categoria) throws Exception {
		// TODO Auto-generated method stub
		try{
			this.objCnx = new Conexion("MYSQL");
			this.objCnx.conectarBD();
			String sql = "INSERT INTO conftbc_categoria (nombre,observacion,valor_flete) values(?,?,?)";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1,categoria.getNombre());
			ps.setString(2,categoria.getObservacion());
			ps.setDouble(3,categoria.getValor_flete());
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

	public int actualizar(Categoria categoria) throws Exception {
		// TODO Auto-generated method stub
		try{
			this.objCnx = new Conexion("MYSQL");
			this.objCnx.conectarBD();
			String sql = "UPDATE conftbc_categoria SET nombre=?, observacion=?, valor_flete=? WHERE idcategoria = ?";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql);
			ps.setString(1,categoria.getNombre());
			ps.setString(2,categoria.getObservacion());
			ps.setDouble(3,categoria.getValor_flete());
			ps.setInt(4,categoria.getIdcategoria());
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

	public int eliminar(Categoria categoria) throws Exception {
		// TODO Auto-generated method stub
		try{
			this.objCnx = new Conexion("MYSQL");
			this.objCnx.conectarBD();
			String sql = "DELETE FROM conftbc_categoria WHERE idcategoria = ?";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql);
			ps.setInt(1,categoria.getIdcategoria());
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

	public List<Categoria> listar() throws Exception {
		// TODO Auto-generated method stub
		try{
			this.objCnx = new Conexion("MYSQL");
			List<Categoria> lista = new ArrayList<Categoria>();
			this.objCnx.conectarBD();
			String sql = "SELECT idcategoria, nombre, observacion, valor_flete FROM conftbc_categoria";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Categoria cat = new Categoria();
				cat.setIdcategoria(rs.getInt("idcategoria"));
				cat.setNombre(rs.getString("nombre"));
				cat.setObservacion(rs.getString("observacion"));
				cat.setValor_flete(rs.getDouble("valor_flete"));
				lista.add(cat);
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
