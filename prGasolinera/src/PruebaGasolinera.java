import java.io.PrintWriter;
import java.util.HashMap;

import java.util.Map;

import gasolinera.Combustible;
import gasolinera.Gasolinera;

public class PruebaGasolinera {

	public static void main(String[] args) {
		try {
			// Se crea una correspondencia con los precios de cada tipo de combustible
			Map<Combustible,Double> precios = new HashMap<>();
			precios.put(Combustible.GASOLINA95, 1.28);
			precios.put(Combustible.GASOLINA98, 1.38);
			precios.put(Combustible.DIESEL, 1.25);
			precios.put(Combustible.DIESELPLUS, 1.30);
			
			// Estacion 1: sin promoci�n
			Gasolinera estacion = new Gasolinera("Teatinos",precios);
			// Se llenan los dep�sitos con las cantidades establecidas en el fichero
			estacion.llenarDepositos("depositos.txt");
			
			// Varios veh�culos repostan en la estaci�n, algunos varias veces.
			estacion.repostar("1111AAA",Combustible.GASOLINA95,20);
			estacion.repostar("1111AAA",Combustible.GASOLINA95,60);
			estacion.repostar("1111AAA",Combustible.GASOLINA95,60);
			estacion.repostar("2222BBB",Combustible.DIESEL,45);
			estacion.repostar("2222BBB",Combustible.DIESELPLUS,45);
			estacion.repostar("3333CCC",Combustible.DIESELPLUS,45);
			
			// Se hacen varias consultas sobre el veh�culo con matr�cula 2222BBB
			// Primero se consulta si tiene pagos pendientes
			System.out.println("El veh�culo 2222BBB " + (estacion.pagosPendientes("2222BBB")?"s�":"no") + 
					" tiene pagos pendientes");
			// Se emiten todas sus facturas
			estacion.emitirFactura("2222BBB", new PrintWriter(System.out,true));
			// Se vuelve a consultar si hay pagos pendientes.
			System.out.println("El veh�culo 2222BBB " + (estacion.pagosPendientes("2222BBB")?"s�":"no") + 
					" tiene pagos pendientes");	
			
		} catch(Exception e) { // Se captura cualquier tipo de excepci�n y se informa en la ventana de errores
			System.err.println("ERROR: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
