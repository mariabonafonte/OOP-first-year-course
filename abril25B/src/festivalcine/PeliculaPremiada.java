package festivalcine;

import java.util.ArrayList;
import java.util.List;

public class PeliculaPremiada extends Pelicula {
	private List<TipoPremio> premios;

	public PeliculaPremiada(String titulo, String seccion, int duracion, String director, int anio)
			throws ExcepcionFestivalCine {
		super(titulo, seccion, duracion, director, anio);
		premios = new ArrayList<>();
	}
	
	public void addPremio (TipoPremio premio) throws ExcepcionFestivalCine{
		if(!premios.contains(premio)) {
			premios.add(premio);
		}else throw new ExcepcionFestivalCine("Operacion inválida");
	}

	public List<TipoPremio> getPremios() {
		return premios;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString() + "premios=[");
		int cont=0;
		for(TipoPremio p: premios) {
			if(cont==0) {
				sb.append(p);
			}else sb.append(p + ",");
			cont+=1;
		}
		sb.append("]");
		return sb.toString();
	}
	
	
	
}
