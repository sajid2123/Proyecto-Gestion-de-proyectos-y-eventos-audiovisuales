package DAO;

import java.io.EOFException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Entidad.Contenido;
import Entidad.Empleado;
import Entidad.Contenido;
import Entidad.TablonAnuncio;
import Excepcion.ExcepcionNoEncontrado;

/**
 * <p>Esta clase representa un contenido y proporciona funcionalidades para 
 * gestionar la información relacionada con los contenido en la base de datos.</p>
 * @author sajid
 *
 */
public class ContenidoDAO {
	
	/**
	 * <p>Este metodo es para ver todos los contenidos disponibles en bases de datos</p>
	 * 
	 * @param con <p>Establece la conexion con la bases de datos</p>
	 * @return <p>Devuelve una lista con todos los software de contenido que tenemos</p>
	 * @throws Exception <p>Tira una exepcion si hay un problema con SQL</p> 
	 */
	 public List <Contenido> verContenido(Connection con) throws Exception {
	        List <Contenido> _listacontenido = new ArrayList<Contenido>();
	        PreparedStatement stmt = null;
	        ResultSet rs = null;
	        try {
	            stmt = con.prepareStatement("SELECT * FROM contenido"); 
	            rs = stmt.executeQuery();
	            Contenido contenido = null;
	            while(rs.next()) {
	                contenido = new Contenido();
	                obtenContenidoFila(rs, contenido);
	                _listacontenido.add(contenido);
	            }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	            throw new EOFException("Ha habido un problema al buscar contenido " + ex.getMessage());
	        } finally {
	            if (rs != null) rs.close();
	            if (rs != null) stmt.close();            
	        }
	        return _listacontenido;
	    }
	 
	 /**
	  * Obtiene los datos de un registro de la base de datos representado por el objeto ResultSet
	  * y los asigna a un objeto Contenido.
	  * 
	  * @param rs El objeto ResultSet que contiene los datos del registro.
	  * @param contenido El objeto Contenido al cual se asignarán los datos.
	  * @throws SQLException Si ocurre un error al acceder a los datos del ResultSet.
	  */

