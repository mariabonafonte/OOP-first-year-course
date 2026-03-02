package owo;

public class MicroSensacion {
	private int frecuencia;
	private int intensidad;
	private double duracion;
	private int fadeIn;
	private int fadeOut;
	private double exitTime;
	
	public MicroSensacion(int frecuencia, int intensidad, double duracion, int fadeIn, int fadeOut, double exitTime) {
		if(frecuencia < 1 || frecuencia > 100) {
			throw new RuntimeException("Introduce una frecuencia válida");
		}
		if(intensidad < 1 || intensidad > 100) {
			throw new RuntimeException("Introduce una intensidad válida");
		}
		if(duracion < 0.1 || duracion > 5.00) {
			throw new RuntimeException("Introduce una duracion válida");
		}
		if(fadeIn < 0 || fadeIn > 2000) {
			throw new RuntimeException("Introduce un FadeIn válido");
		}
		if(fadeOut < 0 || fadeOut > 2000) {
			throw new RuntimeException("Introduce un FadeOut válido");
		}
		if(exitTime < 0 || exitTime > 2.00) {
			throw new RuntimeException("Introduce un exitTime válido");
		}
		this.frecuencia = frecuencia;
		this.intensidad = intensidad;
		this.duracion = duracion;
		this.fadeIn = fadeIn;
		this.fadeOut = fadeOut;
		this.exitTime = exitTime;
	}

	public int getFrecuencia() {
		return frecuencia;
	}

	public void setFrecuencia(int frecuencia) {
		if(frecuencia < 1 || frecuencia > 100) {
			throw new RuntimeException("Introduce una frecuencia válida");
		}
		this.frecuencia = frecuencia;
	}

	public int getIntensidad() {
		return intensidad;
	}

	public void setIntensidad(int intensidad) {
		if(intensidad < 1 || intensidad > 100) {
			throw new RuntimeException("Introduce una intensidad válida");
		}
		this.intensidad = intensidad;
	}

	public double getDuracion() {
		return duracion;
	}

	public void setDuracion(double duracion) {
		if(duracion < 0.1 || duracion > 5.00) {
			throw new RuntimeException("Introduce una duracion válida");
		}
		this.duracion = duracion;
	}

	public int getFadeIn() {
		return fadeIn;
	}

	public void setFadeIn(int fadeIn) {
		if(fadeIn < 0 || fadeIn > 2000) {
		throw new RuntimeException("Introduce un FadeIn válido");
	}
		this.fadeIn = fadeIn;
	}

	public int getFadeOut() {
		return fadeOut;
	}

	public void setFadeOut(int fadeOut) {
		if(fadeOut < 0 || fadeOut > 2000) {
			throw new RuntimeException("Introduce un FadeOut válido");
		}
		this.fadeOut = fadeOut;
	}

	public double getExitTime() {
		return exitTime;
	}

	public void setExitTime(double exitTime) {
		if(exitTime < 0 || exitTime > 2.00) {
			throw new RuntimeException("Introduce un exitTime válido");
		}
		this.exitTime = exitTime;
	}

	@Override
	public String toString() {
		return "(f:" + frecuencia + "i:" + intensidad + "d:" + duracion + "fi:" + fadeIn + "fo:" + fadeOut + "e:" + exitTime + ")";
	}

	

}
