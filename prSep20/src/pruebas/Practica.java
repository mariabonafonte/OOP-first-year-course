package pruebas;

import java.util.Objects;

public class Practica implements Comparable<Practica>{
	private final String nombre, descripcion;
	private int cntRealizadas, cntExito;
	
	public Practica(String nombre, String descripcion) {
		super();
		if(nombre.isEmpty()||descripcion.isEmpty()||nombre==null||descripcion==null) {
			throw new AppException("Nombre o descripcion nulos");
		}
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.cntRealizadas = 0;
		this.cntExito = 0;
	}

	public Practica(String nombre, String descripcion, int cntRealizadas, int cntExito) {
		super();
		if(nombre.isEmpty()||descripcion.isEmpty()||nombre==null||descripcion==null) {
			throw new AppException("Nombre o descripcion nulos");
		}
		this.nombre = nombre;
		this.descripcion = descripcion;
		setCntRealizadas(cntRealizadas);
		setCntExito(cntExito);
	}

	public int getCntRealizadas() {
		return cntRealizadas;
	}

	public void setCntRealizadas(int cntRealizadas) {
		if(cntRealizadas<0) {
			throw new AppException("Valor negativo");
		}
		this.cntRealizadas = cntRealizadas;
	}

	public int getCntExito() {
		return cntExito;
	}

	public void setCntExito(int cntExito) {
		if(cntExito<0) {
			throw new AppException("Valor negativo");
		}
		this.cntExito = cntExito;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	public int getPorcExito() {
		int res = 0;
		if(cntRealizadas!=0) {
			res = 100*cntExito/cntRealizadas;
		}
		return res;
	}

	@Override
	public String toString() {
		return "(" + nombre + ", " + descripcion + ", " + cntRealizadas
				+ ", " + cntExito + ", " + getPorcExito()+"%)";
	}

	@Override
	public int hashCode() {
		return Objects.hash(descripcion.toLowerCase(), nombre.toLowerCase());
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof Practica p)
				&& descripcion.equalsIgnoreCase(p.descripcion)
				&& nombre.equalsIgnoreCase(p.nombre);
	}

	@Override
	public int compareTo(Practica o) {
		int resultado = nombre.compareToIgnoreCase(o.nombre);
		if(resultado==0) {
			resultado =  descripcion.compareToIgnoreCase(o.descripcion);
		}
		return resultado;
	}
	
	
	
	

	

}
