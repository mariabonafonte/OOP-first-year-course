package chatbots;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;
import java.io.File;
import java.io.FileNotFoundException;

public class Sinonimos {
	private SortedMap<String, String> sinonimos;

	public Sinonimos(String fichero) {
		leerSinonimos(fichero);
	}
	
	private void leerSinonimos(String fichero) {
		try(Scanner sc = new Scanner(new File(fichero))) {
			while(sc.hasNextLine()) {
				leerLinea(sc.nextLine());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
				
	}
	
	private void leerLinea(String linea) {
		String [] l = linea.split(":");
		String k = l[0];
		String [] v = l[1].split(",");
		
		SortedMap<String, String> sinonimos = new TreeMap<>();
		for (int i = 0; i < v.length; i++) {
			String s = v[i].toLowerCase();
			sinonimos.put(k, s);
		}
	}
	
	public String getSinonimoPrincipal(String texto) {
		return sinonimos.get(texto);
	}
	
	public String valorAleatorio() {
		return null;
	}
	//toString()
}
