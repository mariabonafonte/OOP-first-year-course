package gasolinera;

import java.util.Comparator;

public class OrdenAlternativoTicket implements Comparator<Ticket>{

	@Override
	public int compare(Ticket o1, Ticket o2) {
		int resultado = Integer.compare(o1.getNumero(), o2.getNumero());
		if(resultado==0) {
			resultado = o1.getNombre().compareToIgnoreCase(o2.getNombre());
		}
		return resultado;
	}

}
