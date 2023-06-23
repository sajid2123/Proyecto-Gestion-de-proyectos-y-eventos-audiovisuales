package Entidad;

/**
 *  <p>Esta clase representa anuncios sobre equipamientos</p>
 * @author sajid
 *
 */
public class TablonAnuncio {
	private int idAnuncio;
	private String nombre;
	private String tipo;
	private String Fabricante;
	private String comentarioFabricante;
	private String pdfCaracteristicas;
	private int fechaAnuncio;
	private int fechaLanzamiento;
	private int idEquipamiento;
	

	/**
	 * <p>Es el contructor sin parametros de clase</p>
	 */
	public TablonAnuncio(){
		
	}
	/**
	 * <p>Este es el constructor con parametros</p>
	 * @param idAnuncio es el id de anuncio
	 * @param tipo es el tipo de anuncio
	 * @param fabricante el fabricante de equipamiento sobre cual es el anuncio
	 * @param comentarioFabricante comentario de fabricante sobre el equipamineto
	 * @param pdfCaracteristicas caracteristicas del equipamiento sobre cual es el anuncio
	 * @param fechaAnuncio dia en cual se publico este anuncio
	 * @param fechaLanzamiento fecha de lanzamiento del equipamiento
	 */
	public TablonAnuncio(int idAnuncio, String tipo, String fabricante, String comentarioFabricante,
			String pdfCaracteristicas, int fechaAnuncio, int fechaLanzamiento) {
		
		this.idAnuncio = idAnuncio;
		this.tipo = tipo;
		Fabricante = fabricante;
		this.comentarioFabricante = comentarioFabricante;
		this.pdfCaracteristicas = pdfCaracteristicas;
		this.fechaAnuncio = fechaAnuncio;
		this.fechaLanzamiento = fechaLanzamiento;
	}
	/**
	 * <p>Este metodo es para obtener el id de  anuncio</p>
	 * @return devuelve el id de anuncio
	 */
	public int getIdAnuncio() {
		return idAnuncio;
	}
	/**
	 * <p>Este metodo es para obtener el tipo de equipamiento sobre cual esta el anuncio </p>
	 * @return devuelve el tipo de equipamiento sore cual es el anuncio
	 */
	public String getTipo() {
		return tipo;
	}
	/**
	 * <p>Este metodo es para obtener el nombre de equipamiento sobre cual es el anuncio </p>
	 * @return devuelve el nombre de equipamiento sobre cual es el anuncio
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * <p>Este metodo es para establecer el nombre de equipamiento sobre cual es el anuncio </p>
	 * @param nombre el valor para establecer el nombre de equipamiento sobre cual es el anuncio
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 *  <p>Este metodo es para obtener el fabricante de equipamiento sobre cual es el anuncio </p>
	 * @return devuelve el fabricante de equipamiento sobre cual es el anuncio
	 */
	public String getFabricante() {
		return Fabricante;
	}
	/**
	 * <p>Este metodo es para obtener el comentario del fabricante de equipamiento sobre cual es el anuncio </p>
	 * @return devuelve el comentario del fabricante de equipamiento sobre cual es el anuncio 
	 */
	public String getComentarioFabricante() {
		return comentarioFabricante;
	}
	/**
	 * <p>Este metodo es para obtener el pdf de caracteristicas de equipamiento sobre cual es el anuncio </p>
	 * @return devuelve el pdf de caracteristicas de equipamiento sobre cual es el anuncio
	 */
	public String getPdfCaracteristicas() {
		return pdfCaracteristicas;
	}
	/**
	 * <p>Este metodo es para obtener el fecha del anuncio </p>
	 * @return devuelve el fecha del anuncio
	 */
	public int getFechaAnuncio() {
		return fechaAnuncio;
	}
	/**
	 * <p>Este metodo es para obtener la fecha de lanzamiento de equipamiento sobre cual es el anuncio </p>
	 * @return devuelve el fecha de lanzamiento de equipamiento sobre cual es el anuncio
	 */
	public int getFechaLanzamiento() {
		return fechaLanzamiento;
	}
	/**
	 * <p>Este metodo es para establecer el id del anuncio </p>
	 * @param idAnuncio el valor para establecer el id del anuncio
	 */
	public void setIdAnuncio(int idAnuncio) {
		this.idAnuncio = idAnuncio;
	}
	/**
	 * <p>Este metodo es para establecer el tipo de equipamiento sobre cual es el anuncio </p>
	 * @param tipo el valor para establecer el tipo de equipamiento sobre cual es el anuncio
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	/**
	 * <p>Este metodo es para establecer el fabricante de equipamiento sobre cual es el anuncio </p>
	 * @param fabricante el valor para establecer el fabricante de equipamiento sobre cual es el anuncio
	 */
	public void setFabricante(String fabricante) {
		Fabricante = fabricante;
	}
	/**
	 * <p>Este metodo es para establecer el comentario de fabricante sobre equipamiento sobre cual es el anuncio </p>
	 * @param comentarioFabricante el valor para establecer  el comentario de fabricante sobre equipamiento sobre cual es el anuncio
	 */
	public void setComentarioFabricante(String comentarioFabricante) {
		this.comentarioFabricante = comentarioFabricante;
	}
	/**
	 * <p>Este metodo es para establecer el pdf de caracteristicas de equipamiento sobre cual es el anuncio </p>
	 * @param pdfCaracteristicas el valor para establecer el pdf de caracteristicas de equipamiento sobre cual es el anuncio 
	 */
	public void setPdfCaracteristicas(String pdfCaracteristicas) {
		this.pdfCaracteristicas = pdfCaracteristicas;
	}
	/**
	 * <p>Este metodo es para establecer la fecha del anuncio </p>
	 * @param fechaAnuncio el valor para establecer la fecha del anuncio
	 */
	public void setFechaAnuncio(int fechaAnuncio) {
		this.fechaAnuncio = fechaAnuncio;
	}
	/**
	 * <p>Este metodo es para establecer la fecha de lanzamiento de equipamiento sobre cual es el anuncio </p>
	 * @param fechaLanzamiento el valor para establecer la fecha de lanzamiento de equipamiento sobre cual es el anuncio
	 */
	public void setFechaLanzamiento(int fechaLanzamiento) {
		this.fechaLanzamiento = fechaLanzamiento;
	}
	/**
	 * <p>Este metodo es para obtener el id de equipamiento sobre cual es el anuncio </p>
	 * @return devuelve el id de equipamiento sobre cual es el anuncio 
	 */
	public int getIdEquipamiento() {
		return idEquipamiento;
	}
	/**
	 * <p>Este metodo es para establecer el id de equipamiento sobre cual es el anuncio </p>
	 * @param idEquipamiento el valor para establecer el id de equipamiento sobre cual es el anuncio
	 */ 
	public void setIdEquipamiento(int idEquipamiento) {
		this.idEquipamiento = idEquipamiento;
	}
	
	@Override
	public String toString() {
		return "\n" +"TablonAnuncio [idAnuncio=" + idAnuncio + ", nombre=" + nombre + ", tipo=" + tipo + ", Fabricante="
				+ Fabricante + ", comentarioFabricante=" + comentarioFabricante + ", pdfCaracteristicas="
				+ pdfCaracteristicas + ", fechaAnuncio=" + fechaAnuncio + ", fechaLanzamiento=" + fechaLanzamiento
				+ ", idEquipamiento=" + idEquipamiento + "]";
	}
	
	

	

}
