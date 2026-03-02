package hospital;

import java.util.Map;
import java.util.SortedSet;

public class Hospital {
	protected Map<Paciente, Habitacion> habitaciones;
	protected SortedSet<Habitacion> libres;
	private int plantas;
	private String nombre;
	
	public Hospital(int habitacion, int plantas, String nombre) {
		super();
		this.habitaciones = new HashMap<>(habitacion);
		this.plantas = plantas;
		this.nombre = nombre;
	}
	
	

	

}
