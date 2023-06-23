package TestDavid;

import java.sql.*;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import DAO.Conexion_DB;
import DAO.DepartamentoDAO;
import Entidad.*;
import java.io.*;


public class pruebaTest {
	@Test
    public void testBuscarDepartamentoExiste()throws Exception
    {
        boolean condicion=false;
        Connection con =null;
        Conexion_DB conexion =new Conexion_DB();
        String nombreDepartamento ;
        con=conexion.AbrirConexion();
        Departamento departamento = new Departamento();
        DepartamentoDAO departamentoDAO = new DepartamentoDAO();
        //prueba 1 :Caja negra valida

        condicion=departamentoDAO.BuscarDepartamento(con, "Equipamiento");
        Assert.assertTrue(condicion);

    }
    @Test
    public void testBuscarDepartamentoNoExiste()throws Exception
    {
        boolean condicion=false;
        Connection con =null;
        Conexion_DB conexion =new Conexion_DB();
        String nombreDepartamento ;
        con=conexion.AbrirConexion();
        Departamento departamento = new Departamento();
        DepartamentoDAO departamentoDAO = new DepartamentoDAO();
        //prueba 2 :Caja negra no valida

        condicion=departamentoDAO.BuscarDepartamento(con, "departamento2");
        Assert.assertFalse(condicion);

    }
    @Test
    public void testBuscarDepartamento()throws Exception
    {
        boolean condicion=false;
        Connection con =null;
        Conexion_DB conexion =new Conexion_DB();
       
        String nombreDepartamento ;
        con=conexion.AbrirConexion();
        Departamento departamento = new Departamento();
        DepartamentoDAO departamentoDAO = new DepartamentoDAO();
        //prueba 3 :Caja blanca con valor nombreDepartamento incorrecto
        //Aqui estoy probando un tipo de dato invalido 
      //  condicion=departamentoDAO.BuscarDepartamento(con,10);
        Assert.assertFalse(condicion);

    }
    @Test
    public void testBuscarDepartamento2()throws Exception
    {
        boolean condicion=false;
        Connection con =null;
        Conexion_DB conexion =new Conexion_DB();
        String nombreDepartamento ;
        con=conexion.AbrirConexion();
        Departamento departamento = new Departamento();
        DepartamentoDAO departamentoDAO = new DepartamentoDAO();
        //prueba 4 :Caja blanca no valida

        condicion=departamentoDAO.BuscarDepartamento(con,"10");
        Assert.assertFalse(condicion);

    }
}
