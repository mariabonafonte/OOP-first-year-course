import java.util.Random;

import bicis.Bici;
import bicis.BiciException;

public class PruebaBici {

	static public void main(String[] args) {
		String[] componentes = { "LUZ", "BATERIA", "GPS", "CESTA" };
		Random r = new Random();
		
		for(int i= 0; i<5; i++) {
			Bici b = new Bici();
			while(b.getComponentes().size()<2) {
				try {
					b.instalar(componentes[r.nextInt(componentes.length)]);
				}catch(BiciException e) {}
			}
			System.out.println(b);
		}
	}

}
