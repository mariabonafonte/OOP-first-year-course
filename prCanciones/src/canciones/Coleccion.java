package canciones;

import java.util.ArrayList;
import java.util.List;

public class Coleccion {
	private List<Cancion> canciones;
	

	public Coleccion() {
		canciones = new ArrayList<>();
		
	}


	public List<Cancion> getCanciones() {
		return canciones;
	}
	
	protected static boolean iguales(List<String> cadenas1, List<String> cadenas2) {
		if (cadenas1.size() != cadenas2.size())
			return false;
		else {
			int p = 0;
			while (p < cadenas1.size() && cadenas1.get(p).equalsIgnoreCase(cadenas2.get(p))) {
				p++;
			}
			return p == cadenas1.size();
		}
	}
	
	private int buscarCancion(String t, List<String> i) {
	    for (int p = 0; p < canciones.size(); p++) {
	        if (canciones.get(p).getTitulo().equalsIgnoreCase(t) && iguales(canciones.get(p).getInterpretes(), i)) {
	            return p;
	        }
	    }
	    return -1;
	}

}

