package vuelos;

import java.util.Objects;

public class Vuelo implements Comparable<Vuelo>{
	private String aerolinea;
	private String codigo;
	private Hora salida;
	private int duracion;
	private String aOrigen;
	private String aDestino;
	
	
	public Vuelo(String aerolinea, String codigo, Hora salida, int duracion, String aOrigen, String aDestino) {
		super();
		if(duracion<0) {
			throw new VuelosException("Duracion negativa");
		}
		this.aerolinea = aerolinea;
		this.codigo = codigo;
		this.salida = salida;
		this.duracion = duracion;
		this.aOrigen = aOrigen;
		this.aDestino = aDestino;
	}


	public String getAerolinea() {
		return aerolinea;
	}


	public String getCodigo() {
		return codigo;
	}


	public Hora getSalida() {
		return salida;
	}


	public int getDuracion() {
		return duracion;
	}


	public String getaOrigen() {
		return aOrigen;
	}


	public String getaDestino() {
		return aDestino;
	}
	
	public Hora getLlegada() {
		return salida.horaTrasMinutos(duracion);
	}


	@Override
	public int hashCode() {
		return Objects.hash(aDestino.toLowerCase(), aOrigen.toLowerCase(), codigo.toLowerCase());
	}


	@Override
	public boolean equals(Object obj) {
		return (obj instanceof Vuelo v)
				&&aDestino.equalsIgnoreCase(v.aDestino)
				&&aOrigen.equalsIgnoreCase(v.aDestino)
				&&codigo.equalsIgnoreCase(v.codigo);
	}


	@Override
	public String toString() {
		return codigo + ": " + aOrigen + " -> " + aDestino + " (" + salida.toString()
				+ ", " + duracion + "min.)";
	}


	@Override
	public int compareTo(Vuelo o) {
		int resultado = aOrigen.compareToIgnoreCase(o.aOrigen);
		if(resultado==0) {
			resultado = aDestino.compareToIgnoreCase(o.aDestino);
			if(resultado==0) {
				resultado = codigo.compareToIgnoreCase(o.codigo);
			}
		}
		return resultado;
	}
	
	
	
	
	
	

	

	

}
