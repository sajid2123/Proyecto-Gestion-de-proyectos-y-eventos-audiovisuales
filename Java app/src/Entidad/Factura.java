package Entidad;


/**
 *  <p>Esta clase representa una factura de un contrato</p>
 * @author sajid
 *
 */
public class Factura {
	private int idFactura;
	private int fecha;
	private int iva;
	private double totalAPagar;
	private String nombreCliente;
	private String cifCliente;
	private int idContrato;
	
	/**
	 * <p>Es el contructor sin parametros de clase</p>
	 */
	public Factura() {
		
	}
	/**
	 * <p>Este es el constructor con parametros</p>
	 * @param idFactura es el id de factura 
	 * @param fecha la fecha fctura
	 * @param iva la iva aplicada
	 * @param totalAPagar precio total 
	 * @param nombreCliente nombre de cliente 
	 * @param cifCliente cif de cliente
	 * @param idContrato id de contrato
	 */
	public Factura(int idFactura, int fecha,  int iva, double totalAPagar,
			String nombreCliente, String cifCliente, int idContrato) {
		
		this.idFactura = idFactura;
		this.fecha = fecha;
		this.iva = iva;
		this.totalAPagar = totalAPagar;
		this.nombreCliente = nombreCliente;
		this.cifCliente = cifCliente;
		this.idContrato = idContrato;
	}
	/**
	 * <p>Este metodo es para obtener el id de factura </p>
	 * @return devuelve el id de la factura
	 */
	public int getIdFactura() {
		return idFactura;
	}
	/**
	 * <p>Este metodo es para obtener la fecha de factura</p>
	 * @return devuelve la fecha de factura
	 */
	public int getFecha() {
		return fecha;
	}
	/**
	 * <p>Este metodo es para obtener la iva aplicada en la factura</p>
	 * @return devuelve la iva aplicada
	 */
	public int getIva() {
		return iva;
	}
	/**
	 * <p>Este metodo es para obtener total de factura </p>
	 * @return devuelve importe total de la factura
	 */
	public double getTotalAPagar() {
		return totalAPagar;
	}
	/**
	 * <p>Este metodo es para obtener el nombre de cliente de factura </p>
	 * @return devuelve el nombre del cliente
	 */
	public String getNombreCliente() {
		return nombreCliente;
	}
	/**
	 * <p>Este metodo es para obtener el cif de cliente  de factura </p>
	 * @return devuelve el cif de cliente
	 */
	public String getCifCliente() {
		return cifCliente;
	}
	/**
	 * <p>Este metodo es para obtener el id de contrato para cual estamos generando la factura </p>
	 * @return devuelve el id de contrato
	 */
	public int getIdContrato() {
		return idContrato;
	}
	/**
	 * <p>Este metodo es para establecer el id de factura </p>
	 * @param idFactura el valor para establecer id de factura
	 */
	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}
	/**
	 * <p>Este metodo es para establecer el fecha de factura </p>
	 * @param fecha el valor para establecer la fecha de factura
	 */
	public void setFecha(int fecha) {
		this.fecha = fecha;
	}
	/**
	 * <p>Este metodo es para establecer el iva aplicada en la factura </p>
	 * @param iva el valor para establecer iva aplicada
	 */
	public void setIva(int iva) {
		this.iva = iva;
	}
	/**
	 * <p>Este metodo es para establecer el importe total de factura </p>
	 * @param totalAPagar el valor para establecer importe total 
	 */
	public void setTotalAPagar(double totalAPagar) {
		this.totalAPagar = totalAPagar;
	}
	/**
	 * <p>Este metodo es para establecer el nombre de factura </p>
	 * @param nombreCliente el valor para establecer nombre de cliente
	 */
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	/**
	 * <p>Este metodo es para establecer el cif de factura </p>
	 * @param cifCliente el valor para establecer el cif del cliente
	 */
	public void setCifCliente(String cifCliente) {
		this.cifCliente = cifCliente;
	}
	/**
	 * <p>Este metodo es para establecer el id de contrato para cual estamos generando la factura</p>
	 * @param idContrato el valor para establecer la id de contrao
	 */
	public void setIdContrato(int idContrato) {
		this.idContrato = idContrato;
	}
	@Override
	public String toString() {
		return "Factura [idFactura=" + idFactura + ", fecha=" + fecha + ", iva=" + iva + ", totalAPagar=" + totalAPagar
				+ ", nombreCliente=" + nombreCliente + ", cifCliente=" + cifCliente + ", idContrato=" + idContrato
				+ "]";
	}
	
}
