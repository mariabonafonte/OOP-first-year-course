package reconocimientos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

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
		if (m instanceof AnalisisSangre) {
			analisis.put(m.getAnio(),  (AnalisisSangre) m);
		}else if (m instanceof Electrocardiograma) {
			electros.put(m.getAnio(), (Electrocardiograma) m);
		}
	}
	
	public AnalisisSangre getAnalisisSangre(int anio) {
		AnalisisSangre resultado = analisis.get(anio);
		if (resultado==null) {
			throw new PruebaMedicaException("Análisis no encontrado para este año " + anio);
		}
		return  resultado;
	}
	public Electrocardiograma getElectro(int anio) {
		Electrocardiograma resultado = electros.get(anio);
		if (resultado==null) {
			throw new PruebaMedicaException("Electro no encontrado para este año " + anio);
		}
		return  resultado;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(edad, nombre.toLowerCase()); //Lo ponemos a minúscula, consistencia con equals
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof Paciente p)
			&& p.edad == edad
			&& p.nombre.equalsIgnoreCase(nombre);
	}
	
	private String toStringAnalisis() {
		StringBuilder sb = new StringBuilder();
		for(Map.Entry<Integer, AnalisisSangre> pair : analisis.entrySet()) {
			sb.append("\n" + pair.getValue());
		}
		return sb.toString();
	}
	
	private String toStringElectro() {
		StringBuilder sb = new StringBuilder();
		for(Map.Entry<Integer, Electrocardiograma> pair : electros.entrySet()) {
			sb.append("\n" + pair.getValue());
		}
		return sb.toString();
	}

	@Override
	public String toString() {
		return nombre +": edad=" + edad + toStringAnalisis()+ toStringElectro(); //Si en un futuro crece con otros más, facilita el tenerlo desglosado.
	}
	
	private void procesarLinea(String linea) {
		try { //Si no se puede procesar se ignora
			String[] split = linea.split(",");
			int dia = Integer.parseInt(split[1]);
			int mes = Integer.parseInt(split[2]);
			int anio = Integer.parseInt(split[3]);
			if(split[0].compareTo("A")==0) {
				TipoAnalisis tipo = TipoAnalisis.valueOf(split[4]);
				int numeroFueraRango = Integer.parseInt(split[5]);
				//analisis.put(anio, new AnalisisSangre(dia, mes, anio, tipo, numeroFueraRango)); //esta es otra opcion
				aniadirPrueba( new AnalisisSangre(dia, mes, anio, tipo, numeroFueraRango));
			}
			else if(split[0].compareTo("E")==0) {
				int freq = Integer.parseInt(split[4]);
				boolean anomalias = Boolean.parseBoolean(split[5]);
				//electros.put(anio, new Electrocardiograma(dia, mes, anio, freq, anomalias)); //esta es otra opcion
				aniadirPrueba(new Electrocardiograma(dia, mes, anio, freq, anomalias));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	
		
	}

	public void leerHistorialFichero(String fichero) {
		try(Scanner sc = new Scanner(new File(fichero))){
			while(sc.hasNextLine()) {
				procesarLinea(sc.next());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public boolean calcularDiagnostico(ICalculoSalud ces, int anio) {
		// TODO Auto-generated method stub
		return ces.analizar(this, anio);
	}
	
	
}