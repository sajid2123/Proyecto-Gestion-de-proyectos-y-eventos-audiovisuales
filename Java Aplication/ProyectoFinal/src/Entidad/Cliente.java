package Entidad;


/**
 * <p> Clase Cliente almacenamos los atributos y tenemos getters y setters asi como toString que muestra atributos </p>
 * @author David Salinas
 */
public class Cliente {
    private int id_cliente;
    private String nombre;
    private String Cif;
    private String Cif_Empresa;
/**
 * <p> El constructor con parametros </p>
 * @param id_cliente es el id del cliente
 * @param nombre nombre del cliente
 * @param Cif es el cif del cliente
 * @param Cif_Empresa es el Cif de la empresa del cliente
 */
    public Cliente(int id_cliente, String nombre, String Cif, String Cif_Empresa) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.Cif = Cif;
        this.Cif_Empresa = Cif_Empresa;
    }
    /**
     * <p> Constructor por defecto </p>
     */
    public Cliente() {

    }
    // Getters y Setters
    /**
     *  <p> metodo para obtener el id_cliente
     * @return devuleve id_cliente
     */

    public int getId_cliente() {
        return id_cliente;
    }
/**
 * <p> metodo para establecer el id_cliente </p>
 * @param id_cliente el valor para establecer
*/
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
/**
 * <p> metodo para obtener nombre cliente </p>
 * @return nombre del cliente
 */
    public String getNombre() {
        return nombre;
    }
/**
 * <p> establece el nombre del cliente </p>
 * @param nombre el valor para establecer al cliente
 */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
/**
 * <p> para obtener el Cif del cliente </p>
 * @return el cif del cliente
 */
    public String getCif() {
        return Cif;
    }
/**
 * <p> para establecer cual es el cif del cliente </p>
 * @param cif es el valor que se establecera al cliente
 */
    public void setCif(String cif) {
        Cif = cif;
    }
/**
 * <p> para obtener  el Cif_Empresa del cliente  </p>
 * @return regresa el Cif_Empresa del cliente
 */
    public String getCif_Empresa() {
        return Cif_Empresa;
    }
/** <p> establece cual es el cif de empresa del cliente </p>
 * @param cif_Empresa valor para asignar al cliente 
 */
    public void setCif_Empresa(String cif_Empresa) {
        Cif_Empresa = cif_Empresa;
    }
/**
 * <p> este metodo regresa un string con toda la información de Cliente </p>
 * @return regresa String con la informacion de cliente
 *  */   
    public String toString() {
        return "Cliente{" +
            "id_cliente=" + id_cliente +
            ", nombre='" + nombre + '\'' +
            ", Cif='" + Cif + '\'' +
            ", Cif_Empresa='" + Cif_Empresa + '\'' +
            '}';
    }
}
