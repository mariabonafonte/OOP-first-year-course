package bicis;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Bici {
	private Set<String> componentes;

	public Bici() {
		componentes = new HashSet<>();
	}

	public Set<String> getComponentes() {
		return componentes;
	}
	
	public void instalar(String c) {
		if (!Set.of("LUZ", "BATERIA", "GPS", "CESTA").contains(c.toUpperCase())) {
			throw new BiciException("Operación no válida");
		}
	componentes.add(c.toUpperCase());
	}
	
	public void desinstalar(String c) {
		if(!componentes.contains(c.toUpperCase())) {
			throw new BiciException("Operación no válida");
		}
	componentes.remove(c.toUpperCase());
	}

	@Override
	public int hashCode() {
		return Objects.hash(componentes);
	}

	@Override
	public boolean equals(Object o) {
		return (o instanceof Bici b)
				&& b.componentes.equals(componentes);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Bici ([");
		int cont = 0;
		for(String c: componentes) {
			if(cont==0) {
				sb.append(c);
				cont +=1;
			}else {
				sb.append("," + c);}
		}
		sb.append(")]");
				
		return sb.toString();
	}
	
	
	
	
	

}
