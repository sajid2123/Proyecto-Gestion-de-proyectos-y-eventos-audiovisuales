package DAO;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *<p>Esta clase es para establecer y cerarar conexion con bases de datos</p>
 * @author sajid
 *
 */
public class Conexion_DB {
	/**
	 * <p>Este metodo establece la conexion con bases de datos</p>
	 * @return devuelve la conexion establecida con bases de datos
	 * @throws Exception si da error el bases de datos genera excepcion
	 */
	 public Connection AbrirConexion() throws Exception{
	        Connection con=null;  // instacia una conexión
	        try {
	           Class.forName("com.mysql.cj.jdbc.Driver");  // Cargar el driver
	           String urlOdbc = "jdbc:mysql://localhost:3306/proyecto1prueba";
	           con=(java.sql.DriverManager.getConnection(urlOdbc,"root","sajid"));  //crea conexión
	           return con;
	         } catch(Exception e){//SQLException y ClassNotFoundException
	            e.printStackTrace();
	            throw new Exception("Ha sido imposible establecer la conexion"+e.getMessage());
	         }          
	 }
	 /**
	  * <p>Este metodo es para cerrar la conexion con bases de datos</p>
	  * @param con le pasamos la conexion
	  * @throws Exception si da error el bases de datos genera excepcion
	  */
	 public  void CerrarConexion(Connection con) throws Exception{
	        
	        try {
	             if (con!= null) con.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new Exception("Ha sido imposible cerrar la conexion"+e.getMessage());
	        }    
	 }

}
