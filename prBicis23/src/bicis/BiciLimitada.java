package bicis;

public class BiciLimitada extends Bici {
	private double precio;
	private Criterio criterio;
	
	public BiciLimitada(double precio, Criterio criterio) {
		super();
		if(precio<0|| criterio==null) {
			throw new BiciException("No se ha podido generar");
		}
		this.precio = precio;
		this.criterio = criterio;
	}

	public void instalar(String c, double pre) {
		// TODO Auto-generated method stub
		super.instalar(c);
	}
	
	

	

}
