package pacientes;

import personal.Medico;

public abstract class Pacientes {
	String nombre;
	String apellidos;
	String dni;
	String direccion;
	int numeroTelefono;
	
	public Pacientes(String nombre, String apellidos, String dni) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(int numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getDni() {
		return dni;
	}
	 @Override
	    public abstract String toString();
	 
	 public abstract void setMedico(Medico medico);
	
	
	

}
