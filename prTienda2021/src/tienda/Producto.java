package tienda;

import java.util.Objects;
import java.util.Set;

public class Producto implements Comparable<Producto>{
	private String denominacion, codigo;
	private Set<String> caracteristicas;
	private int precio;
	public Producto(String denominacion, Set<String> caracteristicas,String codigo, int precio) {
		super();
		if(denominacion.isEmpty()||codigo.isEmpty()||precio<0) {
			throw new TiendaException("Parámetros inválidos");
		}
		this.denominacion = denominacion;
		this.caracteristicas = caracteristicas;
		this.codigo = codigo;
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
		return "[" + denominacion + ", " + caracteristicas+ ", " + codigo
				+ ", " + precio + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(denominacion.toLowerCase(), precio);
	}
	@Override
	public boolean equals(Object obj) {
		return (obj instanceof Producto p)
				&&denominacion.equalsIgnoreCase(p.denominacion)
				&&precio==p.precio;
	}
	@Override
	public int compareTo(Producto o) {
		int resultado = denominacion.compareToIgnoreCase(o.denominacion);
		if(resultado==0) {
			resultado=Integer.compare(precio, o.precio);
		}
		return resultado;
	}
	
	
	
	
	
	

	

}
