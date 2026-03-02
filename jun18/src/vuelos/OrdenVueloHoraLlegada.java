package vuelos;

import java.util.Comparator;
public class OrdenVueloHoraLlegada implements Comparator<Vuelo> {
	
	@Override
	public int compare(Vuelo v1, Vuelo v2) {
		int res = v1.getHoraLlegada().compareTo(v2.getHoraLlegada());
		if (res == 0)
			res = v1.compareTo(v2);
		return res;
	}
}