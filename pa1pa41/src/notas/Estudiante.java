package notas;

import java.util.Objects;

public class Estudiante {
	private String dni;
	private String nombre;
	private double nota;
	public Estudiante(String dni, String nombre) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		nota = 0;
	}
	public Estudiante(String dni, String nombre, double nota) throws EstudianteException {
		super();
		if(nota<0) {
			throw new EstudianteException("La nota no puede ser negativa");
		}
		
		this.dni = dni;
		this.nombre = nombre;
		this.nota = nota;
	}
	public String getDni() {
		return dni;
	}
	public String getNombre() {
		return nombre;
	}
	public double getNota() {
		return nota;
	}
	@Override
	public int hashCode() {
		return Objects.hash(dni.toLowerCase(), nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estudiante other = (Estudiante) obj;
		return Objects.equals(dni.toLowerCase(), other.dni.toLowerCase()) && Objects.equals(nombre, other.nombre);
	}
	@Override
	public String toString() {
		return nombre + " " + dni;
	}
	
	
	

	
}
