package pruebas;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class SelectorNombre implements Selector {
	private final SortedSet<String> nombres;


	public SelectorNombre(SortedSet<String> ns) {
		super();
		if(ns==null) {
			throw new AppException("conjunto nulo");
		}
		this.nombres = new TreeSet<>();
		for(String n: ns) {
			nombres.add(n.toUpperCase());
		}
	}



	public SortedSet<String> getNombres() {
		return nombres;
	}

	@Override
	public boolean esSeleccionable(Set<Practica> s) {
		boolean res = false;
		if(!s.isEmpty()) {
			for(Practica p: s) {
				if(nombres.contains(p.getNombre())) {
					res=true;
				}
			}
		}
		return res;
	}

}
