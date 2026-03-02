package pruebas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.StringJoiner;
import java.util.TreeMap;
import java.util.TreeSet;

public class Resultados {
	private SortedSet<Practica> practicas;
	private SortedMap<String, SortedSet<Practica>> alumnos;
	
	
	public Resultados(SortedSet<Practica> practicas) {
		super();
		this.practicas = practicas;
		this.alumnos = new TreeMap<>();
	}

	private static Practica buscar(SortedSet<Practica> s, String d) {
		Practica res = null;

		for(Practica p: s) {
			if(p.getDescripcion().equalsIgnoreCase(d)) {
				res = p;
			}
		}
		return res;
	}
	
	public void anyadirPractica(Practica p) {
		
		Practica res = null;
		for (Practica pr: practicas) {
			if(pr.getDescripcion().equalsIgnoreCase(p.getDescripcion())) {
				res = pr;
			}
		}
		if(res==null) {
			throw new AppException("Practica no encontrada");
		}else {
			p.setCntRealizadas(res.getCntRealizadas());
		}
		
		String nombre = p.getNombre();
		if(alumnos.containsKey(nombre)) {
			SortedSet<Practica> s = alumnos.get(nombre);
			s.add(p);
			alumnos.put(nombre, s);
		}else {
			SortedSet<Practica> so = new TreeSet<>();
			so.add(p);
			alumnos.put(nombre, so);
		}
	}
	
	public Resultados seleccionar(Selector i) {
		Resultados res = new Resultados(practicas);
		for(SortedSet<Practica> s: alumnos.values()) {
			if(i.esSeleccionable(s)) {
				for(Practica p: s) {
					res.anyadirPractica(p);
				}
			}
		}
		return res;
		
	}

	@Override
	public String toString() {
		StringJoiner sj = new StringJoiner(";");
		for(Practica p: practicas) {
			sj.add(p.toString());
		}
		StringJoiner sj2 = new StringJoiner(";");
		for(SortedSet<Practica> s: alumnos.values()) {
			for(Practica pp: s) {
				sj2.add(pp.toString());
			}
		}
		return("{[" + sj.toString()+"],/n[" + sj2.toString() +"]}") ;
	}
	
	public void guardarEnFichero(String fichero) throws IOException {
		try (PrintWriter pw = new PrintWriter(fichero)){
			for(SortedSet<Practica> s: alumnos.values()) {
				for(Practica p: s) {
					pw.println(p.getNombre()
						+ "; " + p.getDescripcion()
						+ "; " + p.getCntExito());
				}
			}
		}
	}
	
	
}
