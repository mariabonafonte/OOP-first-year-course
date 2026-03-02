package bibliotecas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.io.File;
import java.io.FileNotFoundException;

public class Biblioteca {
	protected SortedMap<Libro, Integer> disponibles, prestados;

	public Biblioteca(String nomFich) {
		disponibles = new TreeMap<>();
		prestados = new TreeMap<>();
		
		try (Scanner sc = new Scanner(new File(nomFich))){
			while(sc.hasNextLine()) {
				leerLibros(sc.nextLine());
			}
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	private void leerLibros (String sc) {
		String titulo;
		List<String> autores;
		String codigo;
		int ano;
		int copias=0;
		Libro l=null;
		try {
			String [] s = sc.split("%");
			titulo = s[0];
			autores = List.of(s[1].split(","));
			codigo = s[2];
			ano = Integer.parseInt(s[3]);
			copias = Integer.parseInt(s[4]);
			l = new Libro(titulo,autores,codigo,ano);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		if(l!=null&& copias!=0) {
			if(disponibles.containsKey(l)) {
				disponibles.put(l, disponibles.get(l) + copias);
			}else {
				disponibles.put(l, copias);
			}
		}
		
	}
	
	public void anadir(Libro l, int c) {
		if(disponibles.containsKey(l)) {
			disponibles.put(l, disponibles.get(l) + c);
		}else {
			disponibles.put(l, c);
		}
	}
	
	public int disponibles(Libro l) {
		return disponibles.get(l);
	}
	
	public Libro getLibro(String t, int a) {
		Libro res= null;
		for(Libro l: disponibles.keySet()) {
			if(l.getTitulo().equals(t)&&l.getAno()==a) {
				res = l;
			}
		}
		return res;
	}
	
	public List<Libro> librosDeAutor(String a){
		List<Libro> res = new ArrayList<>();
		for (Libro l: disponibles.keySet()) {
			if(l.getAutores().contains(a)) {
				if(!res.contains(l)) {
					res.add(l);
				}
			}
		}
		return res;
	}
	
	public void prestar(Libro l) {
		if(prestados.containsKey(l)) {
			prestados.put(l, prestados.get(l)+1);
		}else {
			prestados.put(l, 1);
		}
		disponibles.put(l, disponibles.get(l)-1);
	}
	
	public void devolver(Libro l) {
		disponibles.put(l, disponibles.get(l)+1);
		prestados.put(l, prestados.get(l)-1);
		if(prestados.get(l)==0) {
			prestados.remove(l);
		}
	}
	
	public SortedMap<String,Set<Libro>> indiceDeAutores(){
		SortedMap<String,Set<Libro>> res = new TreeMap<>();
		
		List<String> autores = listarAutores();
		for(String a: autores) {
			res.put(a, Set.copyOf(librosDeAutor(a)));
		}
		return res;
	}
	
	private List<String> listarAutores(){
		List<String> autores = new ArrayList<>();
		for(Libro l: disponibles.keySet()) {
			for(String a: l.getAutores()) {
				if(!autores.contains(a)) {
					autores.add(a);
				}
			}
		}
		return autores;
	}
	

}
