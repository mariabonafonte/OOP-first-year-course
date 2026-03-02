package ventas;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class InformeVentas {

    public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<>();
        productos.add(new Producto("Gasas", 1200, 0.1));
        productos.add(new Producto("Jeringas", 500, 0.35));
        productos.add(new Producto("Bata_desechables", 300, 2.5));
        

        // Generar el informe de ventas
        obtenerEntrada(productos);
        String informe = generarInforme(productos);

        // Imprimir el informe
        System.out.println(informe);

    }
   
    private static String generarInforme(ArrayList<Producto> productos) {
    	StringBuilder cadena = new StringBuilder();
    	cadena.append("Infore de Ventas:\n");
    	cadena.append(".................................\n");
    	
    	double total = 0.0;
  
    	
        for (Producto producto : productos) {
        	cadena.append("Producto: ");
        	cadena.append(producto.nombre());
        	cadena.append(", Cantidad: ");
        	cadena.append(producto.cantidad());
        	cadena.append(", Precio unitario: ");
        	cadena.append(producto.precio());
        	cadena.append("€, Total: ");
        	cadena.append(producto.precio() * producto.cantidad());
        	cadena.append("€ \n");
        	total = total + producto.precio() * producto.cantidad();
        	
            
        }
        cadena.append(".................................\n");
        cadena.append("Total:");
        cadena.append(total);
        cadena.append("€");
        
        return cadena.toString();
    }
    
    public static void obtenerEntrada(ArrayList<Producto> productos) {
    	Scanner teclado = new Scanner(System.in);
    	System.out.println("Introduzca POO para salir o continuar");
    	String comando = teclado.next();
    	String nombre;
    	int cantidad;
    	double precio;
    	
    	while(comando.compareToIgnoreCase("poo")!=0) {
    		System.out.println("Porfavor, introduzca  nombre:");
    		nombre = teclado.next();
    		System.out.println("Porfavor, introduzca  una cantidad:");
    		cantidad = teclado.nextInt();
    		System.out.println("Porfavor, introduzca  un precio:");
    		precio = teclado.nextDouble();
    		 productos.add(new Producto(nombre, cantidad, precio));
    	}
    	
            
        //catch(NoSuchElementException e) {
            //
       // }
       // catch(InputMismatchException e) {
            //
       // }
    }

}
    