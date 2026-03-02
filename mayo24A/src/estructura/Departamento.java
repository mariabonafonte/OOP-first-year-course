package estructura;

import java.util.ArrayList;
import java.util.List;

import personal.ExcepcionesPersona;
import personal.Pdi;

public class Departamento {
	private String nombre;
	private List<Pdi> listaPDI;
	
	public Departamento(String nombre) {
		super();
		this.nombre = nombre;
		listaPDI = new ArrayList();
		
	}

	public List<Pdi> getListaPDI() {
		return listaPDI;
	}
	
	private boolean buscarPDI(String dni) {
	    for (Pdi listado : listaPDI) {
	        if (dni.equalsIgnoreCase(listado.getDNI())) {
	            return true;
	        }
	    }
	    return false;
	}
	
	public void addListaPDI (Pdi nuevo) {
		if (buscarPDI(nuevo.getDNI()) == false) {
			listaPDI.add(nuevo);
		}else {
			throw new ExcepcionesPersona("Esta persona ya está en la lista");
		}
	}
	
	public void removeListaPDI (Pdi eliminar) {
		for (Pdi persona: listaPDI) {
			if(persona.getDNI().equals(eliminar.getDNI())) {
				listaPDI.remove(persona);
			} else {
				throw new ExcepcionesPersona("Esta persona no está en la lista");
			}
		}
	}
	
	public void promocionarPDI(String dni) {
	    for (Pdi persona : listaPDI) {
	        if (persona.getDNI().equalsIgnoreCase(dni)) {
	            try {
	                persona.promocionar(); 
	            } catch (ExcepcionesPersona e) {
	                throw new ExcepcionesPersona("No se puede promocionar");
	            }
	        }
	    }
	    throw new ExcepcionesPersona("No existe ningún PDI con este DNI");
	}
	
	
	
	

	

}
