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
/*
 * Salida esperada:

Clara Ruiz: edad=51
AnalisisSangre: 5/10/2022 – tipo=ENDOCRINOLOGIA - numFueraRango=0
AnalisisSangre: 15/10/2023 – tipo=BIOQUIMICA - numFueraRango=1
AnalisisSangre: 30/6/2024 – tipo=BIOQUIMICA - numFueraRango=1
AnalisisSangre: 10/3/2025 – tipo=HEMATOLOGIA - numFueraRango=0
Electrocardiograma: 5/11/2022 – ritmoCardiaco=90 - anormalidades=true
Electrocardiograma: 4/2/2023 – ritmoCardiaco=140 - anormalidades=true
Electrocardiograma: 11/3/2025 – ritmoCardiaco=75 - anormalidades=false
Juan Sanchez: edad=30
AnalisisSangre: 10/5/2023 – tipo=BIOQUIMICA - numFueraRango=0
AnalisisSangre: 30/5/2024 – tipo=BIOQUIMICA - numFueraRango=2
AnalisisSangre: 21/4/2025 – tipo=HEMATOLOGIA - numFueraRango=0
Electrocardiograma: 3/6/2023 – ritmoCardiaco=101 - anormalidades=false
Electrocardiograma: 1/6/2024 – ritmoCardiaco=61 - anormalidades=false
Electrocardiograma: 21/4/2025 – ritmoCardiaco=75 - anormalidades=false
** Historial Juan Sánchez
* AÑO 2022
No se han encontrado datos
* AÑO 2023
RESULTADOS DEL ESTUDIO SIMPLE: El paciente está sano
RESULTADOS DEL ESTUDIO COMPLETO: El paciente debería continuar con el estudio de su salud
* AÑO 2024
RESULTADOS DEL ESTUDIO SIMPLE: El paciente debería continuar con el estudio de su salud
RESULTADOS DEL ESTUDIO COMPLETO: El paciente debería continuar con el estudio de su salud

*/
