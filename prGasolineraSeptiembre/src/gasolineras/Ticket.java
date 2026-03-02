package gasolineras;

import java.util.Objects;

public class Ticket implements Comparable<Ticket>{
	private int numTicket;
	private String gasolinera;
	private String matricula;
	private double litros, precioLitro;
	private boolean facturado;
	
	public Ticket(int numTicket, String gasolinera, String matricula, double litros, double precioLitro) {
		super();
		if(precioLitro<=0||litros<=0
				||matricula==null||gasolinera==null
				||matricula.isEmpty()||gasolinera.isEmpty()) {
			throw new GasolineraException("No se puede crear el ticket");	
		}
		this.numTicket = numTicket;
		this.gasolinera = gasolinera;
		this.matricula = matricula;
		this.litros = litros;
		this.precioLitro = precioLitro;
		this.facturado = false;
	}

	public boolean isFacturado() {
		return facturado;
	}

	public void setFacturado(boolean facturado) {
		this.facturado = facturado;
	}

	public int getNumTicket() {
		return numTicket;
	}

	public String getGasolinera() {
		return gasolinera;
	}

	public String getMatricula() {
		return matricula;
	}
	
	public double precioTotal() {
		return precioLitro*litros;
	}

	@Override
	public int hashCode() {
		return Objects.hash(gasolinera.toLowerCase(), numTicket);
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof Ticket t)
				&&gasolinera.equalsIgnoreCase(t.gasolinera)
				&&numTicket==t.numTicket;
	}

	@Override
	public int compareTo(Ticket o) {
		int resultado = gasolinera.compareToIgnoreCase(o.gasolinera);
		if(resultado==0) {
			resultado = Integer.compare(numTicket, o.numTicket);
		}
		return resultado;
	}

	@Override
	public String toString() {
		return "Ticket:" + numTicket + " (gasolinera:" + gasolinera + ", matricula:" + matricula
				+ ", litros:" + litros + ", PRECIO=" + precioTotal() + ")";
	}
	
	
	
	
	
	
	
	

	
}
