package residencias;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.io.FileNotFoundException;

import residentes.ExcepcionResidente;
import residentes.GradoDependencia;
import residentes.Residente;

public class ResidenciaLocal extends Residencia {
	private Map<GradoDependencia, Integer> mapGrado;

	public ResidenciaLocal() {
		mapGrado = new HashMap<>();
	}

	@Override
	public void almacenarEstadisticas(String nombreFichero) {
		try (PrintWriter pw = new PrintWriter(new File(nombreFichero))){
			procesarMapa();
			for(GradoDependencia grado: mapGrado.keySet()) {
				int num = mapGrado.get(grado);
				pw.append(grado + ": " + num + "residentes");
			}
		} catch (FileNotFoundException e) {
			throw new ExcepcionResidente("No se han podido cargar los residentes");
		}
	}

	@Override
	public void mostrarEstadisticas() {
		procesarMapa();
		for(GradoDependencia grado: mapGrado.keySet()) {
			int num = mapGrado.get(grado);
			System.out.println(grado + ": " + num + " residentes");
		}
	}
	
	private void procesarMapa() {
		mapGrado.clear();
		for(Residente r: conjuntoResidentes) {
			GradoDependencia grado = r.getGradoDependencia();
			if(mapGrado.containsKey(grado)){
				mapGrado.put(grado, mapGrado.get(grado)+1);
			}else {
				mapGrado.put(grado, 1);
			}
		}
	}

}
