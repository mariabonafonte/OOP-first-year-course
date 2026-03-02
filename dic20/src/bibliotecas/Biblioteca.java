package bibliotecas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;
import java.io.File;
import java.io.FileNotFoundException;

public class Biblioteca {
	protected SortedMap<Libro, Integer> disponibles;
	protected SortedMap<Libro, Integer> prestados;

	public Biblioteca(String NomFich) {
		disponibles = new TreeMap<>();
		prestados = new TreeMap<>();
		
		try (Scanner sc = new Scanner(new File(NomFich))){
			while(sc.hasNextLine()){
				Libro l = procesar(sc.nextLine());
				aniadir(l,1);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	private Libro procesar(String sc) {
		String[] s = sc.split("%");
		String titulo = s[0];
		List<String> autores = List.of(s[1].split(","));
		String codigo = s[2];
		int ano = Integer.parseInt(s[3]);
		
		return new Libro(titulo, autores, codigo, ano);
	}

	public void aniadir(Libro l, int c) {
		if(l==null ||c<0) {
			throw new BibliotecaException("Error al añadir el libro");
		}
		if(disponibles.containsKey(l)) {
			disponibles.put(l, disponibles.get(l) + c);
		} else disponibles.put(l, c);
		
	}
	
	public int disponibles(Libro l) {
		if(disponibles.containsKey(l)) {
			return disponibles.get(l);
		} else throw new BibliotecaException("El libro no está disponible"); 
	}
	
	public Libro getLibro(String t, int a) {
		Libro res = null;
		for(Libro l: disponibles.keySet()) {
			if(l.getTitulo().equals(t)&&l.getAno()==a) {
				res=l;
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
		if(disponibles.containsKey(l)) {
			if(disponibles.get(l)!=0) {
				disponibles.put(l, disponibles.get(l) -1);
				if(prestados.containsKey(l)) {
					prestados.put(l, prestados.get(l)+1);
				}else prestados.put(l,1);
				
			}else throw new BibliotecaException("No hay unidades"); 
		}else throw new BibliotecaException("El libro no está disponible"); 
	}
	
	public void devolver(Libro l) {
		if(prestados.containsKey(l)) {
			prestados.put(l, prestados.get(l) -1);
			disponibles.put(l, disponibles.get(l)+1);
			
			if(prestados.get(l)==0) {
				prestados.remove(l);
			}	
		}else throw new BibliotecaException("El libro no está prestado"); 
	}
	
	public SortedMap<String, Set<Libro>> indiceDeAutores(){
		SortedMap<String, Set<Libro>> res = new TreeMap<>();
		for(Libro l: disponibles.keySet()) {
			for(String autor: l.getAutores()) {
				if (!res.containsKey(autor)) {
	                res.put(autor, new TreeSet<Libro>());
	             }
				res.get(autor).add(l);
			}
		}
		return res;
	}
}
