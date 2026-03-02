package canciones;

import java.util.List;

public class Cancion {
	private String titulo;
	private List<String> interpretes;
	private int duracion;
	private Estilo estilo;
	
	public Cancion(String titulo, List<String> interpretes, int duracion, Estilo estilo) {
		if(duracion<=0) {
			throw new RuntimeException("La cancion debe tener una duracion positiva");
		}
		this.titulo = titulo;
		this.interpretes = interpretes;
		this.duracion = duracion;
		this.estilo = estilo;
	}

	public Cancion(String titulo, List<String> interpretes, int duracion) {
		super();
		this.titulo = titulo;
		this.interpretes = interpretes;
		this.duracion = duracion;
		this.estilo = Estilo.OTRO;
	}

	public String getTitulo() {
		return titulo;
	}

	public List<String> getInterpretes() {
		return interpretes;
	}

	public int getDuracion() {
		return duracion;
	}

	public Estilo getEstilo() {
		return estilo;
	}

	@Override
	public String toString() {
		return titulo + ";" + interpretes + ";" + duracion + ";" + estilo;
	}
	
	
	
	
	

}
