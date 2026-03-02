package tenis;

import java.util.List;

public class Deportista extends Integrante {
	List<Patrocinio> patrocinios;

	public Deportista(String nombre, int edad, double sueldo, double cuenta, List<Patrocinio> patrocinios) {
		super(nombre, edad, sueldo, cuenta);
		this.patrocinios = patrocinios;
		this.setTipo(TipoParticipante.jugador);
	}
	
	@Override
	public void cobrar() {
		double ingresosPatrocinios=0.0;
		for (Patrocinio elem: patrocinios) {
			ingresosPatrocinios+=elem.getCantidadMensual();
		}
		cuenta+=sueldo+ingresosPatrocinios;
	}
	
	@Override
	public String toString() {
		return super.toString()+" "+patrocinios.toString();
	}

	
}
