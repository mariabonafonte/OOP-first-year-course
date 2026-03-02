import java.io.PrintWriter;

import tienda.Producto;
import tienda.Tienda;
import tienda.TiendaException;

public class TestTienda {

	public static void main(String[] args) {
		try {      
		  	Tienda tienda = new Tienda("productos.txt");
	        		  	
	        System.out.println("Sobre el producto: ordenador de sobremesa:700");
	        Producto p = tienda.producto("ordenador de sobremesa", 700);
	        System.out.println(p);
	        int unidades = tienda.disponibles(p);
	        System.out.println("Unidades: " + unidades);
	        try {
				while (unidades > 0) {
	                tienda.almacenar(p);
	                unidades = tienda.disponibles(p);
	                System.out.println("Producto: ordenador de sobremesa:700 almacenado");
				}
	        } catch (RuntimeException e) {
				System.out.println(e.getMessage());
	        }
	        tienda.guardarProductos(new PrintWriter(System.out,true));
			if (tienda.disponibles(p) != 0) {
				System.out.println("Error en almacenar en Tienda");
			}
	        
	        tienda.recuperar(p); //Se devuelve una unidad
	        System.out.println("Producto: ordenador de sobremesa:700 recuperado");
	        tienda.guardarProductos(new PrintWriter(System.out,true));
			if (tienda.disponibles(p) != 1) {
				System.out.println("Error en recuperar en Tienda");
			}
	        
	        System.out.println("\nProductos con: procesador ACME");
	        for (Producto ppp : tienda.productosConCaracteristica("procesador ACME")) {
	        	System.out.println(ppp);
	        }
		} catch (TiendaException ee) {
			System.err.println(ee.getMessage());
		}    
	}
}
/*
--------------------------------------------------------------------------
Salida del programa
--------------------------------------------------------------------------
Sobre el producto: ordenador de sobremesa:700
[Ordenador de Sobremesa, [8GB RAM, 1TB HDD, procesador ACME], informatica, 700]
Unidades: 6
Producto: ordenador de sobremesa:700 almacenado
Producto: ordenador de sobremesa:700 almacenado
Producto: ordenador de sobremesa:700 almacenado
Producto: ordenador de sobremesa:700 almacenado
Producto: ordenador de sobremesa:700 almacenado
Producto: ordenador de sobremesa:700 almacenado
Productos:
	[Ordenador de Sobremesa, [300GB HDD, 2GB RAM, procesador EMCA], informatica, 300]
	 	 Disponibles: 9 Almacenadas: 0
	[Ordenador de Sobremesa, [8GB RAM, 1TB HDD, procesador ACME], informatica, 700]
	 	 Disponibles: 0 Almacenadas: 6
	[Ordenador Portatil, [4GB RAM, 300GB HDD, procesador ACME], informatica, 400]
	 	 Disponibles: 11 Almacenadas: 0
	[Ordenador Portatil, [4GB RAM, 500GB HDD, procesador EMCA], informatica, 500]
	 	 Disponibles: 13 Almacenadas: 0
	[Telefono Movil, [4GB RAM, 64GB SSD, camara, HD], smartphone, 200]
	 	 Disponibles: 8 Almacenadas: 0
	[Telefono Movil, [4GB RAM, doble camara, full HD, 128GB SSD], smartphone, 400]
	 	 Disponibles: 7 Almacenadas: 0
Producto: ordenador de sobremesa:700 recuperado
Productos:
	[Ordenador de Sobremesa, [300GB HDD, 2GB RAM, procesador EMCA], informatica, 300]
	 	 Disponibles: 9 Almacenadas: 0
	[Ordenador de Sobremesa, [8GB RAM, 1TB HDD, procesador ACME], informatica, 700]
	 	 Disponibles: 1 Almacenadas: 5
	[Ordenador Portatil, [4GB RAM, 300GB HDD, procesador ACME], informatica, 400]
	 	 Disponibles: 11 Almacenadas: 0
	[Ordenador Portatil, [4GB RAM, 500GB HDD, procesador EMCA], informatica, 500]
	 	 Disponibles: 13 Almacenadas: 0
	[Telefono Movil, [4GB RAM, 64GB SSD, camara, HD], smartphone, 200]
	 	 Disponibles: 8 Almacenadas: 0
	[Telefono Movil, [4GB RAM, doble camara, full HD, 128GB SSD], smartphone, 400]
	 	 Disponibles: 7 Almacenadas: 0

Productos con: procesador ACME
[Ordenador de Sobremesa, [8GB RAM, 1TB HDD, procesador ACME], informatica, 700]
[Ordenador Portatil, [4GB RAM, 300GB HDD, procesador ACME], informatica, 400]
*/