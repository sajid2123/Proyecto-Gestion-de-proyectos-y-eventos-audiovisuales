package DAO;

import java.sql.*;
import java.util.ArrayList;
import Entidad.*;
import java.io.*;
/**
 * <p> Clase de EmpresaDAO donde estan los metodos que interactuan con base de datos </p>
 * @author David Salinas
 */
public class EmpresaDAO {
  /**
 * <p> obtiene el contenido que hay en las filas y los introduce en la nueva Empresa </p>
 * @param rs el resultSet que se obtiene del metodo vercontenido , Empresa donde se insertara atributos de la base de datos
 * @throws error en sql
 */

    private void obtenContenidoFila(ResultSet rs, Empresa empresa) throws SQLException {
        empresa.setCif(rs.getString("Cif"));
        empresa.setNombre(rs.getString("nombre"));
        empresa.setDireccion(rs.getString("direccion"));
        empresa.setMunicipio(rs.getString("municipio"));
        empresa.setTelefono(rs.getString("telefono"));
    }
       /**
     * <p> verContenido selecciona todo de Empresa en la base de datos y llamando a obtenContenidoFila crea un arrayList y lo carga </p>
 * @param con para poder conectarse a la base da datos
 * @throws error en sql
 * @return ArrayList de Empresa cargado
 */
    public ArrayList < Empresa > verContenido(Connection con) throws Exception {
        ArrayList < Empresa > listaEmpresas = new ArrayList < Empresa > ();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("SELECT * FROM empresa");
            rs = stmt.executeQuery();
            Empresa empresa = null;
            while (rs.next()) {
                empresa = new Empresa();
                obtenContenidoFila(rs, empresa);
                listaEmpresas.add(empresa);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new EOFException("Ha habido un problema al buscar contenido " + ex.getMessage());
        } finally {
            if (rs != null) rs.close();
            if (rs != null) stmt.close();
        }
        return listaEmpresas;
    }
     /** 
 * @deprecated
 */
    public Empresa findById(Connection con, Empresa empresa) throws Exception {
        Empresa empresa2 = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("SELECT * FROM empresa WHERE Cif=?");
            stmt.setString(1, empresa.getCif());
            rs = stmt.executeQuery();
            while (rs.next()) {
                empresa2 = new Empresa();
                obtenContenidoFila(rs, empresa2);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Ha habido un problema al buscar el Contenido por Nombre" + ex.getMessage());
        } finally {
            if (rs != null) rs.close();
            if (rs != null) stmt.close();
        }
        return empresa2;
    }
        /**
     * <p> registrarDepartamento inserta un nuevo Empresa en la base de datos mediante un objeto previamente creado </p>
 * @param con para poder conectarse a la base da datos, Empresa sera el objeto del cual crearemos una entidad en la base de datos
 * @throws lanza excepción de sql
 * 
 */
    public void registrarEmpresa(Connection con, Empresa empresa) throws Exception {
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("insert into empresa (Cif,nombre,direccion,municipio,telefono)" +
                "values(?,?,?,?,?)");
            stmt.setString(1, empresa.getCif());
            stmt.setString(2, empresa.getNombre());
            stmt.setString(3, empresa.getDireccion());
            stmt.setString(4, empresa.getMunicipio());
            stmt.setString(5, empresa.getTelefono());


            ;


            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Ha habido un problema al insertar" + e.getMessage());
        } finally {
            if (stmt != null) stmt.close();
        }
    }

    /**
     * <p> el metodo BorrarEmpresa buscara por el Cif en la base de datos </p>
     * @param con establece conexion , Cif es por el cual buscará y lo borra
     * @return boolean true si se borró false si no se borró
     * @throws Exception en caso de problema con el sql
     */
    public boolean BorrarEmpresa(Connection con, String Cif) throws Exception {
        PreparedStatement stmt = null;
        boolean borrado = false;
        try {
            stmt = con.prepareStatement("DELETE FROM empresa WHERE Cif=?");
            stmt.setString(1, Cif);
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

/** <p> el metodo BuscarEmpresa buscará por el Cif en la base de datos muestra si existe o no </p>
     * @param con establece conexion , Cif es el dato por el cual buscará en la base de datos 
     * @return boolean true si se encontró
     * @throws Exception en caso de problema con el sql
     */
    public boolean BuscarEmpresa(Connection con, String Cif) throws Exception {
        PreparedStatement stmt = null;
        boolean encontrado = false;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("Select * FROM empresa WHERE Cif=?");
            stmt.setString(1, Cif);
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
    /** <p> el metodo modificarEmpresa en base a Cif buscara y modificará la Empresa con los nuevos datos pasados por parametro </p>
     * @param con establece conexion ,Cif es el dato por el cual buscará  ,nombre ,direccion ,municipio y telefono son los datos nuevos
     * @throws Exception en caso de problema con el sql
     */
    public void modificarEmpresa(Connection con, String Cif, String nombre, String direccion, String municipio, String telefono) throws Exception {
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE empresa  SET nombre=?," +
                "direccion=?,municipio=?,telefono=? where Cif=?");

            stmt.setString(1, nombre);
            stmt.setString(2, direccion);
            stmt.setString(3, municipio);
            stmt.setString(4, telefono);
            stmt.setString(5, Cif);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Ha habido un problema al actualizar la empresa " + ex.getMessage());
        } finally {
            if (stmt != null) stmt.close();
        }

    }
}