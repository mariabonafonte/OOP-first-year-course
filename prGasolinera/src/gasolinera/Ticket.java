package gasolinera;

import java.util.Objects;

public class Ticket implements Comparable<Ticket>{
	private int numero;
	private String nombre, matricula;
	private double litros, precio;
	private boolean facturado;
	
	public Ticket(int numero, String nombre, String matricula, double litros, double precio) {
		super();
		if(precio<=0||litros<=0||
				nombre.length()==0||nombre==null||
				matricula.length()==0||matricula==null) {
			throw new GasolineraException("No se ha podido crear el ticket");
			}
		this.numero = numero;
		this.nombre = nombre;
		this.matricula = matricula;
		this.litros = litros;
		this.facturado = false;
		this.precio = precio;
	}

	public boolean isFacturado() {
		return facturado;
	}

	public void setFacturado(boolean facturado) {
		this.facturado = facturado;
	}

	public int getNumero() {
		return numero;
	}

	public String getNombre() {
		return nombre;
	}

	public String getMatricula() {
		return matricula;
	}
	public double getLitros() {
		return litros;
	}

	public double getPrecioTotal() {
		return precio*litros;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre.toLowerCase(), numero);
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof Ticket t)
				&&nombre.equalsIgnoreCase(t.nombre)
				&&numero==t.numero;
	}

	@Override
	public int compareTo(Ticket o) {
		int resultado = this.nombre.compareToIgnoreCase(o.nombre);
		if(resultado==0) {
			resultado=Integer.compare(numero, o.numero);
		}
		return resultado;
	}

	@Override
	public String toString() {
		return "Ticket:" + numero + " (gasolinera: " + nombre + ", matricula:" + matricula + ", litros:" + litros
				+ ", PRECIO=" + getPrecioTotal() +")";
	}
	
	
	
	
	
	

	

}
