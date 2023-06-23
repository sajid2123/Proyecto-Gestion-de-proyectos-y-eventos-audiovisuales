package DAO;

import java.io.EOFException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Entidad.Contenido;
import Entidad.Contrato;
import Entidad.Equipamiento;
import Entidad.Evento;
import Entidad.Factura;
/**
 * <p>Esta clase representa un contrato y proporciona funcionalidades para 
 * gestionar la información relacionada con los contratos en la base de datos.</p>
 * @author sajid
 *
 */
public class ContratoDAO {
	/**
	 * <p>Es para ver todos los contratos</p>
	 * @param con Para establecer conexion con bases de datos
	 * @return devuelve una lista con los contratos 
	 * @throws Exception Si hay un problema con bases de datos
	 */
	public List <Contrato> verContrato(Connection con) throws Exception {
        List <Contrato> _listaContrato = new ArrayList<Contrato>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("SELECT * FROM Contrato"); 
            rs = stmt.executeQuery();
            Contrato contrato = null;
            while(rs.next()) {
                contrato = new Contrato();
                obtenContratoFila(rs, contrato);
                _listaContrato.add(contrato);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new EOFException("Ha habido un problema al buscar Contrato " + ex.getMessage());
        } finally {
            if (rs != null) rs.close();
            if (rs != null) stmt.close();            
        }
        return _listaContrato;
    }
	/**
	 * <p>Obtiene los datos de un registro de la base de datos representado por el objeto ResultSet
	 * y los asigna a un objeto Contrato.</p>
	 *
	 * @param rs El objeto ResultSet que contiene los datos del registro.
	 * @param contrato El objeto Contrato al cual se asignarán los datos.
	 * @throws SQLException Si ocurre un error al acceder a los datos del ResultSet.
	 */
	private void obtenContratoFila(ResultSet rs, Contrato contrato) throws SQLException {
		contrato.setIdcontrato(rs.getInt("idcontrato"));;
		contrato.setFechaIncio(rs.getInt("fecha_inicio"));
		contrato.setFechaFin(rs.getInt("fecha_fin"));
		contrato.setIdEvento(rs.getInt("idevento"));
	}
	/**
	 * 
	 * <p>Este metodo es para anyadir un nuevo contrato</p>
	 * 
	 * @param con Para establecer conexion con bases de datos
	 * @param contrato le paso objeto de contarto con la informacion de contrato 
	 * @param evento le paso objeto de evento para sacar la id 
	 * @return devuelve el contarto creado
	 * @throws Exception Si hay un problema con bases de datos
	 */
	public Contrato addContrato(Connection con,Contrato contrato,Evento evento) throws Exception {
		PreparedStatement stmt=null;
		Contrato contrato1 = null;
		try {
			
			stmt=con.prepareStatement("insert into contrato (fecha_inicio,fecha_fin,idevento)" 
			                        + "values(?,?,?)",Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, contrato.getFechaIncio());
			stmt.setInt(2, contrato.getFechaFin());
			stmt.setInt(3, evento.getIdEvento());
			stmt.executeUpdate();
			
			ResultSet  rs = stmt.getGeneratedKeys();
			
			if(rs.next()) {
				int id = rs.getInt(1);
				contrato1 = new Contrato(id,contrato.getFechaIncio(),contrato.getFechaFin(),evento.getIdEvento());
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new Exception("Ha habido un problema al insertar articulo" + e.getMessage());
		}finally {
			if(stmt != null) stmt.close();
		}
		return contrato1;
	}
	/**
	 * <p>Este metodo es para guardar la informacion de equipamiento alquilado</p>
	 * @param con Para establecer conexion con bases de datos
	 * @param equipamiento le paso el objeto de equipamiento alquilado para sacar el id
	 * @param contrato le paso el objeto de contrato para meter el id de contrato en la tabla
	 * @param ejemplares unidades alquiladas
	 * @throws Exception Si hay un problema con bases de datos
	 */
	public void addEquipamientoContrato(Connection con,Equipamiento equipamiento,Contrato contrato,int ejemplares) throws Exception {
		PreparedStatement stmt=null;
		try {
			stmt=con.prepareStatement("insert into contrato_equipamiento values(?,?,?)");
			stmt.setInt(1, equipamiento.getIdEquipamiento());
			stmt.setInt(2, contrato.getIdcontrato());
			stmt.setInt(3, ejemplares);
			stmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new Exception("Ha habido un problema al insertar euipamiento" + e.getMessage());
		}finally {
			if(stmt != null) stmt.close();
		}
	}
	/**
	 * <p>Este metodo es para guardar la informacion de contenido alquilado</p>
	 * @param con Para establecer conexion con bases de datos
	 * @param contenido le paso el objeto de conenido alquilado para sacar el id
	 * @param contrato le paso el objeto de contrato para meter el id de contrato en la tabla
	 * @throws Exception Si hay un problema con bases de datos
	 */
	public void addContenidoContrato(Connection con,Contenido contenido,Contrato contrato) throws Exception {
		PreparedStatement stmt=null;
		try {
			stmt=con.prepareStatement("insert into contrato_contenido values(?,?)");
			stmt.setInt(1, contenido.getIdContenido());
			stmt.setInt(2, contrato.getIdcontrato());
			stmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new Exception("Ha habido un problema al insertar contenido" + e.getMessage());
		}finally {
			if(stmt != null) stmt.close();
		}
	}
	/**
	 * <p>Este metodo es para saber los equipamientos contratados para un evento</p>
	 * @param con Para establecer conexion con bases de datos
	 * @param contrato le paso el objeto con id para sacar equipamientos de ese contrato si hay 
	 * @return devuelve un arraylist con los id's de equipamiento contratados
	 * @throws Exception Si hay un problema con bases de datos
	 */
	public ArrayList<Integer> equipamientoContratados(Connection con,Contrato contrato) throws Exception {
		ArrayList<Integer> codigosEquipamiento = new ArrayList<Integer>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("SELECT idequipamiento FROM contrato_equipamiento where idcontrato=?"); 
            stmt.setInt(1, contrato.getIdcontrato());
            rs = stmt.executeQuery();
            while(rs.next()) {
                int codigo = rs.getInt("idequipamiento");
                codigosEquipamiento.add(codigo);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new EOFException("Ha habido un problema al buscar Contrato " + ex.getMessage());
        } finally {
            if (rs != null) rs.close();
            if (rs != null) stmt.close();            
        }
        return codigosEquipamiento;
    }
	/**
	 * <p>Este metodo es para saber cuantos unidades de equipamiento alquilaron</p>
	 * @param con Para establecer conexion con bases de datos
	 * @param idEquipamiento le paso id de equipamiento para cual quiero saber las unidades
	 * @return devuleve los numeros de unidades que alquilaron de ese equipamiento
	 * @throws Exception Si hay un problema con bases de datos
	 */
	public int unidades(Connection con,int idEquipamiento) throws Exception {
		PreparedStatement stmt = null;
        ResultSet rs = null;
        int unidades = 0;
        try {
            stmt = con.prepareStatement("SELECT unidades FROM contrato_equipamiento where idequipamiento=?"); 
            stmt.setInt(1, idEquipamiento);
            rs = stmt.executeQuery();
            while(rs.next()) {
                unidades = rs.getInt("unidades");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Ha habido un problema al buscar Contrato " + ex.getMessage());
        } finally {
            if (rs != null) rs.close();
            if (rs != null) stmt.close();            
        }
        return unidades;
	}
	/**
	 * <p>Este metodo es para saber los contenidos contratados para un evento</p>
	 * @param con Para establecer conexion con bases de datos
	 * @param contrato le paso el objeto con id para sacar contenidos de ese contrato si hay 
	 * @return devuelve un arraylist con los id's de contenidos contratados
	 * @throws Exception Si hay un problema con bases de datos
	 */
	public ArrayList <Integer> contenidoContratados(Connection con,Contrato contrato) throws Exception {
		ArrayList <Integer> codigosContenidos= new ArrayList<Integer>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("SELECT idcontenido FROM contrato_contenido where idcontrato=?"); 
            stmt.setInt(1, contrato.getIdcontrato());
            rs = stmt.executeQuery();
            while(rs.next()) {
                int codigo = rs.getInt("idcontenido");
                codigosContenidos.add(codigo);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new EOFException("Ha habido un problema al buscar Contrato " + ex.getMessage());
        } finally {
            if (rs != null) rs.close();
            if (rs != null) stmt.close();            
        }
        return codigosContenidos;
    }
	/**
	 * <p>Este metodo es para buscar un contrato con id</p>
	 * @param con Para establecer conexion con bases de datos
	 * @param contrato le paso el objeto de contrato con la id de contrato que quiero buscar
	 * @return devuelve el contrato 
	 * @throws Exception Si hay un problema con bases de datos
	 */
	 public Contrato findById(Connection con, Contrato contrato) throws Exception {
		 	Contrato _contrato = null;
	        PreparedStatement stmt = null;
	        ResultSet rs = null;
	        try {
	            stmt = con.prepareStatement ("SELECT * FROM contrato WHERE idcontrato=?");
	            stmt.setInt(1, contrato.getIdcontrato());
	            rs =  stmt.executeQuery();
	                while (rs.next()) {
	                    _contrato = new Contrato();
	                    obtenContratoFila(rs, _contrato);
	                }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	            throw new Exception ("Ha habido un problema al buscar el Equipamiento por ID" + ex.getMessage ());
	        } finally {
	            if (rs != null) rs.close();
	            if (rs != null) stmt.close();            
	        }
			return _contrato;
	   }
	 /**
	  * <p>Este metodo es para buscar un contrato con la id de evento</p>
	  * @param con Para establecer conexion con bases de datos
	  * @param contrato le paso el objeto de contrato porque contrato tiene un campo con id evento
	  * @return devuelve el contrato
	  * @throws Exception Para establecer conexion con bases de datos
	  */
	 public Contrato findByIdEvento(Connection con, Contrato contrato) throws Exception {
		 	Contrato _contrato = null;
	        PreparedStatement stmt = null;
	        ResultSet rs = null;
	        try {
	            stmt = con.prepareStatement ("SELECT * FROM contrato WHERE idevento=?");
	            stmt.setInt(1, contrato.getIdEvento());
	            rs =  stmt.executeQuery();
	                while (rs.next()) {
	                    _contrato = new Contrato();
	                    obtenContratoFila(rs, _contrato);
	                }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	            throw new Exception ("Ha habido un problema al buscar el Equipamiento por ID" + ex.getMessage ());
	        } finally {
	            if (rs != null) rs.close();
	            if (rs != null) stmt.close();            
	        }
			return _contrato;
	   }
	 
}
