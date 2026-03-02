import residentes.*;
import residencias.*;

public class PruebaExamen {

	public static void main(String[] args) {
		System.out.println("---- Añadimos residentes ----");
		Residente resi1 = new Residente("Juan Pérez", 65, "73095931E", Provincia.Córdoba);
		System.out.println(resi1);

		Residente resi2 = new Residente("María López", 70, "72987764R", Provincia.Málaga);
		System.out.println(resi2);

		Residente resi3 = new Residente("Luis García", 75, "02229461W", Provincia.Granada);
		System.out.println(resi3);

		Residente resi4 = new Residente("Ana Martínez", 80, "01090166N", Provincia.Jaén, GradoDependencia.GradoII);
		System.out.println(resi4);

		Residente resi5 = new Residente("Pedro Miramón", 85, "91254300Y", Provincia.Almería, GradoDependencia.GradoI);
		System.out.println(resi5);

		Residente resi6 = new Residente("Laura Fernández", 90, "57541249X", Provincia.Huelva, GradoDependencia.GradoII);
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
