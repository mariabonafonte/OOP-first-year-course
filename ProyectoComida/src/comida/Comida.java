package comida;

import java.util.List;

import Ingredientes.Ingredientes;


public abstract class Comida {
	
	private String nombre;
	private double precio;
	 private List<Ingredientes> ingredientes;

	public Comida(String nombre, double precio, List<Ingredientes> ingredientes2) {
		this.nombre = nombre;
		this.precio = precio;
		this.ingredientes = ingredientes2;
	}
	
	public String getNombre() {
		return nombre;
	}
	public int getPrecio() {
		return (int) precio;
	}
	public abstract TipoComida getTipo();


	public static void main(String[] args) {  
		PlatoPrincipal arrozCubana = new PlatoPrincipal("arrozCubana", 8,"arroz,huevo,tomate", "Legumbres");
			
		System.out.println(arrozCubana.getTipo());	
		}
}
