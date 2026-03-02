package rehab;

import java.util.ArrayList;
import java.util.List;

public class Sesion {
	List<Tratamiento> tratamientos;

	public Sesion() {
		tratamientos = new ArrayList<>();
	}

	public Sesion(List<Tratamiento> tratamientos) {
		this.tratamientos = tratamientos;
	}
	
	public void addTratamiento (Tratamiento t) {
		if(t == null) {
			throw new NullPointerException("Error al añadir un tratamiento nulo"); //Aunque no lo piden en el enunciado, así es más robusto a malos usos. También se podría poner en el constructor.
		}
		tratamientos.add(t);
	}
	
	@Override
	public String toString() {
		return  tratamientos.toString();
	}

}
