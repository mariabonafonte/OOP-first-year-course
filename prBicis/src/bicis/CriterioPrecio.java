package bicis;

public class CriterioPrecio implements Criterio {
	double precioMaximo; 

	

	public CriterioPrecio(double precio) {
		super();
		this.precioMaximo = precio;
	}



	@Override
	public boolean valida(BiciLimitada b) {
		boolean res = false;
		if(b.getPrecio()<=precioMaximo) {
			res= true;
		}
		return res;
	}

}
