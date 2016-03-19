package com.darko.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.darko.dao.DaoProducto;
import com.darko.model.Categoria;
import com.darko.model.Color;
import com.darko.model.Marca;
import com.darko.model.Modelo;
import com.darko.model.Producto;
import com.darko.model.Talla;
import com.mysql.jdbc.Statement;

import conexion.Conexion;

public class DaoImplProducto implements DaoProducto {
	private static DaoProducto objInstance;
	private Conexion objCnx;
	
	public static DaoProducto getInstance(){
		if(objInstance == null){
			objInstance = new DaoImplProducto();
		}
		return objInstance;
	}

	public int registrar(Producto producto) throws Exception {
		try{
			this.objCnx = new Conexion("MYSQL");
			this.objCnx.conectarBD();
			String sql = "INSERT INTO conftbc_producto (nombre_producto, imagen, idcategoria, idmarca, idmodelo) values(?,?,?,?,?)";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1,producto.getNombre());
			ps.setString(2,producto.getImagen());
			ps.setInt(3, producto.getCategoria().getIdcategoria());
			ps.setInt(4, producto.getMarca().getIdmarca());
			ps.setInt(5, producto.getModelo().getIdmodelo());
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

	public int actualizar(Producto producto) throws Exception {
		// TODO Auto-generated method stub
		try{
			this.objCnx = new Conexion("MYSQL");
			this.objCnx.conectarBD();
			String sql = "UPDATE conftbc_producto SET nombre_producto=?, imagen=?, idcategoria=?, idmarca=?, idmodelo=? WHERE idmodelo = ?";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql);
			ps.setString(1,producto.getNombre());
			ps.setString(2,producto.getImagen());
			ps.setInt(3,producto.getCategoria().getIdcategoria());
			ps.setInt(4, producto.getMarca().getIdmarca());
			ps.setInt(5, producto.getModelo().getIdmodelo());
			ps.setInt(6, producto.getModelo().getIdmodelo());// como el producto se originacuando se crea el modelo lo actualizamos por el modelo
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

	public int eliminar(Producto producto) throws Exception {
		// TODO Auto-generated method stub
		try{
			this.objCnx = new Conexion("MYSQL");
			this.objCnx.conectarBD();
			String sql = "DELETE FROM conftbc_producto WHERE idmodelo = ?";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql);
			ps.setInt(1,producto.getModelo().getIdmodelo());
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

	public List<Producto> listar() throws Exception {
		// TODO Auto-generated method stub
		try{
			this.objCnx = new Conexion("MYSQL");
			List<Producto> lista = new ArrayList<Producto>();
			this.objCnx.conectarBD();
			String sql = "SELECT t.idproducto, t.nombre_producto, t.imagen, t.idcategoria, t.idmarca, t.idmodelo, c.nombre as categoria, m.nombre as marca, d.nombre as modelo "
					+ " FROM conftbc_producto t INNER JOIN conftbc_categoria c on c.idcategoria = t.idcategoria"
					+ " INNER JOIN conftbc_marca m  on m.idmarca = t.idmarca INNER JOIN conftbc_modelo d on d.idmodelo = t.idmodelo  ";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Producto producto = new Producto();
				producto.setIdproducto(rs.getInt("idproducto"));
				producto.setNombre(rs.getString("nombre_producto"));
				producto.setImagen(rs.getString("imagen"));
				Categoria categoria = new Categoria();
				categoria.setIdcategoria(rs.getInt("idcategoria"));
				categoria.setNombre(rs.getString("categoria"));
				producto.setCategoria(categoria);
				Marca marca = new Marca();
				marca.setIdmarca(rs.getInt("idmarca"));
				marca.setNombre(rs.getString("marca"));
				producto.setMarca(marca);
				Modelo modelo = new Modelo();
				modelo.setIdmodelo(rs.getInt("idmodelo"));
				modelo.setNombre(rs.getString("modelo"));
				producto.setModelo(modelo);
				lista.add(producto);
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
	
	public List<Producto> buscar(String nombre) throws Exception {
		// TODO Auto-generated method stub
		try{
			this.objCnx = new Conexion("MYSQL");
			List<Producto> lista = new ArrayList<Producto>();
			this.objCnx.conectarBD();
			String sql = "SELECT idproducto, nombre_producto, imagen "
					+ " FROM conftbc_producto  WHERE nombre_producto like '%"+nombre+"%' ";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Producto producto = new Producto();
				producto.setIdproducto(rs.getInt("idproducto"));
				producto.setNombre(rs.getString("nombre_producto"));
				producto.setImagen(rs.getString("imagen"));
//				Categoria categoria = new Categoria();
//				categoria.setIdcategoria(rs.getInt("idcategoria"));
//				categoria.setNombre(rs.getString("categoria"));
//				producto.setCategoria(categoria);
//				Marca marca = new Marca();
//				marca.setIdmarca(rs.getInt("idmarca"));
//				marca.setNombre(rs.getString("marca"));
//				producto.setMarca(marca);
//				Modelo modelo = new Modelo();
//				modelo.setIdmodelo(rs.getInt("idmodelo"));
//				modelo.setNombre(rs.getString("modelo"));
//				producto.setModelo(modelo);
				lista.add(producto);
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

	public List<Producto> getProductos(Producto producto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Talla> tallasProducto(Producto producto) throws Exception {
		// TODO Auto-generated method stub
		try{
			this.objCnx = new Conexion("MYSQL");
			List<Talla> lista = new ArrayList<Talla>();
			this.objCnx.conectarBD();
			String sql = "SELECT t.idtalla, t.nombre, t.observacion FROM conftbc_talla t "
					+ " INNER JOIN conftbc_producto p ON t.idcategoria = p.idcategoria WHERE p.idproducto = "+producto.getIdproducto();
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Talla talla = new Talla();
				talla.setIdtalla(rs.getInt("idtalla"));
				talla.setNombre(rs.getString("nombre"));
				talla.setObservacion(rs.getString("observacion"));
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
	
	public List<Color> coloresProducto(Producto producto) throws Exception {
		// TODO Auto-generated method stub
		try{
			this.objCnx = new Conexion("MYSQL");
			List<Color> lista = new ArrayList<Color>();
			this.objCnx.conectarBD();
			String sql = "SELECT t.idcolor, t.nombre, t.observacion FROM conftbc_color t "
					+ " INNER JOIN conftbc_producto p ON t.idmarca = p.idmarca WHERE p.idproducto = "+producto.getIdproducto();
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Color color = new Color();
				color.setIdcolor(rs.getInt("idcolor"));
				color.setNombre(rs.getString("nombre"));
				color.setObservacion(rs.getString("observacion"));
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
