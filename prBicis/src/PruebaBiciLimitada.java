import java.util.Map;

import bicis.BiciException;
import bicis.BiciLimitada;
import bicis.CriterioPrecio;

public class PruebaBiciLimitada {
	public static void main(String[] args) {
		Map<String, Double> precios = Map.of("LUZ", 15.0, "BATERIA", 150.0, "GPS", 20.0, "CESTA", 8.0);

		BiciLimitada b = new BiciLimitada(100, new CriterioPrecio(125));
		try {
			b.instalar("CESTA", precios.get("CESTA"));
		} catch (BiciException e) {
			System.out.println("Bici no válida tras instalar la cesta: " + b);
		}
		try {
			b.instalar("BATERIA", precios.get("BATERIA"));
		} catch (BiciException e) {
			System.out.println("Bici no válida tras instalar la bateria: " + b);
		}
		try {
			b.instalar("LUZ", precios.get("LUZ"));
		} catch (BiciException e) {
			System.out.println("Bici no válida tras instalar la luz: " + b);
		}
		System.out.println("Bici: " + b);
	}
}
