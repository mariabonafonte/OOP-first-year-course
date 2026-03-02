package pruebas;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.StringJoiner;
import java.util.TreeMap;
import java.util.TreeSet;
import java.io.File;
import java.io.IOException;

public class Resultados {
	private SortedSet<Practica> practicas;
	private SortedMap<String, SortedSet<Practica>> alumnos;
	
	public Resultados(Set<Practica> p) {
		super();
		practicas = new TreeSet<Practica>(p);
		alumnos = new TreeMap<String, SortedSet<Practica>>();
	}
	
	private static Practica buscar(SortedSet<Practica> pr ,String d) {
		Practica p=null;
		boolean ok = false;
		Iterator<Practica> it = pr.iterator();
		while(!ok && it.hasNext()) {
			p=it.next();
			ok = p.getDescripcion().equalsIgnoreCase(d);
		}
		return ok ? p: null;
		
	}
	
	public void anyadirPractica(Practica p) {
		Practica t = buscar(practicas, p.getDescripcion());
		if(t==null) {
			throw new AppException("Descripcion erronea " + p.getDescripcion());
		}
		p.setCntRealizadas(t.getCntRealizadas());
		SortedSet<Practica> s = alumnos.get(p.getNombre().toLowerCase());
		if(s==null) {
			s = new TreeSet<Practica>();
			alumnos.put(p.getNombre().toLowerCase(), s);
		}
		s.remove(p); 
		s.add(p);
		
	}
	
	public Resultados seleccionar( Selector sel) {
		Resultados r = new Resultados(practicas);
		for (SortedSet<Practica> s : alumnos.values()) {
			if(sel.esSeleccionable(s)) {
				for(Practica p: s) {
					r.anyadirPractica(p);
				}
			}
		}
		return r;
	}
	@Override
	public String toString() {
		StringJoiner sj1 = new StringJoiner("; ", "[ ", " ]");
		for (Practica p: practicas) {
			sj1.add(p.toString());
		}
		StringJoiner sj2 = new StringJoiner("; ", "[ ", " ]");
		for (SortedSet<Practica> s : alumnos.values()) {
			for (Practica p : s) {
				sj2.add(p.toString());
			}
		}
		StringJoiner sj = new StringJoiner(", ", "{ ", " }");
		sj.add(sj1.toString());
		sj.add(sj2.toString());
		return sj.toString();
		
	}
	
	public void guardarEnFichero(String nomFich) throws IOException {
		try(PrintWriter pw = new PrintWriter(nomFich)){
			for (SortedSet<Practica> s : alumnos.values()) {
				for (Practica p : s) {
					pw.println(p.getNombre()
							+ "; " + p.getDescripcion()
							+ "; " + p.getCntExito());
				}
			}
		}
	}
	
	public void cargarDeFichero(String nomFich) throws IOException{
		try(Scanner sc = new Scanner(new File(nomFich))){
			while(sc.hasNextLine()) {
				String linea = sc.nextLine();
				try {
					String[]campos = linea.split("\\s*[;]\\s*");
					if(campos.length==3) {
						anyadirPractica(new Practica(campos[0], campos[1], 0, Integer.parseInt(campos[2])));
					}
				}catch(Exception e) {
					
				}
			}
		}
	}
	
	public void completarPracticas() {
		SortedSet<Practica> nuevasPracticas = new TreeSet<Practica>();
		for (Map.Entry<String,SortedSet<Practica>> e : alumnos.entrySet()) {
			if (e.getValue().size() != practicas.size()) {
				for (Practica t : practicas) {
					Practica p = buscar(e.getValue(), t.getDescripcion());
					if (p == null) {
						nuevasPracticas.add(new Practica(e.getKey(), t.getDescripcion()));
					}
				}
			}
		}
		for (Practica p : nuevasPracticas) {
			anyadirPractica(p);
		}
		
		
	}
	

	

}
