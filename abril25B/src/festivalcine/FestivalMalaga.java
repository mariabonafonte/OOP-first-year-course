package festivalcine;

import java.util.ArrayList;
import java.util.List;

public class FestivalMalaga {
	private List<Pelicula> peliculas;
	

	public FestivalMalaga() {
		peliculas = new ArrayList <>();
	}


	public List<Pelicula> getPeliculas() {
		return peliculas;
	}
	
	public void addPelicula (Pelicula p) throws ExcepcionFestivalCine {
		if(peliculas.contains(p)) {
			throw new ExcepcionFestivalCine("Pelicula existente");
		}
		peliculas.add(p);
	}
	
	 public void removePelicula(String titulo) {
	        int indice = buscar(titulo);
	        if (indice != -1) {
	            peliculas.remove(indice);
	        }
	    }
		private int buscar(String titulo) {
			int i = 0;
			int res = -1;
			boolean encontrado = false;
			while (!encontrado && i < peliculas.size()) {
				Pelicula pelicula = peliculas.get(i);
				if (pelicula.getTitulo().equalsIgnoreCase(titulo)) {
					res = i;
					encontrado = true;
				}
				i++;
			}
			return res;
		}
	
	public void darPremio(String titulo, TipoPremio premio) throws ExcepcionFestivalCine {
		Pelicula p = buscadorPeli(titulo);
		if(p instanceof PeliculaPremiada) {
			((PeliculaPremiada) p).addPremio(premio);
		}else {
			PeliculaPremiada pp = new PeliculaPremiada(p.getTitulo(), p.getSeccion(), p.getDuracion(), p.getDirector(),p.getAnio());
			pp.addPremio(premio);
		}
	
	}
	
	private Pelicula buscadorPeli(String titulo) throws ExcepcionFestivalCine {
		Pelicula peli = null;
		for(Pelicula p: peliculas) {
			if(p.getTitulo().equalsIgnoreCase(titulo)) {
				peli = p;
			}
		}
		if(peli==null) {
			throw new ExcepcionFestivalCine("Pelicula inválida");
		} else return peli;
	}
	
	public List<Pelicula> verPeliculasPremiadas() {
		List<Pelicula> lista = new ArrayList<>();
		for(Pelicula p: peliculas) {
			if(p instanceof PeliculaPremiada) {
				lista.add(p);
			}
		}
		return lista;
		
		
	}


}
