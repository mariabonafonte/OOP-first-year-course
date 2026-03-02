package comida;

import java.util.List;

import Ingredientes.Ingredientes;

public class PlatoPrincipal extends Comida {
	
	private String Base;
	
	public PlatoPrincipal(String nombre, double precio, List<Ingredientes> ingredientes, String Base) {
		super(nombre, precio, ingredientes);
		this.Base = Base;
		
	}

	@Override
	public TipoComida getTipo() {
		return TipoComida.PlatoPrincipal;
	}

}
