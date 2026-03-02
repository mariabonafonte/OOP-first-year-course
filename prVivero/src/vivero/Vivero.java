package vivero;

import java.util.ArrayList;

public class Vivero {
	public final int capacidad;
	public ArrayList<Planta> plantas;
	
	public Vivero(int c) {
		this.capacidad = c;
		this.plantas = new ArrayList<>();
	}
	
	public Vivero(int c, ArrayList<Planta> plantas) {
		if (c <= 0 || c < plantas.size()) {
		    throw new RuntimeException("La capacidad debe ser mayor que 0 y al menos igual al número de plantas.");
		}
		this.capacidad = c;
		this.plantas = new ArrayList<>(plantas);
	}

	public int getCapacidad() {
		return capacidad;
	}

	public ArrayList<Planta> getPlantas() {
		return plantas;
	}
	
	private int numeroPlantas() {
		return plantas.size();
	}
	
	private int buscarPlanta(String p) {
		for(int i=0; i < plantas.size();i++) {
			if (plantas.get(i).equals(p)) {
				return i;
			}
		}
		return -1;
	}
	
	public void aniadirPlanta(Planta p) {
		if(plantas.size() >= capacidad) {
			throw new RuntimeException("El vivero no tiene capacidad para más plantas");
			
		}
		if(buscarPlanta(p.getId()) != -1) {
			throw new RuntimeException("Esta planta ya existe");
		}
		plantas.add(p);
	}
	
	public void aniadirPlanta(String id,String n, int humedad) {
		if(plantas.size() == capacidad) {
			throw new RuntimeException("El vivero no tiene capacidad para más plantas");
			
		}
		if(buscarPlanta(id) != -1) {
			throw new RuntimeException("Esta planta ya existe");
		}
		plantas.add(new Planta(id,n,humedad));
	}
	
	public void eliminarPlanta(String id) {
		int posicion = buscarPlanta(id);
		if(posicion == -1) {
			throw new RuntimeException("Esta planta no existe");
		}
		plantas.remove(posicion);
	}
	
	public ArrayList<Planta> buscarPlantaPorNombre (String nombre){
		ArrayList<Planta> filtradas =new ArrayList<>();
		for(Planta planta: plantas) {
			if(planta.toString().equals(nombre)) {
				filtradas.add(planta);
			}
		}
		return  filtradas;
	}
	
	protected ArrayList<Planta> plantasNoRegadas(){
		ArrayList<Planta> regadas =new ArrayList<>();
		for(Planta planta: plantas) {
			if(!planta.isEstaRegada()) {
				regadas.add(planta);
			}
		}
		return regadas;
	}
	
	public void regarPlantas() {
		for(Planta planta: plantas) {
			if(!planta.isEstaRegada()) {
				planta.setEstaRegada(true);
			}
		}
	}

	@Override
	public String toString() {
		return "Vivero [capacidad=" + capacidad + ", plantas=" + plantas + "]";
	}
	
	

	

}
