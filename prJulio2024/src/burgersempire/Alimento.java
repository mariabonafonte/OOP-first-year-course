package burgersempire;

public abstract class Alimento {
	private TipoAlimento tipo;
	private Pedido pedidoAsociado;
	private boolean preparado;

	public Alimento() {
		pedidoAsociado=null;
		preparado = false;
		
	}

	public TipoAlimento getTipo() {
		return tipo;
	}

	public void setTipo(TipoAlimento tipo) {
		this.tipo = tipo;
	}

	public Pedido getPedidoAsociado() {
		return pedidoAsociado;
	}

	public void setPedidoAsociado(Pedido pedidoAsociado) {
		this.pedidoAsociado = pedidoAsociado;
	}

	public boolean isPreparado() {
		return preparado;
	}

	public void setPreparado(boolean preparado) {
		this.preparado = preparado;
	}
	
	

}
