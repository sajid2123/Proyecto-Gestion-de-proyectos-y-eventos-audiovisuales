package Entidad;

import java.util.ArrayList;
import java.util.List;
/**
 * <p>Esta clase representa un software de contenido</p>
 * @author sajid
 *
 */
public class Contenido {
	private int idContenido;
	private String tipo;
	private double precio;
	private String software;
	private ArrayList<Empleado> empleados = new ArrayList<Empleado>() ;
	

	

	/**
	 * <p>Es el contructor sin parametros de clase</p>
	 */
	public Contenido() {
		
	}
	/**
	 *  <p>Este es el constructor con parametros</p>
	 *  
	 * @param idContenido. Representa de id de contenido.
	 * @param tipo. Representa tipo de contenido
	 * @param precio. Representa precio de un contenido
	 * @param software Representa el nombre de contenido.
	 */

	public Contenido(int idContenido, String tipo, double precio, String software) {
		super();
		this.idContenido = idContenido;
		this.tipo = tipo;
		this.precio = precio;
		this.software = software;
	}
	/**
	 *  <p>Este metodo es para añadir los empleados de contenido en el arraylist</p>
	 * @param e  Es el objeto de clase empleado que le paso para añadir en el arraylist
	 * 
	 */
	public void addEmpleado(Empleado e) {
		empleados.add(e);
		
	}
	/**
	 * <p>Este metodo es para tener los empleados de contenido </p>
	 * @return devuelve la lista de los empleado
	 */
	
	public ArrayList<Empleado> getEmpleados() {
		return empleados;
	}
	
	@Override
	public String toString() {
		return "\n" +"Contenido [idContenido=" + idContenido + ", tipo=" + tipo + ", precio=" + precio + ", software="
				+ software +"]" ;
	}
	/**
	 * <p>Este metodo es para obtener el id de contrato</p>
	 * @return devuelve el id de contenido
	 */
	public int getIdContenido() {
		return idContenido;
	}
	/**
	 * <p>Este metodo es para obtener el el tipo de contenido </p>
	 * @return devuelve el tipo de contenido
	 */

	public String getTipo() {
		return tipo;
	}
	/**
	 * <p>Este metodo es para obtener el precio de contenido</p>
	 * @return devuelve el precio de ceontenido
	 */
	public double getPrecio() {
		return precio;
	}
	/**
	 * <p>Este metodo es para obtener el nombre de software</p>
	 * @return devuelve el nombre de software de contenido
	 */
	public String getSoftware() {
		return software;
	}
	/**
	 * <p>Este metodo es para establecer el id de contenido </p>
	 * @param idContenido  el valor para establecer un id de un contenido
	 */
	public void setIdContenido(int idContenido) {
		this.idContenido = idContenido;
	}
	/**
	 * <p>Este metodo es para establecer el tipo de contenido </p>
	 * @param tipo para  el valor para establecer un tipo de un contenido
	 */

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	/**
	 * <p>Este metodo es para establecer el precio de contenido </p>
	 * @param precio para  el valor para establecer el precio de un contenido
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	/**
	 * <p>Este metodo es para establecer el nopmbre de software </p>
	 * @param software para  el valor para establecer un nombre de software de contenido
	 */
	public void setSoftware(String software) {
		this.software = software;
	}
	/**
	 * <p>El objetivo de esta funcion es buscar un empleado que cumple con las condiciones, 
	 * se devuelve el dni de ese empleado. En caso contrario, se devuelve una cadena 
	 *	de texto indicando el motivo por el cual no se encontró ningún empleado. </p>
	 *  
	 * @param empleados Una lista de empleados desde la tabla empleado donde el departamento es contenido.
	 * @param nombre El nombre del Empleado del que quieren saber el dni.
	 * @param apellido El apellido del Empleado del que quieren saber el dni.
	 * @return Devuelve el dni del empleado.
	 */
	public String getDniEmpleado(ArrayList<Empleado>empleados,String nombre,String apellido) {
		String cadena="Vacia";
		boolean encontrado = false;;
	
		
		for(int i=0;i<empleados.size() && encontrado==false ;i++) {
				if(empleados.get(i).getNombre().equalsIgnoreCase(nombre) && empleados.get(i).getApellido().equalsIgnoreCase(apellido)) {
						cadena = empleados.get(i).getDNI();
						encontrado=true;
				}else {
					cadena = "Empleado no Encontrado";
				}
		}
		return cadena;
	}
	

}
