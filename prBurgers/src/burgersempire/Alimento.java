package burgersempire;

public abstract class Alimento {
	private TipoAlimento tipo;
	private Pedido pedidoAsociado;
	private	boolean preparado;

	protected Alimento() {
		this.pedidoAsociado = null;
		this.preparado = false;
	}

	public TipoAlimento getTipoAlimento() {
		return tipo;
	}

	public void setTipo(TipoAlimento tipo) {
		this.tipo = tipo;
	}

	public void setPedido(Pedido pedidoAsociado) {
		this.pedidoAsociado = pedidoAsociado;
	}

	public boolean isPreparado() {
		return preparado;
	}

	public void setPreparado(boolean preparado) {
		this.preparado = preparado;
	}

	public Pedido getPedido() {
		return pedidoAsociado;
	}

	
	
	

}
