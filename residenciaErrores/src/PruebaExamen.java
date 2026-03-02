import residentes.*;
import residencias.*;

public class PruebaExamen {

	public static void main(String[] args) {
		System.out.println("---- Añadimos residentes ----");
		Residente resi1 = new Residente("Juan Pérez", 65, "73095931E", Provincia.Málaga);
		System.out.println(resi1);

		Residente resi2 = new Residente("María López", 70, "72987764R", Provincia.Málaga);
		System.out.println(resi2);

		Residente resi3 = new Residente("Luis García", 75, "02229461W", Provincia.Málaga);
		System.out.println(resi3);

		Residente resi4 = new Residente("Ana Martínez", 80, "01090166N", Provincia.Málaga, GradoDependencia.GradoII);
		System.out.println(resi4);

		Residente resi5 = new Residente("Pedro Miramón", 85, "91254300Y", Provincia.Málaga, GradoDependencia.GradoI);
		System.out.println(resi5);

		Residente resi6 = new Residente("Laura Fernández", 90, "57541249X", Provincia.Málaga, GradoDependencia.GradoII);
		System.out.println(resi6);

		// Forzamos errores
		System.out.println("---- Forzamos error por DNI incorrecto ----");
		try {
			Residente dniIncorrecto = new Residente("Laura Fernández", 90, "44556677K", Provincia.Málaga,
					GradoDependencia.GradoIII);

		} catch (ExcepcionResidente e) {
			e.printStackTrace();
		}

		System.out.println("---- Forzamos error por edad incorrecta ----");
		try {
			Residente edadIncorrecta = new Residente("Laura Fernández", 17, "57541249X", Provincia.Málaga,
					GradoDependencia.GradoIII);
		} catch (ExcepcionResidente e) {
			e.printStackTrace();
		}

		// -------------------------
		// Creamos una ResidenciaGradoCantidad
		ResidenciaLocal rgc = new ResidenciaLocal();
		rgc.agregarResidente(resi1);
		rgc.agregarResidente(resi2);
		rgc.agregarResidente(resi3);
		rgc.agregarResidente(resi4);
		rgc.agregarResidente(resi5);
		rgc.agregarResidente(resi5); // Este no debería ser añadido
		rgc.agregarResidente(resi6);

		System.out.println("---- Listamos Residentes por Grado y cantidad ----");
		rgc.mostrarEstadisticas();
		rgc.almacenarEstadisticas("ResidenciaGradoCantidad.txt");

		// Creamos una residenciaGradoProvincia y cargamos desde fichero:
		ResidenciaAutonomica rgp = new ResidenciaAutonomica();
		rgp.cargarResidentes("ResidenciaDatos.txt");

		System.out.println("---- Listamos Residentes por Grado y Provincia ----");
		rgp.mostrarEstadisticas();
		rgp.almacenarEstadisticas("ResidenciaGradoProvincia.txt");

		System.out.println("---- Listamos los residentes por orden natural ----");

		System.out.println(rgp);

	}

}

/*
 
 ---- Añadimos residentes ----
[Juan Pérez, 65 años, residente en Málaga, GradoI]
[María López, 70 años, residente en Málaga, GradoI]
[Luis García, 75 años, residente en Málaga, GradoI]
[Ana Martínez, 80 años, residente en Málaga, GradoII]
[Pedro Miramón, 85 años, residente en Málaga, GradoI]
[Laura Fernández, 90 años, residente en Málaga, GradoII]
---- Forzamos error por DNI incorrecto ----
residentes.ExcepcionResidente: No se puede asignar, DNI invalido 
	at residentes.Residente.setDNI(Residente.java:49)
	at residentes.Residente.<init>(Residente.java:25)
	at PruebaExamen.main(PruebaExamen.java:29)
---- Forzamos error por edad incorrecta ----
residentes.ExcepcionResidente: Edad incorrecta 17
	at residentes.Residente.setEdad(Residente.java:55)
	at residentes.Residente.<init>(Residente.java:26)
	at PruebaExamen.main(PruebaExamen.java:38)
---- Listamos Residentes por Grado y cantidad ----
GradoI: 4 residentes
GradoII: 2 residentes

---- Listamos Residentes por Grado y Provincia ----
GradoI:[Jaén, Cádiz, Málaga, Almería, Granada, Sevilla, Córdoba]
GradoII:[Huelva, Jaén, Cádiz, Málaga, Almería, Granada, Córdoba]
GradoIII:[Huelva, Jaén, Málaga, Granada, Córdoba, Sevilla]

---- Listamos los residentes por orden natural ----
Residentes:
[Jorge Ruiz, 60 años, residente en Sevilla, GradoI]
[Sofía Ramírez, 62 años, residente en Cádiz, GradoII]
[Juan Pérez, 65 años, residente en Córdoba, GradoI]
[Carlos Gómez, 68 años, residente en Córdoba, GradoIII]
[María López, 70 años, residente en Málaga, GradoII]
[Elena Torres, 72 años, residente en Málaga, GradoI]
[Luis García, 75 años, residente en Granada, GradoIII]
[Francisco Ortiz, 76 años, residente en Almería, GradoI]
[Martín Fernández, 78 años, residente en Granada, GradoII]
[Antonio Delgado, 79 años, residente en Sevilla, GradoIII]
[Ana Martínez, 80 años, residente en Jaén, GradoI]
[Cristina Morales, 81 años, residente en Huelva, GradoII]
[Isabel González, 82 años, residente en Jaén, GradoIII]
[Julia Ruiz, 83 años, residente en Cádiz, GradoI]
[Miguel Vega, 84 años, residente en Córdoba, GradoII]
[Pedro Sánchez, 85 años, residente en Almería, GradoII]
[Natalia Herrera, 89 años, residente en Málaga, GradoIII]
[Santiago Márquez, 90 años, residente en Granada, GradoI]
[Laura Fernández, 90 años, residente en Huelva, GradoIII]
[Patricia Campos, 92 años, residente en Jaén, GradoII]

*/
