package vacunas;

public class SistemaVacunacion {
	private static final int CAP_INICIAL = 5;
	private Persona [] personas;
	private int numPersonas;
	private int vacunas;
	
	public SistemaVacunacion() {
		numPersonas = 0;
		personas = new Persona[CAP_INICIAL];
		vacunas = 0;
	}
	
	private int buscarPersona(String nombre, int edad) {
		int pos = numPersonas -1;
		while (pos >= 0 && !(nombre.equalsIgnoreCase(personas[pos].getNombre()) &&
							 edad == personas[pos].getEdad())
			   ) {
			pos--;
		}
		return pos;
	}
	
	
	
	
}
