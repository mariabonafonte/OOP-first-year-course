package reconocimientos;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Paciente {
	private final String nombre;
	private int edad;
	private Map<Integer, AnalisisSangre> analisis;
	private Map<Integer, Electrocardiograma> electros;
	
	public Paciente(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		analisis = new HashMap<Integer, AnalisisSangre> ();
		electros = new HashMap<Integer, Electrocardiograma> ();
		
	}
	
	public void aniadirPrueba(PruebaMedica m) {
		//lo dejo para el final
	}
	
	public AnalisisSangre getAnalisisSangre(int anio) {
		AnalisisSangre an = null;
		for(Integer a: analisis.keySet()) {
			if(a.equals(anio)) {
				 an = analisis.get(a);
			}
		}
		return an;
	}
	
	public Electrocardiograma getElectro(int anio) {
		Electrocardiograma el = null;
		for(Integer e: electros.keySet()) {
			if(e.equals(anio)) {
				 el = electros.get(e);
			}
		}
		return el;
	}
	
	public void leerHistorialFichero(String fichero) {
		try(Scanner sc = new Scanner(new File(fichero))) {
			while(sc.hasNextLine()) {
				dividir(sc.nextLine());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void dividir(String linea) {
		String[] s = linea.split(",");
		int dia = Integer.parseInt(s[1]);
		int mes = Integer.parseInt(s[2]);
		int anio = Integer.parseInt(s[3]);
		
		if(s[0].equals("A")) {
			TipoAnalisis tipo = TipoAnalisis.valueOf(s[4]);
			int num = Integer.parseInt(s[5]);
			
			AnalisisSangre a = new AnalisisSangre(dia, mes, anio, tipo, num);
			analisis.put(anio, a);
			
		}else if (s[0].equals("E")) {
			int ritmo = Integer.parseInt(s[4]);
			boolean anormalidades = Boolean.parseBoolean(s[5]);
			
			Electrocardiograma e = new Electrocardiograma(dia,mes,anio,ritmo,anormalidades);
			electros.put(anio, e);
		}
		
	}

	
	public boolean calcularDiagnostico(ICalculoSalud ces, int anio) {
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(edad, nombre.toLowerCase());
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof Paciente p)
				&&p.edad == edad
				&& p.nombre.equalsIgnoreCase(nombre);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(nombre + ": edad=" + edad + "\n");
		for(Integer a: analisis.keySet()) {
			sb.append(analisis.get(a).toString());
			sb.append("\n");
			}
		for(Integer e: electros.keySet()) {
			sb.append(electros.get(e).toString());
			sb.append("\n");
			}
		
		return sb.toString();
	}
	
	
	
	
	
	

}
