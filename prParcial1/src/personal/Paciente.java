package personal;

import java.util.ArrayList;

import alergias.Alergia;
import alergias.AlergiasException;

public class Paciente {
	private final String nombre;
	private int edad;
	private ArrayList<Alergia> alergias;
	
	public Paciente(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		alergias = new ArrayList<>();
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public ArrayList<Alergia> getAlergias() {
		return alergias;
	}
	
	public boolean addAlergia(Alergia al) {
		boolean estado = true;
		
		if(al == null) {
			throw new AlergiasException("No se puede añadir una alergia sin inicializar");
		}
		
		for (Alergia a: alergias) {
			if(a.equals(al)) {
				estado = false;
			}
		}
				
		if (estado) {
			alergias.add(al);
		}
		
		return estado;	
	}
	
	
	public boolean removeAlergia(Alergia al) {
		boolean cambios = false;
		
		for (Alergia alergia: alergias) {
			if(alergia.equals(al)) {
				cambios = true;
				alergias.remove(al);
			}	
		}
		return cambios;	
	}
	
	public ArrayList<Alergia> alergiasSeveridad (int umbral){
		ArrayList<Alergia> lista_severidad = new ArrayList<> () ;
		
		for(Alergia alergia: alergias) {
			if(alergia.getSeveridad() >= umbral) {
				lista_severidad.add(alergia);
			}
		}
		
		return lista_severidad;
	}
	


	 @Override
	    public String toString() {
	        StringBuilder sb = new StringBuilder();
	        sb.append("--Paciente--\n");
	        sb.append("Nombre: ").append(nombre).append("\n");
	        sb.append("Edad: ").append(edad).append("\n");
	        sb.append("Alergias:\n");

	        for (Alergia alergia : alergias) {
	            sb.append(alergia).append("\n");
	        }

	        return sb.toString();
	    }
	
	
	

	

}
