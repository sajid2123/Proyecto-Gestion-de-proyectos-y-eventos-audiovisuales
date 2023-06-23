package Entidad;

import java.util.ArrayList;

/**
 * <p>Esta clase representa un contrato entre un evento y equipamiento,contenido.</p>
 * @author sajid 
 *
 */
public class Contrato {
	

	private int idcontrato;
	private int fechaIncio;
	private int fechaFin;
	private int idEvento;
	private ArrayList<Equipamiento> equipamiento = new ArrayList<Equipamiento>();
	private ArrayList<Contenido> contenido = new ArrayList<Contenido>();
	
	
	/**
	 * <p>Es el contructor sin parametros de clase</p>
	 */
	public Contrato() {
		
	}
	/**
	 * <p>Este es el constructor con parametros</p>
	 * @param idcontrato es el id de contrtao
	 * @param fechaIncio fecha de inicio del contrato
	 * @param fechaFin fecha de fin del contrato 
	 * @param idEvento id de evento con la que estamos haciendo el contrato
	 */
	public Contrato(int idcontrato, int fechaIncio, int fechaFin, int idEvento) {
		super();
		this.idcontrato = idcontrato;
		this.fechaIncio = fechaIncio;
		this.fechaFin = fechaFin;
		this.idEvento = idEvento;
	}
	/**
	 * <p>Este metodo es para obtener el id de contrato </p>
	 * @return devuelve el id de contrato
	 */
	public int getIdcontrato() {
		return idcontrato;
	}
	/**
	 * <p>Este metodo es para obtener la fecha de Inicio de contrato</p>
	 * @return devuelve la fecha de inicio de contrato
	 */
	public int getFechaIncio() {
		return fechaIncio;
	}
	/**
	 * <p>Este metodo es para obtener el fecha fin de contrato</p>
	 * @return devuelve la fecha de fin de contrato
	 */
	public int getFechaFin() {
		return fechaFin;
	}
	/**
	 * <p>Este metodo es para obtener el id de evento con el que hemos hecho el contrato </p>
	 * @return devuelve la id de evento con la que hemos el hecho el contrato
	 */
	public int getIdEvento() {
		return idEvento;
	}
	/**
	 * <p>Este metodo establece el id de contrato </p>
	 * @param idcontrato el valor para establecer el id de contrato
	 */
	public void setIdcontrato(int idcontrato) {
		this.idcontrato = idcontrato;
	}
	/**
	 * <p>Este metodo establece la fecha inicio de contrato </p>
	 * @param fechaIncio el valor para establecer fecha de inicio de contrato
	 */
	public void setFechaIncio(int fechaIncio) {
		this.fechaIncio = fechaIncio;
	}
	/**
	 * <p>Este metodo establecela fecha fin de contrato </p>
	 * @param fechaFin el valor para establecer fecha de fin de contrato
	 */
	public void setFechaFin(int fechaFin) {
		this.fechaFin = fechaFin;
	}
	/**
	 * <p>Este metodo establece el id de evento con la que hemos hecho el contrato </p>
	 * @param idEvento el valor para establecer el id de evento con la que hemos hecho el contrato
	 */
	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}
	@Override
	public String toString() {
		return "\n" +"Contrato [idcontrato=" + idcontrato + ", fechaIncio=" + fechaIncio + ", fechaFin=" + fechaFin
				+ ", idEvento=" + idEvento + "]";
	}
	
	
}
