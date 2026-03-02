package residencia;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import residentes.GradoDependencia;
import residentes.Provincia;
import residentes.Residente;


public class ResidenciaAutonomica extends Residencia {
	private Map<GradoDependencia, HashSet<Provincia> > mapProvincia;

	public ResidenciaAutonomica() {
		mapProvincia = new HashMap<>();
	}

	@Override
	public void almacenarEstadísticas(String nombreFichero) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mostrarEstadisticas() {
		procesarInfo();
		for (Map.Entry<GradoDependencia, HashSet<Provincia> entry : mapProvincia.entrySet()) {
		    System.out.println(entry.getKey() + ": [" + entry.getValue()+"]");
		}

	}
	
	private void procesarInfo() {
		for(Residente r:conjuntoResidentes) {
			GradoDependencia d = r.getGradodependencia();
			if(mapProvincia.containsKey(d)) {
				//mapGrado.put(d, mapGrado.get(d)+1);
				
			}else {
				//mapGrado.put(d, 1);
			}
		}
	}

}
