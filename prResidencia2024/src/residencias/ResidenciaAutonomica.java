package residencias;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeSet;

import residentes.GradoDependencia;
import residentes.Provincia;
import residentes.Residente;


public class ResidenciaAutonomica extends Residencia {
	private Map<GradoDependencia,HashSet<Provincia>> mapProvincia;

	public ResidenciaAutonomica() {
		this.mapProvincia = new HashMap<>();
	}

	@Override
	public void almacenarEstadisticas(String nombreFichero) {
		procesarMapa();
		try (PrintWriter pw = new PrintWriter(nombreFichero)){
			for(GradoDependencia gp: mapProvincia.keySet()) {
				System.out.println(gp + ": " + mapProvincia.get(gp) );
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void mostrarEstadisticas() {
		procesarMapa();
		for(GradoDependencia gp: mapProvincia.keySet()) {
			System.out.println(gp + ": " + mapProvincia.get(gp));
		}

	}
	
	private void procesarMapa() {
		mapProvincia.clear();
		for(Residente r: conjuntoResidentes) {
			GradoDependencia g = r.getGradoDependencia();
			if(mapProvincia.containsKey(g)) {
				HashSet<Provincia> set = mapProvincia.get(g);
				set.add(r.getProvincia());
				mapProvincia.put(g, set);
			}else {
				HashSet<Provincia> set = new HashSet<>();
				set.add(r.getProvincia());
				mapProvincia.put(g, set);
			}
		}
	}

}
