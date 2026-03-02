package bicis;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Mantenimiento {
	private Map<Bici, Integer> bicis;

	public Mantenimiento() {
		this.bicis = new HashMap<>();
	}
	public void alta (Bici b) {
		if(bicis.containsKey(b)) {
			bicis.put(b, bicis.get(b)+1);
		}else {
			bicis.put(b, 1);
		}
	}
	
	public void baja (Bici b) {
		if(!bicis.containsKey(b)) {
			throw new BiciException("Bici no existente");
		}
		if(bicis.get(b)==1) {
			bicis.remove(b);
		}else {
			bicis.put(b, bicis.get(b)-1);
		}
	}
	
	public Map<String, Integer> bicisPorComponente(){
		Map<String, Integer> res = new HashMap<>();
		
		for(Bici b: bicis.keySet()) {
			Set<String> componentes = b.getComponentes();
			for(String c: componentes) {
				if(res.containsKey(c)) {
					res.put(c, res.get(res)+1);
				}else {
					res.put(c,1);
				}
			}
		}
		return res;
		
	}
	
	public int leeBicicletas(String f) {
		int numLineas = 0;
		try (Scanner sc = new Scanner(new File(f))){
			while(sc.hasNextLine()) {
				try {
					procesarLinea(sc.nextLine());
				} catch (Exception e) {
					numLineas++;
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return numLineas;
	}
	
	private void procesarLinea(String sc) {
		String [] s = sc.split("\\s*[,]\\s*");
		Bici b = new Bici();
		for(String com: s) {
			b.instalar(com);
		}
		
	}
	
	public void escribeBicicletas(String f) {
		int cont =1; 
		try (PrintWriter pw = new PrintWriter(f)){
			for(Bici b: bicis.keySet()) {
				pw.println(cont + b.toString());
				cont++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
