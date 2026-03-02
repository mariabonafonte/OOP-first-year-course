package residencia;

import java.util.HashMap;
import java.util.Map;

import residentes.GradoDependencia;
import residentes.Residente;

public class ResidenciaLocal extends Residencia {
	private Map<GradoDependencia, Integer> mapGrado;

	public ResidenciaLocal() {
		mapGrado = new HashMap<>();
	}

	@Override
	public void almacenarEstadísticas(String nombreFichero) {
		cargarResidentes(nombreFichero);
		procesarInfo();
		

	}

	@Override
	public void mostrarEstadisticas() {
		procesarInfo();
		for (Map.Entry<GradoDependencia, Integer> entry : mapGrado.entrySet()) {
		    System.out.println(entry.getKey() + ": " + entry.getValue()+"residentes");
		}

	}
	private void procesarInfo() {
		for(Residente r:conjuntoResidentes) {
			GradoDependencia d = r.getGradodependencia();
			if(mapGrado.containsKey(d)) {
				mapGrado.put(d, mapGrado.get(d)+1);
			}else {
				mapGrado.put(d, 1);
			}
		}
	}

}
