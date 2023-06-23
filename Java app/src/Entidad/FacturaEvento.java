package Entidad;


/**
 * <p>Esta clase representa una factura de un evento</p>
 * @author gabriel
 *
 */

public class FacturaEvento {
	private int idFactura;
	private String cifEmpresa;
	private int fecha;
	private int idventa;
	private int iva;
	private double totalAPagar;
	private String nombreCliente;
	private String cifCliente;
	private int idevento;
	
	/**
	 * <p>Crea una instancia de FacturaEvento.</p>
	 */
	public FacturaEvento() {
		
	}

	/**
	 * <p>Crea una instancia de FacturaEvento con los valores especificados.</p>
	 * 
	 * @param idFactura      El ID de la factura.
	 * @param cifEmpresa     El CIF de la empresa.
	 * @param fecha          La fecha de la factura.
	 * @param idventa        El ID de la venta.
	 * @param iva            El IVA de la factura.
	 * @param totalAPagar    El total a pagar de la factura.
	 * @param nombreCliente  El nombre del cliente.
	 * @param cifCliente     El CIF del cliente.
	 * @param idevento       El ID del evento.
	 */
	public FacturaEvento(int idFactura, String cifEmpresa, int fecha, int idventa, int iva, double totalAPagar, String nombreCliente, String cifCliente, int idevento) {
        this.idFactura = idFactura;
        this.cifEmpresa = cifEmpresa;
        this.fecha = fecha;
        this.idventa = idventa;
        this.iva = iva;
        this.totalAPagar = totalAPagar;
        this.nombreCliente = nombreCliente;
        this.cifCliente = cifCliente;
        this.idevento = idevento;
	}

	/**
	 * <p>Obtiene el ID de la factura.</p>
	 * 
	 * @return El ID de la factura.
	 */
	public int getIdFactura() {
		return idFactura;
	}

	/**
	 * <p>Obtiene el CIF de la empresa.</p>
	 * 
	 * @return El CIF de la empresa.
	 */
	public String getCifEmpresa() {
		return cifEmpresa;
	}

	/**
	 * <p>Obtiene la fecha de la factura.</p>
	 * 
	 * @return La fecha de la factura.
	 */
	public int getFecha() {
		return fecha;
	}

	/**
	 * <p>Obtiene el ID de la venta.</p>
	 * 
	 * @return El ID de la venta.
	 */
	public int getIdVenta() {
		return idventa;
	}

	/**
	 * <p>Obtiene el IVA de la factura.</p>
	 * 
	 * @return El IVA de la factura.
	 */
	public int getIVA() {
		return iva;
	}

	/**
	 * <p>Obtiene el total a pagar de la factura.</p>
	 * 
	 * @return El total a pagar de la factura.
	 */
	public double getTotalAPagar() {
		return totalAPagar;
	}

	/**
	 * <p>Obtiene el nombre del cliente.</p>
	 * 
	 * @return El nombre del cliente.
	 */
	public String getNombreCliente() {
		return nombreCliente;
	}

	/**
	 * <p>Obtiene el CIF del cliente.</p>
	 * 
	 * @return El CIF del cliente.
	 */
	public String getCifCliente() {
		return cifCliente;
	}

	/**
	 * <p>Obtiene el ID del evento.</p>
	 * 
	 * @return El ID del evento.
	 */
	public int getIdEvento() {
		return idevento;
	}

	/**
	 * <p>Establece el ID de la factura.</p>
	 * 
	 * @param idFactura El ID de la factura.
	 */
	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	/**
	 * <p>Establece el CIF de la empresa.</p>
	 * 
	 * @param cifEmpresa El CIF de la empresa.
	 */
	public void setCifEmpresa(String cifEmpresa) {
		this.cifEmpresa = cifEmpresa;
	}

	/**
	 * <p>Establece la fecha de la factura.</p>
	 * 
	 * @param fecha La fecha de la factura.
	 */
	public void setFecha(int fecha) {
		this.fecha = fecha;
	}

	/**
	 * <p>Establece el ID de la venta.</p>
	 * 
	 * @param idventa El ID de la venta.
	 */
	public void setIdVenta(int idventa) {
		this.idventa = idventa;
	}

	/**
	 * <p>Establece el IVA de la factura.</p>
	 * 
	 * @param iva El IVA de la factura.
	 */
	public void setIVA(int iva) {
		this.iva = iva;
	}

	/**
	 * <p>Establece el total a pagar de la factura.</p>
	 * 
	 * @param totalAPagar El total a pagar de la factura.
	 */
	public void setTotalAPagar(double totalAPagar) {
		this.totalAPagar = totalAPagar;
	}

	/**
	 * <p>Establece el nombre del cliente.</p>
	 * 
	 * @param nombreCliente El nombre del cliente.
	 */
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	/**
	 * <p>Establece el CIF del cliente.</p>
	 * 
	 * @param cifCliente El CIF del cliente.
	 */
	public void setCifCliente(String cifCliente) {
		this.cifCliente = cifCliente;
	}

	/**
	 * <p>Establece el ID del evento.</p>
	 * 
	 * @param idevento El ID del evento.
	 */
	public void setIdEvento(int idevento) {
		this.idevento = idevento;
	}
}
