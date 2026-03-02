package bibliotecas;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.io.File;
import java.io.FileNotFoundException;

public class Biblioteca {
	protected SortedMap<Libro,Integer> disponibles, prestados;
	

	public Biblioteca(String fich) {
		try (Scanner sc = new Scanner(new File(fich))){
			while(sc.hasNextLine()) {
				leerLibros(sc.nextLine());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void leerLibros(String sc) {
		try {
			String [] s = sc.split("%");
			String titulo = s[0];
			List<String> autores = List.of(s[1].split(";"));
			String codigo = s[2];
			int ano = Integer.parseInt(s[3]);
			Libro l = new Libro(titulo, autores, codigo,ano);
			anadir(l,1);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
	
	public void anadir(Libro l, int c) {
		if(disponibles.containsKey(l)) {
			disponibles.put(l, disponibles.get(l)+ c);
		}else {
			disponibles.put(l, c);
		}
	}
	
	public int disponibles(Libro l) {
		return disponibles.get(l);
	}
	
	public Libro getLibro(String t, int a) {
		Libro res = null;
		for(Libro l: disponibles.keySet()) {
			if(l.getTitulo().equalsIgnoreCase(t)
					&&l.getAno()==a) {
				res = l;
			}
		}
		return res;
	}
	
	public List<Libro> librosDeAutor(String a){
		List<Libro> res = new ArrayList<>();
		for(Libro l: disponibles.keySet()) {
			if(l.getAutores().contains(a)) {
				res.add(l);
			}
		}
		return res;
	}
	
	public void prestar(Libro l) {
		int cant = disponibles.get(l);
		disponibles.put(l, cant-1);
		if(prestados.containsKey(l)) {
			prestados.put(l, prestados.get(l)+1);
		}else prestados.put(l, 1);
	}
	
	public void devolver(Libro l) {
		int cant = prestados.get(l);
		if(cant==1) {
			prestados.remove(l);
		}else prestados.put(l, cant-1);
		disponibles.put(l, disponibles.get(l)+1);
	}
	
	public SortedMap<String,Set<Libro>> indiceDeAutores(){
		SortedMap<String,Set<Libro>> res = new TreeMap<>();
		for(Libro l: disponibles.keySet()) {
			List<String> autores = l.getAutores();
			for(String a: autores) {
				if(res.containsKey(a)) {
					Set<Libro> set = res.get(a);
					set.add(l);
					res.put(a, set);
				}else {
					Set<Libro> set = new HashSet<>();
					set.add(l);
					res.put(a, set);
				}
			}
		}
		return res;
	}

}
