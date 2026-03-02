package tienda;

import java.io.FileNotFoundException;

public class TiendaLimite extends Tienda {
	private int limite;

	public TiendaLimite(int limite, String FichDatos) throws FileNotFoundException {
		super(FichDatos);
		if(limite<0) {
			throw new TiendaException("El límite no peude ser negativo");
		}
		this.limite = limite;
	}

	@Override
	public void almacenar(Producto p) {
		if(getDisponibles().containsKey(p)) {
			if(getDisponibles().get(p)<=limite) {
			throw new TiendaException("no quedan unidades disponibles suficientes para ser trasladadas a almacenadas.");
			} else {
				getDisponibles().put(p, getDisponibles().get(p) -1);
				if(getAlmacenadas().containsKey(p)) {
					getAlmacenadas().put(p, getAlmacenadas().get(p) +1);
				} else getAlmacenadas().put(p,1);
			}
		}else throw new TiendaException("Este producto no existe");
		
	}
	
	

}
