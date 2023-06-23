package Entidad;

/**
 * <p>Esta clase representa un recinto</p>
 * @author gabriel
 *
 */


public class Recinto {
	private int id_recinto;
	private String nombre;
	private String descripcion;
	private String direccion;
	private String municipio;
	private int cod_postal;
	private String foto_recinto;
	private int salas;
	
	/**
	 * <p>Crea una instancia de Recinto.</p>
	 */
	public Recinto() {
		
	}


	/**
	 * <p>Crea una instancia de Recinto con los valores especificados.</p>
	 * 
	 * @param id_recinto   El ID del recinto.
	 * @param nombre       El nombre del recinto.
	 * @param descripcion  La descripción del recinto.
	 * @param direccion    La dirección del recinto.
	 * @param municipio    El municipio del recinto.
	 * @param cod_postal   El código postal del recinto.
	 * @param foto_recinto La foto del recinto.
	 * @param salas        El número de salas del recinto.
	 */
	public Recinto(int id_recinto, String nombre, String descripcion, String direccion, String municipio, int cod_postal, String foto_recinto, int salas) {
        this.id_recinto = id_recinto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.municipio = municipio;
        this.cod_postal = cod_postal;
        this.foto_recinto = foto_recinto;
        this.salas = salas;
    }
    
    /**
     * <p>Obtiene el ID del recinto.</p>
     * 
     * @return El ID del recinto.
     */
    public int getIdRecinto() {
        return id_recinto;
    }
    
    /**
     * <p>Obtiene el nombre del recinto.</p>
     * 
     * @return El nombre del recinto.
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * <p>Obtiene la descripción del recinto.</p>
     * 
     * @return La descripción del recinto.
     */
    public String getDescripcion() {
        return descripcion;
    }
    
    /**
     * <p>Obtiene la dirección del recinto.</p>
     * 
     * @return La dirección del recinto.
     */
    public String getDireccion() {
        return direccion;
    }
    
    /**
     * <p>Obtiene el municipio del recinto.</p>
     * 
     * @return El municipio del recinto.
     */
    public String getMunicipio() {
        return municipio;
    }
    
    /**
     * <p>Obtiene el código postal del recinto.</p>
     * 
     * @return El código postal del recinto.
     */
    public int getCodPostal() {
        return cod_postal;
    }
    
    /**
     * <p>Obtiene la foto del recinto.</p>
     * 
     * @return La foto del recinto.
     */
    public String getFotoRecinto() {
        return foto_recinto;
    }
    
    /**
     * <p>Obtiene el número de salas del recinto.</p>
     * 
     * @return El número de salas del recinto.
     */
    public int getSalas() {
        return salas;
    }
    
    /**
     * <p>Establece el ID del recinto.</p>
     * 
     * @param id_recinto El ID del recinto.
     */
    public void setIdRecinto(int id_recinto) {
        this.id_recinto = id_recinto;
    }
    
    /**
     * <p>Establece el nombre del recinto.</p>
     * 
     * @param nombre El nombre del recinto.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * <p>Establece la descripción del recinto.</p>
     * 
     * @param descripcion La descripción del recinto.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    /**
     * <p>Establece la dirección del recinto.</p>
     * 
     * @param direccion La dirección del recinto.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    /**
     * <p>Establece el municipio del recinto.</p>
     * 
     * @param municipio El municipio del recinto.
     */
    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
    
    /**
     * <p>Establece el código postal del recinto.</p>
     * 
     * @param cod_postal El código postal del recinto.
     */
    public void setCodPostal(int cod_postal) {
        this.cod_postal = cod_postal;
    }
    
    /**
     * <p>Establece la foto del recinto.</p>
     * 
     * @param foto_recinto La foto del recinto.
     */
    public void setFotoRecinto(String foto_recinto) {
        this.foto_recinto = foto_recinto;
    }
    
    /**
     * <p>Establece el número de salas del recinto.</p>
     * 
     * @param salas El número de salas del recinto.
     */
    public void setSalas(int salas) {
        this.salas = salas;
    }
}
