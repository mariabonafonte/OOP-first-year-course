package rutas;

import java.util.Objects;

public class Lugar {
	private String nombre;
	private double longitud, latitud;
	
	public Lugar(String nombre, double longitud, double latitud) {
		super();
		if(longitud<-90||longitud>90||latitud<-180||latitud>180) {
			throw new RutasException("Coordenadas inválidad");
		}
		this.nombre = nombre;
		this.longitud = longitud;
		this.latitud = latitud;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getLongitud() {
		return longitud;
	}

	public double getLatitud() {
		return latitud;
	}

	@Override
	public int hashCode() {
		return Objects.hash(latitud, longitud, nombre.toLowerCase());
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof Lugar l)
				&&latitud==l.latitud
				&&longitud==l.longitud
				&&nombre.equalsIgnoreCase(l.nombre);
	}
	
	public int distancia(Lugar lugar) {
		double res = Haversine.distancia(this.latitud, this.longitud, lugar.latitud, lugar.longitud);
		return (int) res;
		
	}

	@Override
	public String toString() {
		return nombre.toUpperCase() + ": " + longitud + "," + latitud;
	}
	
	
	
	
	
	

	

}
