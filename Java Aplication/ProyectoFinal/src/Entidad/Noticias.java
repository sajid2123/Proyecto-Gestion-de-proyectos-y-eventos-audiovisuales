package Entidad;

/**
 * <p>Esta clase representa una noticia</p>
 * @author gabriel
 *
 */

public class Noticias {
	private int id_noticia;
	private int id_evento;
	private String nombre;
	private String noticia;
	
	/**
	 * <p>Crea una instancia de Noticias.</p>
	 */
	public Noticias() {
		
	}

	/**
	 * <p>Crea una instancia de Noticias con los valores especificados.</p>
	 * 
	 * @param id_noticia El ID de la noticia.
	 * @param id_evento El ID del evento asociado a la noticia.
	 * @param nombre    El nombre de la noticia.
	 * @param noticia   El contenido de la noticia.
	 */
	public Noticias(int id_noticia, int id_evento, String nombre, String noticia) {
        this.id_noticia = id_noticia;
        this.id_evento = id_evento;
        this.nombre = nombre;
        this.noticia = noticia;
    }
    
    /**
     * <p>Obtiene el ID de la noticia.</p>
     * 
     * @return El ID de la noticia.
     */
    public int getId_noticia() {
        return id_noticia;
    }
    
    /**
     * <p>Establece el ID de la noticia.</p>
     * 
     * @param id_noticia El ID de la noticia.
     */
    public void setId_noticia(int id_noticia) {
        this.id_noticia = id_noticia;
    }
    
    /**
     * <p>Obtiene el ID del evento asociado a la noticia.</p>
     * 
     * @return El ID del evento asociado a la noticia.
     */
    public int getId_evento() {
        return id_evento;
    }
    
    /**
     * <p>Establece el ID del evento asociado a la noticia.</p>
     * 
     * @param id_evento El ID del evento asociado a la noticia.
     */
    public void setId_evento(int id_evento) {
        this.id_evento = id_evento;
    }
    
    /**
     * <p>Obtiene el nombre de la noticia.</p>
     * 
     * @return El nombre de la noticia.
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * <p>Establece el nombre de la noticia.</p>
     * 
     * @param nombre El nombre de la noticia.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * <p>Obtiene el contenido de la noticia.</p>
     * 
     * @return El contenido de la noticia.
     */
    public String getNoticia() {
        return noticia;
    }
    
    /**
     * <p>Establece el contenido de la noticia.</p>
     * 
     * @param noticia El contenido de la noticia.
     */
    public void setNoticia(String noticia) {
        this.noticia = noticia;
    }
}
