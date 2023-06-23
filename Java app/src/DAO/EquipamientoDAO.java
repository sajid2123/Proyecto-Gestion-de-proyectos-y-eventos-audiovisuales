package DAO;

import java.io.EOFException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entidad.Equipamiento;
import Excepcion.ExcepcionNoEncontrado;
import Entidad.Empleado;
import Entidad.Equipamiento;

/**
 * <p>Esta clase representa un equipamiento y proporciona funcionalidades para
 *  gestionar la información relacionada con los equipamientos en la base de datos.</p>
 * @author sajid
 *
 */
public class EquipamientoDAO {
	
	/**
	 * <p>Este metodo es para ver todos los equipamiento disponibles en bases de datos</p>
	 * 
	 * @param con <p>Establece la conexion con la bases de datos</p>
	 * @return <p>Devuelve una lista con todos los equipamientos que tenemos</p>
	 * @throws Exception <p>Tira una exepcion si hay un problema con SQL</p> 
	 */
	 public List <Equipamiento> verEquipamiento(Connection con) throws Exception {
	        List <Equipamiento> _listaEquipamiento = new ArrayList<Equipamiento>();
	        PreparedStatement stmt = null;
	        ResultSet rs = null;
	        try {
	            stmt = con.prepareStatement("SELECT * FROM Equipamiento"); 
	            rs = stmt.executeQuery();
	            Equipamiento equipamiento = null;
	            while(rs.next()) {
	                equipamiento = new Equipamiento();
	                obtenEquipamientoFila(rs, equipamiento);
	                _listaEquipamiento.add(equipamiento);
	            }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	            throw new EOFException("Ha habido un problema al buscar Equipamiento " + ex.getMessage());
	        } finally {
	            if (rs != null) rs.close();
	            if (rs != null) stmt.close();            
	        }
	        return _listaEquipamiento;
	   }

	 /**
	  * Obtiene los datos de un registro de la base de datos representado por el objeto ResultSet
	  * y los asigna a un objeto Equipamiento.
	  * 
	  * @param rs El objeto ResultSet que contiene los datos del registro.
	  * @param equipamiento El objeto Contenido al cual se asignarán los datos.
	  * @throws SQLException Si ocurre un error al acceder a los datos del ResultSet.
	  */

