package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Entidad.Contrato;
import Entidad.Factura;
import Entidad.Factura;
import Entidad.Factura;
/**
 * <p>Esta clase representa una factura y proporciona funcionalidades para 
 * gestionar la información relacionada con las facturas en la base de datos.</p>
 * @author sajid
 *
 */
public class FacturaDAO {
	
	
	/**
	 *  <p>Este metodo es para añadir  una factura</p>
	 * @param con Para establecer conexion con bases de datos
	 * @param factura le paso la factura con los datos a añadir
	 * @param pagar hago los calculos en el main y le paso el precio a pagar
	 * @return Devuelve la factura añadida
	 * @throws Exception Si hay un problema con bases de datos
	 */
	public Factura addFactura(Connection con,Factura factura,double pagar) throws Exception {
		PreparedStatement stmt=null;
		Factura factura1 = null;
		try {
			stmt=con.prepareStatement("insert into contrato_factura (fecha,iva,totalAPagar,nombreCliente,cifCliente,idcontrato)" 
			                        + "values(?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			
			stmt.setInt(1, factura.getFecha());
			stmt.setInt(2, factura.getIva());
			stmt.setDouble(3, pagar);
			stmt.setString(4,factura.getNombreCliente());
			stmt.setString(5,factura.getCifCliente());
			stmt.setInt(6, factura.getIdContrato());
			stmt.executeUpdate();
			
			ResultSet  rs = stmt.getGeneratedKeys();
			
			if(rs.next()) {
				int id = rs.getInt(1);
				factura1 = new Factura(id,factura.getFecha(),factura.getIva(),factura.getTotalAPagar(),factura.getNombreCliente(),factura.getCifCliente(),factura.getIdContrato());
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new Exception("Ha habido un problema al insertar factura" + e.getMessage());
		}finally {
			if(stmt != null) stmt.close();
		}
		return factura1;
		
	}
	/**
	 * <p>Este metodo es para buscar una factura con el id</p>
	 * @param con Para establecer conexion con bases de datos
	 * @param factura le paso un objeto que tiene el id que quiere buscar el usuario
	 * @return devuelve si encuentra una factura con el id de objeto que le hemos pasado
	 * @throws Exception Si hay un problema con bases de datos
	 */
	 public Factura findById(Connection con, Factura factura) throws Exception {
	        Factura _factura = null;
	        PreparedStatement stmt = null;
	        ResultSet rs = null;
	        try {
	            stmt = con.prepareStatement ("SELECT * FROM contrato_factura WHERE idfactura=?");
	            stmt.setInt(1, factura.getIdFactura());
	            rs =  stmt.executeQuery();
	                while (rs.next()) {
	                    _factura = new Factura();
	                    obtenFacturaFila(rs, _factura);
	                }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	            throw new Exception ("Ha habido un problema al buscar el Factura por ID" + ex.getMessage ());
	        } finally {
	            if (rs != null) rs.close();
	            if (rs != null) stmt.close();            
	        }
			return _factura;
	   }
	 	/**
		 * <p>Este metodo es para buscar una factura  con el id contrato</p>
		 * 
		 * @param con Para establecer conexion con bases de datos
		 * @param factura le paso un objeto que tiene el id que quiere buscar el usuario
		 * @return devuelve si encuentra una factura con el id de objeto que le hemos pasado
		 * @throws Exception Si hay un problema con bases de datos
		 */
	 public Factura findByIdContrato(Connection con, Factura factura) throws Exception {
	        Factura _factura = null;
	        PreparedStatement stmt = null;
	        ResultSet rs = null;
	        try {
	            stmt = con.prepareStatement ("SELECT * FROM contrato_factura WHERE idcontrato=?");
	            stmt.setInt(1, factura.getIdContrato());
	            rs =  stmt.executeQuery();
	                while (rs.next()) {
	                    _factura = new Factura();
	                    obtenFacturaFila(rs, _factura);
	                }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	            throw new Exception ("Ha habido un problema al buscar el Factura por ID" + ex.getMessage ());
	        } finally {
	            if (rs != null) rs.close();
	            if (rs != null) stmt.close();            
	        }
			return _factura;
	   }
	 /**
	  * Obtiene los datos de un registro de la base de datos representado por el objeto ResultSet
	  * y los asigna a un objeto Factura.
	  *
	  * @param rs El objeto ResultSet que contiene los datos del registro.
	  * @param factura El objeto Factura al cual se asignarán los datos.
	  * @throws SQLException Si ocurre un error al acceder a los datos del ResultSet.
	  */
	 private void obtenFacturaFila(ResultSet rs, Factura factura) throws SQLException {
			factura.setIdFactura(rs.getInt("idFactura"));;
			factura.setFecha(rs.getInt("fecha"));;
			factura.setIva(rs.getInt("iva"));;
			factura.setTotalAPagar(rs.getDouble("totalAPagar"));
			factura.setNombreCliente(rs.getString("nombreCliente"));
			factura.setCifCliente(rs.getString("cifCliente"));
			factura.setIdContrato(rs.getInt("idcontrato"));;
		}
}
