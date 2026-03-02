package pacientes;

import java.time.LocalDateTime;
import personal.Medico;

public class PAmbulatorios extends Pacientes {
	private String razonVisita;
	private Medico medico;
	private LocalDateTime cita;
	
	public PAmbulatorios(String nombre, String apellidos, String dni) {
		super(nombre, apellidos, dni);
	}

    public String getRazonVisita() {
		return razonVisita;
	}
    
	public void setRazonVisita(String razonVisita) {
		this.razonVisita = razonVisita;
	}
	
	public Medico getMedico() {
		return medico;
	}

	public LocalDateTime getCita() {
		return cita;
	}

	public void setCita(LocalDateTime cita) {
		this.cita = cita;
	}


	@Override
	public String toString() {
		return "[" + nombre + ", " + apellidos + " (" + dni + ") - " + numeroTelefono + "]\nRazon visita: " + razonVisita
				+ "\nMédico asignado: " + medico.toString() + "\nFecha Visita: " + cita.toString();
	}

	@Override
	public void setMedico(Medico medico) {
		// TODO Auto-generated method stub
		this.medico = medico;
	}
}
