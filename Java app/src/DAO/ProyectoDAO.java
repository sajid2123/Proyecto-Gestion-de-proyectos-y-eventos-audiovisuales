package DAO;


import java.sql.*;

import Entidad.*;
import java.io.*;
import java.util.*;

/**
 * <p> Clase de ProyectoDAO donde estan los metodos que interactuan con base de datos </p>
 * @author David Salinas
 */

public class ProyectoDAO {
    static Scanner tec = new Scanner(System.in);

      /**
 * <p> obtiene el contenido que hay en las filas y los introduce en el nuevo Proyecto </p>
 * @param rs el resultSet que se obtiene  del metodo vercontenido  , proyecto donde se insertara atributos de la base de datos
 * @throws error en sql
 */
    private void obtenContenidoFila(ResultSet rs, Proyecto proyecto) throws SQLException {
        proyecto.setId_proyecto(rs.getInt("id_proyecto"));
        proyecto.setFechaInicio(rs.getInt("fechaInicio"));
        proyecto.setFechaFin(rs.getInt("fechaFin"));
        proyecto.setCoste(rs.getFloat("coste"));
        proyecto.setlocalizacion(rs.getString("localizacion"));
        proyecto.setCif_Empresa(rs.getString("Cif_Empresa"));
        proyecto.setId_cliente(rs.getInt("id_cliente"));

    }
       /**
     * <p> verContenido selecciona todo de Proyecto en la base de datos y llamando a obtenContenidoFila crea un arrayList y lo carga </p>
 * @param con para poder conectarse a la base da datos
 * @throws error en sql
 * @return ArrayList de Proyecto cargado
 */

    public ArrayList < Proyecto > verContenido(Connection con) throws Exception {
        ArrayList < Proyecto > listaProyectos = new ArrayList < Proyecto > ();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("SELECT * FROM proyecto");
            rs = stmt.executeQuery();
            Proyecto proyecto = null;
            while (rs.next()) {
                proyecto = new Proyecto();
                obtenContenidoFila(rs, proyecto);
                listaProyectos.add(proyecto);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new EOFException("Ha habido un problema al buscar contenido " + ex.getMessage());
        } finally {
            if (rs != null) rs.close();
            if (rs != null) stmt.close();
        }
        return listaProyectos;
    }

