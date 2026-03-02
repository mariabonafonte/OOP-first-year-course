package neveras;

import java.util.Objects;

public class Producto {
	private String codigo;
	private String nombre;
	private double peso;
	
	public Producto(String codigo, String nombre, double peso) {
		if(peso<0) {
			throw new RuntimeException("El peso no puede ser negativo");
		}
		this.codigo = codigo;
		this.nombre = nombre;
		this.peso = peso;
	}

	protected String getCodigo() {
		return codigo;
	}

	protected String getNombre() {
		return nombre;
	}

	protected double getPeso() {
		return peso;
	}

	protected void incPeso(double p) {
		this.peso = peso + p;
	}
	
	protected void idecPeso(double p) {
		if(p>peso) {
			throw new RuntimeException ("No se puede quitar más del peso inical");
		}
		this.peso = peso - p;
	}

	@Override
	public String toString() {
		return "[" + nombre + ":"+ codigo + "(" + peso + ")]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(codigo, other.codigo);
	}
	

	
	
	
	
	
	
	

}
