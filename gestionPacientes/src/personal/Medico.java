package personal;

public class Medico {
	String nombre;
	String apellido;
	Especialidades especialidad;
	
	public Medico(String nombre, String apellido, Especialidades especialidad) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.especialidad = especialidad;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public Especialidades getEspecialidad() {
		return especialidad;
	}
	@Override
	public String toString() {
	    return "Médico: [" + nombre + ", " + apellido + " - " + especialidad + "]";
	}

}
