import java.time.LocalDate;

import pruebasclinicas.*;

public class ProgramaPrueba {
    public static void main(String[] args) throws PruebasClinicasException {
        // Crear pacientes
		Paciente paciente1 = new Paciente("Juan Pérez", 30);
		Paciente paciente2 = new Paciente("Ana García", 25);

		// Crear pruebas para paciente1 Sano
		AnalisisSangre analisisSangre1 = new AnalisisSangre(LocalDate.of(2025, 4, 1));
         
		// Añadir marcadores
		Marcador glucosa1 = new Marcador("Glucosa",85, 70, 100);
		analisisSangre1.agregarMarcador(glucosa1);
		Marcador colesterol1 = new Marcador("Colesterol", 190,125, 200);
		analisisSangre1.agregarMarcador(colesterol1);

		Radiografia radiografia1 = new Radiografia(LocalDate.of(2025, 4, 2),"C:/imagenes/radiografia1.jpg","No se observan anomalías");
		
		// Agregar pruebas a paciente1
		paciente1.agregarPrueba(analisisSangre1);
		paciente1.agregarPrueba(radiografia1);

		// Crear pruebas para paciente2 Ana Pachucha
		AnalisisSangre analisisSangre2 = new AnalisisSangre(LocalDate.of(2025, 4, 3));
		
		//Añadir marcadores
		Marcador glucosa2 = new Marcador("Glucosa",65, 70, 100);
		analisisSangre2.agregarMarcador(glucosa2);

		Marcador colesterol2 = new Marcador("Colesterol",230, 125, 200);
		analisisSangre2.agregarMarcador(colesterol2);
		
		Marcador plaquetas2=new Marcador("Plaquetas",100000,150000,450000);
		analisisSangre2.agregarMarcador(plaquetas2);

		Radiografia radiografia2 = new Radiografia(LocalDate.of(2025, 4, 4),"C:/imagenes/radiografia2.jpg","Fractura en el brazo derecho");
		
		// Agregar pruebas a paciente2
		paciente2.agregarPrueba(analisisSangre2);
		paciente2.agregarPrueba(radiografia2);

		// Procesar y guardar informes
		paciente1.guardarInforme("informe_paciente1.txt");
		paciente2.guardarInforme("informe_paciente2.txt");

		// Cargar y mostrar informes
		String informePaciente1 = paciente1.cargarInforme("informe_paciente1.txt");
		String informePaciente2 = paciente2.cargarInforme("informe_paciente2.txt");

		System.out.println("Informe de Juan Pérez:");
		System.out.println(informePaciente1);

		System.out.println("Informe de Ana García:");
		System.out.println(informePaciente2);

         
       // Buscar pruebas
		PruebaClinica pruebaBuscada1 = paciente1.buscarPrueba(TipoPrueba.ANALISIS_DE_SANGRE,LocalDate.of(2025, 4, 1));
		PruebaClinica pruebaBuscada2 = paciente2.buscarPrueba(TipoPrueba.RADIOGRAFIA, LocalDate.of(2025, 4, 4));
		PruebaClinica pruebaBuscadaNoExiste = paciente2.buscarPrueba(TipoPrueba.RADIOGRAFIA, LocalDate.of(2025, 2, 3));

		System.out.println("Prueba buscada en Juan Pérez:");
		System.out.println(pruebaBuscada1);

		System.out.println("Prueba buscada en Ana García:");
		System.out.println(pruebaBuscada2);
      
		
		System.out.println("Prueba buscada debe ser null:");
		System.out.println(pruebaBuscadaNoExiste);
    }
}
