package vivero;

public class Planta {
	private String id;
	private String nombre;
	private int nivelHumedad;
	private boolean estaRegada;
	
	public Planta(String id, String n, int nivelHumedad, boolean regada) {
		
		if(nivelHumedad<0) {
			throw new RuntimeException("La humedad no puede ser negativa");
		}

		this.id = id;
		this.nombre = n;
		this.nivelHumedad = nivelHumedad;
		this.estaRegada = regada;
	}
	
		public Planta(String id, String n, int nivelHumedad) {
		
		if(nivelHumedad<0) {
			throw new RuntimeException("La humedad no puede ser negativa");
		}

		this.id = id;
		this.nombre = n;
		this.nivelHumedad = nivelHumedad;
		this.estaRegada = false;
	}

		protected int getNivelHumedad() {
			return nivelHumedad;
		}

		protected void setNivelHumedad(int nivelHumedad) {
			if(nivelHumedad<0) {
				throw new RuntimeException("La humedad no puede ser negativa");
			}
			this.nivelHumedad = nivelHumedad;
		}

		protected boolean getEstaRegada() {
			return estaRegada;
		}

		protected void setEstaRegada(boolean esta_Regada) {
			this.estaRegada = esta_Regada;
		}

		protected String getId() {
			return id;
		}

		protected String getNombre() {
			return nombre;
		}

		@Override
		public String toString() {
			return "(id:" + id + ", nombre:" + nombre + ", nivelHumedad:" + nivelHumedad + ", regada:" + estaRegada + ")";
		}
		
		
		
		
		
	
	

}
