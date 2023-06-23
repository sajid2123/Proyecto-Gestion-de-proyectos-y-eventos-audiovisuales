package Entidad;

import java.util.ArrayList;
import java.util.List;

/**
 *  <p>Esta clase representa un equipamiento
 * @author sajid
 *
 */
public class Equipamiento {
	private int idEquipamiento;
	private String nombre;
	private String tipo;
	private int ejemplares;
	private double precio;
	private String imagen;
	private ArrayList<Empleado> empleados = new ArrayList<Empleado>() ;
	

	/**
	 * <p>Es el contructor sin parametros de clase</p>
	 */
	public Equipamiento() {
		
	}
	/**
	 * <p>Este es el constructor con parametros</p>
	 * @param idEquipamiento es el id de equipamiento
	 * @param nombre es el nombre de equipamiento
	 * @param tipo es el tipo de equipamiento
	 * @param ejemplares es el ejemplares que tiene el equipamiento
	 * @param precio es el precio de equipamiento
	 * @param imagen es la imagen de equipamiento
	 */
	public Equipamiento(int idEquipamiento,String nombre, String tipo, int ejemplares, double precio, String imagen) {
		
		this.idEquipamiento = idEquipamiento;
		this.nombre = nombre;
		this.tipo = tipo;
		this.ejemplares = ejemplares;
		this.precio = precio;
		this.imagen = imagen;
	}
	/**
	 * <p>Este metodo es para obtener el nombre de equipamiento</p>
	 * @return devuelve el nombre de equipamiento
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * <p>Este metodo es para obtener los empleados de equipamiento</p>
	 * @return devuelve todos los empleados de equipamiento
	 */
	public ArrayList<Empleado> getEmpleados() {
		return empleados;
	}
	/**
	 * <p>Este metodo es para establecer el nombre de equipamiento</p>
	 * @param nombre establece el nombre de equipamiento
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * <p>Este metodo es para añadir el empleado de equipamiento en la lista</p>
	 * @param e pasamos un objeto de empleado para añadir en la lista de empleados
	 *
	 */
	public void addEmpleado(Empleado e) {
		empleados.add(e);
		
		
	}
	/**
	 * <p>Este metodo es para obtener el id de equipamiento</p>
	 * @return devuelve el id de equipamiento
	 */
	public int getIdEquipamiento() {
		return idEquipamiento;
	}
	/**
	 * <p>Este metodo es para obtener el tipo de equipamiento</p>
	 * @return devuelve el tipo de equipamiento
	 */
	public String getTipo() {
		return tipo;
	}
	/**
	 * <p>Este metodo es para obtener los ejemplares disponible de equipamiento</p>
	 * @return devuelve los ejemplares disponibles para ese equipamiento
	 */
	public int getEjemplares() {
		return ejemplares;
	}
	/**
	 * <p>Este metodo es para obtener el precio de equipamiento</p>
	 * @return devuelve el precio de equipamiento
	 */
	public double getPrecio() {
		return precio;
	}
	/**
	 * <p>Este metodo es para obtener la imagen de equipamiento</p>
	 * @return devueleve la imagen de equipamiento
	 */
	public String getImagen() {
		return imagen;
	}
	/**
	 * <p>Este metodo es para establecer el id de equipamiento</p>
	 * @param idEquipamiento  el valor para establecer el id de equipamiento
	 */
	public void setIdEquipamiento(int idEquipamiento) {
		this.idEquipamiento = idEquipamiento;
	}
	/**
	 * <p>Este metodo es para establecer el tipo de equipamiento</p>
	 * @param tipo  el valor para establecer el tio de equipamiento
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	/**
	 * <p>Este metodo es para establecer los ejemplares de equipamiento</p>
	 * @param ejemplares  el valor para establecer los ejemplares disponible para el equipamiento
	 */
	public void setEjemplares(int ejemplares) {
		this.ejemplares = ejemplares;
	}
	/**
	 * <p>Este metodo es para establecer r el precio de equipamiento</p>
	 * @param precio el valor para establecer el precio de equipamiento
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	/**
	 * <p>Este metodo es para establecer la imagen de equipamiento</p>
	 * @param imagen  el valor para establecer la imagen de equipamiento
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Override
	public String toString() {
		return "\n" +"Equipamiento [idEquipamiento=" + idEquipamiento + ", nombre=" + nombre + ", tipo=" + tipo
				+ ", ejemplares=" + ejemplares + ", precio=" + precio + ", imagen=" + imagen + "]";
	}
	

}
