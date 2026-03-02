package medicamentos;

import java.util.List;
import java.util.Objects;

public class Medciamento {
	private String nombre;
	private List<String> componentes;
	
	public Medciamento(String nombre, List<String> componentes) {
		super();
		this.nombre = nombre;
		this.componentes = componentes;
	}

	public String getNombre() {
		return nombre;
	}

	public List<String> getComponentes() {
		return componentes;
	}
	
	public boolean contiene(String componente) {
	    String componenteNormalizado = componente.toLowerCase();
	    for (String c : componentes) {
	        if (c.toLowerCase().equals(componenteNormalizado)) {
	            return true;
	        }
	    }
	    return false;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder ();
		sb.append(nombre + " (");
		for(String c:componentes) {
			sb.append(c + ", ");
		}
		sb.append(")");
		return sb.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre.toLowerCase());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medciamento other = (Medciamento) obj;
		return Objects.equals(nombre.toLowerCase(), other.nombre.toLowerCase());
	}




	

}
