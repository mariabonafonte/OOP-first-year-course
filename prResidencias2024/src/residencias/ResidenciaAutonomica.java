package residencias;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.StringJoiner;
import java.io.File;
import java.io.FileNotFoundException;

import residentes.ExcepcionResidente;
import residentes.GradoDependencia;
import residentes.Provincia;
import residentes.Residente;


public class ResidenciaAutonomica extends Residencia {
	private Map<GradoDependencia, HashSet<Provincia>> mapProvincia;

	public ResidenciaAutonomica() {
		mapProvincia = new HashMap<>();
	}

	@Override
	public void almacenarEstadisticas(String nombreFichero) {
		try (PrintWriter pw = new PrintWriter(new File(nombreFichero))){
			procesarMapa();
			for(GradoDependencia grado: mapProvincia.keySet()) {
				HashSet<Provincia> setProvincias = mapProvincia.get(grado);
				StringJoiner sj = new StringJoiner(",");
				for(Provincia p: setProvincias) {
					sj.add(p.toString());
				}
				pw.append(grado + ": [" + sj.toString() + "]");
			}
		} catch (FileNotFoundException e) {
			throw new ExcepcionResidente("No se han podido cargar los residentes");
		}
	}

	@Override
	public void mostrarEstadisticas() {
		procesarMapa();
		for(GradoDependencia grado: mapProvincia.keySet()) {
			HashSet<Provincia> setProvincias = mapProvincia.get(grado);
			StringJoiner sj = new StringJoiner(",");
			for(Provincia p: setProvincias) {
				sj.add(p.toString());
			}
			System.out.println(grado + ": [" + sj.toString() + "]");
		}
	}
	
	private void procesarMapa() {
		mapProvincia.clear();
		for(Residente r: conjuntoResidentes) {
			GradoDependencia grado = r.getGradoDependencia();
			Provincia prov = r.getProvincia();
			
			if(mapProvincia.containsKey(grado)){
				HashSet<Provincia> setProvincias = mapProvincia.get(grado);
				if(!setProvincias.contains(prov)) {
					setProvincias.add(prov);
					mapProvincia.put(grado, setProvincias);
				}
			}else {
				HashSet<Provincia> setProvincias = new HashSet<>();
				setProvincias.add(prov);
				mapProvincia.put(grado, setProvincias);
			}
		}
	}

}
