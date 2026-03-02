package hospital;

import java.util.Objects;

public class Habitacion implements Comparable<Habitacion>{
	private int planta, numero;

	public Habitacion(int planta, int numero) {
		super();
		this.planta = planta;
		this.numero = numero;
	}

	public int getPlanta() {
		return planta;
	}

	public void setPlanta(int planta) {
		this.planta = planta;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Override
	public int compareTo(Habitacion o) {
		int resultado = Integer.compare(planta, o.planta);
		if(resultado==0) {
			resultado = Integer.compare(numero, o.numero);
		}
		return resultado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numero, planta);
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof Habitacion h)
				&& numero==h.numero
				&&planta ==h.planta;
	}

	@Override
	public String toString() {
		return "Habitacion [planta=" + planta + ", numero=" + numero + "]";
	}
	
	
	
	

	

}
