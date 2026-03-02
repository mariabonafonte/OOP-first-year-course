package tienda;

public class TiendaLimite extends Tienda {
	private int limite;

	public TiendaLimite(int limite, String fichDatos) {
		super(fichDatos);
		this.limite = limite;
	}

	@Override
	public void almacenar(Producto p) {
		if(disponibles(p)<limite) {
			throw new TiendaException("Unidades insuficientes");
		}
		super.almacenar(p);
	}
	

}
