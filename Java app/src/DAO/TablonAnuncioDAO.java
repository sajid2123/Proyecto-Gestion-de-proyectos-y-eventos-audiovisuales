package DAO;

import java.io.EOFException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Entidad.Equipamiento;
import Entidad.TablonAnuncio;
import Excepcion.ExcepcionNoEncontrado;

/**
 * <p>Esta clase representa un Tablon de anuncio y proporciona funcionalidades para
 *  gestionar la información relacionada con los anuncios en la base de datos.</p>
 * @author sajid
 *
 */
public class TablonAnuncioDAO {
	
	/**
	 *  <p>Este metodo es para ver todos los anuncios que ahi</p>
	 *  
	 * @param con  Para establecer conexion con bases de datos
	 * @return devuelve una lista con todos los anuncio que estan activos ahora mismo
	 * @throws Exception Si hay un problema con bases de datos
	 */
	
	 public List <TablonAnuncio> verTablonAnuncio(Connection con) throws Exception {
	        List <TablonAnuncio> _listaTablonAnuncio = new ArrayList<TablonAnuncio>();
	        PreparedStatement stmt = null;
	        ResultSet rs = null;
	        try {
	            stmt = con.prepareStatement("SELECT * FROM tablon_anuncio"); 
	            rs = stmt.executeQuery();
	            TablonAnuncio tablonAnuncio = null;
	            while(rs.next()) {
	                tablonAnuncio = new TablonAnuncio();
	                obtenTablonAnuncioFila(rs, tablonAnuncio);
	                _listaTablonAnuncio.add(tablonAnuncio);
	            }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	            throw new EOFException("Ha habido un problema al encontrar Anuncios " + ex.getMessage());
	        } finally {
	            if (rs != null) rs.close();
	            if (rs != null) stmt.close();            
	        }
	        return _listaTablonAnuncio;
	    }

	 /**
	  * Obtiene los datos de un registro de la base de datos representado por el objeto ResultSet
	  * y los asigna a un objeto TablonAnuncio.
	  * 
	  * @param rs El objeto ResultSet que contiene los datos del registro.
	  * @param tablonAnuncio El objeto TablonAnuncio al cual se asignarán los datos.
	  * @throws SQLException Si ocurre un error al acceder a los datos del ResultSet.
	  */
	private void obtenTablonAnuncioFila(ResultSet rs, TablonAnuncio tablonAnuncio) throws SQLException {
		tablonAnuncio.setIdAnuncio(rs.getInt("idanuncio"));
		tablonAnuncio.setNombre(rs.getString("nombre"));
		tablonAnuncio.setTipo(rs.getString("tipo"));
		tablonAnuncio.setFabricante(rs.getString("fabricante"));
		tablonAnuncio.setComentarioFabricante(rs.getString("comentarioFabricante"));
		tablonAnuncio.setPdfCaracteristicas(rs.getString("pdfcaracteristicas"));
		tablonAnuncio.setFechaAnuncio(rs.getInt("fechaAnuncio"));
		tablonAnuncio.setFechaLanzamiento(rs.getInt("fechaLanzamiento"));
		tablonAnuncio.setIdEquipamiento(rs.getInt("id_equipamiento"));
	}
	/**
	 * <p>Este metodo es para añadir un nuevo anuncio</p>
	 * @param con  Para establecer conexion con bases de datos
	 * @param anuncio le paso el anuncio que quiero añadir
	 * @throws Exception Si hay un problema con bases de datos
	 */
	public void addAnuncio(Connection con,TablonAnuncio anuncio) throws Exception {
		PreparedStatement stmt=null;
		try {
			stmt=con.prepareStatement("insert into tablon_anuncio (nombre,tipo,fabricante,comentarioFabricante,pdfcaracteristicas,fechaAnuncio,fechalanzamiento,id_equipamiento)" 
			                        + "values(?,?,?,?,?,?,?,?)");
			stmt.setString(1,anuncio.getNombre());
			stmt.setString(2,anuncio.getTipo());
			stmt.setString(3,anuncio.getFabricante());
			stmt.setString(4,anuncio.getComentarioFabricante());
			stmt.setString(5,anuncio.getPdfCaracteristicas());
			stmt.setInt(6, anuncio.getFechaAnuncio());
			stmt.setInt(7, anuncio.getFechaLanzamiento());
			stmt.setInt(8, anuncio.getIdEquipamiento());
			
			stmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new Exception("Ha habido un problema al insertar articulo" + e.getMessage());
		}finally {
			if(stmt != null) stmt.close();
		}
	}
	/**
	 * <p>Este metodo es para eliminar un  anuncio</p>
	 * 
	 * @param con  Para establecer conexion con bases de datos
	 * @param anuncio le paso un anuncio que tiene la id de anuncio que quiere eliminar el usuario
	 * @throws Exception Si hay un problema con bases de datos
	 */
	public void eliminarAnuncio(Connection con,TablonAnuncio anuncio) throws Exception {
		PreparedStatement stmt=null;
		try {
			stmt=con.prepareStatement("Delete from tablon_anuncio" 
			                        + " where idanuncio=?");
			stmt.setInt(1,anuncio.getIdAnuncio());
			stmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new Exception("Ha habido un problema al eliminar anuncio" + e.getMessage());
		}finally {
			if(stmt != null) stmt.close();
		}
	}
	/**
	 * <p>Este metodo es para buscar anuncio sobre un equipamiento con nombre</p>
	 * @param con Para establecer conexion con bases de datos
	 * @param anuncio le paso un objeto de anuncio que tiene el nombre de anuncio que queremos buscar
	 * @throws Exception Si hay un problema con bases de datos
	 */
	
