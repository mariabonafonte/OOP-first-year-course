import reconocimientos.AnalisisSangre;
import reconocimientos.Electrocardiograma;
import reconocimientos.EstudioCompleto;
import reconocimientos.EstudioSimple;
import reconocimientos.Paciente;
import reconocimientos.PruebaMedica;
import reconocimientos.PruebaMedicaException;
import reconocimientos.TipoAnalisis;

public class Main {

	public static void main(String[] args) {
		
		Paciente pacC = new Paciente("Clara Ruiz", 51);
		pacC.leerHistorialFichero("pacienteClara.txt");
		System.out.println(pacC);
	
		Paciente pacJ = new Paciente("Juan Sanchez", 30);
		pacJ.leerHistorialFichero("pacienteJuan.txt");
		System.out.println(pacJ);
		
		
		System.out.println("** Historial Juan Sánchez");
		for (int year=2022; year<2025; year++) {
			System.out.println("* AÑO "+year);
			try {
				boolean ds = pacJ.calcularDiagnostico(new EstudioSimple(), year);
				System.out.print("RESULTADOS DEL ESTUDIO SIMPLE: ");
				if (ds) {
					System.out.println("El paciente está sano");
				} else {
					System.out.println("El paciente debería continuar con el estudio de su salud");
				}
				
				boolean dc = pacJ.calcularDiagnostico(new EstudioCompleto(60, 100), year);
				System.out.print("RESULTADOS DEL ESTUDIO COMPLETO: ");
				if (dc) {
					System.out.println("El paciente está sano");
				} else {
					System.out.println("El paciente debería continuar con el estudio de su salud");
				}
			} catch (PruebaMedicaException e) {
				System.out.println("No se han encontrado datos");
			}
		}
		
		
		
		
		
		
	}

}
