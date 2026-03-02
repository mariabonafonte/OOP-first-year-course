package hospital;

import java.util.Objects;

public class Habitacion implements Comparable<Habitacion>{
	private int planta;
	private int numero;
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
	public int hashCode() {
		return Objects.hash(numero, planta);}
	

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof Habitacion h)
				&&h.getNumero() == numero
				&&h.getPlanta() == planta;
	}
	@Override
	public String toString() {
		return "Habitacion [planta=" + planta + ", numero=" + numero + "]";
	}
	
	@Override
    public int compareTo (Habitacion h) {
        int res = 0 ;
        if(this.getPlanta() > h.getPlanta()) {
            res = 1 ;
        }else if(this.getPlanta() < h.getPlanta()) {
            res= -1 ;
        }else {
            if (this.numero > h.getNumero()) {
                res =1;
            }else if (this.numero < h.getNumero()) {
                res = -1;
            }     
        }
        return res  ;  
	}
	
	

	

}
