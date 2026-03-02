
import java.util.Random;
import java.util.Set;

import bicis.Bici;
import bicis.BiciException;

public class PruebaBici {
	public static void main(String[] args) {
		String[] componentes = { "LUZ", "BATERIA", "GPS", "CESTA" };
		Random rnd = new Random();
		for (int i = 0; i < 5; i++) {
			Bici b = new Bici();
			while (b.getComponentes().size() < 2) {
				try {
					b.instalar(componentes[rnd.nextInt(componentes.length)]);
				} catch (BiciException e) {
				}
			}
			System.out.println(b);
		}
	}
}
