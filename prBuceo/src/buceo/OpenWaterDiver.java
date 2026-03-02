package buceo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OpenWaterDiver {
	protected String id;
	protected String nombre;
	protected int anioCertificacion;
	protected List<Inmersion> inmersiones;
	
	public OpenWaterDiver(String id, String nombre, int year) {
		this.id = id;
		this.nombre = nombre;
		this.anioCertificacion = year;
		this.inmersiones = new ArrayList<Inmersion>();
		
	}

	public OpenWaterDiver(String id, String nombre) {
		this.id = id;
		this.nombre = nombre;
		this.anioCertificacion = 2023;
		this.inmersiones = new ArrayList<Inmersion>();
	}

	public String getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public int getAnioCertificacion() {
		return anioCertificacion;
	}

	public List<Inmersion> getInmersiones() {
		return inmersiones;
	}
	
	public void aniadirInmersion(String loc,int duracion, Date f) {
		for(Inmersion inmersion: inmersiones) {
			if(inmersion.getUbicacion().equals(loc) && inmersion.getFecha().equals(f)) {
				throw new RuntimeException("Ya hay una inmersion en esta localizacion y fecha");
			}
		Inmersion nuevaInmersion = new Inmersion(loc, duracion, f);
		inmersiones.add(nuevaInmersion);
		}
	}
	public void aniadirInmersion(Inmersion dive) {
		for(Inmersion inmersion: inmersiones) {
			if(inmersion.getUbicacion().equals(dive.getUbicacion()) && inmersion.getFecha().equals(dive.getFecha())) {
				throw new RuntimeException("Ya hay una inmersion en esta localizacion y fecha");
			}
		inmersiones.add(dive);
		}
	}
	
	private Inmersion buscarInmersion (String loc, Date dt) {
		for(Inmersion inmersion: inmersiones) {
			if(inmersion.getUbicacion().equals(loc) && inmersion.getFecha().equals(dt)) {
				return inmersion;
			}
		}
		return null;
	}
	
	public List<Inmersion> buscarInmersiones(int anio){
		List<Inmersion> lista_inmersiones = new ArrayList<>();
		for(Inmersion inmersion: inmersiones) {
			if(inmersion.getFecha().getAnio() == anio) {
				lista_inmersiones.add(inmersion);
			}
		}
		return lista_inmersiones;
	}
	
	public int getMaxProf() {
		int maxProf = 18;
		return maxProf;
	}

	@Override
	public String toString() {
		return id + "," + nombre + "," + anioCertificacion + ","+ getMaxProf()+"," +inmersiones;
	}
	
	
	
	
		
		
		
}
