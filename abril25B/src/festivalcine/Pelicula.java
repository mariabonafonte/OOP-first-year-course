package festivalcine;

public class Pelicula {
	private String titulo;
	private String seccion;
	private int duracion;
	private String director;
	private int anio;
	
	public Pelicula(String titulo, String seccion, int duracion, String director, int anio) throws ExcepcionFestivalCine {
		super();
		this.titulo = titulo;
		this.seccion = seccion;
		setDuracion(duracion);
		this.director = director;
		setAnio(anio);
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) throws ExcepcionFestivalCine {
		if(duracion<75 || duracion>250) {
			throw new ExcepcionFestivalCine("Duracion inválida");
		}
		this.duracion = duracion;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) throws ExcepcionFestivalCine {
		if(anio<2023 || anio>2025) {
			throw new ExcepcionFestivalCine("Año inválido");
		}
		this.anio = anio;
	}

	@Override
	public String toString() {
		return "[" + titulo + ", " + seccion + ", " + duracion + ", "
				+ director + ", " + anio + "]";
	}
	
	
	
	
	

	
	
	

}
