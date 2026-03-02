package paciente;

import java.time.LocalDateTime;

public class CitaMedica {

    private final int pacienteId;
    private final Especialidad especialidad;
    private LocalDateTime fechaHora;
    private String doctor;
	public CitaMedica(int pacienteId, LocalDateTime fechaHora, Especialidad especialidad, String doctor) {
		super();
		this.pacienteId = pacienteId;
		this.fechaHora = fechaHora;
		this.especialidad = especialidad;
		this.doctor = doctor;
	}
	public LocalDateTime getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}
	public String getDoctor() {
		return doctor;
	}
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
	public int getPacienteId() {
		return pacienteId;
	}
	public Especialidad getEspecialidad() {
		return especialidad;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CitaMedica [pacienteId=");
		builder.append(pacienteId);
		builder.append(", especialidad=");
		builder.append(especialidad);
		builder.append(", fechaHora=");
		builder.append(fechaHora);
		builder.append(", doctor=");
		builder.append(doctor);
		builder.append("]");
		return builder.toString();
	}
	
    
	
	
    
}
