package bicis;

public class BiciLimitada extends Bici {
	private double precio;
	private Criterio criterio;

	public BiciLimitada(double p, Criterio c) {
		super();
		if (p<0) {
			throw new BiciException("Precio inicial inválido");
		}
		if (c==null) {
			throw new BiciException("Criterio null");
		}
		this.precio = p;
		this.criterio = c;
	}
	
	public void instalar(String com, double pre) {
		this.instalar(com);
		precio += pre;
		if(!criterio.valida(this)) {
			this.desinstalar(com, pre);
			throw new BiciException("Operacion no válida");
		}
		
	}
	
	public void desinstalar(String com, double pre) {
		this.desinstalar(com);
		precio -= pre;
	}

	public double getPrecio() {
		return precio;
	}

	@Override
	public String toString() {
		return super.toString() + ": " + precio;
	}
	
	
	
	

}
