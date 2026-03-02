package fidelizacion;

import java.util.Comparator;

public class ClienteCantidad implements Comparator<Cliente>{

	public int compare(Cliente o1, Cliente o2) {
		return Double.compare(o1.getCantidad(), o2.getCantidad());
	}
}