	 public TablonAnuncio findByNombre(Connection con,TablonAnuncio tablonAnuncio) throws Exception {
	        TablonAnuncio _tablonAnuncio = null;
	        PreparedStatement stmt = null;
	        ResultSet rs = null;
	        try {
	            stmt = con.prepareStatement ("SELECT * FROM tablon_anuncio WHERE nombre=?");
	            stmt.setString(1, tablonAnuncio.getNombre());
	            rs =  stmt.executeQuery();
	                while (rs.next()) {
	                    _tablonAnuncio = new TablonAnuncio();
	                    obtenTablonAnuncioFila(rs, _tablonAnuncio);
	                }
	                if(_tablonAnuncio == null) {
	                	throw new ExcepcionNoEncontrado(3);
	                }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	            throw new Exception ("Ha habido un problema al buscar el anuncio por Nombre" + ex.getMessage ());
	        } finally {
	            if (rs != null) rs.close();
	            if (rs != null) stmt.close();            
	        }
			return _tablonAnuncio;
	   }
	 /**
		 * <p>Este metodo es para buscar anuncio sobre un equipamiento con id</p>
		 * @param con Para establecer conexion con bases de datos
		 * @param anuncio le paso un objeto de anuncio que tiene el nombre de anuncio que queremos buscar
		 * @throws Exception Si hay un problema con bases de datos
		 */
		
		 public TablonAnuncio findById(Connection con,TablonAnuncio tablonAnuncio) throws Exception {
		        TablonAnuncio _tablonAnuncio = null;
		        PreparedStatement stmt = null;
		        ResultSet rs = null;
		        try {
		            stmt = con.prepareStatement ("SELECT * FROM tablon_anuncio WHERE idanuncio=?");
		            stmt.setInt(1, tablonAnuncio.getIdAnuncio());
		            rs =  stmt.executeQuery();
		                while (rs.next()) {
		                    _tablonAnuncio = new TablonAnuncio();
		                    obtenTablonAnuncioFila(rs, _tablonAnuncio);
		                }
		                if(_tablonAnuncio == null) {
		                	throw new ExcepcionNoEncontrado(3);
		                }
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		            throw new Exception ("Ha habido un problema al buscar el anuncio por id" + ex.getMessage ());
		        } finally {
		            if (rs != null) rs.close();
		            if (rs != null) stmt.close();            
		        }
				return _tablonAnuncio;
		   }
	

}
