import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import pacientes.PAmbulatorios;
import pacientes.PHospitalizados;
import personal.Especialidades;
import personal.Medico;

public class Principal {
	
	public static void main(String[] args) {
		GestionHospital hospital = new GestionHospital();
		Medico trauma = new Medico("Iskandar", "Tamimi", Especialidades.Traumatologia); 
		Medico rehab = new Medico("Marina", "Tirado", Especialidades.Rehabilitacion); 
		Medico neuro = new Medico("José", "Paz", Especialidades.Neurologia); 
		  
		hospital.addMedico(trauma);
		hospital.addMedico(rehab); 
		hospital.addMedico(neuro);
		  
		System.out.println(hospital.listarMedicos());
		  
		PAmbulatorios pacienteJoaquin = new PAmbulatorios("Joaquin", "Ballesteros","30874859J"); 
		pacienteJoaquin.setCita(LocalDateTime.of(2024, 1,24, 9, 30)); 
		pacienteJoaquin.setRazonVisita("Dolor articular");
		
		PAmbulatorios pacienteAna = new PAmbulatorios("Ana", "Vico", "309689574Z");
		pacienteAna.setCita(LocalDateTime.of(2024, 1, 24, 10, 30));
		pacienteAna.setRazonVisita("Lesión codo");
		pacienteAna.setMedico(trauma);
		pacienteAna.setNumeroTelefono(645787543);
		
		PHospitalizados pacienteCarlos = new PHospitalizados("Carlos", "Quintero","4099384X",LocalDateTime.of(2024, 1, 24, 11, 00));
		pacienteCarlos.setDiagnosticoPrincipal("Fractura cadera izquierda");
		pacienteCarlos.setNumeroTelefono(619750945);
		pacienteCarlos.setDireccion("Calle Frigiliana 4");
		pacienteCarlos.setHabitacion("503");
		  
		hospital.addPaciente(pacienteJoaquin);
		hospital.addPaciente(pacienteCarlos);
		hospital.addPaciente(pacienteAna);
		hospital.asignarMedico(rehab, pacienteJoaquin);
		hospital.asignarMedico(trauma, pacienteCarlos);
		
		System.out.println("Lista completa ");
		System.out.println(hospital.listarPacientes());

		
		hospital.crearHabitacion("301");
		try{
			hospital.eliminarHabitacion("302");
		}
		catch(RuntimeException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("termino");
	}

}
