package burgersempire;

public class Hamburguesa extends Alimento {
	private boolean mostaza, ketchup, cebolla, queso, pollo, doble;

	public Hamburguesa(boolean mostaza, boolean ketchup, boolean cebolla, boolean queso, boolean pollo, boolean doble) {
		super();
		this.mostaza = mostaza;
		this.ketchup = ketchup;
		this.cebolla = cebolla;
		this.queso = queso;
		this.pollo = pollo;
		this.doble = doble;
		this.setTipo(TipoAlimento.HAMBURGUESA);
	}

	public boolean isMostaza() {
		return mostaza;
	}

	public boolean isKetchup() {
		return ketchup;
	}

	public boolean isCebolla() {
		return cebolla;
	}

	public boolean isQueso() {
		return queso;
	}

	public boolean isPollo() {
		return pollo;
	}

	public boolean isDoble() {
		return doble;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Hamburguesa. ");
		if(this.getPedidoAsociado()!=null) {
			sb.append(" Pedido: " + this.getPedidoAsociado());
		}
		sb.append("(");
		if(isMostaza()) {
			sb.append("mostaza ");
		}
		if(isKetchup()) {
			sb.append("ketchup ");
		}
		if(isCebolla()) {
			sb.append("cebolla ");
		}
		if(isQueso()) {
			sb.append("queso ");
		}
		if(isPollo()) {
			sb.append("pollo ");
		}
		if(isDoble()) {
			sb.append("doble ");
		}
		sb.append(")");
		return sb.toString();
	}
	

	

}
