package rutas;

import java.util.Comparator;

public class OrdenETSIInfUMA implements Comparator<Lugar>{
	
	private static final Lugar ETSI = new Lugar("ETSI Informática UMA", -4.477, 36.715);

	@Override
	public int compare(Lugar l1, Lugar l2) {
		int d1 = l1.distancia(ETSI);
		int d2 = l2.distancia(ETSI);
		return Integer.compare(d1, d2);
	}

}	