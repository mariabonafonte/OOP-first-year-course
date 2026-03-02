package bicis;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Bici {
	private Set<String> componentes;
	
	public Bici() {
		this.componentes = new HashSet<>();
	}

	public Set<String> getComponentes() {
		return componentes;
	}
	
	public void instalar(String c) {
		c = c.toUpperCase();
		List<String> comp = List.of("LUZ", "BATERIA", "GPS", "CESTA");
		if(comp.contains(c) && !componentes.contains(c)){
			componentes.add(c);
		}
	}
	public void desinstalar(String c) {
		if(!componentes.contains(c)) {
			throw new BiciException("No existe el componente");
		}
		componentes.remove(c);
	}

	@Override
	public int hashCode() {
		return Objects.hash(componentes);
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof Bici b)
				&&componentes.equals(b.componentes);
	}

	@Override
	public String toString() {
		return "Bici (" + componentes + ")";
	}
	
	
	
	

}
