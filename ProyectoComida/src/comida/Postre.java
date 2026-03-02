package comida;

import java.util.List;

import Ingredientes.Ingredientes;

public class Postre extends Comida {

	private boolean vegano;
	
	public Postre(String nombre, double precio, List<Ingredientes> ingredientes, boolean vegano) {
		super(nombre, precio, ingredientes);
		this.vegano = vegano;
	}

	@Override
	public TipoComida getTipo() {
		return TipoComida.Postre;
	}
	@Override
	public String toString() {
	    return "Postre: " + super.toString() + ", Es vegano: " + (vegano ? "Sí" : "No");
	}
}
