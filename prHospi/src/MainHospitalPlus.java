
import java.io.FileNotFoundException;

import hospital.HospitalException;
import hospital.HospitalPlus;

public class MainHospitalPlus {

	public static void main(String[] args) {
		try {
			HospitalPlus m = new HospitalPlus("Hospital Regional Universitario de Malaga", 50, 20);
			m.leePacientes("pacientes.txt");
			System.out.println(m.pacientesPorAno());
			System.out.println(m.numeroDePacientesPorAno());
		} catch (HospitalException e) {
			e.printStackTrace();
		}
	}

}

