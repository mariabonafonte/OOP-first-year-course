package rehab;

import java.util.ArrayList;
import java.util.List;

public class TratamientoLocalizado extends Tratamiento {
	List<Zona> zonas;

	public TratamientoLocalizado(int frecuencia, int ganancia, double duracion, int subida, int bajada, int espera) {
		super(frecuencia, ganancia, duracion, subida, bajada, espera);
		this.zonas = new ArrayList<>();
	}
	
	public TratamientoLocalizado(int frecuencia, int ganancia, double duracion, int subida, int bajada, int espera,List<Zona> zonas) {
		super(frecuencia, ganancia, duracion, subida, bajada, espera);
		this.zonas = zonas;
	}

	public List<Zona> getZonas() {
		return zonas;
	}
	
	public boolean addZona(Zona zona) {
		for(Zona z: zonas) {
			if(z.equals(zona)) {
				return false;
			}
		}
		zonas.add(zona);
		return true;
	}
	
	public boolean remZona(Zona zona) {
		for(Zona z: zonas) {
			if(z.equals(zona)) {
				zonas.remove(zona);
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		return "(f:" + super.getFrecuencia() + "g:" + super.getGanancia() + "d:" + super.getDuracion()
				+ "s:" + super.getSubida() + "b:" + super.getBajada() + "e:" + super.getEspera() + ")"
				+ "-Zonas:" + zonas;
	}
	
	
	
	
	
}