	private void obtenContenidoFila(ResultSet rs, Contenido contenido) throws SQLException {
		contenido.setIdContenido(rs.getInt("id_contenido"));
		contenido.setTipo(rs.getString("tipo"));
		contenido.setPrecio(rs.getDouble("precio"));
		contenido.setSoftware(rs.getString("software"));
	}
	/**
	 * <p>Este metodo es para obtener todos los empleados de contenido </p>
	 * @param con Para establecer conexion con bases de datos
	 * @return Devuelve el contenido donde que tiene un arraylist que tiene los empleados 
	 * @throws Exception Si hay un problema con bases de datos
	 */ 
	public Contenido verEmpleadosContenido(Connection con) throws Exception {
    	Empleado empleado = null;
    	PreparedStatement stmt = null;
    	Contenido contenido = new Contenido();
    	try {
            stmt = con.prepareStatement ("select * from empleado where id_dept in (select id_dept from departamento where nombreDepartamento like 'Contenido')");
            ResultSet rs = stmt.executeQuery();
            
			while(rs.next()) {
				empleado = new Empleado(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getInt(8),rs.getInt(9));
				contenido.addEmpleado(empleado);
			}
		
		}catch(SQLException e) {
			e.printStackTrace();
			throw new Exception("Ha habido un problema" + e.getMessage());
		}finally {
			if(stmt != null) stmt.close();
		}
		return contenido;
    }
	/**
	 * <p>Este metodo es para añadir un contenido nuevo en la bases de datos</p>
	 * @param con  Para establecer conexion con bases de datos
	 * @param contenido el contenido que quiero añadir
	 * @throws Exception Si hay un problema con bases de datos
	 */
	public void addContenido(Connection con,Contenido contenido) throws Exception {
		PreparedStatement stmt=null;
		try {
			stmt=con.prepareStatement("insert into contenido (tipo,precio,software)" 
			                        + "values(?,?,?)");
			stmt.setString(1,contenido.getTipo());
			stmt.setDouble(2, contenido.getPrecio());
			stmt.setString(3, contenido.getSoftware());
			
			
			stmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new Exception("Ha habido un problema al insertar articulo" + e.getMessage());
		}finally {
			if(stmt != null) stmt.close();
		}
	}
	/**
	 * <p>Este metodo es para buscar un contenido con el nombre</p>
	 * 
	 * @param con  Para establecer conexion con bases de datos
	 * @param contenido le paso un objeto que tiene el nombre que quiere buscar el usuario
	 * @return devuelve si encuentra un contenido con el nombre de objeto que le hemos pasado
	 * @throws Exception Si hay un problema con bases de datos
	 */
	public Contenido findByNombre(Connection con, Contenido contenido) throws Exception {
	        Contenido _contenido = null;
	        PreparedStatement stmt = null;
	        ResultSet rs = null;
	        try {
	            stmt = con.prepareStatement ("SELECT * FROM Contenido WHERE software=?");
	            stmt.setString(1, contenido.getSoftware());
	            rs =  stmt.executeQuery();
	                while (rs.next()) {
	                    _contenido = new Contenido();
	                    obtenContenidoFila(rs, _contenido);
	                }
	                
	                if(_contenido == null) {
	                	throw new ExcepcionNoEncontrado(2);
	                }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        } finally {
	            if (rs != null) rs.close();
	            if (rs != null) stmt.close();            
	        }
			return _contenido;
	}
	/**
	 * <p>Este metodo es para buscar un contenido con el id</p>
	 * 
	 * @param con  Para establecer conexion con bases de datos
	 * @param contenido le paso un objeto que tiene el id que quiere buscar el usuario
	 * @return devuelve si encuentra un contenido con el id de objeto que le hemos pasado
	 * @throws Exception Si hay un problema con bases de datos
	 */
	public Contenido findById(Connection con, Contenido contenido) throws Exception {
        Contenido _contenido = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement ("SELECT * FROM Contenido WHERE id_contenido=?");
            stmt.setInt(1, contenido.getIdContenido());
            rs =  stmt.executeQuery();
                while (rs.next()) {
                    _contenido = new Contenido();
                    obtenContenidoFila(rs, _contenido);
                }
                if(_contenido == null) {
                	throw new ExcepcionNoEncontrado(2);
                }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) rs.close();
            if (rs != null) stmt.close();            
        }
		return _contenido;
	}
	/**
	 * <p>Este metodo es para eliminar un contenido</p>
	 * 
	 * @param con  Para establecer conexion con bases de datos
	 * @param contenido le paso el objeto de contenido que quiero eliminar
	 * @throws Exception Si hay un problema con bases de datos
	 */
	public void eliminarContenido(Connection con,Contenido contenido) throws Exception {
		PreparedStatement stmt=null;
		try {
			stmt=con.prepareStatement("Delete from contenido " 
			                        + "where id_contenido=?");
			stmt.setInt(1,contenido.getIdContenido());
			stmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new Exception("Ha habido un problema al insertar articulo" + e.getMessage());
		}finally {
			if(stmt != null) stmt.close();
		}
	}
	/**
	 * <p>Este metodo es para modificar el precio de un contenido</p>
	 * 
	 * @param con  Para establecer conexion con bases de datos
	 * @param contenido le paso un contenido con el nuevo precio y la id donde quiero cambiar el precio
	 * @throws Exception Si hay un problema con bases de datos
	 */
	public void modificarPrecio(Connection con,Contenido contenido) throws Exception {
		PreparedStatement stmt=null;
		try {
			stmt=con.prepareStatement("update contenido set precio=? " 
			                        + "where id_contenido=?");
			stmt.setDouble(1, contenido.getPrecio());
			stmt.setInt(2,contenido.getIdContenido());
			stmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new Exception("Ha habido un problema al modificar Precio" + e.getMessage());
		}finally {
			if(stmt != null) stmt.close();
		}
	}
	/**
	 * <p>Este metodo es para modificar nombre de un contenido</p>
	 * @param con  Para establecer conexion con bases de datos
	 * @param contenido le paso un contenido con el nuevo nombre y la id donde quiero cambiar el precio
	 * @throws Exception Si hay un problema con bases de datos
	 */
	public void modificarNombre(Connection con,Contenido contenido) throws Exception {
		PreparedStatement stmt=null;
		try {
			stmt=con.prepareStatement("update contenido set software=? " 
			                        + "where id_contenido=?");
			stmt.setString(1, contenido.getSoftware());
			stmt.setInt(2,contenido.getIdContenido());
			stmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new Exception("Ha habido un problema al modificar Nombre" + e.getMessage());
		}finally {
			if(stmt != null) stmt.close();
		}
	}
	
	
    
}
