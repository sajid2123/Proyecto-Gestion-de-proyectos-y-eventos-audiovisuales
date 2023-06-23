package Entidad;

/**
 * <p>Esta clase representa una Empresa</p>
 * @author David Salinas
 *
 */
public class Empresa {
    private String Cif;
    private String nombre;
    private String direccion;
    private String municipio;
    private String telefono;
/**
 * <p> Constructor por defecto </p>
 */
    public Empresa() {

    }
    /**
     * <p> Constructor con parametros </p>
     * @param Cif es el Cif que tiene al empresa
     * @param nombre es el nombre de la empresa
     * @param direccion la direccion de la empresa
     * @param municipio es el municipio donde esta el empresa
     * @param telefono es el telefono de la empresa
     */
    public Empresa(String Cif, String nombre, String direccion, String municipio, String telefono) {
        this.Cif = Cif;
        this.nombre = nombre;
        this.direccion = direccion;
        this.municipio = municipio;
        this.telefono = telefono;
    }
    // Getters y Setters
    /**
     * <p> Metodo que establece el Cif a la empresa </p>
     * @return devuleve el Cif de la empresa
     */
    public String getCif() {
        return Cif;
    }
/**
 * <p> Metodo que estblece el cif de la empresa </p>
 * @param cif valor que establece el cif de la empresa
 */
    public void setCif(String cif) {
        Cif = cif;
    }
/**
 *  <p> Metodo que obtiene el nombre de la empresa </p>
 * @return devuelve el nombre de la empresa
 */
    public String getNombre() {
        return nombre;
    }
/**
 * <p> Metodo para establecer el nombre de la empresa </p>
 * @param nombre valor para asignar la empresa 
 */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
/**
 * <p> El metodo devuelve la direccion de la empresa </p>
 * @return devuleve dirección de la empresa </p>
 */
    public String getDireccion() {
        return direccion;
    }
/**
 * <p> Metodo que asigna la direccion de la empresa </p>
 * @param direccion valor para estblecer cual es la dirección de la empresa
 */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
/**
 * <p> Método que regresa el municipio </p>
 * @return devuelve el municipio de la empresa
 */
    public String getMunicipio() {
        return municipio;
    }
/**
 * <p>Metodo que establece el municipio de Empresa </p>
 * @param municipio valor que se asigna a la empresa que designa el municipio
 */
    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
/**
 * <p> Metodo que nos devuleve el telefono de la empresa </p>
 * @return nos regresa el valor del telefono de la empresa
 */
    public String getTelefono() {
        return telefono;
    }
/**
 * <p> Metodo que  asigna un telefono a la empresa </p>
 * @param telefono el valor asigna el telefono de la empresa
 */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    /**
     * <p> metodo que devuelve un String con la información de Cliente </p>
     * @return regresa un String con al información de la empresa
     */
    public String toString() {
        return "Cliente{" +
            "Cif='" + Cif + '\'' +
            ", nombre='" + nombre + '\'' +
            ", direccion='" + direccion + '\'' +
            ", municipio='" + municipio + '\'' +
            ", telefono='" + telefono + '\'' +
            '}';
    }

}
