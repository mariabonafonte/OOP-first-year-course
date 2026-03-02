package rutas;

import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Ruta {
	private String nombre;
	private SortedSet<Lugar> lugares;
	
	public Ruta(String nombre) {
		super();
		this.nombre = nombre;
		this.lugares = new TreeSet<>(new OrdenETSIInfUMA());
	}
	
	public void agregar(Lugar lugar) {
		if(lugar==null) {
			throw new RutasException("El lugar es nulo");
		}
		lugares.add(lugar);
	}
	
	public void agregarLugares(String nombreFichero) {
		try (Scanner sc = new Scanner(new File(nombreFichero))){
			agregarLugares(sc);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	public void agregarLugares(Scanner sc) {
		while(sc.hasNextLine()) {
			try {
				String[]l = sc.nextLine().split("@");
				String nombre = l[0];
				String[] coord = l[1].split(":");
				double lat = Double.parseDouble(coord[0]);
				double lon = Double.parseDouble(coord[1]);
				
				agregar(new Lugar(nombre, lat, lon));
				
			} catch (NumberFormatException e) {
				throw new RutasException("No se ha podido procesar la línea");
			}
		}
	}

	public String getNombre() {
		return nombre;
	}

	public Lugar origen() {
		if(lugares.isEmpty()) {
			throw new RutasException("Ruta vacía");
		}
		return lugares.first();
	}
	public Lugar destino() {
		if(lugares.isEmpty()) {
			throw new RutasException("Ruta vacía");
		}
		return lugares.last();
	}
	
	public boolean estaEnRuta(Lugar lugar) {
		if(lugar==null) {
			throw new RutasException("Valor nulo");
		}
		return lugares.contains(lugar);
	}
	
	public double distanciaRuta() {
		double res = 0;
		Lugar ant = null;
		for(Lugar l: lugares) {
			if(ant == null) {
				ant=l;
			}else {
				res+= ant.distancia(l);
				ant=l;
			}
		}
		return res;
	}
	public void guardarRuta(String nombreFichero) {
		try(PrintWriter pw = new PrintWriter(nombreFichero)) {
			guardarRuta(pw);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	public void guardarRuta(PrintWriter pw) {
		pw.println(getNombre()+":\n");
		for(Lugar l: lugares) {
			pw.println(l.toString()+"\n");
		}
	}
	
	

	

}
