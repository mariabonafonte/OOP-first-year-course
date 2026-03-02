package gasolineras;

import java.util.Comparator;

public class OrdenAlternativoTicket implements Comparator<Ticket>{

	public OrdenAlternativoTicket() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(Ticket o1, Ticket o2) {
		int resultado = Integer.compare(o1.getNumTicket(), o2.getNumTicket());
		if(resultado==0) {
			resultado = o1.getGasolinera().compareToIgnoreCase(o1.getGasolinera());
		}
		return resultado;
	}

}
