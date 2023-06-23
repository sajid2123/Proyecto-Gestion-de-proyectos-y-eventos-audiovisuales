package DAO;


import java.sql.*;
import java.util.ArrayList;
import Entidad.*;
import java.io.*;
/**
 * <p> Clase de DepartamentoDAO donde estan los metodos que interactuan con base de datos </p>
 * @author David Salinas
 */

public class DepartamentoDAO {
    /**
 * <p> obtiene el contenido que hay en las filas y los introduce en el nuevo Departamento </p>
 * @param rs el resultSet que se obtiene  del metodo vercontenido , departamento donde se insertara atributos de la base de datos
 * @throws error en sql
 */

    private void obtenContenidoFila(ResultSet rs, Departamento departamento) throws SQLException {
        departamento.setId_dept(rs.getInt("id_dept"));
        departamento.setNombreDepartamento(rs.getString("nombreDepartamento"));
    }
/**
     * <p> verContenido selecciona todo de Departamento en la base de datos y llamando a obtenContenidoFila crea un arrayList y lo carga </p>
 * @param con para poder conectarse a la base da datos
 * @throws error en sql
 * @return ArrayList de Departamento cargado
 */
    public ArrayList < Departamento > verContenido(Connection con) throws Exception {
        ArrayList < Departamento > listaDepartamentos = new ArrayList < Departamento > ();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("SELECT * FROM departamento");
            rs = stmt.executeQuery();
            Departamento departamento = null;
            while (rs.next()) {
                departamento = new Departamento();
                obtenContenidoFila(rs, departamento);
                listaDepartamentos.add(departamento);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new EOFException("Ha habido un problema al buscar contenido " + ex.getMessage());
        } finally {
            if (rs != null) rs.close();
            if (rs != null) stmt.close();
        }
        return listaDepartamentos;
    }
     /** 
 * @deprecated
 */
    public Departamento findById(Connection con, Departamento departamento) throws Exception {
        Departamento departamento2 = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("SELECT * FROM departamento WHERE id_dept=?");
            stmt.setInt(1, departamento.getId_dept());
            rs = stmt.executeQuery();
            while (rs.next()) {
                departamento2 = new Departamento();
                obtenContenidoFila(rs, departamento2);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Ha habido un problema al buscar el Contenido por Nombre" + ex.getMessage());
        } finally {
            if (rs != null) rs.close();
            if (rs != null) stmt.close();
        }
        return departamento2;
    }
     /**
     * <p> registrarDepartamento inserta un nuevo departamento en la base de datos mediante un objeto previamente creado </p>
 * @param con para poder conectarse a la base da datos, Departamento sera el objeto del cual crearemos una entidad en la base de datos
 * @throws lanza excepción de sql
 * 
 */
    public void registrarDepartamento(Connection con, Departamento departamento) throws Exception {
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("insert into departamento (id_dept,nombreDepartamento)" +
                "values(?,?)");
            stmt.setInt(1, departamento.getId_dept());
            stmt.setString(2, departamento.getNombreDepartamento());

            ;


            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Ha habido un problema al insertar " + e.getMessage());
        } finally {
            if (stmt != null) stmt.close();
        }
    }
    /**
     * <p> el metodo BorrarDepartamento buscara por el id_dept en la base de datos </p>
     * @param con establece conexion , id_dept es el id por el cual buscará y lo borra
     * @return boolean true si se borró false si no se borró
     * @throws Exception en caso de problema con el sql
     */
    public boolean BorrarDepartamento(Connection con, int id_dept) throws Exception {
        PreparedStatement stmt = null;
        boolean borrado = false;
        try {
            stmt = con.prepareStatement("DELETE FROM departamento WHERE id_dept=?");
            stmt.setInt(1, id_dept);
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
    /** <p> el metodo BuscarDepartamento buscará por el nombreDepartamento en la base de datos muestra si existe o no </p>
     * @param con establece conexion , nombreDepartamento es el dato por el cual buscará 
     * @return boolean true si se encontró
     * @throws Exception en caso de problema con el sql
     */
    public boolean BuscarDepartamento(Connection con, String nombreDepartamento) throws Exception {
        PreparedStatement stmt = null;
        boolean encontrado = false;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("Select * FROM departamento WHERE nombreDepartamento=?");
            stmt.setString(1, nombreDepartamento);
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
    /** <p> el metodo modificarDepartamento en base a nombreDepartamento  buscara y modificará el cliente con los nuevos datos pasados por parametro </p>
     * @param con establece conexion ,nombreDepartamento es el id por el cual buscará ,nombreDepartamentoNuevo el nuevo nombre de cliente 
     * @throws Exception en caso de problema con el sql
     */
    public void modificarDepartamento(Connection con, String nombreDepartamento, String nombreDepartamentoNuevo) throws Exception {
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE departamento SET nombreDepartamento=?" +
                "where nombreDepartamento=?");

            stmt.setString(1, nombreDepartamentoNuevo);
            stmt.setString(2, nombreDepartamento);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Ha habido un problema al actualizar el departamento " + ex.getMessage());
        } finally {
            if (stmt != null) stmt.close();
        }

    }
}