package fidelizacion;


public class Transaccion {
	private final double cantidad;
	private final int puntos;
	private final Fecha fecha;
	private final int numCliente;
	
	public Transaccion(double cantidad, int puntos, Fecha fecha, int numCliente) {
		super();
		if(cantidad<0) {
			throw new FidelizacionException("La cantidad no puede ser negativa");
		}
		if(puntos<0) {
			throw new FidelizacionException("Los puntos no pueden ser negativos");
		}
		this.cantidad = cantidad;
		this.puntos = puntos;
		this.fecha = fecha;
		this.numCliente = numCliente;
	}
	public double getCantidad() {
		return cantidad;
	}
	public int getPuntos() {
		return puntos;
	}
	public Fecha getFecha() {
		return fecha;
	}
	public int getNumCliente() {
		return numCliente;
	}
	@Override
	public String toString() {
		return numCliente + ":" + fecha + ":" + cantidad + ":" + puntos;
	}
	

	
}
