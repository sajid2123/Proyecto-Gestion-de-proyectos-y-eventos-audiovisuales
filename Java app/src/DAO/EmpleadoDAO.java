package DAO;


import java.sql.*;
import java.util.ArrayList;

import Entidad.*;
import java.io.*;
/**
 * <p> Clase de EmpleadoDAO donde estan los metodos que interactuan con base de datos </p>
 * @author David Salinas
 */
public class EmpleadoDAO {


      /**
 * <p> obtiene el contenido que hay en las filas y los introduce en el nuevo Empleado </p>
 * @param rs el resultSet que se obtiene del metodo vercontenido , Empleado donde se insertara atributos de la base de datos
 * @throws error en sql
 */
    private void obtenContenidoFila(ResultSet rs, Empleado empleado) throws SQLException {
        empleado.setIdEmpleado(rs.getInt("id_empleado"));
        empleado.setDNI(rs.getString("DNI"));
        empleado.setNombre(rs.getString("nombre"));
        empleado.setApellido(rs.getString("apellidos"));
        empleado.setIdDept(rs.getInt("id_dept"));
        empleado.setCifEmpresa(rs.getString("CifEmpresa"));
        empleado.setFechaAlta(rs.getInt("fechaAlta"));
        empleado.setTelefono(rs.getInt("telefono"));
        empleado.setId_jefe(rs.getInt("id_Jefe"));;
    }
    /**
     * <p> verContenido selecciona todo de Empleado en la base de datos y llamando a obtenContenidoFila crea un arrayList y lo carga </p>
 * @param con para poder conectarse a la base da datos
 * @throws error en sql
 * @return ArrayList de Empleado cargado
 */
    public ArrayList < Empleado > verContenido(Connection con) throws Exception {
        ArrayList < Empleado > listaEmpleado = new ArrayList < Empleado > ();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("SELECT * FROM empleado");
            rs = stmt.executeQuery();
            Empleado empleado = null;
            while (rs.next()) {
                empleado = new Empleado();
                obtenContenidoFila(rs, empleado);
                listaEmpleado.add(empleado);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new EOFException("Ha habido un problema al buscar contenido " + ex.getMessage());
        } finally {
            if (rs != null) rs.close();
            if (rs != null) stmt.close();
        }
        return listaEmpleado;
    }
     /** 
 * @deprecated
 */
    public Empleado findById(Connection con, int id_empleado) throws Exception {
        ArrayList < Empleado > listaEmpleado = new ArrayList < Empleado > ();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Empleado empleado = null;
        try {
            stmt = con.prepareStatement("SELECT * FROM empleado");
            rs = stmt.executeQuery();
            while (rs.next()) {
                empleado = new Empleado();
                obtenContenidoFila(rs, empleado);
                listaEmpleado.add(empleado);
                for (int i = 0; i < listaEmpleado.size(); i++) {
                    if (listaEmpleado.get(i).getIdEmpleado() == id_empleado) {
                        empleado = listaEmpleado.get(i);
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new EOFException("Ha habido un problema al buscar contenido " + ex.getMessage());
        } finally {
            if (rs != null) rs.close();
            if (rs != null) stmt.close();
        }
        return empleado;
    }

    /**
     * <p> registrarDepartamento inserta un nuevo Empleado en la base de datos mediante un objeto previamente creado </p>
 * @param con para poder conectarse a la base da datos, Empleado sera el objeto del cual crearemos una entidad en la base de datos
 * @throws lanza excepción de sql
 * 
 */
    public void registrarEmpleado(Connection con, Empleado empleado) throws Exception {
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("insert into empleado values(?,?,?,?,?,?,?,?,?)");
            stmt.setInt(1, empleado.getIdEmpleado());
            stmt.setString(2, empleado.getDNI());
            stmt.setString(3, empleado.getNombre());
            stmt.setString(4, empleado.getApellido());
            stmt.setInt(5, empleado.getIdDept());
            stmt.setString(6, empleado.getCifEmpresa());
            stmt.setInt(7, empleado.getFechaAlta());
            stmt.setInt(8, empleado.getTelefono());
            stmt.setInt(9, empleado.getId_jefe());

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
      * <p> el metodo BorrarEmpleado buscara por el id_empleado en la base de datos </p>
     * @param con establece conexion , id_empleado es el id por el cual buscará y lo borra
     * @return boolean true si se borró false si no se borró
     * @throws Exception en caso de problema con el sql
     */
    public boolean BorrarEmpleado(Connection con, int id_empleado) throws Exception {
        PreparedStatement stmt = null;
        boolean borrado = false;
        try {
            stmt = con.prepareStatement("DELETE FROM empleado WHERE id_empleado=?");
            stmt.setInt(1, id_empleado);
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
/** <p> el metodo BuscarEmpleado buscará por el DNI en la base de datos muestra si existe o no </p>
     * @param con establece conexion , DNI es el dato por el cual buscará en la base de datos 
     * @return boolean true si se encontró
     * @throws Exception en caso de problema con el sql
     */
    public boolean BuscarEmpleado(Connection con, String DNI) throws Exception {
        PreparedStatement stmt = null;
        boolean encontrado = false;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("Select * FROM empleado WHERE DNI=?");
            stmt.setString(1, DNI);
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
    /** <p> el metodo modificarEmpleado en base a DNI buscara y modificará el empleado con los nuevos datos pasados por parametro </p>
     * @param con establece conexion ,DNI es el id por el cual buscará ,DNI ,nombre ,apellidos ,fechaAlta,  telefono son los datos nuevos
     * @throws Exception en caso de problema con el sql
     */
    public void modificarEmpleado(Connection con, String DNI, String DNInuevo, String nombre, String apellidos, String fechaAlta, String telefono) throws Exception {
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE empleado  SET DNI=?," +
                "nombre=?,apellidos=?,fechaAlta=?,telefono=? where DNI=?");

            stmt.setString(1, DNInuevo);
            stmt.setString(2, nombre);
            stmt.setString(3, apellidos);
            stmt.setString(4, fechaAlta);
            stmt.setString(5, telefono);
            stmt.setString(6, DNI);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Ha habido un problema al actualizar el empleado " + ex.getMessage());
        } finally {
            if (stmt != null) stmt.close();
        }

    }

}
