package vivero;

import java.util.ArrayList;
import java.util.List;

public class Vivero {
	public List<Planta> plantas;
	private final int capacidad;
	
	public Vivero(int c) {
		if (c <= 0) {
			throw new RuntimeException("La capacidad del vivero no puede ser negativa");
		}
		this.capacidad = c;
		this.plantas = new ArrayList<>();
		
		
	}
	public Vivero(int c, List<Planta> plantas) {
		
		if(c<=0 || c < plantas.size()) {
			throw new RuntimeException("El vivero es demasiado pequeño");
		}
		
		this.plantas = plantas;
		capacidad = c;
	}
	protected List<Planta> getPlantas() {
		return plantas;
	}
	protected int getCapacidad() {
		return capacidad;
	}
	
	public int numeroPlantas() {
		return plantas.size();
	}
	
	private int buscarPlanta(String id) {
		int i = 0, pos = -1;
		boolean found = false;
		while (!found && i < plantas.size()) {
			if (plantas.get(i).getId().equals(id)) {
				found = true;
				pos = i;
			}
			i++;
		}
		return pos;
	}

	
	public void aniadirPlanta(Planta p) {
		if(capacidad <= plantas.size()) {
			throw new RuntimeException("No hay espacio para más plantas");
		}
		if(buscarPlanta(p.getId())!= -1) {
				throw new RuntimeException("Ya existe esta planta");
			}
		plantas.add(p);
	}
	public void aniadirPlanta(String id, String n, int humedad) {
		aniadirPlanta(new Planta(id, n, humedad));
	}

	public void eliminarPlanta(String id) {
		int pos = buscarPlanta(id);
		if (pos >= 0) {
			plantas.remove(pos);
		}
	}
	
	public List<Planta >buscarPorNombre (String nombre) {
		List<Planta> filtradas = new ArrayList<>();
		for (Planta p: plantas) {
			if(p.getNombre() == nombre) {
				filtradas.add(p);
			}
		}
		return filtradas;
	}
	
	protected List<Planta> plantasNoRegadas(){
		List<Planta> no_regadas = new ArrayList<>();
		for(Planta p:plantas) {
			if(p.getEstaRegada()==false) {
				no_regadas.add(p);
			}
		}
		return no_regadas;
	}
	
	public void regarPlantas() {
		List<Planta> l = plantasNoRegadas();
		for (Planta p : l) {
			p.setEstaRegada(true);
		}
	}
	@Override
	public String toString() {
		return "Vivero: [capacidad=" + capacidad + ", plantas=" + plantas + "]";
	}

	

}
