package coches;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;

public class Fabricante {
	protected Map<String, Set<Coche>> coches;
	private String name;

	public Fabricante(String nombre) throws CochesException {
		if (nombre == null || nombre.isEmpty())
			throw new CochesException("nombre incorrecto");
		this.name = nombre;
		coches = new HashMap<>();
	}
	
	public void anadeModelo(String modelo) throws CochesException {
		if (modelo == null || modelo.isEmpty() || coches.get(modelo) != null)
			throw new CochesException("el modelo ya existe");
		coches.put(modelo, new HashSet<>());
	}
	
	public void anadeCoche (Coche coche) {
		if(coche==null) {
			throw new CochesException("Coche inválido");
		}
		for(Set<Coche> set: coches.values()) {
			for(Coche c: set) {
				if(c.getNiv().equalsIgnoreCase(coche.getNiv())) {
					throw new CochesException("Niv existente");	
				}
			}
		}
		String modelo = coche.getModelo();
		if(coches.containsKey(modelo)) {
			Set<Coche> set = coches.get(modelo);
			set.add(coche);
			coches.put(modelo, set);
		} else{
			coches.put(modelo, Set.of(coche));
		}
	}

	@Override
	public String toString() {
		StringJoiner si = new StringJoiner(", ", name + ": <", ">");
		for (Map.Entry<String, Set<Coche>> e : coches.entrySet()) {
			StringJoiner sj = new StringJoiner(", ", e.getKey() + ": <", ">");
			for (Coche c : e.getValue())
				sj.add(c.toString());
			si.add(sj.toString());
		}
		return si.toString();
	}
	
	

}
