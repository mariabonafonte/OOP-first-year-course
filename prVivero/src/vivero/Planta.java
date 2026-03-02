package vivero;

public class Planta {
	private String id;
	private String nombre;
	private int nivelHumedad;
	private boolean estaRegada;
	
	public Planta(String id, String nombre, int nivelHumedad, boolean regada) {
		super();
		if (nivelHumedad < 0) {
		    throw new RuntimeException("El nivel de humedad no puede ser negativo");
		}
		this.id = id;
		this.nombre = nombre;
		this.nivelHumedad = nivelHumedad;
		this.estaRegada = regada;
	}
	
	public Planta(String id, String nombre, int nivelHumedad) {
		super();
		if (nivelHumedad < 0) {
		    throw new RuntimeException("El nivel de humedad no puede ser negativo");
		}
		this.id = id;
		this.nombre = nombre;
		this.nivelHumedad = nivelHumedad;
		this.estaRegada = false;
	}

	public int getNivelHumedad() {
		return nivelHumedad;
	}

	public void setNivelHumedad(int nivelHumedad) {
		if (nivelHumedad < 0) {
		    throw new RuntimeException("El nivel de humedad no puede ser negativo");
		}
		this.nivelHumedad = nivelHumedad;
	}

	public boolean isEstaRegada() {
		return estaRegada;
	}

	public void setEstaRegada(boolean estaRegada) {
		this.estaRegada = estaRegada;
	}

	public String getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public String toString() {
		return "(id:" + id + ", nombre:" + nombre + ", nivelHumedad:" + nivelHumedad + ", estaRegada:"+ estaRegada + ")";
	}
	
}

