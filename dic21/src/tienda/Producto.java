package tienda;

import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;

public class Producto implements Comparable<Producto>{
	private String denominacion;
	private String codigo;
	private Set<String> caracteristicas;
	private int precio;
	public Producto(String denominacion, String codigo, Set<String> caracteristicas, int precio) {
		super();
		if(denominacion.isEmpty()||codigo.isEmpty()) {
			throw new TiendaException("Hay parametros vacios");
		}
		if(precio<0) {
			throw new TiendaException("El precio no puede ser negativo");
		}
		this.denominacion = denominacion;
		this.codigo = codigo;
		this.caracteristicas = caracteristicas;
		this.precio = precio;
	}
	public String getDenominacion() {
		return denominacion;
	}
	public String getCodigo() {
		return codigo;
	}
	public Set<String> getCaracteristicas() {
		return caracteristicas;
	}
	public int getPrecio() {
		return precio;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[" + denominacion + ",[");
		StringJoiner sj = new StringJoiner(",");
		for(String s: caracteristicas) {
				sj.add(s);
		}
		sb.append(sj.toString()+"], " + codigo + ", " + precio +"]");
		
		return sb.toString();
	}
	@Override
	public int hashCode() {
		return Objects.hash(denominacion.toLowerCase(), precio);
	}
	@Override
	public boolean equals(Object obj) {
		return (obj instanceof Producto p)
				&&p.denominacion.equalsIgnoreCase(denominacion)
				&&p.precio==precio;
	}
	@Override
	public int compareTo(Producto o) {
		int resultado = o.denominacion.compareToIgnoreCase(denominacion);
		if(resultado==0) {
			resultado = Integer.compare(precio, o.precio);
		}
		return resultado;
	}
	
	
	
	
	
	

}
