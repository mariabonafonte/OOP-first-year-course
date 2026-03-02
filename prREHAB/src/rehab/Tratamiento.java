package rehab;

public class Tratamiento {
	private int frecuencia;
	private int ganancia;
	private double duracion;
	private int subida;
	private int bajada;
	private int espera;

	public Tratamiento(int frecuencia, int ganancia, double duracion, int subida, int bajada, int espera) {
		if(frecuencia<1 || frecuencia>1000) {
			throw new RuntimeException("Frecuencia inválida");
		}
		if(ganancia<0 || ganancia>5) {
			throw new RuntimeException("Ganancia inválida");
		}
		if(duracion<1.00 || duracion>600.00) {
			throw new RuntimeException("Duracion inválida");
		}
		if(subida<0 || subida>300) {
			throw new RuntimeException("Subida inválida");
		}
		if(bajada<0 || bajada>300) {
			throw new RuntimeException("Bajada inválida");
		}
		if(espera<0 || espera>1200) {
			throw new RuntimeException("Espera inválida");
		}
		
		this.frecuencia = frecuencia;
		this.ganancia = ganancia;
		this.duracion = duracion;
		this.subida = subida;
		this.bajada = bajada;
		this.espera = espera;
	}

	public int getFrecuencia() {
		return frecuencia;
	}

	public void setFrecuencia(int frecuencia) {
		if(frecuencia<1 || frecuencia>1000) {
			throw new RuntimeException("Frecuencia inválida");
		}
		this.frecuencia = frecuencia;
	}

	public int getGanancia() {
		return ganancia;
	}

	public void setGanancia(int ganancia) {
		if(ganancia<0 || ganancia>5) {
			throw new RuntimeException("Ganancia inválida");
		}
		this.ganancia = ganancia;
	}

	public double getDuracion() {
		return duracion;
	}

	public void setDuracion(double duracion) {
		if(duracion<1.00 || duracion>600.00) {
			throw new RuntimeException("Duracion inválida");
		}
		this.duracion = duracion;
	}

	public int getSubida() {
		return subida;
	}

	public void setSubida(int subida) {
		if(subida<0 || subida>300) {
			throw new RuntimeException("Subida inválida");
		}
		this.subida = subida;
	}

	public int getBajada() {
		return bajada;
	}

	public void setBajada(int bajada) {
		if(bajada<0 || bajada>300) {
			throw new RuntimeException("Bajada inválida");
		}
		this.bajada = bajada;
	}

	public int getEspera() {
		return espera;
	}

	public void setEspera(int espera) {
		if(espera<0 || espera>1200) {
			throw new RuntimeException("Espera inválida");
		}
		this.espera = espera;
	}

	@Override
	public String toString() {
		return "(f:" + frecuencia + "g:" + ganancia + "d:" + duracion
				+ "s:" + subida + "b:" + bajada + "e:" + espera + ")";
	}
	
	
	
	

}
