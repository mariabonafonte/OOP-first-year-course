package tienda;

public class TiendaLimite extends Tienda {
	private int limite;

	public TiendaLimite(int limite,String FichDatos) {
		super(FichDatos);
		if(limite<0) {
			throw new TiendaException("El límite no puede ser negativo");
		}
		this.limite = limite;
	}

	@Override
	public void almacenar(Producto p) {
		
		if(this.disponibles.get(p)<=limite) {
			throw new TiendaException("no quedan unidades disponibles suficientes"
					+ "para ser trasladadas a almacenadas");
		}
		super.almacenar(p);
	}
	
	

}
