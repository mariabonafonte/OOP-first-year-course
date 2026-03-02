package hospital;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;
import java.io.File;
import java.io.PrintWriter;

public class Hospital {
	protected Map<Paciente,Habitacion> habitaciones;
	protected SortedSet<Habitacion> libres;
	private int plantas;
	private String nombre;

	public Hospital(String nombre, int plantas, int habs) {
		if(nombre==null) {
			throw new HospitalException("Nombre nulo");
		}
		if(plantas<0 || habs<0) {
			throw new HospitalException("Valores negativos");
		}
		this.nombre = nombre;
		this.plantas = plantas;
		this.libres = new TreeSet<>();
		this.habitaciones = new HashMap<>();
		generarHabitaciones(plantas,habs);
		
	}
	private void generarHabitaciones(int plantas, int habs) {
		int contadorPlantas = 1;
		while(contadorPlantas<=plantas){
			int contadorHabs = 1;
			while(contadorHabs<=habs) {
				libres.add(new Habitacion(contadorPlantas,contadorHabs));
				contadorHabs++;
			}
			contadorPlantas++;
		}
	}
	
	public void altaPaciente(Paciente p) {
		if(libres.isEmpty()||p==null|habitaciones.containsKey(p)) {
			throw new HospitalException("No se piuede dar alta");
		}
		int randomIndex = new Random().nextInt(libres.size());
		Iterator<Habitacion> it = libres.iterator();
		for (int i = 0; i < randomIndex; i++) it.next();
		Habitacion habRandom = it.next();
		libres.remove(habRandom);
		
		habitaciones.put(p, habRandom);
	}
	
	public Paciente bajaPaciente (String nuss) {
		Paciente pbaja = null;
		Habitacion h = null;
		for(Paciente p: habitaciones.keySet()) {
			if(p.getNuss().equals(nuss)) {
				pbaja = p;
				h =habitaciones.get(p);
				libres.add(h);
				habitaciones.remove(p);
			}
		}
		return pbaja;
	}
	public Paciente[] seleccion(Criterio c) {
		List<Paciente> res = new ArrayList<>();
		for(Paciente p: habitaciones.keySet()) {
			if(c.cumpleCondicion(p, habitaciones.get(p))) {
				res.add(p);
			}
		}
		return res.toArray(new Paciente[0]);
	}
	public void leePacientes(String nombreDeFichero) {
		try (Scanner sc = new Scanner(new File(nombreDeFichero))){
			leePacientes(sc);
		} catch (Exception e) {}
		
	}
	private void leePacientes(Scanner sc) {
		while(sc.hasNextLine()) {
			try {
				String [] s = sc.nextLine().split("\\s*[,]\\s*");
				String nom = s[0];
				String ape = s[1];
				String nuss = s[2];
				int ano = Integer.parseInt(s[3]);
				Paciente p = new Paciente(nom,ape,nuss,ano);
				altaPaciente(p);
			} catch (Exception e) {}
			
		}
	}
	public void escribePacientes(String f) {
		try (PrintWriter pw = new PrintWriter(f)){
			escribePacientes(pw);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void escribePacientes(PrintWriter pw) {
		for(Habitacion h: habitaciones.values()) {
			
		}
	}
	@Override
	public String toString() {
		return "Hospital [nombre=" +nombre + ", pacientes=" + habitaciones +  ", libres="
				+ libres + "]";
	}
	
	
	
	
	
}
