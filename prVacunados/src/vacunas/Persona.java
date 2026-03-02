package vacunas;

public class Persona {
	private String nombre;
	private int edad;
	private boolean inmunizado;
	
	public Persona (String nombre, int edad) {
		if( edad<0) {
			throw new RuntimeException ("La edad no puede ser negativa");
		}
		this.nombre = nombre;
		this.edad = edad;
		this.inmunizado = false;
	}
	protected String getNombre() {
		return nombre;
	}
	protected int getEdad() {
		return edad;
	}
	protected boolean inmunizado() {
		return inmunizado;
	}
	
	public void vacunar() {
		inmunizado = true;
	}
	@Override
	public String toString() {
		
		if(inmunizado) {
			return "(" + nombre + ", " + edad + ", INMUNIZADO)";
		}
		return "(" + nombre + ", " + edad + ", NO INMUNIZADO)";
	}
}
