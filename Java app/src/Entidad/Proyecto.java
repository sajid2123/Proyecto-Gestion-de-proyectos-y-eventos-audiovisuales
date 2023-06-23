package Entidad;

import java.util.*;


/**
 * <p>Esta clase representa un proeycto</p>
 * @author David Salinas
 *
 */
public class Proyecto {
    private int id_proyecto, fechaInicio, fechaFin, id_cliente;
    private float coste;
    private String localizacion, Cif_Empresa;
    
    /**
     * <p> Constructor con parametros </p>
     * @param id_proyecto es el id que identifica el proyecto
     * @param fechaInicio la fecha en la que se inicio el proyecto
     * @param fechaFin  la fecha en la que se acabara el proyecto
     * @param coste el coste que del proyecto
     * @param localizacion donde se encuentra el proyecto
     * @param Cif_Empresa  el cif de la empresa de la que se hace el proyecto
     * @param id_cliente el id del cliente que se va a hacer el proyecto
     */
    public  Proyecto (int id_proyecto,int fechaInicio,int fechaFin,Float coste, String localizacion,String Cif_Empresa ,int id_cliente)
    {
        this.id_proyecto=id_proyecto;
        this.fechaInicio=fechaInicio;
        this.fechaFin=fechaFin;
        this.coste=coste;
        this.localizacion=localizacion;
        this.Cif_Empresa = Cif_Empresa;
        this.id_cliente=id_cliente;

    }
    /**
     * <p> Constructor por defecto </p>
     */
    public Proyecto()
    {
        
    }
    // Getters y Setters
    /**
     * <p> Nos devuelve el id que tiene el proyecto
     * @return nos regresa el id del proyecto
     */
    public int getId_proyecto() {
        return id_proyecto;
    }
    /**
     * <p> Este metodo asigna el id que tendra el proyecto </p>
     * @param id_proyecto valor que se asignara al proyecto
     */
    public void setId_proyecto(int id_proyecto) {
        this.id_proyecto = id_proyecto;
    }
    /**
     * <p> Metodo que devuelve cual es la fecha de inicio del proyecto </p>
     * @return devuelve la fecha de inicio que tiene el proyecto
     */
    public int getFechaInicio() {
        return fechaInicio;
    }
    /**
     * <p> Metodo para establecer la fecha de inicio </p>
     * @param fechaInicio valor que se asignara como la fecha de inicio del proyecto
     */
    public void setFechaInicio(int fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    /**
     *  <p> Metodo que devuelve la fecha de finalizacion del proyecto </p>
     * @return devuelve la fecha de finalizacion del proyecto
     */
    public int getfechaFin() {
        return fechaFin;
    }
    /**
     * <p> Metodo para asignar la fecha de fin del proyecto </p>
     * @param fechaFin valor que se establece para la fecha de fin de proyecto
     */
    public void setFechaFin(int fechaFin) {
        this.fechaFin = fechaFin;
    }
    /**
     * <p> Metodo para obtener el id del cliente que tiene el proyecto
     * @return regresa id del cliente del cual se hace el proyecto
     */
    public int getId_cliente() {
        return id_cliente;
    }
    /**
     * <p> Metodo para asigna id del cliente para el proyecto </p>
     * @param id_cliente valor que se establece com id del cliente en el proyecto
     */
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
    /**
     * <p> Metodo que no regresa el coste de el proyecto </p>
     * @return devuelve el coste del proyecto
     */
    public float getCoste() {
        return coste;
    }
    /**
     * <p> El metodo define cual es el coste que tiene el proyecto </p>
     * @param coste es e valor que le vamos a determinar al proyecto
     */
    public void setCoste(float coste) {
        this.coste = coste;
    }
    /**
     * <p> Metodo que nos regresa la localizacion del proyecto </p>
     * @return devueleve la localizacion del proyecto
     */
    public String getlocalizacion() {
        return localizacion;
    }
    /**
     * <p> Metodo para asignar la localizacion que tiene el proyecto </p>
     * @param localizacion se asigna este valor para el proyecto
     */
    public void setlocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }
    /**
     * <p> Metodo establece el cif de empresa del proyecto </p>
     * @param CifEmpresa valor que se asigna al proyecto
     */
    public void setCif_Empresa(String CifEmpresa)
    {
        this.Cif_Empresa=CifEmpresa;
    }
    /**
     * <p>Metodo para obtener el cif de la empresa del proyecto </p>
     * @return devuelve el cif de la empresa 
     */
    public  String getCif_Empresa()
    {
       return this.Cif_Empresa;
    }
    
/**
 * <p> metodo toString devuelve una cadena con la información de proyecto </p>
 * @return regresa la informacion del proyecto
 */
    @Override
    public String toString() {
        return "Proyecto{" +
                "id_proyecto=" + id_proyecto +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", id_cliente=" + id_cliente +
                ", coste=" + coste +
                ", localizacion='" + localizacion + '\'' +
                ", Cif_Empresa='" + Cif_Empresa + '\'' +
                '}';
    }
    
        

}
    

