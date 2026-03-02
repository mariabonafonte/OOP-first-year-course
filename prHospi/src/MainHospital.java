
import java.io.FileNotFoundException;
import java.util.Arrays;

import hospital.HospitalException;
import hospital.MismaPlanta;
import hospital.NacidoAntesDe;
import hospital.Paciente;
import hospital.Hospital;

public class MainHospital {

	public static void main(String[] args) {
		try {
			Hospital m = new Hospital("Hospital de Malaga", 5, 10);
			m.leePacientes("pacientes.txt");
			m.escribePacientes("output.txt");
			System.out.println("Estado del hospital");
			System.out.println(m.toString());
			
			System.out.println("Pacientes nacidos antes de 1800");
			Paciente[] antiguos = m.seleccion(new NacidoAntesDe(1800));
			System.out.println(Arrays.toString(antiguos));
			
			System.out.println("Pacientes planta 2");
			Paciente[] pacientesPlanta2 = m.seleccion(new MismaPlanta(2));
			System.out.println(Arrays.toString(pacientesPlanta2));
			
		} catch (HospitalException e) {
			e.printStackTrace();
		}
	}

}
