package owo;

import java.util.ArrayList;
import java.util.List;

public class MicroSensacionMusculos extends MicroSensacion {
	List<Musculo> musculos;

	public MicroSensacionMusculos(int frecuencia, int intensidad, double duracion, int fadeIn, int fadeOut,
			double exitTime) {
		super(frecuencia, intensidad, duracion, fadeIn, fadeOut, exitTime);
		this.musculos = new ArrayList<>();
	}
	public MicroSensacionMusculos(int frecuencia, int intensidad, double duracion, int fadeIn, int fadeOut,
			double exitTime, List<Musculo> musculos) {
		super(frecuencia, intensidad, duracion, fadeIn, fadeOut, exitTime);
		this.musculos = musculos;
	}
	public List<Musculo> getMusculos() {
		return musculos;
	}
	
	public boolean addMusculo (Musculo musculo) {
		for(Musculo m: musculos) {
			if(m.equals(musculo)) {
				return false;
			}
		}
		musculos.add(musculo);
		return true;
	}
	
	public boolean remMusculo (Musculo musculo) {
		for(Musculo m: musculos) {
			if(m.equals(musculo)) {
				musculos.remove(musculo);
				return true;
			}
		}
		return false;
	}
	@Override
	public String toString() {
		return "(f:" + super.getFrecuencia() + "i:" + super.getIntensidad() + "d:" 
				+ super.getDuracion() + "fi:" + super.getFadeIn() + "fo:" + super.getFadeOut() 
				+ "e:" + super.getExitTime() + ")"
				+ "- Músculos:" + musculos;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
