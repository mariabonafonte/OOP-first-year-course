package bicis;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Mantenimiento {
	private Map<Bici, Integer> bicis;

	public Mantenimiento() {
		bicis = new HashMap<>();
	}
	
	public void alta(Bici b) {
		if(bicis.containsKey(b)) {
			bicis.put(b, bicis.get(b)+1);
		}else {
			bicis.put(b, 1);
		}
	}
	
	public void baja(Bici b) {
		if(bicis.containsKey(b)) {
			int valor = bicis.get(b) -1;
			if(valor<=0) {
				bicis.remove(b);
			}else {
				bicis.put(b, valor);
			}
		}else {
			throw new BiciException("No hay bicis del tipo especificado");
		}
	}
	
	public Map<String, Integer> bicisPorComponente(){
		Map<String, Integer> mapa = new HashMap<>();
		
		for(Bici b: bicis.keySet()) {
			for(String c: b.getComponentes()) {
				if(mapa.containsKey(c)) {
					mapa.put(c, mapa.get(c) + 1);
				}else {
					mapa.put(c, 1);
				}
			}
		}
		return mapa;
		
	}
	public int leeBicicletas(String f) throws FileNotFoundException {
		int incorrectas;
		try (Scanner sc = new Scanner(new File(f))) {
			incorrectas = leeBicicletas(sc);
		}
		return incorrectas;
	}
	
	private int leeBicicletas(Scanner sc) {
		int incorrectas = 0;
		while (sc.hasNextLine()) {
			String l = sc.nextLine();
			try (Scanner scl = new Scanner(l)) {
				scl.useDelimiter("\\s*[,]+\\s*");
				Bici b = new Bici();
				while (scl.hasNext()) {
					b.instalar(scl.next());
				}
				alta(b);
			} catch (IllegalArgumentException | BiciException e) {
				incorrectas++;
			}
		}
		return incorrectas;
	}
	public void escribeBicicletas(String f) throws FileNotFoundException {
		try (PrintWriter pw = new PrintWriter(f)) {
			for (Map.Entry<Bici, Integer> e : bicis.entrySet()) {
				pw.printf("%2d %s\n", e.getValue(), e.getKey());
			}
		}
	}

}
