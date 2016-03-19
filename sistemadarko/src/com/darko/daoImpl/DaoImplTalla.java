package com.darko.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.darko.dao.DaoTalla;
import com.darko.model.Categoria;
import com.darko.model.Talla;
import com.mysql.jdbc.Statement;

import conexion.Conexion;

public class DaoImplTalla implements DaoTalla {
	private static DaoTalla objInstance;
	private Conexion objCnx;
	
	public static DaoTalla getInstance(){
		if(objInstance == null){
			objInstance = new DaoImplTalla();
		}
		return objInstance;
	}

	public int registrar(Talla talla) throws Exception {
		// TODO Auto-generated method stub
		try{
			this.objCnx = new Conexion("MYSQL");
			this.objCnx.conectarBD();
			String sql = "INSERT INTO conftbc_talla (nombre,observacion,defecto,idcategoria) values(?,?,?,?)";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1,talla.getNombre());
			ps.setString(2,talla.getObservacion());
			ps.setInt(3,talla.getDefecto());
			ps.setInt(4, talla.getCategoria().getIdcategoria());
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

	public int actualizar(Talla talla) throws Exception {
		// TODO Auto-generated method stub
		try{
			this.objCnx = new Conexion("MYSQL");
			this.objCnx.conectarBD();
			String sql = "UPDATE conftbc_talla SET nombre=?, observacion=?, defecto=?, idcategoria=? WHERE idtalla = ?";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql);
			ps.setString(1,talla.getNombre());
			ps.setString(2,talla.getObservacion());
			ps.setInt(3,talla.getDefecto());
			ps.setInt(4, talla.getCategoria().getIdcategoria());
			ps.setInt(5,talla.getIdtalla());
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

	public int eliminar(Talla talla) throws Exception {
		// TODO Auto-generated method stub
		try{
			this.objCnx = new Conexion("MYSQL");
			this.objCnx.conectarBD();
			String sql = "DELETE FROM conftbc_talla WHERE idtalla = ?";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql);
			ps.setInt(1,talla.getIdtalla());
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

	public List<Talla> listar() throws Exception {
		// TODO Auto-generated method stub
		try{
			this.objCnx = new Conexion("MYSQL");
			List<Talla> lista = new ArrayList<Talla>();
			this.objCnx.conectarBD();
			String sql = "SELECT t.idtalla, t.nombre, t.observacion, t.defecto,t.idcategoria,c.nombre as categoria"
					+ " FROM conftbc_talla t INNER JOIN conftbc_categoria c on t.idcategoria = c.idcategoria";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Talla talla = new Talla();
				talla.setIdtalla(rs.getInt("idtalla"));
				talla.setNombre(rs.getString("nombre"));
				talla.setObservacion(rs.getString("observacion"));
				talla.setDefecto(rs.getInt("defecto"));
				Categoria categoria = new Categoria();
				categoria.setIdcategoria(rs.getInt("idcategoria"));
				categoria.setNombre(rs.getString("categoria"));
				talla.setCategoria(categoria);
				lista.add(talla);
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
