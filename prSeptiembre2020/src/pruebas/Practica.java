package pruebas;

import java.util.Objects;

public class Practica implements Comparable<Practica>{
	private final String nombre, descripcion;
	private int cntRealizadas, cntExito;
	
	public Practica(String nombre, String descripcion) {
		super();
		if(nombre==null||nombre.isEmpty()) {
			throw new AppException("Nombre inválido");
		}
		if(descripcion==null||descripcion.isEmpty()) {
			throw new AppException("Descripcion inválida");
		}
		this.nombre = nombre;
		this.descripcion = descripcion;
		setCntRealizadas(0);
		setCntExito(0);
	}

	public Practica(String nombre, String descripcion, int cntRealizadas, int cntExito) {
		super();
		if(nombre==null||nombre.isEmpty()) {
			throw new AppException("Nombre inválido");
		}
		if(descripcion==null||descripcion.isEmpty()) {
			throw new AppException("Descripcion inválida");
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
			throw new AppException("El valor no puede ser negativo");
		}
		this.cntRealizadas = cntRealizadas;
	}

	public int getCntExito() {
		return cntExito;
	}

	public void setCntExito(int cntExito) {
		if(cntExito<0) {
			throw new AppException("El valor no puede ser negativo");
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
		int res;
		if(this.getCntRealizadas()==0) {
			res = 0;
		}else {
			res=100*this.getCntExito()/this.getCntRealizadas();
		}
		return res;
	}

	@Override
	public String toString() {
		return "(" + nombre + ", " + descripcion + ", " + cntRealizadas
				+ ", " + cntExito + ", " + getPorcExito() + "%)";
	}

	@Override
	public int hashCode() {
		return Objects.hash(descripcion.toUpperCase(), nombre.toUpperCase());
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof Practica p)
				&&p.descripcion.equalsIgnoreCase(descripcion)
				&&p.nombre.equalsIgnoreCase(nombre);
	}

	@Override
	public int compareTo(Practica o) {
		int resultado = nombre.compareToIgnoreCase(o.nombre);
		if(resultado == 0) {
			resultado = descripcion.compareToIgnoreCase(o.descripcion);
		}
		return resultado;
	}
	
	
	
	
	
	
	
	

	
}
