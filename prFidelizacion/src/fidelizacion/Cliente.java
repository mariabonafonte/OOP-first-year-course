package fidelizacion;

import java.util.Objects;

public class Cliente {
	private int puntos;
	private double cantidad;
	private final int numero;

	public Cliente(int n) {
		this.numero = n;
		this.puntos = 0;
		this.cantidad = 0;
	}

	public int getPuntos() {
		return puntos;
	}

	public double getCantidad() {
		return cantidad;
	}

	public int getNumero() {
		return numero;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numero);
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof Cliente c)
				&&c.numero == numero;
	}
	
	public void actualiza (Transaccion tr) {
		if(tr.getNumCliente() != this.numero) {
			throw new FidelizacionException("La transaccion no corresponde a este cliente");
		}
		this.puntos += tr.getPuntos();
		this.cantidad += tr.getCantidad();
		
	}

	@Override
	public String toString() {
		return "Cliente [puntos=" + puntos + ", cantidad=" + cantidad + ", numero=" + numero + "]";
	}
	
	
	
	

}
