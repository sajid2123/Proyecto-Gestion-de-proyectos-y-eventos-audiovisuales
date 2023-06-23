package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Entidad.Contenido;
import Entidad.Evento;
/**
 * <p>Esta clase representa un evento y proporciona funcionalidades para 
 * gestionar la información relacionada con los contenido en la base de datos.</p>
 * @author gabriel
 *
 */


public class EventoDAO {
	  /**
	 * <p>Agrega una factura de evento a la base de datos.</p>
	 * 
	 * @param con     La conexión a la base de datos.
	 * @param factura La factura de evento que se va a agregar.
	 * @param pagar   El monto total a pagar en la factura.
	 * @return La factura de evento agregada con éxito, incluido el ID generado.
	 * @throws Exception Si ocurre algún error durante la inserción de la factura.
	 */
	public Evento findByNombre(Connection con, Evento evento) throws Exception {
        Evento _evento = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement ("SELECT * FROM Evento WHERE nombre=?");
            stmt.setString(1, evento.getNombre());
            rs =  stmt.executeQuery();
                while (rs.next()) {
                    _evento = new Evento();
                    obtenEventoFila(rs, _evento);
                }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception ("Ha habido un problema al buscar el Evento por Nombre" + ex.getMessage ());
        } finally {
            if (rs != null) rs.close();
            if (rs != null) stmt.close();            
        }
		return _evento;
	}
	 /**

	    *<p>Obtiene los datos de un evento a partir de un objeto ResultSet y los asigna a un objeto Evento.</p>
	    *@param rs <p>El objeto ResultSet que contiene los datos del evento.</p>
	    *@param evento <p>El objeto Evento al que se asignarán los datos.</p>
	    *@throws SQLException <p>Tira una excepción si hay un problema al acceder a los datos del ResultSet.</p>
	    */

	private void obtenEventoFila(ResultSet rs, Evento evento) throws SQLException {
		evento.setIdEvento(rs.getInt("idevento"));
		evento.setNombre(rs.getString("nombre"));
		evento.setTipo(rs.getString("tipo"));
		evento.setFecha(rs.getInt("fecha"));
		evento.setIdCliente(rs.getInt("id_cliente"));
		evento.setPrecio(rs.getDouble("precio"));
		evento.setIdrecinto(rs.getInt("id_recinto"));
		evento.setGestor(rs.getString("gestor"));
	}
	/**

	*<p>Añade un evento a la base de datos.</p>
	*@param con <p>Establece la conexión con la base de datos.</p>
	*@param evento <p>El evento a añadir.</p>
	*@throws Exception <p>Tira una excepción si hay un problema al insertar el evento.</p>
	*/

	    public void addEvento(Connection con, Evento evento) throws Exception {
	        PreparedStatement stmt = null;
	        try {
	            stmt = con.prepareStatement("INSERT INTO Evento (idEvento, nombre, tipo, fecha, id_Cliente, precio, id_recinto, gestor) "
	                                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
	            stmt.setInt(1, evento.getIdEvento());
	            stmt.setString(2, evento.getNombre());
	            stmt.setString(3, evento.getTipo());
	            stmt.setInt(4, evento.getFecha());
	            stmt.setInt(5, evento.getIdCliente());
	            stmt.setDouble(6, evento.getPrecio());
	            stmt.setInt(7, evento.getIdrecinto());
	            stmt.setString(8, evento.getGestor());
	    
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new Exception("Ha habido un problema al insertar el evento: " + e.getMessage());
	        } finally {
	            if (stmt != null) stmt.close();
	        }
	    }

	    /**

	*<p>Actualiza un evento en la base de datos.</p>
	*@param con <p>Establece la conexión con la base de datos.</p>
	*@param evento <p>El evento a actualizar.</p>
	*@throws Exception <p>Tira una excepción si hay un problema al actualizar el evento.</p>
	*/

	    public void updateEvento(Connection con, Evento evento) throws Exception {
	        PreparedStatement stmt = null;
	        try {
	            stmt = con.prepareStatement("UPDATE Evento SET tipo = ?, fecha = ?, id_Cliente = ?, precio = ?, id_recinto = ?, gestor = ? WHERE nombre = ?");
	            stmt.setString(1, evento.getTipo());
	            stmt.setInt(2, evento.getFecha());
	            stmt.setInt(3, evento.getIdCliente());
	            stmt.setDouble(4, evento.getPrecio());
	            stmt.setInt(5, evento.getIdrecinto());
	            stmt.setString(6, evento.getGestor());
	            stmt.setString(7, evento.getNombre());
	    
	            int rowsAffected = stmt.executeUpdate();
	    
	            if (rowsAffected == 0) {
	                throw new Exception("No se encontró ningún evento con el nombre especificado.");
	            }
	    
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new Exception("Ha habido un problema al actualizar el evento: " + e.getMessage());
	        } finally {
	            if (stmt != null) stmt.close();
	        }
	    }

	    /**

	*<p>Elimina un evento de la base de datos.</p>
	*@param con <p>Establece la conexión con la base de datos.</p>
	*@param idEvento <p>El ID del evento a eliminar.</p>
	*@throws Exception <p>Tira una excepción si hay un problema al eliminar el evento.</p>
	*/

	    public void deleteEvento(Connection con, int idEvento) throws Exception {
	        PreparedStatement stmt = null;
	        try {
	            stmt = con.prepareStatement("DELETE FROM Evento WHERE idEvento = ?");
	            stmt.setInt(1, idEvento);
	            
	            int rowsAffected = stmt.executeUpdate();
	            
	            if (rowsAffected == 0) {
	                throw new Exception("No se encontró ningún evento con el ID especificado.");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new Exception("Ha habido un problema al eliminar el evento: " + e.getMessage());
	        } finally {
	            if (stmt != null) {
	                stmt.close();
	            }
	        }
	    }
	

}
