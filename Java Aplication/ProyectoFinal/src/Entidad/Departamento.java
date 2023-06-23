package Entidad;


/**
 * <p> Clase Departamentos almacenamos los atributos y tenemos getters y setters asi como toString que muestra atributos </p>
 * @author David Salinas
 */
public class Departamento {
    private int id_dept;
    private String nombreDepartamento;
/**
 * <p> Constructor de Departamento con parametros </p>
 * @param id_dept es el ide del departamento
 * @param nombreDepartamento nombre de departamento
 */
    public Departamento(int id_dept, String nombreDepartamento) {
        this.id_dept = id_dept;
        this.nombreDepartamento = nombreDepartamento;
    }
    /** 
    * <p> Constructor predeterminado </p>
     */
    public Departamento() {

    }
    // Getters y Setters
    /**
     * <p> Para obtener cual es el ide del departamento </p>
     * @return regresa el id del departamento
     */
    public int getId_dept() {
        return id_dept;
    }
/**
 * <p> Establece el id del departamento </p>
 * @param id_dept es el valor que damos para asignarlo al departamento
 */
    public void setId_dept(int id_dept) {
        this.id_dept = id_dept;
    }
/**
 * <p> Nos devuelve el nombre del departamento </p>
 * @return regresa cual es el nombre del departamento
 */
    public String getNombreDepartamento() {
        return nombreDepartamento;
    }
/**
 * <p> Establecemos para asignar el nombre del departamento </p>
 * @param nombreDepartamento pasamos un String con el nombre de departamento a establecer
 */
    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }
 /**
  * <p> Devuleve un String con toda la informacion de Departamento </p>
  * @return nos regresa el String con informacion de Departamento
  */
    @Override
    public String toString() {
        return "Departamento{" +
            "id_dept=" + id_dept +
            ", nombreDepartamento='" + nombreDepartamento + '\'' +
            '}';
    }
}
