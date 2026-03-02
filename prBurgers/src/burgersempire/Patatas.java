package burgersempire;

public class Patatas extends Alimento{
	private String size;
	private String tipoPatata;
	public Patatas(String size, String tipoPatata) {
		super();
		if(size=="Grande"|| size=="Mediana") {
			this.size = size;
		}else throw new BurgerException("Tamaño inválido");
		if(tipoPatata=="Clasica"||tipoPatata=="Gajo") {
			this.tipoPatata = tipoPatata;
		}else throw new BurgerException("Tipo inválido");
	}
	
	
	public String getSize() {
		return size;
	}


	public void setSize(String size) {
		this.size = size;
	}


	public String getTipoPatata() {
		return tipoPatata;
	}


	public void setTipoPatata(String tipoPatata) {
		this.tipoPatata = tipoPatata;
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Helado.");
		if(getPedido()!=null) {
			sb.append("Pedido: " + getPedido().getIdPedido());
		}
		sb.append(" (" + getSize() + getTipoPatata() + ")");
		return sb.toString();
	}
	
	
	
}
