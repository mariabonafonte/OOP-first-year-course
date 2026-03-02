package fidelizacion;

import java.util.Comparator;

public class ClientePuntos  implements Comparator<Cliente>{

	public int compare(Cliente o1, Cliente o2) {
		return Integer.compare(o1.getPuntos(), o2.getPuntos());
	}
}

