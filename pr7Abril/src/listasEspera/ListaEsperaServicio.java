package listasEspera;

import java.util.ArrayList;
import java.util.List;

public class ListaEsperaServicio {
	private List<Paciente> lista;
	private final String servicio;
	public ListaEsperaServicio(String servicio) {
		super();
		this.servicio = servicio;
		lista = new ArrayList<>();
			}
	public ListaEsperaServicio(List<Paciente> lista, String servicio) {
		super();
		this.lista = lista;
		this.servicio = servicio;
	}
	
	public void addPaciente (Paciente p) throws ListasEsperaException {
		if(!lista.contains(p)) {
			lista.add(p);
		}else {
			throw new ListasEsperaException ("No se puede añadir un paciente duplicado");
		}
	}
	
	public void removePaciente (Paciente p) throws ListasEsperaException {
		if(lista.contains(p)) {
			lista.remove(p);
		}else {
			throw new ListasEsperaException ("No se puede eliminar un paciente inexistente");
		}
	}
	

}