	private void obtenEquipamientoFila(ResultSet rs, Equipamiento equipamiento) throws SQLException {
		equipamiento.setIdEquipamiento(rs.getInt("id_equipamiento"));
		equipamiento.setNombre(rs.getString("nombre"));
		equipamiento.setTipo(rs.getString("tipo"));
		equipamiento.setEjemplares(rs.getInt("ejemplares"));
		equipamiento.setPrecio(rs.getDouble("precio"));
		equipamiento.setImagen(rs.getString("imagen"));
	}
	/**
	 * <p>Este metodo es para obtener todos los empleados de equipamiento </p>
	 * @param con Para establecer conexion con bases de datos
	 * @return Devuelve el equimapiento que tiene  un arraylist que tiene los empleados 
	 * @throws Exception Si hay un problema con bases de datos
	 */ 
	public Equipamiento verEmpleadosEquipamiento(Connection con) throws Exception {
    	Empleado empleado = null;
    	PreparedStatement stmt = null;
    	Equipamiento equipamiento = new Equipamiento();
    	try {
            stmt = con.prepareStatement ("select * from empleado where id_dept in (select id_dept from departamento where nombreDepartamento like 'Equipamiento')");
            ResultSet rs = stmt.executeQuery();
            
			while(rs.next()) {
				empleado = new Empleado(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getInt(8),rs.getInt(9));
				equipamiento.addEmpleado(empleado);
			}
		
		}catch(SQLException e) {
			e.printStackTrace();
			throw new Exception("Ha habido un problema" + e.getMessage());
		}finally {
			if(stmt != null) stmt.close();
		}
		return equipamiento;
    }
	/**
	 * <p>Este metodo es para añadir un equipamiento nuevo en la bases de datos</p>
	 * @param con  Para establecer conexion con bases de datos
	 * @param equipamiento el equipamiento que quiero añadir
	 * @throws Exception Si hay un problema con bases de datos
	 */
	public void addEquipamiento(Connection con,Equipamiento equipamiento) throws Exception {
		PreparedStatement stmt=null;
		try {
			stmt=con.prepareStatement("insert into equipamiento (nombre,tipo,ejemplares,precio,imagen)" 
			                        + "values(?,?,?,?,?)");
			stmt.setString(1,equipamiento.getNombre());
			stmt.setString(2, equipamiento.getTipo());
			stmt.setInt(3, equipamiento.getEjemplares());
			stmt.setDouble(4, equipamiento.getPrecio());
			stmt.setString(5,equipamiento.getImagen());
			stmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new Exception("Ha habido un problema al insertar articulo" + e.getMessage());
		}finally {
			if(stmt != null) stmt.close();
		}
	}
	/**
	 * <p>Este metodo es para modificar el stock de un equipamiento</p>
	 * @param con Para establecer conexion con bases de datos
	 * @param equipamiento el equipamiento donde quiero modificar el stock
	 * @throws Exception Si hay un problema con bases de datos
	 */
	public void updateStock(Connection con,Equipamiento equipamiento ) throws Exception {
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement ("update equipamiento set ejemplares=?  WHERE id_equipamiento=?");
            stmt.setInt(1, equipamiento.getEjemplares());
			stmt.setInt(2, equipamiento.getIdEquipamiento());
			stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			throw new Exception("Ha habido un problema al actualizar stock" + e.getMessage());
		}finally {
			if(stmt != null) stmt.close();
		}
    }
	/**
	 * <p>Este metodo es para buscar un equipamiento con el nombre</p>
	 * 
	 * @param con  Para establecer conexion con bases de datos
	 * @param equipamiento le paso un objeto que tiene el nombre que quiere buscar el usuario
	 * @return devuelve si encuentra un equipamiento con el nombre de objeto que le hemos pasado
	 * @throws Exception Si hay un problema con bases de datos
	 */
	 public Equipamiento findByNombre(Connection con, Equipamiento equipamiento) throws Exception {
	        Equipamiento _equipamiento = null;
	        PreparedStatement stmt = null;
	        ResultSet rs = null;
	        try {
	            stmt = con.prepareStatement ("SELECT * FROM Equipamiento WHERE nombre=?");
	            stmt.setString(1, equipamiento.getNombre());
	            rs =  stmt.executeQuery();
	                while (rs.next()) {
	                    _equipamiento = new Equipamiento();
	                    obtenEquipamientoFila(rs, _equipamiento);
	                }
	                if(_equipamiento == null) {
	                	throw new ExcepcionNoEncontrado(1);
	                }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        } finally {
	            if (rs != null) rs.close();
	            if (rs != null) stmt.close();            
	        }
			return _equipamiento;
	   }
	 	/**
		 * <p>Este metodo es para buscar un equipamiento con el id</p>
		 * 
		 * @param con  Para establecer conexion con bases de datos
		 * @param equipamiento le paso un objeto que tiene el id que quiere buscar el usuario
		 * @return devuelve si encuentra un equipamiento con el id de objeto que le hemos pasado
		 * @throws Exception Si hay un problema con bases de datos
		 */
	 public Equipamiento findById(Connection con, Equipamiento equipamiento) throws Exception {
	        Equipamiento _equipamiento = null;
	        PreparedStatement stmt = null;
	        ResultSet rs = null;
	        try {
	            stmt = con.prepareStatement ("SELECT * FROM Equipamiento WHERE id_equipamiento=?");
	            stmt.setInt(1, equipamiento.getIdEquipamiento());
	            rs =  stmt.executeQuery();
	                while (rs.next()) {
	                    _equipamiento = new Equipamiento();
	                    obtenEquipamientoFila(rs, _equipamiento);
	                }
	                if(_equipamiento == null) {
	                	throw new ExcepcionNoEncontrado(1);
	                }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        } finally {
	            if (rs != null) rs.close();
	            if (rs != null) stmt.close();            
	        }
			return _equipamiento;
	   }
	 /**
		 * <p>Este metodo es para eliminar un equipamiento</p>
		 * 
		 * @param con  Para establecer conexion con bases de datos
		 * @param equipamiento le paso el objeto de contenido que quiero eliminar
		 * @throws Exception Si hay un problema con bases de datos
		 */
		public void eliminarEquipamiento(Connection con,Equipamiento equipamiento) throws Exception {
			PreparedStatement stmt=null;
			try {
				stmt=con.prepareStatement("Delete from equipamiento" 
				                        + " where id_equipamiento=?");
				stmt.setInt(1,equipamiento.getIdEquipamiento());
				stmt.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
				throw new Exception("Ha habido un problema al insertar articulo" + e.getMessage());
			}finally {
				if(stmt != null) stmt.close();
			}
		}
		/**
		 * <p>Este metodo es para modificar el precio de un equipamiento</p>
		 * 
		 * @param con  Para establecer conexion con bases de datos
		 * @param equipamiento le paso un equipamiento con el nuevo precio y la id donde quiero cambiar el precio
		 * @throws Exception Si hay un problema con bases de datos
		 */
		public void modificarPrecio(Connection con,Equipamiento equipamiento) throws Exception {
			PreparedStatement stmt=null;
			try {
				stmt=con.prepareStatement("update equipamiento set precio=?" 
				                        + " where id_equipamiento=?");
				stmt.setDouble(1, equipamiento.getPrecio());
				stmt.setInt(2,equipamiento.getIdEquipamiento());
				stmt.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
				throw new Exception("Ha habido un problema al modificar precio de  equipamiento" + e.getMessage());
			}finally {
				if(stmt != null) stmt.close();
			}
		}
		/**
		 * <p>Este metodo es para modificar nombre de un equipamiento</p>
		 * @param con  Para establecer conexion con bases de datos
		 * @param equipamiento le paso un  equipamiento con el nuevo nombre y la id donde quiero cambiar el precio
		 * @throws Exception Si hay un problema con bases de datos
		 */
		public void modificarNombre(Connection con,Equipamiento equipamiento) throws Exception {
			PreparedStatement stmt=null;
			try {
				stmt=con.prepareStatement("update equipamiento set nombre=?" 
				                        + " where id_equipamiento=?");
				stmt.setString(1, equipamiento.getNombre());
				stmt.setInt(2,equipamiento.getIdEquipamiento());
				stmt.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
				throw new Exception("Ha habido un problema al modificar nombre de  equipamiento" + e.getMessage());
			}finally {
				if(stmt != null) stmt.close();
			}
		}
	

}
