package Entidad;

/**
 * <p>Esta clase representa un Empleado</p>
 * @author David Salina
 *
 */
public class Empleado {
	private int idEmpleado;
	private String DNI;
	private String nombre;
	private String apellido;
	private int idDept;
	private String cifEmpresa;
	private int fechaAlta;
	private int telefono;
	private int id_jefe;
	
	/**
	 * <p> Constructor por defecto </p>
	 */
	  public Empleado() {}
	/**
	 * <p> Constructor con parametros </p>
	 * @param idEmpleado es el id del empleado
	 * @param dNI dni del empleado
	 * @param nombre es el nombre del empleado
	 * @param apellido apellido del empleado
	 * @param idDept la id del departamento que pertenece empleado
	 * @param cifEmpresa es el cif de la empresa del empleado
	 * @param fechaAlta la fecha de alta del empleado
	 * @param telefono es el telefono que tiene el empleado
	 * @param id_jefe el id del jefe del empleado
	 */
	  public Empleado(int idEmpleado, String dNI, String nombre, String apellido, int idDept, String cifEmpresa, int fechaAlta, int telefono, int id_jefe) {
	    this.idEmpleado = idEmpleado;
	    this.DNI = dNI;
	    this.nombre = nombre;
	    this.apellido = apellido;
	    this.idDept = idDept;
	    this.cifEmpresa = cifEmpresa;
	    this.fechaAlta = fechaAlta;
	    this.telefono = telefono;
	    this.id_jefe = id_jefe;
	  }
	  // Getters y Setters
	  /**
	   * <p> nos devuelve cual es el id del empleado </p>
	   * @return regresa el id de empleado
	   */
	  public int getIdEmpleado() {
	    return idEmpleado;
	  }
	/**
	 * <p> Nos va a devolver el Dni que tendra el empleado </p>
	 * @return regresa el dni del empleado
	 */
	  public String getDNI() {
	    return DNI;
	  }
	/**
	 * <p> Regresa cual es el nombre del empleado </p>
	 * @return nos devulve un String con el nombre del empleado
	 */
	  public String getNombre() {
	    return nombre;
	  }
	/**
	 * <p> Nos regresa el apellido del cliente </p>
	 * @return nos va a devolver el apellido del cliente
	 */
	  public String getApellido() {
	    return apellido;
	  }
	/**
	 * <p> Regresa el id del departamento </p>
	 * @return devuelde un int con el id del departamento
	 */
	  public int getIdDept() {
	    return idDept;
	  }
	/**
	 * <p> Regresa cual es el cif de la empresa </p>
	 * @return devuelve String con cif de la empresa
	 */
	  public String getCifEmpresa() {
	    return cifEmpresa;
	  }
	/**
	 *  <p> Nos devuelve cual es la fecha de alta del empleado </p>
	 * @return devuelve cual es el valor de la fecha de alta del empleado
	 */
	  public int getFechaAlta() {
	    return fechaAlta;
	  }
	/**
	 *  <p> Regresa el telefono del empleado </p>
	 * @return devuelve un int con el nuemero de telefono
	 */
	  public int getTelefono() {
	    return telefono;
	  }
	/**
	 * <p> Nos regresa el id del jefe del empleado </p>  
	 * @return devuelve un int con el id del jefe del empleado
	 */
	  public int getId_jefe() {
	    return id_jefe;
	  }
	/**
	 * <p> Establece cual es el id del empleado  </p>
	 * @param idEmpleado asigna el valor del id de empleado
	 */
	  public void setIdEmpleado(int idEmpleado) {
	    this.idEmpleado = idEmpleado;
	  }
	/**
	 * <p> Asigna a empleado el dni </p>
	 * @param  dNi valor que se asigna el dni al empleado
	 */
	  public void setDNI(String dNI) {
	    this.DNI = dNI;
	  }
	/**
	 * <p> Establece cual es el nombre del empleado  </p>
	 * @param nombre que se asigna al empleado
	 */
	  public void setNombre(String nombre) {
	    this.nombre = nombre;

	  }
	/**
	 *  <p> Este valor asigna el apellido del empleado </p>
	 * @param apellido valor a establecer al empleado  como apellido
	 */
	  public void setApellido(String apellido) {
	    this.apellido = apellido;
	  }
	/**
	 *  <p> Establece cual es el id del departamento del empleado </p>
	 * @param idDept valor para asignar el id del empleado 
	 */
	  public void setIdDept(int idDept) {
	    this.idDept = idDept;
	  }
	/**
	 *  <p> Asigna cual es el cif de la empresa del empleado </p>
	 * @param cifEmpresa este valor establece el cif de la empresa de cliente
	 */
	  public void setCifEmpresa(String cifEmpresa) {
	    this.cifEmpresa = cifEmpresa;
	  }
	/**
	 * <p> Establece la fecha de alta del empleado </p>
	 * @param fechaAlta este valor establece la fecha de alta del empleado
	 */
	  public void setFechaAlta(int fechaAlta) {
	    this.fechaAlta = fechaAlta;
	  }
	/**
	 * <p> El metodo establece el telefono del cliente </p>
	 * @param telefono el valor a asignar al cliente
	 */
	  public void setTelefono(int telefono) {
	    this.telefono = telefono;
	  }
	/**
	 * <p> El metodo asigna a empleado el id del jefe </p>
	 * @param id_jefe valor para asignar jefe al empleado
	 */
	  public void setId_jefe(int id_jefe) {
	    this.id_jefe = id_jefe;
	  }

	@Override
	public String toString() {
		return "Empleado [idEmpleado=" + idEmpleado + ", DNI=" + DNI + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", idDept=" + idDept + ", cifEmpresa=" + cifEmpresa + ", fechaAlta=" + fechaAlta + ", telefono="
				+ telefono + ", id_jefe=" + id_jefe + "]";
	}
	

}
