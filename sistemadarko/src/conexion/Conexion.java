package conexion;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexion {
	public Connection cnx;
	private String ipHost;
    private String puerto;
    private String baseDatos;
    private String usuario;
    private String contrasena;
    private String cadenaConexion;
    private String gestorBD;
    private String driver;
    
    public Conexion(String gestor){
    	init(gestor);
    	if(this.gestorBD.equals(gestor)){
    		this.cadenaConexion = "jdbc:mysql://" + this.ipHost + ":" + this.puerto + "/" + this.baseDatos;
            this.driver = "com.mysql.jdbc.Driver";
    	}else{
    		System.err.println("No existe implementacion para el Gestor "+gestor);
    	}
    }
        
    public void conectarBD() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
    	try {
			Class.forName(this.driver).newInstance();
		    cnx = DriverManager.getConnection(this.cadenaConexion,this.usuario,this.contrasena);
		    cnx.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
		    cnx.setAutoCommit(false);			
			
		} catch (InstantiationException ex) {
			System.err.println("causa: " + ex.getCause());
            System.err.println("Mensaje: " + ex.getMessage());
            System.err.println("Localizacion: " + ex.getLocalizedMessage());
            System.err.println("Traza: " + ex.getStackTrace());
            throw ex;
		} catch (IllegalAccessException ex) {
			System.err.println("causa: " + ex.getCause());
            System.err.println("Mensaje: " + ex.getMessage());
            System.err.println("Localizacion: " + ex.getLocalizedMessage());
            System.err.println("Traza: " + ex.getStackTrace());
            throw ex;
		} catch (ClassNotFoundException ex) {
			System.err.println("causa: " + ex.getCause());
            System.err.println("Mensaje: " + ex.getMessage());
            System.err.println("Localizacion: " + ex.getLocalizedMessage());
            System.err.println("Traza: " + ex.getStackTrace());
            throw ex;
		} catch (SQLException ex) {
			System.err.println("causa: " + ex.getCause());
            System.err.println("Mensaje: " + ex.getMessage());
            System.err.println("Localizacion: " + ex.getLocalizedMessage());
            System.err.println("Traza: " + ex.getStackTrace());
            throw ex;
		}
    }
    
    public void closeDB() throws SQLException{
    	try {
    		if(this.cnx != null && !this.cnx.isClosed()){
    			this.cnx.close();
    		}
		} catch (SQLException ex) {
			System.err.println("causa: " + ex.getCause());
            System.err.println("Mensaje: " + ex.getMessage());
            System.err.println("Localizacion: " + ex.getLocalizedMessage());
            System.err.println("Traza: " + ex.getStackTrace());
            throw ex;
		}
    }
    
    public void confirmarDB() throws SQLException{
    	try {
			this.cnx.commit();
		} catch (SQLException ex) {
			System.err.println("causa: " + ex.getCause());
            System.err.println("Mensaje: " + ex.getMessage());
            System.err.println("Localizacion: " + ex.getLocalizedMessage());
            System.err.println("Traza: " + ex.getStackTrace());
            throw ex;
		}
    }
    
    public void deshacerDB() throws SQLException{
    	try {
			this.cnx.rollback();
		} catch (SQLException ex) {
			System.err.println("causa: " + ex.getCause());
            System.err.println("Mensaje: " + ex.getMessage());
            System.err.println("Localizacion: " + ex.getLocalizedMessage());
            System.err.println("Traza: " + ex.getStackTrace());
            throw ex;
		}
    }
    
	
	public void init(String gestor){
		try{
			if(gestor.equals("MYSQL")){
				Properties properties = new Properties();
				InputStream input = getFileDBMysql().openStream();
				properties.load(input);
				
				this.ipHost = properties.getProperty("iphost");
				this.puerto=properties.getProperty("puerto");
		        this.baseDatos=properties.getProperty("namedb");
		        this.usuario=properties.getProperty("usuario");
		        this.contrasena=properties.getProperty("password");
		        this.gestorBD=properties.getProperty("gestor");
		        input.close();			
			}
		}catch(IOException ex){
			System.err.println("causa: " + ex.getCause());
            System.err.println("Mensaje: " + ex.getMessage());
            System.err.println("Localizacion: " + ex.getLocalizedMessage());
            System.err.println("Traza: " + ex.getStackTrace());
		}
	}
	
	public URL getFileDBMysql(){
		return getClass().getResource("/conexion/dbmysql.properties");
	}
}
