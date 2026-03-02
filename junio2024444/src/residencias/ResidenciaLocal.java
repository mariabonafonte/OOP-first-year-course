package residencias;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.io.File;
import java.io.PrintWriter;

import residentes.GradoDependencia;
import residentes.Residente;

public class ResidenciaLocal extends Residencia {
	private Map<GradoDependencia, Integer> mapGrado;

	public ResidenciaLocal() {
		mapGrado = new HashMap<>();
	}

	@Override
	public void almacenarEstadisticas(String nombreFichero) {
		procesar();
		try (PrintWriter pw = new PrintWriter(new File(nombreFichero))) {
			for(Entry<GradoDependencia, Integer> entrada : mapGrado.entrySet()) {
				GradoDependencia g = entrada.getKey();
				int num = entrada.getValue();
				pw.append(g + ":" + num + "residentess");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	@Override
	public void mostrarEstadisticas() {
		for(Entry<GradoDependencia, Integer> entrada : mapGrado.entrySet()) {
			GradoDependencia g = entrada.getKey();
			int num = entrada.getValue();
			System.out.println(g + ":" + num + "residentes");
		}
	}
			

	
	private void procesar() {
		mapGrado.clear();
		for(Residente r: conjuntoResidentes) {
			GradoDependencia g = r.getGradoDependencia();
			if(mapGrado.containsKey(g)) {
				mapGrado.put(g, mapGrado.get(g) +1);
			}else {
				mapGrado.put(g, 1);
			}
			// aquí podría hacer un getOrDefault 
		}
	}

}
