package burgersempire;

public class Helado extends Alimento {
	private boolean nata, cacahuetes;

	public Helado(boolean nata, boolean cacahuetes) {
		super();
		this.nata = nata;
		this.cacahuetes = cacahuetes;
	}

	public boolean isNata() {
		return nata;
	}

	public boolean isCacahuetes() {
		return cacahuetes;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Helado.");
		if(getPedido()!=null) {
			sb.append("Pedido: " + getPedido().getIdPedido());
		}
		sb.append(" (");
		if(isNata()) {
			sb.append("con Nata ");
		}
		if(isCacahuetes()) {
			sb.append("Con Cacahuetes ");
		}
		sb.append(")");
		return sb.toString();
		}
	
	

}
