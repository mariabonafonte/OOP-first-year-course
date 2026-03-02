package tienda;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Tienda {
	private SortedMap<Producto,Integer> disponibles;
	private SortedMap<Producto,Integer> almacenadas;

	public SortedMap<Producto, Integer> getDisponibles() {
		return disponibles;
	}

	public SortedMap<Producto, Integer> getAlmacenadas() {
		return almacenadas;
	}

	public Tienda(String FichDatos) throws FileNotFoundException {
		disponibles = new TreeMap<>();
		almacenadas = new TreeMap<>();
		try (Scanner sc = new Scanner(new File(FichDatos))){
				while(sc.hasNextLine()) {
					Producto p =procesar(sc.nextLine());
					agregar(p,1);
				}
		} catch (TiendaException e) {
			e.printStackTrace();
		}
	}
	
	private Producto procesar(String sc) {
		String[] s = sc.split("%");
		String den = s[0];
		String car = s[1];
		String cod = s[2];
		int pre = Integer.parseInt(s[3]);
		
		Set<String> caracteristicas = Set.of(car.split(","));
		
		return new Producto(den, cod, caracteristicas, pre);
	}
	
	public void agregar(Producto p, int unidades) {
		if(unidades<0) {
			throw new TiendaException("Las unidades no pueden ser negativas");
		}
		if(disponibles.containsKey(p)) {
			disponibles.put(p, disponibles.get(p) + unidades);
		} else disponibles.put(p, unidades);
	}
	
	public int disponibles(Producto p) {
		int res = 0;
		if(disponibles.containsKey(p)) {
			res =disponibles.get(p);
		}
		return res;
	}
	
	public Producto producto(String denominacion, int precio) {
		Producto res = null;
		for(Producto p: disponibles.keySet()) {
			if(p.getDenominacion().equalsIgnoreCase(denominacion)&& p.getPrecio()==precio) {
				res = p;
			}
		}
		return res;
	}
	
	public Set<Producto> productosConCaracteristica(String caracteristica){
		Set<Producto> set = new HashSet<>();
		for(Producto p: disponibles.keySet()) {
			if(p.getCaracteristicas().contains(caracteristica)) {
				set.add(p);
			}
		}
		return set;
	}
	
	public void almacenar(Producto p) {
		if(disponibles.containsKey(p)) {
			if(disponibles.get(p)!=0) {
				disponibles.put(p, disponibles.get(p) -1);
				if(almacenadas.containsKey(p)) {
					almacenadas.put(p, almacenadas.get(p) +1);
				} else almacenadas.put(p,1);
			}else throw new TiendaException("Unidades insuficientes");
		}else throw new TiendaException("Este producto no existe");
		
	}
	public void recuperar(Producto p) {
		if(almacenadas.containsKey(p)) {
			if(almacenadas.get(p)!=0) {
				almacenadas.put(p, almacenadas.get(p) -1);
				if(disponibles.containsKey(p)) {
					disponibles.put(p, disponibles.get(p) +1);
				} else disponibles.put(p,1);
				
				if(almacenadas.get(p)==0) {
					almacenadas.remove(p);
				}
			}else throw new TiendaException("Unidades insuficientes");
		}else throw new TiendaException("Este producto no existe");
		
	}
	
	public void guardarProductos(String NomFich) {
		try (PrintWriter pw = new PrintWriter(NomFich)){
			guardarProductos(pw);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
		
	
	public void guardarProductos(PrintWriter pw) {
		for(Producto p: disponibles.keySet()) {
			pw.append(p.toString() + "\n");
			pw.append("Disponibles: " + disponibles.get(p) + " Almacenados: ");
			
			if(almacenadas.containsKey(p)){
				pw.append(almacenadas.get(p) +"\n");
			} else pw.append(0 +"\n");
		}	
	}
	

}
