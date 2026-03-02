package pacientes;

import java.time.LocalDateTime;

import personal.Medico;

public class PHospitalizados extends Pacientes{
	private LocalDateTime fechaIngreso;
	private String habitacion;
	private String diagnosticoPrincipal;
	private Medico medicoGuardia;
	
	public PHospitalizados(String nombre, String apellidos, String dni, LocalDateTime fechaIngreso) {
		super(nombre, apellidos, dni);
		this.fechaIngreso = fechaIngreso;
	}

	public LocalDateTime getFechaIngreso() {
		return fechaIngreso;
	}
	public String getHabitacion() {
		return habitacion;
	}
	public void setHabitacion(String habitacion) {
		this.habitacion = habitacion;
	}
	public String getDiagnosticoPrincipal() {
		return diagnosticoPrincipal;
	}
	public void setDiagnosticoPrincipal(String diagnosticoPrincipal) {
		this.diagnosticoPrincipal = diagnosticoPrincipal;
	}
	public Medico getMedicoGuardia() {
		return medicoGuardia;
	}

	@Override
	public String toString() {
		return "[" + nombre + ", " + apellidos + " (" + dni + ") - " + numeroTelefono + "]\nDiagnóstico principal: "
				+ diagnosticoPrincipal + "\nMédico de guardia: " + medicoGuardia.toString() + "\nFecha ingreso: "
				+ fechaIngreso.toString();
	}

	@Override
	public void setMedico(Medico medico) {
		// TODO Auto-generated method stub
		this.medicoGuardia = medico;
	}


}
