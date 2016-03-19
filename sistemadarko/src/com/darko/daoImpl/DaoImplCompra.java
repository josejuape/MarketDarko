package com.darko.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.darko.dao.DaoCompra;
import com.darko.model.DetalleColor;
import com.darko.model.DetalleTalla;
import com.darko.model.Inventario;
import com.mysql.jdbc.Statement;

import conexion.Conexion;

public class DaoImplCompra implements DaoCompra {
	private static DaoCompra objInstance;
	private Conexion objCnx;
	
	public static DaoCompra getInstance(){
		if(objInstance == null){
			objInstance = new DaoImplCompra();
		}
		return objInstance;
	}

	public int registrarInventario(Inventario inventario) throws Exception {
		// TODO Registra un inventario en el proceso de compra
		try{
			this.objCnx = new Conexion("MYSQL");
			this.objCnx.conectarBD();
			String sql = "INSERT INTO comtbc_inventario (nombre_producto,costo_unitario,costo_total,cantidad_compra,estado,"
					+ " stock,idproducto,idtracking,fecha_registro,fecha_actualizacion) values(?,?,?,?,?,?,?,?,now(),now())";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1,inventario.getNombre());
			ps.setDouble(2,inventario.getCostoUnitario());
			ps.setDouble(3,inventario.getCostoTotal());
			ps.setInt(4, inventario.getCantidad());
			ps.setString(5, inventario.getEstado());
			ps.setInt(6, inventario.getCantidad());
			ps.setInt(7, inventario.getProducto().getIdproducto());
			ps.setInt(8, inventario.getTracking().getIdtracking());			
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

	public int eliminarInventario(Inventario inventario) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public int registrarTallasProducto(DetalleTalla obj) throws Exception {
		// TODO Auto-generated method stub
		try{
			this.objCnx = new Conexion("MYSQL");
			this.objCnx.conectarBD();
			String sql = "INSERT INTO comtbd_detalle_talla (talla,estado,idinventario,idtalla) values(?,?,?,?)";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1,obj.getNombre());
			ps.setString(2,obj.getEstado());
			ps.setInt(3,obj.getInventario().getIdinventario());
			ps.setInt(4, obj.getTalla().getIdtalla());
					
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

	public int registrarColoresProducto(DetalleColor obj) throws Exception {
		// TODO Auto-generated method stub
		try{
			this.objCnx = new Conexion("MYSQL");
			this.objCnx.conectarBD();
			String sql = "INSERT INTO comtbd_detalle_color (color,estado,idinventario,idcolor) values(?,?,?,?)";
			PreparedStatement ps = this.objCnx.cnx.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1,obj.getNombre());
			ps.setString(2,obj.getEstado());
			ps.setInt(3,obj.getInventario().getIdinventario());
			ps.setInt(4, obj.getColor().getIdcolor());
					
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


}
