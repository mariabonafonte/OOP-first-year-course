package residencias;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import residentes.GradoDependencia;
import residentes.Residente;

public class ResidenciaLocal extends Residencia {
	private Map<GradoDependencia, Integer> mapGrado;
	

	public ResidenciaLocal() {
		this.mapGrado = new HashMap<>();
	}

	@Override
	public void almacenarEstadisticas(String nombreFichero) {
		procesarMapa();
		try (PrintWriter pw = new PrintWriter(nombreFichero)){
			for(GradoDependencia gp : mapGrado.keySet()) {
				pw.println(gp + ": " + mapGrado.get(gp) + " residentes");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void mostrarEstadisticas() {
		procesarMapa();
		
		for(GradoDependencia gp : mapGrado.keySet()) {
			System.out.println(gp + ": " + mapGrado.get(gp) + " residentes");
		}

	}
	
	private void procesarMapa() {
		mapGrado.clear();
		for(Residente r: conjuntoResidentes) {
			GradoDependencia g = r.getGradoDependencia();
			if(mapGrado.containsKey(g)) {
				mapGrado.put(g, mapGrado.get(g)+1);
			}else {
				mapGrado.put(g,1);
			}
		}
	}

}
