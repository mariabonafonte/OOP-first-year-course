package personal;

import java.util.Objects;

public abstract class Persona {
	private String nombreApellidos;
	private String DNI;
	private int edad;
	public Persona(String nombreApellidos, String dNI, int edad)  {
		super();
		this.nombreApellidos = nombreApellidos;
		DNI = dNI;
		setEdad(edad);
	}
	public String getNombreApellidos() {
		return nombreApellidos;
	}
	public void setNombreApellidos(String nombreApellidos) {
		this.nombreApellidos = nombreApellidos;
	}
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		if(edad<18 || edad>70) {
			throw new ExcepcionesPersona("La edad no está en rango");
		}
		this.edad = edad;
	}
	@Override
	public int hashCode() {
		return Objects.hash(DNI);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(DNI, other.DNI);
	}
	
	
	
	

	

}
