package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Entidad.FacturaEvento;

/**
 * <p>Esta clase representa una factura de un evento y proporciona funcionalidades para 
 * gestionar la información relacionada con los contenido en la base de datos.</p>
 * @author gabriel
 *
 */

public class FacturaEventoDAO {

	/**
 * Agrega una factura de evento a la base de datos.
 * 
 * @param con     La conexión a la base de datos.
 * @param factura La factura de evento que se va a agregar.
 * @param pagar   El monto total a pagar en la factura.
 * @return La factura de evento agregada con éxito, incluido el ID generado.
 * @throws Exception Si ocurre algún error durante la inserción de la factura.
 */

public FacturaEvento addFactura(Connection con, FacturaEvento factura, double pagar) throws Exception {
	PreparedStatement stmt = null;
	FacturaEvento factura1 = null;
	try {
		stmt = con.prepareStatement(
			"insert into evento_factura (idFactura, cifEmpresa, fecha, idventa, iva, totalAPagar, nombreCliente, cifCliente) " +
			"values (?, ?, ?, ?, ?, ?, ?, ?)",
			Statement.RETURN_GENERATED_KEYS);

		stmt.setInt(1, factura.getIdFactura());
		stmt.setString(2, factura.getCifEmpresa());
		stmt.setInt(3, factura.getFecha());
		stmt.setInt(4, factura.getIdVenta());
		stmt.setInt(5, factura.getIVA());
		stmt.setDouble(6, pagar);
		stmt.setString(7, factura.getNombreCliente());
		stmt.setString(8, factura.getCifCliente());

		stmt.executeUpdate();

		ResultSet rs = stmt.getGeneratedKeys();

		if (rs.next()) {
			int id = rs.getInt(1);
			factura1 = new FacturaEvento(id, factura.getCifEmpresa(), factura.getFecha(), factura.getIdVenta(), factura.getIVA(),
					pagar, factura.getNombreCliente(), factura.getCifCliente(),factura.getIdEvento());
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
 * <p>Busca una factura de evento por su ID en la base de datos.</p>
 * 
 * @param con     La conexión a la base de datos.
 * @param factura La factura de evento con el ID a buscar.
 * @return La factura de evento encontrada, o null si no se encuentra ninguna.
 * @throws Exception Si ocurre algún error durante la búsqueda de la factura.
 */


	public FacturaEvento findById(Connection con, FacturaEvento factura) throws Exception {
		FacturaEvento _factura = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.prepareStatement("SELECT * FROM evento_factura WHERE idfactura=?");
			stmt.setInt(1, factura.getIdFactura());
			rs = stmt.executeQuery();
			while (rs.next()) {
				_factura = new FacturaEvento();
				obtenFacturaFila(rs, _factura);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new Exception("Ha habido un problema al buscar la Factura por ID: " + ex.getMessage());
		} finally {
			if (rs != null) rs.close();
			if (stmt != null) stmt.close();
		}
		return _factura;
	}


	/**
 * <p>Rellena los datos de una factura de evento a partir de una fila de resultado de la base de datos.</p>
 * 
 * @param rs      El conjunto de resultados de la consulta SQL.
 * @param factura La factura de evento a la que se agregarán los datos.
 * @throws SQLException Si ocurre algún error al leer los datos de la fila.
 */
	
	private void obtenFacturaFila(ResultSet rs, FacturaEvento factura) throws SQLException {
		factura.setIdFactura(rs.getInt("idFactura"));
		factura.setCifEmpresa(rs.getString("cifEmpresa"));
		factura.setFecha(rs.getInt("fecha"));
		factura.setIdVenta(rs.getInt("idventa"));
		factura.setIVA(rs.getInt("iva"));
		factura.setTotalAPagar(rs.getDouble("totalAPagar"));
		factura.setNombreCliente(rs.getString("nombreCliente"));
		factura.setCifCliente(rs.getString("cifCliente"));
		factura.setIdEvento(rs.getInt("idevento"));
	}
}
