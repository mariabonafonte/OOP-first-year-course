package bicis;

import java.util.HashMap;
import java.util.Map;

public class Mantenimiento {
	private Map<Bici, Integer> bicis;

	public Mantenimiento() {
		bicis = new HashMap<>();
	}
	
	public void alta(Bici b) {
	    if(bicis.containsKey(b)) {
	        bicis.put(b, bicis.get(b) + 1);
	    } else {
	        bicis.put(b, 1);
	    }
	}
	
	public void baja (Bici b) {
		  if(bicis.containsKey(b)) {
			  int cantidad = bicis.get(b);
			  
			  if(cantidad-1 == 0) {
				  bicis.remove(b);
			  }
		        bicis.put(b, cantidad - 1);
		    } else {
		        throw new BiciException("Operacion inválida");
		    }
	}
	
	public Map<String, Integer> bicisPorComponente() {
		Map<String, Integer> map = new HashMap<>();
		for (Bici b : bicis.keySet()) {
			for (String c : b.getComponentes()) {
				int cantidad = map.getOrDefault(c, 0);
				map.put(c, cantidad + bicis.get(b));
			}
		}
		return map;
	}
}

