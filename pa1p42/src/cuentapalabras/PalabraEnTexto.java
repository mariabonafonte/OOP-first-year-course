package cuentapalabras;

import java.util.Objects;

public class PalabraEnTexto {
	private String palabra;
	private int veces;
	
	public PalabraEnTexto(String palabra) {
		super();
		this.palabra = palabra.toUpperCase();
		veces = 1;
	}
	
	public void incrementa(){
		veces +=1;
	}

	@Override
	public int hashCode() {
		return Objects.hash(palabra);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PalabraEnTexto other = (PalabraEnTexto) obj;
		return Objects.equals(palabra, other.palabra);
	}

	@Override
	public String toString() {
		return  palabra + ": " + veces;
	}
	
	
	
	

	

}
