package Excepcion;

/**
 * <p>Esta clase genera una excepcion a la hora de buscar alguna
 * cosa que no hemos encontrado en bases de Datos</p>
 * @author sajid
 */
public class ExcepcionNoEncontrado extends Exception {
	private int tipoError;
	
	
	/**
	 * <p>Este es el constructor de la clase donde le psamos un parametro</p>
	 * @param tipoError. Este parametro es para indicar que tipo de error es.Por ejemplo 1 es para cuando no encuentra
	 * un equipamiento 2 para contenido y 3 para anuncio.
	 */
	public ExcepcionNoEncontrado(int tipoError) {
		super();
		this.tipoError = tipoError;
	}

	/**
	 * <p>Este metodo es para obtener el tipo de errorPor ejemplo 1 es para cuando no encuentra
	 * un equipamiento 2 para contenido y 3 para anuncio. </p>
	 * @return devuelve un valor int que indica el tipo de error
	 */
	public int getTipoError() {
		return tipoError;
	}


	
}
