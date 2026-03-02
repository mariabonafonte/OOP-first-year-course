import java.util.Set;

import tienda.Producto;

public class TestProducto {

	static public void main(String[] args) {
		Producto p1 = new Producto("ordenador de sobremesa",Set.of("procesador ACME", "8GB RAM","1TB HDD"), "informática", 700);
		Producto p2 = new Producto("Ordenador de Sobremesa",Set.of(), "hardware", 700);
		
		System.out.println(p1);
		System.out.println(p2);
		if(p1.equals(p2)) {
			System.out.println("Son iguales");
		}else {
			System.out.println("Son diferentes");
		}
	}
	

}
