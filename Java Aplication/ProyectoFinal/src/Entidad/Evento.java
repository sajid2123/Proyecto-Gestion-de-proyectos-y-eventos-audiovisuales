package Entidad;

/**
 * <p>Esta clase representa un evento</p>
 * @author gabriel
 *
 */

public class Evento {
	private int idEvento;
	private String nombre;
	private String tipo;
	private int fecha;
	private int idCliente;
	private double precio;
	private int idrecinto;
	private String gestor;
	
	/**
	 * <p>Crea una instancia de Evento.</p>
	 */
	public Evento() {
		
	}

	/**
	 * <p>Crea una instancia de Evento con los valores especificados.</p>
	 * 
	 * @param idEvento   El ID del evento.
	 * @param nombre     El nombre del evento.
	 * @param tipo       El tipo de evento.
	 * @param fecha      La fecha del evento.
	 * @param idCliente  El ID del cliente asociado al evento.
	 * @param precio     El precio del evento.
	 * @param idrecinto  El ID del recinto asociado al evento.
	 * @param gestor     El gestor del evento.
	 */
	public Evento(int idEvento, String nombre, String tipo, int fecha, int idCliente, double precio, int idrecinto, String gestor) {
		super();
		this.idEvento = idEvento;
		this.nombre = nombre;
		this.tipo = tipo;
		this.fecha = fecha;
		this.idCliente = idCliente;
		this.precio = precio;
		this.idrecinto = idrecinto;
		this.gestor = gestor;
	}
	
	/**
	 * <p>Obtiene el nombre del evento.</p>
	 * 
	 * @return El nombre del evento.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * <p>Establece el nombre del evento.</p>
	 * 
	 * @param nombre El nombre del evento.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * <p>Obtiene el ID del evento.</p>
	 * 
	 * @return El ID del evento.
	 */
	public int getIdEvento() {
		return idEvento;
	}

	/**
	 * <p>Obtiene el tipo de evento.</p>
	 * 
	 * @return El tipo de evento.
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * <p>Obtiene la fecha del evento.</p>
	 * 
	 * @return La fecha del evento.
	 */
	public int getFecha() {
		return fecha;
	}

	/**
	 * <p>Obtiene el ID del cliente asociado al evento.</p>
	 * 
	 * @return El ID del cliente asociado al evento.
	 */
	public int getIdCliente() {
		return idCliente;
	}

	/**
	 * <p>Obtiene el precio del evento.</p>
	 * 
	 * @return El precio del evento.
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * <p>Obtiene el ID del recinto asociado al evento.</p>
	 * 
	 * @return El ID del recinto asociado al evento.
	 */
	public int getIdrecinto() {
		return idrecinto;
	}

	/**
	 * <p>Obtiene el gestor del evento.</p>
	 * 
	 * @return El gestor del evento.
	 */
	public String getGestor() {
		return gestor;
	}

	/**
	 * <p>Establece el ID del evento.</p>
	 * 
	 * @param idEvento El ID del evento.
	 */
	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}

	/**
	 * <p>Establece el tipo de evento.</p>
	 * 
	 * @param tipo El tipo de evento.
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * <p>Establece la fecha del evento.</p>
	 * 
	 * @param fecha La fecha del evento.
	 */
	public void setFecha(int fecha) {
		this.fecha = fecha;
	}

	/**
	 * <p>Establece el ID del cliente asociado al evento.</p>
	 * 
	 * @param idCliente El ID del cliente asociado al evento.
	 */
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	/**
	 * <p>Establece el precio del evento.</p>
	 * 
	 * @param precio El precio del evento.
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * <p>Establece el ID del recinto asociado al evento.</p>
	 * 
	 * @param idrecinto El ID del recinto asociado al evento.
	 */
	public void setIdrecinto(int idrecinto) {
		this.idrecinto = idrecinto;
	}

	/**
	 * <p>Establece el gestor del evento.</p>
	 * 
	 * @param gestor El gestor del evento.
	 */
	public void setGestor(String gestor) {
		this.gestor = gestor;
	}
}


