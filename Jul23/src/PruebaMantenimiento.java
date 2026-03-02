import java.io.FileNotFoundException;
import java.io.IOException;

import bicis.Bici;
import bicis.Mantenimiento;

public class PruebaMantenimiento {
	public static void main(String[] args) {
		Mantenimiento m = new Mantenimiento();
		Bici b = new Bici();
		b.instalar("CESTA");
		b.instalar("LUZ");
		b.instalar("BATERIA");
		m.alta(b);
		try {
			m.escribeBicicletas("salida1.txt");
		} catch (FileNotFoundException e) {
			System.out.println("El fichero salida1.txt no tiene permisos de escritura");
		}
		try {
			int incorrectas = m.leeBicicletas("entrada.txt");
			System.out.printf("%s líneas incorrectas\n", incorrectas);
		} catch (IOException e1) {
			System.out.println("El fichero entrada.txt no existe o no puede ser abierto para lectura");
		}
		try {
			m.escribeBicicletas("salida2.txt");
		} catch (FileNotFoundException e) {
			System.out.println("El fichero salida2.txt no tiene permisos de escritura");
		}
		System.out.println("Bicis por componentes: " + m.bicisPorComponente());
	}
}
