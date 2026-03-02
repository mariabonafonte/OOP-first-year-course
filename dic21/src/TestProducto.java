import java.util.HashSet;
import java.util.Set;

import tienda.Producto;

public class TestProducto {

	public static void main(String[] args) {
		
		Producto p1 = new Producto("ordenador de sobremesa", "informática",
				Set.of("procesador ACME", "8GB RAM","1TB HDD"),700);
		Producto p2 = new Producto("ordenador de sobremesa", "hardware",
				Set.of(),700);
		
		System.out.println(p1);
		System.out.println(p2);
		
		if(p1.compareTo(p2)==0) {
			System.out.println("Los productos son iguales");
		} else System.out.println("Los productos no son iguales");
		
		
	
	}
	
	
	
	
}
