package Proyecto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import DAO.ClienteDAO;
import DAO.Conexion_DB;
import DAO.ContenidoDAO;
import DAO.ContratoDAO;
import DAO.DepartamentoDAO;
import DAO.EmpleadoDAO;
import DAO.EmpresaDAO;
import DAO.EquipamientoDAO;
import DAO.EventoDAO;
import DAO.FacturaDAO;
import DAO.FacturaEventoDAO;
import DAO.NoticiasDAO;
import DAO.ProyectoDAO;
import DAO.TablonAnuncioDAO;
import Entidad.Cliente;
import Entidad.Contenido;
import Entidad.Contrato;
import Entidad.Departamento;
import Entidad.Empleado;
import Entidad.Empresa;
import Entidad.Equipamiento;
import Entidad.Evento;
import Entidad.Factura;
import Entidad.FacturaEvento;
import Entidad.Noticias;
import Entidad.Proyecto;
import Entidad.TablonAnuncio;
import Excepcion.ExcepcionNoEncontrado;


/**
 * <p>Esta clase representa la aplicacion de gestion de proyectos y eventos audiovisuales</p>
 * @author sajid,gabriel,david
 *
 */
public class Main {
	static Scanner tec = new Scanner(System.in);
	public static void main(String[] args) throws Exception {
		int entrada;
		do {
			getMenuGeneral();
			entrada = tec.nextInt();
			switch(entrada) {
			case 1: 
				/*El menu de David*/
				Connection con = conexion();
		        int opcion = -1;
		        int opcion2 = -1;
		        ProyectoDAO proyectoDAO = new ProyectoDAO();
		        ClienteDAO clienteDAO = new ClienteDAO();
		        DepartamentoDAO departamentoDAO = new DepartamentoDAO();
		        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
		        EmpresaDAO empresaDAO = new EmpresaDAO();
		        while (opcion != 0) {
		            System.out.println("pulsa numero para seleccionar opcion ");
		            System.out.println("1/proyecto 2/Cliente 3/Departamento 4/Empleado 5/Empresa 0.para volver atrás ");
		            opcion2 = -1;
		            opcion = tec.nextInt();

		            switch (opcion) {
		                case 1:

		                    while (opcion2 != 0) {
		                        System.out.println(
		                                " ¿Que quieres hacer con proyecto? | 1.registrar 2.modificar 3.eliminar 4. mostrar 0.volver atrás|");
		                        opcion2 = tec.nextInt();

		                        switch (opcion2) {

		                            case 1:

		                                System.out.println("dime datos a registrar del proyecto");
		                                System.out.println(
		                                        " id proyecto ,fecha inicio , fecha fin , coste , localizacion ,   el cif de la empresa y el id del cliente del que quieres registrar el proyecto");

		                                Proyecto proyecto = new Proyecto(tec.nextInt(), tec.nextInt(), tec.nextInt(),
		                                        tec.nextFloat(), tec.next(), tec.next(), tec.nextInt());
		                                try {
		                                    proyectoDAO.registroProyecto(con, proyecto);
		                                } catch (Exception e) {
		                                    e.printStackTrace();
		                                }
		                                break;
		                            case 2:
		                                System.out.println("dime el id del proyecto a modificar");
		                                try {
		                                    int id_proyecto = tec.nextInt();
		                                    if (proyectoDAO.BuscarProyecto(con, id_proyecto) == true) {
		                                        System.out.println("se encontró el proyecto");
		                                        System.out.println(
		                                                "dime los nuevos datos fechaInicio ,fechaFin, coste, localizacion ");
		                                        proyectoDAO.modificarProyecto(con, id_proyecto, tec.nextInt(), tec.nextInt(),
		                                                tec.nextFloat(), tec.next());

		                                    } else {
		                                        System.out.println("no se encontro el el proyecto");
		                                    }
		                                } catch (Exception e) {
		                                    e.printStackTrace();
		                                }

		                                break;
		                            case 3:
		                                try {
		                                    System.out.println("dime el id del proyecto");
		                                    if (proyectoDAO.borrarProyecto(con, tec.nextInt()) == true) {
		                                        System.out.println("se ha borrado correctamente ");
		                                    } else {
		                                        System.out.println(" no se pudo borrar");
		                                    }
		                                } catch (Exception e) {
		                                    e.printStackTrace();
		                                }
		                                break;
		                            case 4:

		                                try {

		                                    ArrayList listaProyectos = proyectoDAO.verContenido(con);
		                                    for (int i = 0; i < listaProyectos.size(); i++) {
		                                        System.out.println(listaProyectos.get(i).toString());
		                                    }
		                                } catch (Exception e) {
		                                    e.printStackTrace();
		                                }
		                                break;
		                            case 0:
		                                System.out.println(" se va  a volver atrás");

		                                break;
		                            default:
		                                System.out.println("opcion incorrecta");
		                                break;
		                        }
		                    }

		                    break;
		                case 2:
		                    while (opcion2 != 0) {
		                        System.out.println(
		                                " ¿Que quieres hacer con cliente? | 1.registrar 2.modificar 3.eliminar 4. mostrar 0.volver atrás|");
		                        opcion2 = tec.nextInt();

		                        switch (opcion2) {
		                            case 1:

		                                System.out
		                                        .println("dime los datos del cliente id cliente ,nombre,Cif,Cif de la empresa");
		                                try {
		                                    int id_cliente = tec.nextInt();
		                                    String nombre = tec.next();
		                                    String Cif = tec.next();
		                                    String Cif_Empresa = tec.next();
		                                    Cliente cliente = new Cliente(id_cliente, nombre, Cif, Cif_Empresa);
		                                    clienteDAO.registrarCliente(con, cliente);
		                                } catch (Exception e) {
		                                    e.printStackTrace();
		                                }

		                                break;
		                            case 2:
		                                System.out.println("dime el id del cliente a modificar");
		                                try {
		                                    int id_cliente = tec.nextInt();
		                                    if (clienteDAO.BuscarCliente(con, id_cliente) == true) {
		                                        System.out.println("se encontró al cliente");
		                                        System.out.println("dime el nuevo nombre del cliente ");
		                                        clienteDAO.modificarCliente(con, id_cliente, tec.next());

		                                    } else {
		                                        System.out.println("no se encontro el departamento");
		                                    }
		                                } catch (Exception e) {
		                                    e.printStackTrace();
		                                }

		                                break;
		                            case 3:
		                                System.out.println("dime el id del cliente a borrar");
		                                try {

		                                    if (true == clienteDAO.BorrarCliente(con, tec.nextInt())) {
		                                        System.out.println("se borro correctamente el cliente");
		                                    } else
		                                        System.out.println("no se pudo borrar el cliente");

		                                } catch (Exception e) {
		                                    e.printStackTrace();
		                                }
		                                break;
		                            case 4:
		                                try {

		                                    ArrayList a = clienteDAO.verContenido(con);
		                                    if (a.isEmpty()) {
		                                        System.out.println("esta vacio");
		                                    }
		                                    for (int i = 0; i < a.size(); i++) {
		                                        System.out.println(a.get(i).toString());
		                                    }

		                                } catch (Exception e) {
		                                    e.printStackTrace();
		                                }
		                                break;
		                            case 0:
		                                System.out.println(" se va  a volver atrás");
		                                break;
		                            default:
		                                System.out.println("opcion incorrecta");
		                                break;
		                        }

		                    }
		                    break;
		                case 3:
		                    while (opcion2 != 0) {
		                        System.out.println(
		                                " ¿Que quieres hacer con departamento? | 1.registrar 2.modificar 3.eliminar 4. mostrar 0.volver atrás|");
		                        opcion2 = tec.nextInt();

		                        switch (opcion2) {
		                            case 1:
		                                System.out.println("dime el id de departamento y el nombre de departamento");
		                                try {

		                                    Departamento departamento = new Departamento(tec.nextInt(), tec.next());
		                                    departamentoDAO.registrarDepartamento(con, departamento);
		                                } catch (Exception e) {
		                                    e.printStackTrace();
		                                }

		                                break;
		                            case 2:
		                                System.out.println("dime el nombre del departamento que quieres modificar");
		                                try {
		                                    String nombreDepartamento = tec.next();
		                                    if (departamentoDAO.BuscarDepartamento(con, nombreDepartamento) == true) {
		                                        System.out.println("se encontró el departamento");
		                                        System.out.println("dime el nuevo nombre del departamento ");
		                                        departamentoDAO.modificarDepartamento(con, nombreDepartamento, tec.next());

		                                    } else {
		                                        System.out.println("no se encontro el departamento");
		                                    }
		                                } catch (Exception e) {
		                                    e.printStackTrace();
		                                }

		                                break;
		                            case 3:
		                                System.out.println("dime el id del departamento a borrar");
		                                try {

		                                    if (true == departamentoDAO.BorrarDepartamento(con, tec.nextInt())) {
		                                        System.out.println("se borro correctamente el departamento");
		                                    } else
		                                        System.out.println("no se pudo borrar el departamento");

		                                } catch (Exception e) {
		                                    e.printStackTrace();
		                                }
		                                break;
		                            case 4:
		                                try {

		                                    ArrayList a = departamentoDAO.verContenido(con);
		                                    if (a.isEmpty()) {
		                                        System.out.println("esta vacio");
		                                    }
		                                    for (int i = 0; i < a.size(); i++) {
		                                        System.out.println(a.get(i).toString());
		                                    }

		                                } catch (Exception e) {
		                                    e.printStackTrace();
		                                }
		                                break;
		                            case 0:
		                                System.out.println(" se va  a volver atrás");
		                                break;
		                            default:
		                                System.out.println("opcion incorrecta");
		                                break;
		                        }

		                    }
		                    break;

		                case 4:
		                    while (opcion2 != 0) {
		                        System.out.println(
		                                " ¿Que quieres hacer con empleado? | 1.registrar 2.modificar 3.eliminar 4. mostrar 0.volver atrás|");
		                        opcion2 = tec.nextInt();

		                        switch (opcion2) {

		                            case 1:

		                                System.out.println(
		                                        "dime el id del empleado ,DNI,nombre,apellidos,id del departamento ,cif empresa, fechaAlta ,telefono, id del jefe");
		                                try {

		                                    Empleado empleado = new Empleado(tec.nextInt(), tec.next(), tec.next(), tec.next(),
		                                            tec.nextInt(), tec.next(), tec.nextInt(), tec.nextInt(), tec.nextInt());
		                                    empleadoDAO.registrarEmpleado(con, empleado);
		                                } catch (Exception e) {
		                                    e.printStackTrace();
		                                }

		                                break;
		                            case 2:
		                                System.out.println("dime el DNI del empleado que quieres modificar");
		                                try {
		                                    String DNI = tec.next();
		                                    if (empleadoDAO.BuscarEmpleado(con, DNI) == true) {
		                                        System.out.println("se encontró empleado");
		                                        System.out.println(
		                                                "dime los nuevos datos  DNI , nombre, apellidos ,fechaAlta,telefono  ");
		                                        empleadoDAO.modificarEmpleado(con, DNI, tec.next(), tec.next(), tec.next(),
		                                                tec.next(), tec.next());

		                                    } else {
		                                        System.out.println("no se encontro el empleado");
		                                    }
		                                } catch (Exception e) {
		                                    e.printStackTrace();
		                                }

		                                break;
		                            case 3:
		                                System.out.println("dime el id del empleado que quieres borrar");
		                                try {

		                                    if (true == empleadoDAO.BorrarEmpleado(con, tec.nextInt())) {
		                                        System.out.println("se borro correctamente el empleado");
		                                    } else
		                                        System.out.println("no se pudo borrar el empleado");

		                                } catch (Exception e) {
		                                    e.printStackTrace();
		                                }
		                                break;
		                            case 4:
		                                try {

		                                    ArrayList a = empleadoDAO.verContenido(con);
		                                    if (a.isEmpty()) {
		                                        System.out.println("esta vacio");
		                                    }
		                                    for (int i = 0; i < a.size(); i++) {
		                                        System.out.println(a.get(i).toString());
		                                    }

		                                } catch (Exception e) {
		                                    e.printStackTrace();
		                                }

		                                break;
		                            case 0:
		                                System.out.println(" se va  a volver atrás");
		                                break;
		                            default:
		                                System.out.println("opcion incorrecta");
		                                break;

		                        }

		                    }

		                    break;

		                case 5:
		                    while (opcion2 != 0) {
		                        System.out.println("1.registrar 2.modificar 3.eliminar 4. mostrar 0.volver atrás");
		                        opcion2 = tec.nextInt();
		                        switch (opcion2) {
		                            case 1:
		                                System.out.println("dime el Cif,nombre,direccion,municipio y telefono de la empresa");
		                                try {

		                                    Empresa empresa = new Empresa(tec.next(), tec.next(), tec.next(), tec.next(),
		                                            tec.next());
		                                    empresaDAO.registrarEmpresa(con, empresa);
		                                } catch (Exception e) {
		                                    e.printStackTrace();
		                                }

		                                break;
		                            case 2:
		                                System.out.println("dime el Cif de la empresa que quieres modificar");
		                                try {
		                                    String Cif = tec.next();
		                                    if (empresaDAO.BuscarEmpresa(con, Cif) == true) {
		                                        System.out.println("se encontró empresa");
		                                        System.out.println(
		                                                "dime los nuevos datos  nombre , direccion , municipio y telefono ");
		                                        empresaDAO.modificarEmpresa(con, Cif, tec.next(), tec.next(), tec.next(),
		                                                tec.next());

		                                    } else {
		                                        System.out.println("no se encontro la empresa");
		                                    }
		                                } catch (Exception e) {
		                                    e.printStackTrace();
		                                }

		                                break;
		                            case 3:
		                                System.out.println("dime el Cif de la empresa que quieres eliminar");
		                                try {

		                                    if (true == empresaDAO.BorrarEmpresa(con, tec.next())) {
		                                        System.out.println("se borro correctamente la empresa");
		                                    } else
		                                        System.out.println("no se pudo borrar la empresa");

		                                } catch (Exception e) {
		                                    e.printStackTrace();
		                                }
		                                break;
		                            case 4:
		                                try {

		                                    ArrayList a = empresaDAO.verContenido(con);
		                                    if (a.isEmpty()) {
		                                        System.out.println("esta vacio");
		                                    }
		                                    for (int i = 0; i < a.size(); i++) {
		                                        System.out.println(a.get(i).toString());
		                                    }

		                                } catch (Exception e) {
		                                    e.printStackTrace();
		                                }
		                                break;
		                            case 0:
		                                System.out.println(" se va  a volver atrás");
		                                break;
		                            default:
		                                System.out.println("opcion incorrecta");
		                                break;
		                        }

		                    }
		                    break;

		                case 0:
		                    System.out.println("fin del programa");
		                    break;
		                default:
		                    System.out.println("opcion incorrecta");
		                    break;
		            }

		        }
		        /*El termina el menu de David*/
				break;
			case 2: 
				/*El menu de Gabriel*/
				int opcion1;

				do {
					mostrarMenu();
					opcion1 = tec.nextInt();
					tec.nextLine();

					switch (opcion1) {
						case 1:
							RegistrarEvento();
							break;
						case 2:
							ModificaEvento();
							break;
						case 3:
							BorrarEvento();
							break;
						case 4:
							ConsultarEvento();
							break;
						case 5:
							RegistrarFactura();
							break;
						case 6:
							RegistrarNoticia();
							break;
							
						case 0:
							System.out.println("Saliendo del programa...");
							break;
						default:
							System.out.println("Opción inválida. Introduce nuevamente.");
							break;
					}
				} while (opcion1 != 0);
				/*Termina el menu de Gabriel*/
				break;
			case 3: break;
			case 4: 
				/*El menu de Sajid*/
				do {
					menuEquipamientoContenido();
					entrada = tec.nextInt();
					switch(entrada) {
						case 1:
							verContenido();
							break;
						case 2:
							verEquipamiento();
							break;
						case 3:
							verTablonAnuncio();
							break;
						case 4:
							verContratos();
							break;
						case 5:
							verFacturaDeEvento();
							break;
						case 6:
							verEmpleadosContenido();
							break;
						case 7:
							verEmpleadosEquipamiento();
							break;
						case 8:
							addEquipamiento();
							break;
						case 9:
							addContenido();
							break;
						case 10:
							addAnuncio();
							break;
						case 11:
							hacerContrato();
							break;
						case 12:
							generarFactura();
							break;
						case 13:
							generarHtmlFactura();
							break;
						case 14:
							buscarContenidoPorNombre();
							break;
						case 15:
							buscarEquipamientoPorNombre();
							break;
						case 16:
							buscarAnuncio();
							break;
						case 17:
							eliminarContenido();
							break;
						case 18:
							eliminarEquipamiento();
							break;
						case 19:
							eliminarAnuncio();
							break;	
						case 20:
							modificarContenido();
							break;
						case 21:
							modificarEquipamiento();
							break;
						case 22:
							buscarDniEmpleadoContenido();
							break;
					}
				}while(entrada!=0);
				/*Termina el menu de Sajid*/
				break;
			}
			
			
			
			
		}while(entrada!=0);
		
		
		
		}
	/**
     * <p> devuelve una conexion para trabajar en la clase de prueba
     * @return conexion
     */
    public static Connection conexion() {
        Connection con = null;
        try {
            Conexion_DB conexion = new Conexion_DB();
            con = conexion.AbrirConexion();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
	/**
	 * <p>Este metodo te saca el menu principal de la aplicacion</p>
	 */
	public static void getMenuGeneral() {
		System.out.println("----------------------------------------------");
		System.out.println("1.Menu proyecto (David) ");
		System.out.println("2.Menu Evento (Gabriel) ");
		System.out.println("3.Menu Recinto (Alvaro)");
		System.out.println("4.Menu Equipamiento Contenid (Sajid)");
		System.out.println("0.Salir");
		System.out.println("----------------------------------------------");
	}
	/**
	 * <p>Este metodo saca todas las opciones de aplicacion de departamento Equipamiento y Contenido</p>
	 */
	public static void menuEquipamientoContenido() {
		System.out.println("----------------------------------------------");
		System.out.println("1.Ver Software de Contenidos Disponibles");
		System.out.println("2.Ver Equipamiento Disponibles");
		System.out.println("3.Ver Anuncios Nuevos sobre Equipamientos");
		System.out.println("4.Ver Contratos");
		System.out.println("5.Ver Factura de Evento");
		System.out.println("6.Ver Empleados de Departamento Contenido");
		System.out.println("7.Ver Empleados de Departamento Equipamiento");
		System.out.println("8.Anyadir Equipamiento Nuevo");
		System.out.println("9.Anyadir Contenido Nuevo");
		System.out.println("10.Anyadir Nuevo Anuncio");
		System.out.println("11.Hacer Contrato");
		System.out.println("12.Generar Factura");
		System.out.println("13.Generar Html De Una Factura");
		System.out.println("14.Buscar Software de Contenido");
		System.out.println("15.Buscar Equipamiento");
		System.out.println("16.Buscar Anuncio Sobre un Equipamiento");
		System.out.println("17.Eliminar Contenido");
		System.out.println("18.Eliminar Equipamiento");
		System.out.println("19.Borrar Anuncio");
		System.out.println("20.Modificar Contenido");
		System.out.println("21.Modifica Equipamiento ");
		System.out.println("22.Buscar dni de un empleado de contenido");
		System.out.println("0.Salir");
		System.out.println("----------------------------------------------");
		
	}
	
	/* Empieza Parte de Gabriel*/
	/**
	 * <p>
	 * Muestra el menú principal de opciones del programa de evento.
	 * </p>
	 */

	public static void mostrarMenu() {
		System.out.println("---------------------");
		System.out.println("1. Registrar evento");
		System.out.println("2. Modificar evento");
		System.out.println("3. Borrar evento");
		System.out.println("4. Consultar evento");
		System.out.println("5. Registrar factura");
		System.out.println("6. Registrar noticia de evento");
		System.out.println("0. Salir");
		System.out.print("---------------------");

	}
	
	

	/**
	 * <p>
	 * Registra una factura en la base de datos.
	 * </p>
	 * 
	 * @throws Exception Si ocurre algún error durante el proceso de registro.
	 */

	public static void RegistrarFactura() throws Exception {
		Conexion_DB _conexion_DB = new Conexion_DB();
		Connection _con = null;
		int idFactura, fecha, idventa, iva, idevento;
		String cifEmpresa, nombreCliente, cifCliente;
		double totalAPagar;
		try {
			_con = _conexion_DB.AbrirConexion();
			FacturaEventoDAO facturaEventoDAO = new FacturaEventoDAO();
			FacturaEvento facturaEvento = new FacturaEvento();
			Scanner tec = new Scanner(System.in);

			System.out.println("ID de la factura:");
			idFactura = tec.nextInt();
			facturaEvento.setIdFactura(idFactura);

			tec.nextLine();

			System.out.println("CIF de la empresa:");
			cifEmpresa = tec.nextLine();
			facturaEvento.setCifEmpresa(cifEmpresa);

			System.out.println("Fecha de la factura (en formato YYYYMMDD):");
			fecha = tec.nextInt();
			facturaEvento.setFecha(fecha);

			System.out.println("ID de la venta:");
			idventa = tec.nextInt();
			facturaEvento.setIdVenta(idventa);

			System.out.println("IVA:");
			iva = tec.nextInt();
			facturaEvento.setIVA(iva);

			System.out.println("Total a pagar:");
			totalAPagar = tec.nextDouble();
			facturaEvento.setTotalAPagar(totalAPagar);

			tec.nextLine();

			System.out.println("Nombre del cliente:");
			nombreCliente = tec.nextLine();
			facturaEvento.setNombreCliente(nombreCliente);

			System.out.println("CIF del cliente:");
			cifCliente = tec.nextLine();
			facturaEvento.setCifCliente(cifCliente);

			System.out.println("ID del evento:");
			idevento = tec.nextInt();
			facturaEvento.setIdEvento(idevento);

			facturaEventoDAO.addFactura(_con, facturaEvento,totalAPagar);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (_con != null)
				_conexion_DB.CerrarConexion(_con);
		}
	}

	public static void RegistrarNoticia() throws Exception {
		Conexion_DB _conexion_DB = new Conexion_DB();
		Connection _con = null;
		int idNoticia, idEvento;
		String nombre, contenidoNoticia;
		try {
			_con = _conexion_DB.AbrirConexion();
			NoticiasDAO noticiasDAO = new NoticiasDAO();
			Noticias noticia = new Noticias();
			Scanner tec = new Scanner(System.in);

			System.out.println("ID de la noticia:");
			idNoticia = tec.nextInt();
			noticia.setId_noticia(idNoticia);

			tec.nextLine();

			System.out.println("ID del evento:");
			idEvento = tec.nextInt();
			noticia.setId_evento(idEvento);

			tec.nextLine();

			System.out.println("Nombre de la noticia:");
			nombre = tec.nextLine();
			noticia.setNombre(nombre);

			System.out.println("Contenido de la noticia:");
			contenidoNoticia = tec.nextLine();
			noticia.setNoticia(contenidoNoticia);

			noticiasDAO.addNoticia(_con, noticia);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (_con != null)
				_conexion_DB.CerrarConexion(_con);
		}
	}

	/**
	 * <p>
	 * Modifica un evento existente en la base de datos.
	 * </p>
	 *
	 * @throws Exception Si ocurre algún error durante el proceso de modificación.
	 */

	public static void ModificaEvento() throws Exception {
		Conexion_DB _conexion_DB = new Conexion_DB();
		Connection _con = null;
		String nombre, tipo, gestor;
		int fecha, idCliente, idRecinto;
		double precio;
		try {
			_con = _conexion_DB.AbrirConexion();
			EventoDAO eventoDAO = new EventoDAO();
			Evento evento = new Evento();
			Scanner tec = new Scanner(System.in);

			System.out.println("Nombre del evento que desea modificar:");
			nombre = tec.nextLine();
			evento.setNombre(nombre);
			evento = eventoDAO.findByNombre(_con, evento);

			if (evento == null) {
				System.out.println("El evento no existe.");
				return;
			}

			System.out.println("Tipo de evento:");
			tipo = tec.nextLine();
			evento.setTipo(tipo);

			System.out.println("Fecha del evento (en formato YYYYMMDD):");
			fecha = tec.nextInt();
			evento.setFecha(fecha);

			System.out.println("ID del cliente:");
			idCliente = tec.nextInt();
			evento.setIdCliente(idCliente);

			System.out.println("Precio del evento:");
			precio = tec.nextDouble();
			evento.setPrecio(precio);

			System.out.println("ID del recinto:");
			idRecinto = tec.nextInt();
			evento.setIdrecinto(idRecinto);

			tec.nextLine();

			System.out.println("Nombre del gestor:");
			gestor = tec.nextLine();
			evento.setGestor(gestor);

			eventoDAO.updateEvento(_con, evento);

			System.out.println("El evento ha sido modificado correctamente.");
		} finally {
			if (_con != null) {
				_conexion_DB.CerrarConexion(_con);
			}
		}
	}

	/**
	 * <p>
	 * Elimina un evento existente de la base de datos.
	 * </p>
	 *
	 * @throws Exception Si ocurre algún error durante el proceso de eliminación.
	 */

	public static void BorrarEvento() throws Exception {
		Conexion_DB _conexion_DB = new Conexion_DB();
		Connection _con = null;
		String nombre;
		try {
			_con = _conexion_DB.AbrirConexion();
			EventoDAO eventoDAO = new EventoDAO();
			Evento evento = new Evento();
			Scanner tec = new Scanner(System.in);

			System.out.println("Nombre del evento que desea borrar:");
			nombre = tec.nextLine();
		
			evento.setNombre(nombre);
			evento = eventoDAO.findByNombre(_con, evento);

			if (evento == null) {
				System.out.println("El evento no existe.");
				return;
			}

			eventoDAO.deleteEvento(_con, evento.getIdEvento());

			System.out.println("El evento ha sido borrado correctamente.");
		} finally {
			if (_con != null) {
				_conexion_DB.CerrarConexion(_con);
			}
		}
	}

/**
 * <p>Consulta los detalles de un evento en la base de datos.</p>
 *
 * @throws Exception Si ocurre algún error durante el proceso de consulta.
 */

	public static void ConsultarEvento() throws Exception {
		Conexion_DB conexion_DB = new Conexion_DB();
		Connection con = null;
		String nombre;
		try {
			con = conexion_DB.AbrirConexion();
			EventoDAO eventoDAO = new EventoDAO();
			Evento evento = new Evento();
			Scanner tec = new Scanner(System.in);
	
			System.out.println("Nombre del evento que desea consultar:");
			nombre = tec.nextLine();
			evento.setNombre(nombre);
			evento = eventoDAO.findByNombre(con, evento);
	
			if (evento == null) {
				System.out.println("El evento no existe.");
				return;
			}
	
			System.out.println("Detalles del evento:");
			System.out.println("Nombre: " + evento.getNombre());
			System.out.println("Tipo: " + evento.getTipo());
			System.out.println("Fecha: " + evento.getFecha());
			System.out.println("ID del cliente: " + evento.getIdCliente());
			System.out.println("Precio: " + evento.getPrecio());
			System.out.println("ID del recinto: " + evento.getIdrecinto());
			System.out.println("Nombre del gestor: " + evento.getGestor());
		} finally {
			if (con != null) {
				conexion_DB.CerrarConexion(con);
			}
		}
	}
	/**
	 * <p>
	 * Registra un nuevo evento en la base de datos y genera una factura y una
	 * noticia.
	 * </p>
	 * 
	 * @throws Exception Si ocurre algún error durante el registro del evento.
	 */

	public static void RegistrarEvento() throws Exception {
		Conexion_DB _conexion_DB = new Conexion_DB();
		Connection _con = null;
		String nombre, tipo, gestor;
		int fecha, idCliente, idrecinto,idevento;
		double precio;
		try {
			_con = _conexion_DB.AbrirConexion();
			EventoDAO eventoDAO = new EventoDAO();
			Evento evento = new Evento();
			Scanner tec = new Scanner(System.in);
			
			System.out.println("ID del evento:");
			idevento = tec.nextInt();
			evento.setIdEvento(idevento);
			
			System.out.println("Nombre del evento:");
			nombre = tec.nextLine();
			nombre = tec.nextLine();
			evento.setNombre(nombre);

			System.out.println("Tipo de evento:");
			tipo = tec.nextLine();
			evento.setTipo(tipo);

			System.out.println("Fecha del evento (en formato YYYYMMDD):");
			fecha = tec.nextInt();
			evento.setFecha(fecha);

			System.out.println("ID del cliente:");
			idCliente = tec.nextInt();
			evento.setIdCliente(idCliente);

			System.out.println("Precio del evento:");
			precio = tec.nextDouble();
			evento.setPrecio(precio);

			System.out.println("ID del recinto:");
			idrecinto = tec.nextInt();
			evento.setIdrecinto(idrecinto);

			System.out.println("Nombre del gestor:");
			gestor = tec.nextLine();
			gestor = tec.nextLine();
			evento.setGestor(gestor);

			eventoDAO.addEvento(_con, evento);

			

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (_con != null)
				_conexion_DB.CerrarConexion(_con);
		}
	}
	/**
	 * <p>Este metodo Saca todos los Software de Contenidos
	 *  disponible en la Bases de datos y te muestra por Pantalla</p>
	 * @throws Exception
	 */
	
	/* Termina Parte de Gabriel*/
	
	/* Empieza Parte de Sajid*/
	public static void verContenido()throws Exception {
		Conexion_DB _conexion_DB = new Conexion_DB();
		Connection _con = null;
		try {
			_con = _conexion_DB.AbrirConexion();
			ContenidoDAO contenidoDAO = new ContenidoDAO();
			System.out.println(contenidoDAO.verContenido(_con));			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(_con!=null) _conexion_DB.CerrarConexion(_con);
		}	
	}
	/**
	 * <p>Este metodo Saca todos los Contratos 
	 *  en la Bases de datos de y muestra por Pantalla</p>
	 * @throws Exception
	 */
	public static void verContratos()throws Exception {
		Conexion_DB _conexion_DB = new Conexion_DB();
		Connection _con = null;
		try {
			_con = _conexion_DB.AbrirConexion();
			ContratoDAO contratoDAO = new ContratoDAO();
			System.out.println(contratoDAO.verContrato(_con));			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(_con!=null) _conexion_DB.CerrarConexion(_con);
		}	
	}
	/**
	 * <p>Este metodo Saca todos los equipamientos
	 *  disponible en la Bases de datos y te muestra por Pantalla</p>
	 * @throws Exception
	 */
	public static void verEquipamiento()throws Exception {
		Conexion_DB _conexion_DB = new Conexion_DB();
		Connection _con = null;
		try {
			_con = _conexion_DB.AbrirConexion();
			EquipamientoDAO equipamientoDAO = new EquipamientoDAO();
			System.out.println(equipamientoDAO.verEquipamiento(_con));			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(_con!=null) _conexion_DB.CerrarConexion(_con);
		}
	}
	/**
	 * <p>Este metodo Saca todos los anuncios sobre equipamientos que
	 *  estan en el tablon de anuncio desde la Bases de datos y te muestra 
	 *  por Pantalla</p>
	 * @throws Exception
	 */
	public static void verTablonAnuncio()throws Exception {
		Conexion_DB _conexion_DB = new Conexion_DB();
		Connection _con = null;
		try {
			_con = _conexion_DB.AbrirConexion();
			TablonAnuncioDAO tablonAnuncioDAO = new TablonAnuncioDAO(); 
			System.out.println(tablonAnuncioDAO.verTablonAnuncio(_con));			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(_con!=null) _conexion_DB.CerrarConexion(_con);
		}	
	}
	/**
	 * <p>Este metodo Saca todos los empleados  que estan trabajando 
	 * en el departamento de Contenido y  te muestra por Pantalla</p>
	 * @throws Exception
	 */
	public static void verEmpleadosContenido()throws Exception {
		Conexion_DB _conexion_DB = new Conexion_DB();
		Connection _con = null;
		try {
			_con = _conexion_DB.AbrirConexion();
			Contenido contenido = new Contenido();
			ContenidoDAO contenidoDAO = new ContenidoDAO();
			contenido = contenidoDAO.verEmpleadosContenido(_con);
			for(int i=0;i<contenido.getEmpleados().size();i++) {
				Empleado empleado1 = contenido.getEmpleados().get(i);
				System.out.println(empleado1.toString());
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(_con!=null) _conexion_DB.CerrarConexion(_con);
		}
	}
	/**
	 * <p>Este metodo Saca todos los empleados  que estan trabajando 
	 * en el departamento de Equipamiento y  te muestra por Pantalla</p>
	 * @throws Exception
	 */
	public static void verEmpleadosEquipamiento()throws Exception {
		Conexion_DB _conexion_DB = new Conexion_DB();
		Connection _con = null;
		try {
			_con = _conexion_DB.AbrirConexion();
			Equipamiento equipamiento = new Equipamiento();
			EquipamientoDAO equipamientoDAO = new EquipamientoDAO();
			equipamiento =	equipamientoDAO.verEmpleadosEquipamiento(_con);
			for(int i=0;i<equipamiento.getEmpleados().size();i++) {
				Empleado empleado1 = equipamiento.getEmpleados().get(i);
				System.out.println(empleado1.toString());
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(_con!=null) _conexion_DB.CerrarConexion(_con);
		}
	}
	/**
	 * 
	 * <p>Este metodo anyade un anuncio sobre un equipamiento y lo anyade en la bases de datos</p>
	 * @throws Exception
	 *
	 *
	 */
	public static void addAnuncio()throws Exception {
		Conexion_DB _conexion_DB = new Conexion_DB();
		Connection _con = null;
		String nombre,tipo,fabricante,comentario,pdfCaracteristicas,anyo,mes,dia;
		int fechaLanzamiento,fecha;boolean equipNomValido=false;
		try {
			_con = _conexion_DB.AbrirConexion();
			EquipamientoDAO equipamientoDAO = new EquipamientoDAO();
			TablonAnuncioDAO tablonAnuncioDAO = new TablonAnuncioDAO(); 
			Equipamiento equipamiento = new Equipamiento();
			TablonAnuncio anuncio = new TablonAnuncio();
			System.out.println("Nombre de Equipamiento");
			nombre = tec.nextLine();
			nombre = tec.nextLine();
			anuncio.setNombre(nombre);
			equipamiento.setNombre(nombre);
			while(equipNomValido==false) {
				if(equipamientoDAO.findByNombre(_con, equipamiento) != null) {
					equipamiento = equipamientoDAO.findByNombre(_con, equipamiento);
					equipNomValido=true;
				}else {
					System.out.println("Pon un nombre de equipamiento que exista");
					nombre = tec.nextLine();
					equipamiento.setNombre(nombre);
				}
			}
			anuncio.setIdEquipamiento(equipamiento.getIdEquipamiento());
			System.out.println("Tipo de Equipamiento");
			tipo = tec.nextLine();
			anuncio.setTipo(tipo);
			System.out.println("Nombre de Fabricante");
			fabricante = tec.nextLine();
			anuncio.setFabricante(fabricante);
			System.out.println("Comentario de Fabricante");
			comentario = tec.nextLine();
			anuncio.setComentarioFabricante(comentario);
			System.out.println("Pdf caracteristicas");
			pdfCaracteristicas = tec.nextLine();
			anuncio.setPdfCaracteristicas(pdfCaracteristicas);
			Date ahora = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			fecha=Integer.parseInt(sdf.format(ahora));
			anuncio.setFechaAnuncio(fecha);
			System.out.println("Fecha lanzamineto");
			System.out.println("Anyo");
			anyo = tec.next();
			System.out.println("Mes");
			mes = tec.next();
			System.out.println("dia");
			dia = tec.next();
			fechaLanzamiento = Integer.parseInt(anyo+mes+dia);
			anuncio.setFechaLanzamiento(fechaLanzamiento);
			
			tablonAnuncioDAO.addAnuncio(_con, anuncio);
		
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(_con!=null) _conexion_DB.CerrarConexion(_con);
		}
	}
	/**
	 * <p>Este metodo es para anyadir un Contenido sobre un equipamiento y lo anyade en la bases de datos</p>
	 * @throws Exception
	 */
	public static void addContenido()throws Exception {
		Conexion_DB _conexion_DB = new Conexion_DB();
		Connection _con = null;
		String tipo,software;
		double precio;
		try {
			_con = _conexion_DB.AbrirConexion();
			ContenidoDAO contenidoDAO = new ContenidoDAO(); 
			Contenido contenido = new Contenido();
			System.out.println("Tipo de Contenido");
			tipo = tec.nextLine();
			tipo = tec.nextLine();
			contenido.setTipo(tipo);
			System.out.println("Precio de Contenido");
			precio = tec.nextDouble();
			contenido.setPrecio(precio);
			System.out.println("Software de Contenido");
			software = tec.nextLine();
			software = tec.nextLine();
			contenido.setSoftware(software);
	
			contenidoDAO.addContenido(_con, contenido);
		
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(_con!=null) _conexion_DB.CerrarConexion(_con);
		}
	}
	/**
	 * <p>Este metodo es para anyadir un Equipamiento sobre un equipamiento y lo anyade en la bases de datos</p>
	 * @throws Exception
	 */
	public static void addEquipamiento()throws Exception {
		Conexion_DB _conexion_DB = new Conexion_DB();
		Connection _con = null;
		String tipo,nombre,imagen;
		double precio;
		int ejemplares;
		try {
			_con = _conexion_DB.AbrirConexion();
			EquipamientoDAO equipamientoDAO = new EquipamientoDAO(); 
			Equipamiento equipamiento = new Equipamiento();
			System.out.println("Nombre de Equipamiento");
			nombre = tec.nextLine();
			equipamiento.setNombre(nombre);
			System.out.println("Tipo de Equipamiento");
			tipo = tec.nextLine();
			equipamiento.setTipo(tipo);
			System.out.println("Ejemplares de Equipamiento");
			ejemplares = tec.nextInt();
			equipamiento.setEjemplares(ejemplares);
			System.out.println("Precio de Equipamiento");
			precio = tec.nextDouble();
			equipamiento.setPrecio(precio);;
			System.out.println("Imagen de Equipamiento");
			imagen = tec.nextLine();
			imagen = tec.nextLine();
			equipamiento.setImagen(imagen);
	
			equipamientoDAO.addEquipamiento(_con, equipamiento);
		
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(_con!=null) _conexion_DB.CerrarConexion(_con);
		}
	}
	/**
	 * <p>Este metodo es para buscar un equipamiento</p>
	 * @throws Exception
	 */
	public static void buscarEquipamientoPorNombre()throws Exception {
		Conexion_DB _conexion_DB = new Conexion_DB();
		Connection _con = null;
		String nombre;
		try {
			_con = _conexion_DB.AbrirConexion();
			EquipamientoDAO equipamientoDAO = new EquipamientoDAO();
			Equipamiento equipamiento = new Equipamiento();
			System.out.println("Nombre de Equipamineto");
			nombre = tec.nextLine();
			nombre = tec.nextLine();
			equipamiento.setNombre(nombre);
			
			try {
				equipamiento = equipamientoDAO.findByNombre(_con, equipamiento);
				System.out.println(equipamiento.toString());
			}catch(ExcepcionNoEncontrado e) {
				if(e.getTipoError()==1)
					System.out.println("No he podido encontrar el equipamiento en bases de datos");
			}
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(_con!=null) _conexion_DB.CerrarConexion(_con);
		}
	}
	/**
	 * <p>Este metodo es para buscar un contenido por su nombre</p>
	 * @throws Exception
	 */
	public static void buscarContenidoPorNombre()throws Exception {
		Conexion_DB _conexion_DB = new Conexion_DB();
		Connection _con = null;
		String nombre;
		try {
			_con = _conexion_DB.AbrirConexion();
			ContenidoDAO contenidoDAO = new ContenidoDAO();
			Contenido contenido = new Contenido();
			System.out.println("Nombre de Software");
			nombre = tec.nextLine();
			nombre = tec.nextLine();
			contenido.setSoftware(nombre);
		
			try {
				contenido = contenidoDAO.findByNombre(_con, contenido);
				System.out.println(contenido.toString());
			}catch(ExcepcionNoEncontrado e) {
				if(e.getTipoError()==2)
				System.out.println("No he podido encontrar el software en bases de datos");
			}
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(_con!=null) _conexion_DB.CerrarConexion(_con);
		}
	}
	/**
	 * <p>Este metodo es para hacer un contrato con un evento que alquila los equipamientos y contenido</p>
	 * @throws Exception
	 */
	public static void hacerContrato() throws Exception {
		Conexion_DB _conexion_DB = new Conexion_DB();
		Connection _con = null;
		int fechaInicio,fechaFin;
		String nombreEvento,equipamiento,contenido;
		boolean nombreEventoEncontrado = false;
		try {
			_con = _conexion_DB.AbrirConexion();
			ContratoDAO contratoDAO = new ContratoDAO();
			Contrato contrato = new Contrato();
			EventoDAO eventoDAO = new EventoDAO();
			Evento evento = new Evento();
			System.out.println("Nombre de Evento");
			nombreEvento = tec.nextLine();
			nombreEvento = tec.nextLine();
			evento.setNombre(nombreEvento);
			while(nombreEventoEncontrado==false) {
				if(eventoDAO.findByNombre(_con, evento) != null) {
					evento = eventoDAO.findByNombre(_con, evento);
					nombreEventoEncontrado=true;
				}else {
					System.out.println("Pon un nombre de evento valido");
					nombreEvento = tec.nextLine();
					evento.setNombre(nombreEvento);
				}
			}
			System.out.println("Fecha Inicio AAAAMMDD");
			fechaInicio = tec.nextInt();
			contrato.setFechaIncio(fechaInicio);
			System.out.println("Fecha Fin AAAAMMDD");
			fechaFin = tec.nextInt();
			contrato.setFechaFin(fechaFin);
			contrato = contratoDAO.addContrato(_con, contrato, evento);
			System.out.println("Quieres contratar equipamiento SI O NO");
			equipamiento = tec.next();
			while(equipamiento.equalsIgnoreCase("si")) {
				String nombreE;boolean equipNomValido = false;
				int ejemplares;
				EquipamientoDAO equipamientoDAO = new EquipamientoDAO();
				Equipamiento equip = new Equipamiento();
				verEquipamiento();
				System.out.println("Nombre de equipamiento");
				nombreE = tec.nextLine();
				nombreE = tec.nextLine();
				equip.setNombre(nombreE);
				while(equipNomValido==false) {
					if(equipamientoDAO.findByNombre(_con, equip) != null) {
						equip = equipamientoDAO.findByNombre(_con, equip);
						equipNomValido=true;
					}else {
						System.out.println("Pon un nombre de equipamiento que exista");
						nombreEvento = tec.nextLine();
						equip.setNombre(nombreE);
					}
				}
				System.out.println("Cuantas unidades");
				ejemplares = tec.nextInt();
				if((equip.getEjemplares()-ejemplares)>0) {
					equip.setEjemplares(equip.getEjemplares()-ejemplares);
					equipamientoDAO.updateStock(_con, equip);
					contratoDAO.addEquipamientoContrato(_con, equip, contrato,ejemplares);
					
				}else {
					System.out.println("No se ha podido contratar este equipamiento porque solo tenemos " + equip.getEjemplares() + " Undiades disponibles");
				}
				System.out.println("Quieres seguir contratando  equipamiento SI O NO");
				equipamiento = tec.next();
			}
			
			System.out.println("Quieres contratar contenido SI O NO");
			contenido = tec.next();
			while(contenido.equalsIgnoreCase("si")) {
				String nombreE;boolean equipNomValido = false;
				ContenidoDAO contenidoDAO = new ContenidoDAO();
				Contenido contenido1 = new Contenido();
				verContenido();
				System.out.println("Nombre de software");
				nombreE = tec.nextLine();
				nombreE = tec.nextLine();
				contenido1.setSoftware(nombreE);
				while(equipNomValido==false) {
					if(contenidoDAO.findByNombre(_con,contenido1 ) != null) {
						contenido1 = contenidoDAO.findByNombre(_con,contenido1);
						equipNomValido=true;
					}else {
						System.out.println("Pon un nombre de contenido que exista");
						nombreE = tec.nextLine();
						contenido1.setSoftware(nombreE);
					}
				}
				contratoDAO.addContenidoContrato(_con, contenido1, contrato);
				System.out.println("Quieres seguir contratando contenido SI O NO");
				contenido = tec.next();
			}
		
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(_con!=null) _conexion_DB.CerrarConexion(_con);
		}
	}
	/**
	 * <p>Este metodo es para generar una factura de un contrato </p>
	 * @throws Exception
	 */
	public static void generarFactura()throws Exception {
		ArrayList<Integer> equipamientoContratados = new ArrayList<Integer>();
		ArrayList<Integer> contenidoContratados = new ArrayList<Integer>();
		Conexion_DB _conexion_DB = new Conexion_DB();
		Connection _con = null;
		double totalAPagar = 0;
		int id,dias;boolean idExiste=false,eventoNomValido=false;String anyoInicio,mesInicio,diaInicio,anyoFin,mesFin,diaFin,nombre;
		try {
			_con = _conexion_DB.AbrirConexion();
			ContratoDAO contratoDAO = new ContratoDAO();
			EquipamientoDAO equipamientoDAO = new EquipamientoDAO();
			Equipamiento equipamiento = new Equipamiento();
			ContenidoDAO contenidoDAO = new ContenidoDAO();
			Contenido contenido = new Contenido();
			Contrato contrato = new Contrato();
			Factura factura=new Factura();
			EventoDAO eventoDAO = new EventoDAO();
			Evento evento = new Evento();
			System.out.println("Nombre de Evento");
			nombre = tec.nextLine();
			nombre = tec.nextLine();
			evento.setNombre(nombre);
			while(eventoNomValido==false) {
				if(eventoDAO.findByNombre(_con, evento) != null) {
					evento = eventoDAO.findByNombre(_con, evento);
					eventoNomValido=true;
				}else {
					System.out.println("Pon un nombre de evento que exista");
					nombre = tec.nextLine();
					evento.setNombre(nombre);
				}
			}
			contrato.setIdEvento(evento.getIdEvento());
			contrato = contratoDAO.findByIdEvento(_con, contrato);
			/*
			contratoDAO.findById(_con, contrato);
			while(idExiste==false) {
				if(contrato != null) {
					contrato =  contratoDAO.findById(_con, contrato);
					idExiste=true;
				}else {
					System.out.println("Pon un Id de Contrato que exista");
					id = tec.nextInt();
					contrato.setIdcontrato(id);
				}
				
			}
			*/
			factura.setIdContrato(contrato.getIdcontrato());
			factura.setNombreCliente("Eventus");
			factura.setCifCliente("Y256783K");
			
			Date ahora = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			int fecha=Integer.parseInt(sdf.format(ahora));
			
			factura.setFecha(fecha);
			
			
			equipamientoContratados = contratoDAO.equipamientoContratados(_con, contrato);
			
			for(int i=0;i<equipamientoContratados.size();i++) {
				int idEquipamiento = equipamientoContratados.get(i);
				int unidades = contratoDAO.unidades(_con, idEquipamiento);
				equipamiento.setIdEquipamiento(idEquipamiento);
				equipamiento = equipamientoDAO.findById(_con, equipamiento);
				totalAPagar += equipamiento.getPrecio()* unidades;
			}
			contenidoContratados = contratoDAO.contenidoContratados(_con, contrato);
			for(int j=0;j<contenidoContratados.size();j++) {
				int idContenido = contenidoContratados.get(j);
				contenido.setIdContenido(idContenido);
				contenido= contenidoDAO.findById(_con, contenido);
				totalAPagar += contenido.getPrecio();	
			}
			
			dias = calcularDias(contrato.getFechaIncio(),contrato.getFechaFin());
			totalAPagar = totalAPagar * dias;
			
			System.out.println("Cuanto iva vas a aplicar");
			int iva = tec.nextInt();
			factura.setIva(iva);
			double sumar = totalAPagar * ((double) iva / 100);
			double total = totalAPagar + sumar;
			double rounded = Math.round(total * 100.00) / 100.00;

			factura.setTotalAPagar(rounded);
			FacturaDAO facturaDAO = new FacturaDAO();
			factura =  facturaDAO.addFactura(_con, factura,rounded);
			
			System.out.println("\n" + factura.toString());
			
			
		
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(_con!=null) _conexion_DB.CerrarConexion(_con);
		}
	}
	/**
	 * <p>Este metodo es para saber los dias de contrato</p>
	 * @param fechaInicio el dia que empezo el contrato
	 * @param fechaFin el dia que termino el contrato
	 * @return  devuelve los dias que ha sido activo el contrato
	 */
	public static int calcularDias(int fechaInicio,int fechaFin) {

		int anyoInicio = fechaInicio / 10000;
        int mesInicio = (fechaInicio % 10000) / 100;
        int diaInicio = fechaInicio % 100;

        int anyoFin = fechaFin / 10000;
        int mesFin = (fechaFin % 10000) / 100;
        int diaFin = fechaFin % 100;

        LocalDate fechaInicioLocalDate = LocalDate.of(anyoInicio, mesInicio, diaInicio);
        LocalDate fechaFinLocalDate = LocalDate.of(anyoFin, mesFin, diaFin);

        long diferenciaDias = ChronoUnit.DAYS.between(fechaInicioLocalDate, fechaFinLocalDate);
        return (int) diferenciaDias;	
	}
	/**
	 * <p>Genera una factura en html</p>
	 * @throws Exception
	 */
	public static void generarHtmlFactura()throws Exception {
		ArrayList<Integer> equipamientoContratados = new ArrayList<Integer>();
		ArrayList<Integer> contenidoContratados = new ArrayList<Integer>();
		Conexion_DB _conexion_DB = new Conexion_DB();
		Connection _con = null;
		int id,dias;double totalAPagar = 0;String nombre;boolean eventoNomValido = false;
		Date ahora = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		int fecha=Integer.parseInt(sdf.format(ahora));
		try {
			_con = _conexion_DB.AbrirConexion();
			ContratoDAO contratoDAO = new ContratoDAO();
			EquipamientoDAO equipamientoDAO = new EquipamientoDAO();
			Equipamiento equipamiento = new Equipamiento();
			ContenidoDAO contenidoDAO = new ContenidoDAO();
			Contenido contenido = new Contenido();
			Contrato contrato = new Contrato();
			FacturaDAO facturaDAO= new FacturaDAO();
			Factura factura = new Factura();
			EventoDAO eventoDAO = new EventoDAO();
			Evento evento = new Evento();
			System.out.println("Nombre de Evento");
			nombre = tec.nextLine();
			nombre = tec.nextLine();
			evento.setNombre(nombre);
			while(eventoNomValido==false) {
				if(eventoDAO.findByNombre(_con, evento) != null) {
					evento = eventoDAO.findByNombre(_con, evento);
					eventoNomValido=true;
				}else {
					System.out.println("Pon un nombre de evento que exista");
					nombre = tec.nextLine();
					evento.setNombre(nombre);
				}
			}
			contrato.setIdEvento(evento.getIdEvento());
			if(contratoDAO.findByIdEvento(_con, contrato) != null) {
				contrato = contratoDAO.findByIdEvento(_con, contrato);
				
			}else {
				System.out.println("Evento no tiene contrato");
			
			}
			factura.setIdContrato(contrato.getIdcontrato());
			
			if(facturaDAO.findByIdContrato(_con, factura) != null) {
				factura = facturaDAO.findByIdContrato(_con, factura);
				
			}else {
				System.out.println("No existe la factura para ese Evento");
			
			}
			factura = facturaDAO.findById(_con, factura);
			if(factura != null) {
				System.out.println("Dame un nombre de archivo.html");
				String archivo = tec.nextLine();
				File f = new File(archivo);
				contrato.setIdcontrato(factura.getIdContrato());
				contrato = contratoDAO.findById(_con, contrato);
				dias = calcularDias(contrato.getFechaIncio(),contrato.getFechaFin());
				equipamientoContratados = contratoDAO.equipamientoContratados(_con, contrato);
				contenidoContratados = contratoDAO.contenidoContratados(_con, contrato);
			
		        try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {
		            bw.write("<html>");
		            bw.newLine();
		            bw.write("<head>");
		            bw.newLine();
		            bw.write("<title>Factura</title>");
		            bw.newLine();
		            bw.write("<style>");
		            bw.newLine();
		            bw.write("table {");
		            bw.newLine();
		            bw.write("  border-collapse: collapse;");
		            bw.newLine();
		            bw.write("  width: 100%;");
		            bw.newLine();
		            bw.write("margin-top: 10px;");
		            bw.newLine();
		            bw.write("}");
		            bw.newLine();
		            bw.write("th, td {");
		            bw.newLine();
		            bw.write("  padding: 8px;");
		            bw.newLine();
		            bw.write("  text-align: left;");
		            bw.newLine();
		            bw.write("  border-bottom: 1px solid #ddd;");
		            bw.newLine();
		            bw.write("}");
		            bw.newLine();
		            bw.write("</style>");
		            bw.newLine();
		            bw.write("</head>");
		            bw.newLine();
		            bw.write("<body>");
		            bw.newLine();
		            bw.write("<b>ID Factura: </b>");
		            bw.newLine();
		            bw.write(Integer.toString(factura.getIdFactura()));
		            bw.newLine();
		            bw.write("<br>");
		            bw.newLine();
		            bw.write("<b>Fecha: </b>");
		            bw.newLine();
		            bw.write(Integer.toString(factura.getFecha()) );
		            bw.newLine();
		            bw.write("<br>");
		            bw.newLine();
		            bw.write("<b>Nombre del Cliente: </b>");
		            bw.newLine();
		            bw.write(factura.getNombreCliente());
		            bw.newLine();
		            bw.write("<br>");
		            bw.newLine();
		            bw.write("<b>Cif del Cliente: </b>");
		            bw.newLine();
		            bw.write(factura.getCifCliente());
		            bw.newLine();
		            bw.write("<br>");
		            bw.newLine();
		            bw.write("<b>Dias Alquilado: </b>");
		            bw.newLine();
		            bw.write(Integer.toString(dias));
		            bw.newLine();
		            bw.write("<br>");
		            bw.newLine();
		            bw.write("<table>");
		            bw.newLine();
		            bw.write("<tr>");
		            bw.newLine();
		            bw.write("<th>ID Producto</th>");
		            bw.newLine();
		            bw.write("<th>Cantidad</th>");
		            bw.newLine();
		            bw.write("<th>IVA</th>");
		            bw.newLine();
		            bw.write("<th>Precio</th>");
		            bw.newLine();
		            bw.write("<th>Importe</th>");
		            bw.newLine();
		            bw.write("</tr>");
		            bw.newLine();
		            for(int i=0;i<equipamientoContratados.size();i++) {
						int idEquipamiento = equipamientoContratados.get(i);
						int unidades = contratoDAO.unidades(_con, idEquipamiento);
						equipamiento.setIdEquipamiento(idEquipamiento);
						equipamiento = equipamientoDAO.findById(_con, equipamiento);
						totalAPagar += equipamiento.getPrecio()* unidades;
						 	bw.write("<tr>");
				            bw.newLine();
				            bw.write("<td>"+equipamiento.getIdEquipamiento() +"</td>");
				            bw.newLine();
				            bw.write("<td>"+ unidades+"</td>");
				            bw.newLine();
				            bw.write("<td>"+factura.getIva() +"%</td>");
				            bw.newLine();
				            bw.write("<td>"+equipamiento.getPrecio() +"</td>");
				            bw.newLine();
				            bw.write("<td>"+ totalAPagar+"</td>");
				            bw.newLine();
				            bw.write("</tr>");
					}
		        	for(int j=0;j<contenidoContratados.size();j++) {
						int idContenido = contenidoContratados.get(j);
						contenido.setIdContenido(idContenido);
						contenido= contenidoDAO.findById(_con, contenido);
						totalAPagar += contenido.getPrecio();
						bw.write("<tr>");
			            bw.newLine();
			            bw.write("<td>"+contenido.getIdContenido()+"</td>");
			            bw.newLine();
			            bw.write("<td>"+ 1 +"</td>");
			            bw.newLine();
			            bw.write("<td>"+factura.getIva() +"%</td>");
			            bw.newLine();
			            bw.write("<td>"+contenido.getPrecio() +"</td>");
			            bw.newLine();
			            bw.write("<td>"+contenido.getPrecio() +"</td>");
			            bw.newLine();
			            bw.write("</tr>");
					}
	
		            bw.write("<tr>");
		            bw.newLine();
		            bw.write("<th rowspan='3' >Importe Total</th>");
		            bw.newLine();
		            bw.write("<td>"+ factura.getTotalAPagar()+"</td>");
		            bw.newLine();
		            bw.write("</tr>");
		            bw.newLine(); 
		            bw.write("</table>");
		            bw.newLine();
		            bw.write("</body>");
		            bw.newLine();
		            bw.write("</html>");
		            bw.newLine();

		            System.out.println("El archivo HTML se ha generado correctamente.");

		        } catch (IOException e) {
		            e.printStackTrace();
		        }
				
			}else {
				System.out.println("No he podido encontrar La Factura en bases de datos");
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(_con!=null) _conexion_DB.CerrarConexion(_con);
		}
	}
	/**
	 * <p>Este metodo es para eliminar un anuncio</p>
	 * @throws Exception
	 */
	public static void eliminarAnuncio() throws Exception {
		Conexion_DB _conexion_DB = new Conexion_DB();
		Connection _con = null;
		int codigo;
		try {
			_con = _conexion_DB.AbrirConexion();
			TablonAnuncioDAO tablonAnuncioDAO = new TablonAnuncioDAO();
			TablonAnuncio tablonAnuncio = new TablonAnuncio();
			 verTablonAnuncio();
			System.out.println("\n" + "¿Que anuncio quieres eliminar? Pon el codigo del anuncio");
			codigo = tec.nextInt();
			tablonAnuncio.setIdAnuncio(codigo);
			if(tablonAnuncioDAO.findById(_con, tablonAnuncio) != null) {
				tablonAnuncioDAO.eliminarAnuncio(_con, tablonAnuncio);
				System.out.println("\n" + "El Anuncio se ha eliminado con exito");
			}else {
				System.out.println("\n" + "Haz introducido un codigo que no existe");
			}
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(_con!=null) _conexion_DB.CerrarConexion(_con);
		}
	}
	/**
	 * <p>Este metodo es para eliminar un equipamiento que ya no tenemos</p>
	 * @throws Exception
	 */
	public static void eliminarEquipamiento() throws Exception {
		Conexion_DB _conexion_DB = new Conexion_DB();
		Connection _con = null;
		int codigo;
		try {
			_con = _conexion_DB.AbrirConexion();
			EquipamientoDAO equipamientoDAO = new EquipamientoDAO();
			Equipamiento equipamiento = new Equipamiento();
			verEquipamiento();
			System.out.println("\n" + "¿Que equipamiento quieres eliminar? Pon el codigo del equipamiento");
			codigo = tec.nextInt();
			equipamiento.setIdEquipamiento(codigo);
			if(equipamientoDAO.findById(_con, equipamiento) != null) {
				equipamientoDAO.eliminarEquipamiento(_con, equipamiento);
				System.out.println("\n" + "El Equipamiento se ha eliminado con exito");
			}else {
				System.out.println("\n" + "Haz introducido un codigo que no existe");
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(_con!=null) _conexion_DB.CerrarConexion(_con);
		}
	}
	/**
	 * <p>Este metodo es para eliminar un equipamiento que ya no tenemos disponible</p>
	 * @throws Exception
	 */
	public static void eliminarContenido() throws Exception {
		Conexion_DB _conexion_DB = new Conexion_DB();
		Connection _con = null;
		int codigo;
		try {
			_con = _conexion_DB.AbrirConexion();
			ContenidoDAO contenidoDAO = new ContenidoDAO();
			Contenido contenido = new Contenido();
			verContenido();
			System.out.println("\n" + "¿Que contenido quieres eliminar? Pon el codigo del contenido");
			codigo = tec.nextInt();
			contenido.setIdContenido(codigo);
			if(contenidoDAO.findById(_con, contenido) != null) {
				contenidoDAO.eliminarContenido(_con, contenido);
				System.out.println("\n" + "El contenido se ha eliminado con exito");
			}else {
				System.out.println("\n" + "Haz introducido un codigo que no existe");
			}
			
		
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(_con!=null) _conexion_DB.CerrarConexion(_con);
		}
	} 
	/**
	 * <p>Este metodo te muestra la factura de un evento</p>
	 * @throws Exception
	 */
	public static void verFacturaDeEvento() throws Exception {
		Conexion_DB _conexion_DB = new Conexion_DB();
		Connection _con = null;
		String nombre;boolean eventoNomValido=false;
		try {
			_con = _conexion_DB.AbrirConexion();
			ContratoDAO contratoDAO = new ContratoDAO();
			FacturaDAO facturaDAO = new FacturaDAO();
			Factura factura = new Factura();
			Contrato contrato = new Contrato();
			EventoDAO eventoDAO = new EventoDAO();
			Evento evento = new Evento();
			System.out.println("Nombre de Evento");
			nombre = tec.nextLine();
			nombre = tec.nextLine();
			evento.setNombre(nombre);
			while(eventoNomValido==false) {
				if(eventoDAO.findByNombre(_con, evento) != null) {
					evento = eventoDAO.findByNombre(_con, evento);
					eventoNomValido=true;
				}else {
					System.out.println("Pon un nombre de evento que exista");
					nombre = tec.nextLine();
					evento.setNombre(nombre);
				}
			}
			contrato.setIdEvento(evento.getIdEvento());
			if(contratoDAO.findByIdEvento(_con, contrato) != null) {
				contrato = contratoDAO.findByIdEvento(_con, contrato);
				
			}else {
				System.out.println("Evento no tiene contrato");
			
			}
			factura.setIdContrato(contrato.getIdcontrato());
			
			if(facturaDAO.findByIdContrato(_con, factura) != null) {
				factura = facturaDAO.findByIdContrato(_con, factura);
				
			}else {
				System.out.println("No existe la factura para ese Evento");
			
			}
			
			System.out.println(factura.toString());
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(_con!=null) _conexion_DB.CerrarConexion(_con);
		}
	}
	/**
	 * <p>Este metodo es para modificar el nombre o precio de contenido</p>
	 * @throws Exception
	 */
	public static void modificarContenido() throws Exception {
		Conexion_DB _conexion_DB = new Conexion_DB();
		Connection _con = null;
		int codigo,elige;String nombre;double precio;
		try {
			_con = _conexion_DB.AbrirConexion();
			ContenidoDAO contenidoDAO = new ContenidoDAO();
			Contenido contenido = new Contenido();
			verContenido();
			System.out.println("\n" + "¿Que contenido quieres modificarr? Pon el codigo del Contenido");
			codigo = tec.nextInt();
			contenido.setIdContenido(codigo);
			System.out.println("¿Que quieres modificar? Pulsa 1.Cambiar precio 2.Cambiar Nombre");
			elige = tec.nextInt();
			switch(elige) {
			case 1: 
				System.out.println("Introduce el nuevo precio");
				precio = tec.nextDouble();
				contenido.setPrecio(precio);
				contenidoDAO.modificarPrecio(_con, contenido);
				System.out.println("El precio ha sido modificado");
				break;
			case 2: 
				System.out.println("Introduce el nuevo nombre de Software");
				nombre = tec.nextLine();
				nombre = tec.nextLine();
				contenido.setSoftware(nombre);
				contenidoDAO.modificarNombre(_con, contenido);
				System.out.println("El nombre ha sido Modificado");
				break;
			}
			verContenido();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(_con!=null) _conexion_DB.CerrarConexion(_con);
		}
	}
	/**
	 * <p>Este metodo es para modificar el nombre o precio de contenido</p>
	 * @throws Exception
	 */
	public static void modificarEquipamiento() throws Exception {
		Conexion_DB _conexion_DB = new Conexion_DB();
		Connection _con = null;
		int codigo,elige;String nombre;double precio;
		try {
			_con = _conexion_DB.AbrirConexion();
			EquipamientoDAO equipamientoDAO = new EquipamientoDAO();
			Equipamiento equipamiento = new Equipamiento();
			verEquipamiento();
			System.out.println("\n" + "¿Que equipamiento quieres modificarr? Pon el codigo del Equipamiento");
			codigo = tec.nextInt();
			equipamiento.setIdEquipamiento(codigo);
			System.out.println("¿Que quieres modificar? Pulsa 1.Cambiar precio 2.Cambiar Nombre");
			elige = tec.nextInt();
			switch(elige) {
			case 1: 
				System.out.println("Introduce el nuevo precio");
				precio = tec.nextDouble();
				equipamiento.setPrecio(precio);
				equipamientoDAO.modificarPrecio(_con, equipamiento);
				System.out.println("El precio ha sido modificado");
				break;
			case 2: 
				System.out.println("Introduce el nuevo nombre de equipamiento");
				nombre = tec.nextLine();
				nombre = tec.nextLine();
				equipamiento.setNombre(nombre);
				equipamientoDAO.modificarNombre(_con, equipamiento);
				System.out.println("El nombre ha sido Modificado");
				break;
			}
			verEquipamiento();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(_con!=null) _conexion_DB.CerrarConexion(_con);
		}
	}
	/**
	 * <p>Este metodo es para buscar un anuncio</p>
	 * @throws Exception
	 */
	public static void buscarAnuncio()throws Exception {
		Conexion_DB _conexion_DB = new Conexion_DB();
		Connection _con = null;
		String nombre;
		try {
			_con = _conexion_DB.AbrirConexion();
			TablonAnuncioDAO tablonAnuncioDAO = new TablonAnuncioDAO();
			TablonAnuncio tablonAnuncio = new TablonAnuncio();
			System.out.println("Nombre de Equipamiento sobre el que quieres buscar la anuncio");
			nombre = tec.nextLine();
			nombre = tec.nextLine();
			tablonAnuncio.setNombre(nombre);
			try {
				tablonAnuncio = tablonAnuncioDAO.findByNombre(_con, tablonAnuncio);
				System.out.println(tablonAnuncio.toString());
			}catch(ExcepcionNoEncontrado e){
				if(e.getTipoError()==3)
				System.out.println("No he podido encontrar el anuncio en bases de datos");
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(_con!=null) _conexion_DB.CerrarConexion(_con);
		}
	}
	/**
	 * <p>Este metodo es para buscar el dni de un empleado de contenido</p>
	 * @throws Exception
	 */
	public static void buscarDniEmpleadoContenido() throws Exception {
		Conexion_DB _conexion_DB = new Conexion_DB();
		Connection _con = null;
		String nombre,apellido;
		try {
			_con = _conexion_DB.AbrirConexion();
			ContenidoDAO contenidoDAO = new ContenidoDAO();
			Contenido contenido = new Contenido();
			contenido = contenidoDAO.verEmpleadosContenido(_con);
			System.out.println("Dame el nombre de empleado del quieres saber el dni");
			nombre = tec.next();
			System.out.println("Dame el apellido");
			apellido = tec.next();
			System.out.println(contenido.getDniEmpleado(contenido.getEmpleados(),nombre, apellido));
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(_con!=null) _conexion_DB.CerrarConexion(_con);
		}	
	}
	/* Termina Parte de Sajid*/

}
