package chatbots;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class Sinonimos {
	private SortedMap<String, String> sinonimos;
	
	public Sinonimos(String fichero) {
		SortedMap<String, String> sinonimos = new TreeMap<>();
		try (Scanner sc = new Scanner(new File(fichero))){
			while(sc.hasNextLine()) {
				leerLinea(sc.nextLine());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void leerLinea(String sc) {
		String [] s = sc.split(":");
		String valor = s[1];
		String [] claves = s[2].split(",");
		for(String c: claves) {
			sinonimos.put(c, valor);
		}
	}
	
	public String getSinonimoPrincipal(String texto) {
		String res = null;
		if(sinonimos.containsValue(texto)) {
			
		}
		return res;
		
	}

}
