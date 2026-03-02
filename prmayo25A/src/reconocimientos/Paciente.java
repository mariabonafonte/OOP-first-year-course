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
		analisis = new HashMap<>();
		electros = new HashMap<>();
		}
	
	public void aniadirPrueba(PruebaMedica m) {
		
	}
	
	public AnalisisSangre getAnalisisSangre(int anio) {
		AnalisisSangre a =  analisis.get(anio);
		
		if(a== null) {
		throw new PruebaMedicaException("no hay analisis para este año");
		}
		
		return a;
		
	}
	
	public Electrocardiograma getElectro(int anio) {
		Electrocardiograma e =  electros.get(anio);
		
		if(e== null) {
		throw new PruebaMedicaException("no hay electros para este año");
		}
		
		return e;
	}

	@Override
	public int hashCode() {
		return Objects.hash(edad, nombre.toLowerCase());
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof Paciente p)
				&&nombre.equalsIgnoreCase(p.nombre)
				&&edad==p.edad;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(nombre+ ": edad=" + edad +"/n" );
		for(AnalisisSangre a: analisis.values()) {
			sb.append(a.toString() + "/n");
		}
		for(Electrocardiograma e: electros.values()) {
			sb.append(e.toString() + "/n");
		}
		return sb.toString();
	}
	
	public void leerHistorialFichero (String fichero) {
		try (Scanner sc = new Scanner(new File(fichero))){
			while(sc.hasNextLine()) {
				String[] s = sc.nextLine().split(",");
				int dia = Integer.parseInt(s[1]);
				int mes = Integer.parseInt(s[2]);
				int anio = Integer.parseInt(s[3]);
				
				if(s[0]=="A") {
					TipoAnalisis tipo = TipoAnalisis.valueOf(s[4]);
					int num = Integer.parseInt(s[5]);
					analisis.put(anio, new AnalisisSangre(dia, mes,anio, tipo, num));
				} else if(s[0]=="E") {
					int ritmo = Integer.parseInt(s[4]);
					boolean an = Boolean.parseBoolean(s[5]);
					electros.put(anio, new Electrocardiograma(dia, mes, anio,ritmo, an));
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	

	

}
