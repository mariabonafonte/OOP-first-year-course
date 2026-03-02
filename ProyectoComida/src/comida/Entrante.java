package comida;

import java.util.List;

import Ingredientes.Ingredientes;

public class Entrante extends Comida {

	private int porciones;
	
	public Entrante(String nombre, double precio, List<Ingredientes> ingredientes, int porciones ) {
		super(nombre, precio, ingredientes);
		this.porciones = porciones;
	}

	@Override
	public TipoComida getTipo() {
		return TipoComida.Entrante;
	}

}
