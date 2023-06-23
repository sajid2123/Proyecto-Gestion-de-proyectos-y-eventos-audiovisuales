package DAO;


import java.sql.*;
import java.util.ArrayList;
import Entidad.*;
import java.io.*;
/**
 * <p> Clase de ClienteDAO donde estan los metodos que interactuan con base de datos </p>
 * @author David Salinas
 * @version1
 */

public class ClienteDAO {
    /**
 * <p> obtiene el contenido que hay en las filas y los introduce en el nuevo Cliente </p>
 * @param rs el resultSet que se obtiene  del metodo vercontenido  , cliente donde se insertara atributos de la base de datos
 * @throws error en sql
 */
    private void obtenContenidoFila(ResultSet rs, Cliente cliente) throws SQLException {
        cliente.setId_cliente(rs.getInt("id_cliente"));
        cliente.setNombre(rs.getString("nombre"));
        cliente.setCif(rs.getString("Cif"));
        cliente.setCif_Empresa(rs.getString("Cif_Empresa"));


    }
    /**
     * <p> verContenido selecciona todo de cliente en la base da datos y llamando a obtenContenidoFila crea un arrayList y lo carga </p>
 * @param con para poder conectarse a la base da datos
 * @throws error en sql
 * @return ArrayList de Clientes cargado
 */
    public ArrayList < Cliente > verContenido(Connection con) throws Exception {
        ArrayList < Cliente > listaClientes = new ArrayList < Cliente > ();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("SELECT * FROM cliente");
            rs = stmt.executeQuery();
            Cliente cliente = null;
            while (rs.next()) {
                cliente = new Cliente();
                obtenContenidoFila(rs, cliente);
                listaClientes.add(cliente);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new EOFException("Ha habido un problema al buscar contenido " + ex.getMessage());
        } finally {
            if (rs != null) rs.close();
            if (rs != null) stmt.close();
        }
        return listaClientes;
    }
 /** 
 * @deprecated
 */
    public Cliente findById(Connection con, Cliente cliente) throws Exception {
        Cliente cliente2 = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("SELECT * FROM cliente WHERE id_cliente=?");
            stmt.setInt(1, cliente.getId_cliente());
            rs = stmt.executeQuery();
            while (rs.next()) {
                cliente2 = new Cliente();
                obtenContenidoFila(rs, cliente2);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Ha habido un problema al buscar el Contenido por Nombre" + ex.getMessage());
        } finally {
            if (rs != null) rs.close();
            if (rs != null) stmt.close();
        }
        return cliente2;
    }
     /**
     * <p> registrarCliente inserta un nuevo cliente en la base de datos mediante un objeto previamente creado </p>
 * @param con para poder conectarse a la base da datos, Cliente sera el objeto del cual crearemos una entidad en la base de datos
 * @throws lanza excepción de sql
 * 
 */
    public void registrarCliente(Connection con, Cliente cliente) throws Exception {
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("insert into cliente (id_cliente ,nombre , Cif ,Cif_Empresa)" +
                "values(?,?,?,?)");
            stmt.setInt(1, cliente.getId_cliente());
            stmt.setString(2, cliente.getNombre());
            stmt.setString(3, cliente.getCif());
            stmt.setString(4, cliente.getCif_Empresa());

            ;


            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Ha habido un problema al insertar " + e.getMessage());
        } finally {
            if (stmt != null) stmt.close();
        }
    }
    /** <p> el metodo BorrarCliente buscara por el id_cliente en la base de datos </p>
     * @param con establece conexion , id_empleado es el id por el cual buscará y lo borra
     * @return boolean true si se borró false si no se borró
     * @throws Exception en caso de problema con el sql
     */
    public boolean BorrarCliente(Connection con, int id_cliente) throws Exception {
        PreparedStatement stmt = null;
        boolean borrado = false;
        try {
            stmt = con.prepareStatement("DELETE FROM cliente WHERE id_cliente=?");
            stmt.setInt(1, id_cliente);
            if (stmt.executeUpdate() > 0) {
                borrado = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return borrado;
    }
    /** <p> el metodo BuscarCliente buscara por el id_cliente en la base de datos muestra si existe o no </p>
     * @param con establece conexion , id_empleado es el id por el cual buscará 
     * @return boolean true si se encontró
     * @throws Exception en caso de problema con el sql
     */
    public boolean BuscarCliente(Connection con, int id_cliente) throws Exception {
        PreparedStatement stmt = null;
        boolean encontrado = false;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("Select * FROM cliente WHERE id_cliente=?");
            stmt.setInt(1, id_cliente);
            rs = stmt.executeQuery();
            if (!rs.next()) {
                encontrado = false;
            } else {
                encontrado = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        return encontrado;
    }
    /** <p> el metodo modificarCliente en base a id_cliente y nombre buscara y modificará el cliente con los nuevos datos pasados por parametro </p>
     * @param con establece conexion , id_empleado es el id por el cual buscará ,nombre el nuevo nombre de cliente
     * @throws Exception en caso de problema con el sql
     */
    public void modificarCliente(Connection con, int id_cliente, String nombre) throws Exception {
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE cliente SET nombre=?" +
                "where id_cliente=?");

            stmt.setString(1, nombre);
            stmt.setInt(2, id_cliente);

            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Ha habido un problema al actualizar el cliente " + ex.getMessage());
        } finally {
            if (stmt != null) stmt.close();
        }

    }

}