package tienda;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Tienda {
	protected SortedMap<Producto, Integer> disponibles;
	private SortedMap<Producto, Integer> almacenadas;

	public Tienda(String FichDatos) {
		try (Scanner sc = new Scanner (new File(FichDatos))){
			while(sc.hasNextLine()) {
				LeerDatos(sc.nextLine());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void LeerDatos(String sc) {
		Set<String> caracteristicas= new HashSet<>();
		String codigo= null;
		String denominacion= null;
		int precio= 0;
		int unidades= 0;
		
		try {
			String[] s = sc.split("%");
			denominacion = s[0];
			codigo = s[2];
			precio = Integer.parseInt(s[3]);
			unidades = Integer.parseInt(s[4]);
			
			String[] c = s[1].split(",");
			for(String st: c) {
				caracteristicas.add(st);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		Producto p = new Producto(denominacion, caracteristicas, codigo, precio);
		agregar(p, unidades);
	}
	
	public void agregar(Producto p, int unidades) {
		if(unidades<=0) {
			throw new TiendaException("No se peude añadir un valor nulo o negativo");
		}
		if(disponibles.containsKey(p)) {
			disponibles.put(p, disponibles.get(p) + unidades);
		}else {
			disponibles.put(p, unidades);
		}
	}
	
	public int disponibles (Producto p) {
		int res = 0;
		if(disponibles.containsKey(p)) {
			res = disponibles.get(p);
		}
		return res;
	}
	
	public Producto producto(String denominacion, int precio) {
		Producto res = null;
		for(Producto p: disponibles.keySet()) {
			if(p.getDenominacion().equalsIgnoreCase(denominacion)
					&& p.getPrecio()==precio) {
				res = p;
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
		if(!disponibles.containsKey(p)||disponibles.get(p)==0) {
			throw new TiendaException("Producto no disponible");
		}
		
		disponibles.put(p, disponibles.get(p) - 1);
		
		if(almacenadas.containsKey(p)) {
			almacenadas.put(p, almacenadas.get(p)+1);
		}else {
			almacenadas.put(p, 1);
		}
			
	}
	
	public void recuperar(Producto p) {
		if(!almacenadas.containsKey(p)) {
			throw new TiendaException("Producto no encontrado");
		}
		
		almacenadas.put(p, almacenadas.get(p)-1);
		disponibles.put(p, disponibles.get(p)+1);
		
		if(almacenadas.get(p)==0) {
			almacenadas.remove(p);
		}
	}
	public void guardarProductos(String fich) {
		try (PrintWriter pw = new PrintWriter(new File(fich))){
			guardarProductos(pw);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void guardarProductos(PrintWriter pw) {
		for(Producto p: disponibles.keySet()) {
			pw.append(p.toString() +"/n");
			pw.append("Disponibles: " + disponibles.get(p) + "Almacenados: ");
			
			if(almacenadas.containsKey(p)) {
				pw.append(String.valueOf(almacenadas.get(p)));
			}else {
				pw.append("0");
			}
			pw.append("/n");
		}
	}
	
	

}
