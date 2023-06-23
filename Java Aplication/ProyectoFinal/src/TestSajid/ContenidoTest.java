package TestSajid;



import java.sql.Connection;


import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import DAO.Conexion_DB;
import DAO.ContenidoDAO;
import Entidad.Contenido;
import Entidad.Empleado;


class ContenidoTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	public void testPrueba1() throws Exception {
		String dniEncontrado;
		Conexion_DB _conexion_DB = new Conexion_DB();
		Connection _con = null;
		_con = _conexion_DB.AbrirConexion();
		Empleado empleado = new Empleado();
		Contenido contenido = new Contenido();
		ContenidoDAO contenidoDAO = new ContenidoDAO();
		contenido = contenidoDAO.verEmpleadosContenido(_con);
	
		// Prueba 1: Caja Negra Caso Valido 
        dniEncontrado = contenido.getDniEmpleado(contenido.getEmpleados(),"nom_empleado1", "ape_empleado1");
        Assert.assertEquals("Y3470897Z", dniEncontrado);
	}

	@Test
	public void testPrueba2() throws Exception {
		String dniEncontrado;
		Conexion_DB _conexion_DB = new Conexion_DB();
		Connection _con = null;
		_con = _conexion_DB.AbrirConexion();
		Empleado empleado = new Empleado();
		Contenido contenido = new Contenido();
		ContenidoDAO contenidoDAO = new ContenidoDAO();
		contenido = contenidoDAO.verEmpleadosContenido(_con);
        // Prueba 2: Caja Negra Caso Invalido;
		//Esta comentado porque es un caso donde el codigo no compila
        //dniEncontrado = contenido.getDniEmpleado(contenido.getEmpleados(), "Sajid", 10);
       // Assert.assertEquals("Empleado no Encontrado", dniEncontrado);
	}
	@Test
	public void testPrueba3() throws Exception {
		String dniEncontrado;
		Conexion_DB _conexion_DB = new Conexion_DB();
		Connection _con = null;
		_con = _conexion_DB.AbrirConexion();
		Empleado empleado = new Empleado();
		Contenido contenido = new Contenido();
		ContenidoDAO contenidoDAO = new ContenidoDAO();
		contenido = contenidoDAO.verEmpleadosContenido(_con);
        // Prueba 3: Caja Blanca: buscar un empleado con nombre incorrecto
        dniEncontrado = contenido.getDniEmpleado(contenido.getEmpleados(), "Sajid", "ape_empleado1");
        Assert.assertEquals("Empleado no Encontrado", dniEncontrado);
	}
	@Test
	public void testPrueba11() throws Exception {
		String dniEncontrado;
		Conexion_DB _conexion_DB = new Conexion_DB();
		Connection _con = null;
		_con = _conexion_DB.AbrirConexion();
		Empleado empleado = new Empleado();
		Contenido contenido = new Contenido();
		ContenidoDAO contenidoDAO = new ContenidoDAO();
		contenido = contenidoDAO.verEmpleadosContenido(_con);
        //Prueba 4: Caja Blanca: buscar un empleado con apellido incorrecto
        dniEncontrado = contenido.getDniEmpleado(contenido.getEmpleados(),"nom_empleado1","apellido");
        Assert.assertEquals("Empleado no Encontrado", dniEncontrado);
      
	}
}
