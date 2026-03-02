/*MARIA BONBAFONTE SANCHEZ
 * 1ºA ING DE LA SALUD
 * PC 1003
*/
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
	
 
	public AnalisisSangre getAnalisisSangre(int anio) {
		/*if(analisis.isEmpty()) {
			throw new PruebaMedicaException("La prueba no existe");
		}*/
		AnalisisSangre a = analisis.get(anio);
		if(a==null) {
			throw new PruebaMedicaException("La prueba no existe");
		}
		return a;
	}

	public Electrocardiograma getElectros(int anio) {
		/*if(electros.isEmpty()) {
			throw new PruebaMedicaException("La prueba no existe");
		}*/
		Electrocardiograma e = electros.get(anio);
		
		if(e==null) {
			throw new PruebaMedicaException("La prueba no existe");
		}
		
		return e;
	}
	
	public void leerHistorialFichero(String fichero) {
		try (Scanner sc = new Scanner(new File(fichero))) {
			while(sc.hasNextLine()) {
				try {
					String[] prueba = sc.nextLine().split(",");
					int dia = Integer.parseInt(prueba[1]);
					int mes = Integer.parseInt(prueba[2]);
					int anio = Integer.parseInt(prueba[3]);

					if(prueba[0]== "A") {
						TipoAnalisis tipo = TipoAnalisis.valueOf(prueba[4]);
						int num = Integer.parseInt(prueba[5]);		
						AnalisisSangre a = new AnalisisSangre(dia, mes, anio, tipo, num);
					}else if (prueba[0]== "E") {
						int ritmo = Integer.parseInt(prueba[4]);
						boolean anormal = Boolean.parseBoolean(prueba[5]);
					}
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	public boolean calcularDiagnostico(ICalculoSalud ces, int anio) {
		return (ces.analizar(this, anio));
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(edad, nombre.toLowerCase());
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof Paciente p)
					&&p.edad == edad
					&&p.nombre.equalsIgnoreCase(nombre);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(nombre + ": edad=" + edad + "\n");
		/*sb.append(analisis.entrySet());
		sb.append(electros.entrySet());
		return sb.toString();*/
		for(Map.Entry<Integer, AnalisisSangre> entry: analisis.entrySet()) {
			sb.append("\n" + entry.getValue());
		}
		for(Map.Entry<Integer, Electrocardiograma> entry: electros.entrySet()) {
			sb.append("\n" + entry.getValue());
		}
		
		return sb.toString();
	}
	
	public void aniadirPrueba (PruebaMedica m) {
		if(m instanceof AnalisisSangre) {
			analisis.put(m.getAnio(), (AnalisisSangre) m);
		}else if( m instanceof Electrocardiograma) {
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	

}
