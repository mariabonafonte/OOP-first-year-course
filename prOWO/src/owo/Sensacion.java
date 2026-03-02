package owo;

import java.util.ArrayList;
import java.util.List;

public class Sensacion {
	List<MicroSensacion> microsensaciones;
	
	public Sensacion() {
		// TODO Auto-generated constructor stub
	}

	public Sensacion(List<MicroSensacion> microsensaciones) {
		this.microsensaciones = microsensaciones;
	}
	
	public void addMicroSensacion(MicroSensacion ms) {
		 if (this.microsensaciones == null) {
	            this.microsensaciones = new ArrayList<>();
	        }
		microsensaciones.add(ms);
	}

	@Override
	public String toString() {
		return "[" + microsensaciones + "]";
	}
	
	
	

}
