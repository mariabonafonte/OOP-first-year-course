import vacunas.Persona;
import vacunas.SistemaVacunacion;
import vacunas.SistemaVacunacionDosis;

public class PruebaVacunacion {
	public static void main(String []args) {
		Persona [] personas = {	new Persona("Alberto G�mez",64),
								new Persona("Mar�a Abad", 50),
								new Persona("Sara Campos", 80),
								new Persona("Jorge T�llez",25),
								new Persona("Rafael S�nchez",75),
								new Persona("Alicia Gutierrez", 82)};
		
		SistemaVacunacion s = new SistemaVacunacion();
		addPersonas(s,personas);
		s.addPersona("ALICIA Gutierrez", 40);
		System.out.println(s);
		s.vacunar(0, 100);
		System.out.println(s);
		s.comprarVacunas(20);
		s.vacunar(60, 100);
		System.out.println(s);
		
		System.out.println("\nProbando sistema de vacunaci�n con dosis");
		SistemaVacunacionDosis sd = new SistemaVacunacionDosis(2);
		addPersonas(sd, personas);
		System.out.println(sd);
		sd.comprarVacunas(20);
		sd.vacunar(60, 100);
		System.out.println("Primera dosis administrada. Ning�n inmunizado a�n.");
		System.out.println(sd);
		sd.vacunar(60, 100);
		System.out.println("Segunda dosis administrada. Grupo de 60 a 100 a�os inmunizado");
		System.out.println(sd);
	}
	
	private static void addPersonas(SistemaVacunacion s, Persona personas[]) {
		for (int i=0;i<personas.length;i++) {
			s.addPersona(personas[i].getNombre(), personas[i].getEdad());
		}
		
	}

}

/*Salida esperada:
Vacunas: 0 [(Alberto G�mez, 64, NO INMUNIZADO), (Mar�a Abad, 50, NO INMUNIZADO), (Sara Campos, 80, NO INMUNIZADO), (Jorge T�llez, 25, NO INMUNIZADO), (Rafael S�nchez, 75, NO INMUNIZADO), (Alicia Gutierrez, 82, NO INMUNIZADO), (ALICIA Gutierrez, 40, NO INMUNIZADO), null, null, null]
Vacunas: 0 [(Alberto G�mez, 64, NO INMUNIZADO), (Mar�a Abad, 50, NO INMUNIZADO), (Sara Campos, 80, NO INMUNIZADO), (Jorge T�llez, 25, NO INMUNIZADO), (Rafael S�nchez, 75, NO INMUNIZADO), (Alicia Gutierrez, 82, NO INMUNIZADO), (ALICIA Gutierrez, 40, NO INMUNIZADO), null, null, null]
Vacunas: 16 [(Alberto G�mez, 64, INMUNIZADO), (Mar�a Abad, 50, NO INMUNIZADO), (Sara Campos, 80, INMUNIZADO), (Jorge T�llez, 25, NO INMUNIZADO), (Rafael S�nchez, 75, INMUNIZADO), (Alicia Gutierrez, 82, INMUNIZADO), (ALICIA Gutierrez, 40, NO INMUNIZADO), null, null, null]

Probando sistema de vacunaci�n con dosis
Vacunas: 0 [(Alberto G�mez, 64, NO INMUNIZADO), (Mar�a Abad, 50, NO INMUNIZADO), (Sara Campos, 80, NO INMUNIZADO), (Jorge T�llez, 25, NO INMUNIZADO), (Rafael S�nchez, 75, NO INMUNIZADO), (Alicia Gutierrez, 82, NO INMUNIZADO), null, null, null, null]
Primera dosis administrada. Ning�n inmunizado a�n.
Vacunas: 16 [(Alberto G�mez, 64, NO INMUNIZADO), (Mar�a Abad, 50, NO INMUNIZADO), (Sara Campos, 80, NO INMUNIZADO), (Jorge T�llez, 25, NO INMUNIZADO), (Rafael S�nchez, 75, NO INMUNIZADO), (Alicia Gutierrez, 82, NO INMUNIZADO), null, null, null, null]
Segunda dosis administrada. Grupo de 60 a 100 a�os inmunizado
Vacunas: 12 [(Alberto G�mez, 64, INMUNIZADO), (Mar�a Abad, 50, NO INMUNIZADO), (Sara Campos, 80, INMUNIZADO), (Jorge T�llez, 25, NO INMUNIZADO), (Rafael S�nchez, 75, INMUNIZADO), (Alicia Gutierrez, 82, INMUNIZADO), null, null, null, null]
*/