        /**
     * <p> registrarProyecto inserta un nuevo Proyecto en la base de datos mediante un objeto previamente creado </p>
 * @param con para poder conectarse a la base da datos, Proyecto sera el objeto del cual crearemos una entidad en la base de datos
 * @throws lanza excepción de sql
 * 
 */
    public void registroProyecto(Connection con, Proyecto proyecto) throws Exception {
        PreparedStatement stmt = null;
        try {
                                            
            stmt = con.prepareStatement("Insert into proyecto  values(?,?,?,?,?,?,?)");
            stmt.setInt(1, proyecto.getId_proyecto());
            stmt.setInt(2, proyecto.getFechaInicio());
            stmt.setInt(3, proyecto.getfechaFin());
            stmt.setFloat(4, proyecto.getCoste());
            stmt.setString(5, proyecto.getlocalizacion());
            stmt.setString(6, proyecto.getCif_Empresa());
            stmt.setInt(7, proyecto.getId_cliente());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Ha habido un problema al insertar" + e.getMessage());
        } finally {
            if (stmt != null) stmt.close();
        }
    }
     /** 
 * @deprecated
 */
    public Proyecto findById(Connection con, Proyecto proyecto) throws Exception {
        Proyecto proyecto1 = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("SELECT * FROM proyecto WHERE id_proyecto=?");
            stmt.setInt(1, proyecto.getId_proyecto());
            rs = stmt.executeQuery();
            while (rs.next()) {
                proyecto1 = new Proyecto();
                obtenContenidoFila(rs, proyecto1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Ha habido un problema al buscar el Contenido por Nombre" + ex.getMessage());
        } finally {
            if (rs != null) rs.close();
            if (rs != null) stmt.close();
        }
        return proyecto1;
    }
     /**
      * <p> el metodo BorrarProyecto buscara por el id_proyecto en la base de datos </p>
     * @param con establece conexion , id_proyecto es el id por el cual buscará y lo borra
     * @return boolean true si se borró false si no se borró
     * @throws Exception en caso de problema con el sql
     */
    public boolean borrarProyecto(Connection con, int id_proyecto) throws Exception {
        boolean borrado = false;
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("delete from proyecto where id_proyecto =?");
            stmt.setInt(1,id_proyecto);
            if (stmt.executeUpdate() > 0) {
                borrado = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (stmt != null) stmt.close();
        }
        return borrado;
    }
    public String buscarFechas(Connection con) throws SQLException {
        int fechaInicio = 0, fechaFin = 0;
        do {
            System.out.println("dime el año de inicio y fin deben ser mayores a el año 2000");
            fechaInicio = tec.nextInt();
            fechaFin = tec.nextInt();
        } while (fechaInicio > fechaFin || fechaInicio < 2000 || fechaFin < 2000 || fechaInicio > 2100 | fechaFin > 2100);

        PreparedStatement stmt = null;
        ResultSet rs = null;
        final int tamanyo = 30;
        int fechaFinA[] = new int[tamanyo];
        int fechaIncioA[] = new int[tamanyo];
        int i = 0;
        String sol = "";
        int n = 0;
        boolean existeInicio = false;
        boolean existeFin = false;
        try {

            stmt = con.prepareStatement("SELECT fechaInicio ,fechaFin from proyecto");
            rs = stmt.executeQuery();
            while (rs.next()) {

                n = (rs.getInt("fechaInicio"));
                fechaIncioA[i] = n;
                n = (rs.getInt("fechaFin"));
                fechaFinA[i] = n;
                i++;
            }
            for (int x = 0; x < tamanyo; x++) {

                if (fechaIncioA[x] == fechaInicio) {

                    existeInicio = true;
                }
                if (fechaFinA[x] == fechaFin) {

                    existeFin = true;
                } else {

                }

            }
            if (existeInicio == true && existeFin == true) {
                sol = "existen la fecha de inicio y final";
            } else if (existeInicio == true) {
                sol = "existe fecha inicio pero no de final";
            } else if (existeFin == true) {
                sol = "existe fecha de final pero no de inicio";
            } else {
                sol = "no existe ninguna fecha";
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {

            if (rs != null) rs.close(); //Cerramos e resultset

            if (stmt != null) stmt.close(); //Cerramos el Statement

        }
        return sol;

    }
    /** <p> el metodo BuscarProyecto buscará por el id_proyecto en la base de datos muestra si existe o no </p>
     * @param con establece conexion , id_proyecto es el dato por el cual buscará en la base de datos 
     * @return boolean true si se encontró
     * @throws Exception en caso de problema con el sql
     */
    public boolean BuscarProyecto(Connection con, int id_proyecto) throws Exception {
        PreparedStatement stmt = null;
        boolean encontrado = false;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("Select * FROM proyecto WHERE id_proyecto=?");
            stmt.setInt(1, id_proyecto);
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
    /** <p> el metodo modificarProyecto en base a id_proyecto buscara y modificará el proyecto con los nuevos datos pasados por parametro </p>
     * @param con establece conexion ,id_proyecto  es el id por el cual buscará fechaInicio,fechaFin,coste y localizacion  son los datos nuevos
     * @throws Exception en caso de problema con el sql
     */
    public void modificarProyecto(Connection con, int id_proyecto, int fechaInicio, int fechaFin, float coste, String localizacion) throws Exception {
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE proyecto  SET fechaInicio=?," +
                "fechaFin=?,coste=?,localizacion=? where id_proyecto=?");

            stmt.setInt(1, fechaInicio);
            stmt.setInt(2, fechaFin);
            stmt.setFloat(3, coste);
            stmt.setString(4, localizacion);
            stmt.setInt(5, id_proyecto);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Ha habido un problema al actualizar el proyecto " + ex.getMessage());
        } finally {
            if (stmt != null) stmt.close();
        }

    }

}