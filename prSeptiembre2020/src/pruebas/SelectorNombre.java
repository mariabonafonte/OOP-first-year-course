package pruebas;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class SelectorNombre implements Selector {
	private final SortedSet<String> nombres;

	public SelectorNombre(Set<String> nom) {
		super();
		this.nombres = new TreeSet<>();
		if(nom==null) {
			throw new AppException("El conjunto es nulo");
		}
		for(String s: nom) {
			nombres.add(s.toUpperCase());
			}
	}

	public SortedSet<String> getNombres() {
		return nombres;
	}

	@Override
	public boolean esSeleccionable(Set<Practica> set) {
		boolean res;
		if(set.isEmpty()) {
			res=false;
		}else {
			Practica p = set.iterator().next();
			res = nombres.contains(p.getNombre());
		}
		return res;
	}

}
