package pruebasclinicas;

import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Paciente {
	private String nombre;
	private int edad;
	private List<PruebaClinica> pruebas;
	
	public Paciente(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		pruebas = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public List<PruebaClinica> getPruebas() {
		return pruebas;
	}
	
	public void agregarPrueba(PruebaClinica p) {
		for(PruebaClinica pc: pruebas) {
			if(pc.equals(p)) {
				pruebas.remove(pc);
			}
		}
		pruebas.add(p);
	}
	
	public String crearInforme() {
		StringBuilder sb = new StringBuilder("Informe de " + nombre + ": \n");
		for(PruebaClinica pc: pruebas) {
			sb.append(pc.toString());
		}
		return sb.toString();
		
	}
	
	public void guardarInforme(String nombreArchivo) throws PruebasClinicasException {
		String informe = crearInforme();
		try (PrintWriter pw = new PrintWriter(nombreArchivo)){
			pw.println(informe);
		} catch (IOException e) {
			throw new PruebasClinicasException("Error al guardar el informe en el archivo: " + nombreArchivo);
		}
	}
	
	public String cargarInforme(String nombreArchivo) throws PruebasClinicasException {
		StringBuilder informe = new StringBuilder();
		try (Scanner scanner = new Scanner(new File(nombreArchivo))) {
			while (scanner.hasNextLine()) {
				informe.append(scanner.nextLine()).append("\n");
			}
		} catch (FileNotFoundException e) {
			throw new PruebasClinicasException("Error al cargar el informe desde el archivo: " + nombreArchivo);
		}
		return informe.toString();
	}
	
	
	public PruebaClinica buscarPrueba(TipoPrueba tipo, LocalDate fecha) {
		PruebaClinica res=null;
		for(PruebaClinica pc: pruebas) {
			if(pc.getTipoPrueba().equals(tipo)&&pc.getFechaPrueba().equals(fecha)) {
				res = pc;
			}
		}
		return res;
	}
	
	

}
