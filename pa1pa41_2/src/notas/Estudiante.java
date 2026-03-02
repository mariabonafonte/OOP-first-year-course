package notas;

import java.util.Objects;

public class Estudiante {
	private String dni;
	private String nombre;
	private double nota;
	
	public Estudiante(String dni, String nombre, double nota) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		setNota(nota);
	}

	public Estudiante(String dni, String nombre) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		setNota(0);
	}

	public double getNota() {
		return nota;
	}

	private void setNota(double nota) {
		if(nota<0) {
			throw new EstudianteException("Calificación negativa");
		}
		this.nota = nota;
	}

	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni.toUpperCase(), nombre);
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
		return Objects.equals(dni.toUpperCase(), other.dni.toUpperCase()) && Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return nombre +" "+ dni;
	}
	
	
	
	
	
	
	
	

}
