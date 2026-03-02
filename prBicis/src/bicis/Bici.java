package bicis;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;

public class Bici {
	private Set<String> componentes;

	public Bici() {
	componentes = new HashSet<>();
	}

	public Set<String> getComponentes() {
		return componentes;
	}
	
	public void instalar(String c) {
		c.toUpperCase();
		Set<String> componentesValidos = Set.of("LUZ", "BATERIA", "GPS", "CESTA");
		if(componentesValidos.contains(c)&& !componentes.contains(c)) {
			componentes.add(c);
		}else {
			throw new BiciException("El componente no es válido");
		}
	}
	
	public void desinstalar(String c) {
		if(componentes.contains(c)) {
			componentes.remove(c);
		}else {
			throw new BiciException("El compoente no estsba instalado");
		}
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
		StringBuilder sb = new StringBuilder("Bici [");
		StringJoiner sj = new StringJoiner(", ");
		for(String c: componentes) {
			sj.add(c);
		}
		sb.append(sj.toString()+"])");
		return sb.toString();
	}
	
	
	
	

}
