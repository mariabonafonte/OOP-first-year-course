package burgersempire;

public class Patatas extends Alimento{
	private String size, tipoPatata;

	public Patatas(String size, String tipoPatata) throws BurgerException {
		super();
		this.setTipo(TipoAlimento.PATATAS);
		if (!size.equals("Grande")&&!size.equals("Mediana")) {
			throw new BurgerException("Las patatas solo puede ser Grande o Mediana");
		}
		if (!tipoPatata.equals("Clasica")&&!tipoPatata.equals("Gajos")) {
			throw new BurgerException("Las patatas solo puede ser Clasica o Gajos");
		}
		this.size=size;
		this.tipoPatata=tipoPatata;
	}
	
	public String getSize() {
		return size;
	}

	public String getTipoPatata() {
		return tipoPatata;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Patatas. ");
		if(this.getPedidoAsociado()!=null) {
			sb.append(" Pedido: " + this.getPedidoAsociado());
		}
		sb.append("(" + this.size + " " + this.tipoPatata + ")");
		return sb.toString();
	}

	
	
}
