package tienda;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class Tienda {
	private SortedMap<Producto, Integer> disponibles, almacenadas;
	

	public Tienda(String fichDatos) {
		this.disponibles = new TreeMap<>();
		this.almacenadas=new TreeMap<>();
		
		try (Scanner sc = new Scanner(new File(fichDatos))){
			while(sc.hasNextLine()) {
				procesar(sc.nextLine());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void procesar(String sc) {
		String[] s = sc.split("%");
		String denominacion = s[0];
		Set<String> caracteristicas = Set.of(s[1].split(","));
		String codigo = s[2];
		int  precio = Integer.parseInt(s[3]);
		int  unidades = Integer.parseInt(s[4]);
		Producto p = new Producto(denominacion, caracteristicas, codigo, precio);
		
		if(disponibles.containsKey(p)) {
			disponibles.put(p, disponibles.get(p) + unidades);
		}else {
			disponibles.put(p, unidades);
		}
	}
	
	public void agregar(Producto p, int unidades) {
		if(unidades<0) {
			throw new TiendaException("Unidades negativas");
		}
		if(disponibles.containsKey(p)) {
			disponibles.put(p, disponibles.get(p) + unidades);
		}else {
			disponibles.put(p, unidades);
		}
	}
	
	public int disponibles(Producto p) {
		int res;
		if(disponibles.containsKey(p)) {
			res=disponibles.get(p);
		}else {
			res = 0;
		}
		return res;
		
	}
	public Producto producto(String denominacion, int precio) {
		Producto res = null;
		for(Producto p: disponibles.keySet()) {
			if(p.getDenominacion().equalsIgnoreCase(denominacion)
					&&precio==p.getPrecio()) {
				res=p;
			}
		}
		
		return res;
	}
	public Set<Producto> productosConCaracteristica(String caracteristica){
		Set<Producto> res = new HashSet<>();
		for(Producto p: disponibles.keySet()) {
			if(p.getCaracteristicas().contains(caracteristica)) {
				res.add(p);
			}
		}
		return res;
	}
	
	public void almacenar(Producto p) {
		if(disponibles.containsKey(p)&&disponibles.get(p)!=0) {
			disponibles.put(p, disponibles.get(p)-1);
			if(almacenadas.containsKey(p)) {
				almacenadas.put(p, almacenadas.get(p)+1);
			}else {
				almacenadas.put(p, 1);
			}
		}else {
			throw new TiendaException("Unidades insuficientes");
		}
	}
	
	public void recuperar (Producto p) {
		if(almacenadas.containsKey(p)) {
			if(almacenadas.get(p)==1) {
				almacenadas.remove(p);
			}else{
				almacenadas.put(p, almacenadas.get(p)-1);
			}
			disponibles.put(p, disponibles.get(p)+1);
		}else {
			throw new TiendaException("Producto no encontrado");
		}
	}
	
	public void guardarProductos(String Fich) {
		try (PrintWriter pw = new PrintWriter(Fich)){
			guardarProductos(pw);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	public void guardarProductos(PrintWriter pw) {
		for(Producto p: disponibles.keySet()) {
			pw.println(p.toString());
			if(almacenadas.containsKey(p)) {
				pw.println("Disponibles: " + disponibles.get(p) + " Almacenados: " + almacenadas.get(p));
			}else {
				pw.println("Disponibles: " + disponibles.get(p) + " Almacenados: 0");
			}
		}
	}

	

	
	

}
