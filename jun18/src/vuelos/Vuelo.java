package vuelos;

import java.util.Objects;

public class Vuelo implements Comparable<Vuelo>{
	private String aerolinea,codigo, apOrigen, apDestino;
	private Hora horaSalida;
	private int duracion;
	
	public Vuelo(String aerolinea, String codigo, 
			Hora horaSalida, int duracion, String apOrigen, String apDestino) {
		
		if(duracion<0) {
			throw new VuelosException("La duracion no puede ser negativa");
		}
		this.aerolinea = aerolinea;
		this.codigo = codigo;
		this.apOrigen = apOrigen;
		this.apDestino = apDestino;
		this.horaSalida = horaSalida;
		this.duracion = duracion;
	}

	public String getAerolinea() {
		return aerolinea;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getApOrigen() {
		return apOrigen;
	}

	public String getApDestino() {
		return apDestino;
	}

	public Hora getHoraSalida() {
		return horaSalida;
	}

	public int getDuracion() {
		return duracion;
	}
	
	public Hora getHoraLlegada() {
		Hora h =horaSalida.horaTrasMinutos(duracion);
		return h;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apDestino.toLowerCase(), 
				apOrigen.toLowerCase(), codigo.toLowerCase());
	}

	@Override
	public boolean equals(Object o) {
		return (o instanceof Vuelo v)
				&&v.apDestino.equalsIgnoreCase(apDestino)
				&&v.apOrigen.equalsIgnoreCase(apOrigen)
				&& v.codigo.equalsIgnoreCase(codigo);
	}
	
	public int compareTo(Vuelo v) {
		int resultado = apOrigen.compareToIgnoreCase(v.apOrigen);
		if (resultado == 0) {
			resultado = apDestino.compareToIgnoreCase(v.apDestino);
			if (resultado == 0) {
				resultado = codigo.compareToIgnoreCase(v.codigo);
			}
		}
		return resultado;
		}

	@Override
	public String toString() {
		return codigo + " : " + apOrigen +" -> "+apDestino+" ("+ horaSalida.toString() +", "+duracion +"min.)";
	}
	
	
	
	
	
	
	
	
	

}
