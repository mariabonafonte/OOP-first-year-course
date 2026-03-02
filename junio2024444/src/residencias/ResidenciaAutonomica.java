package residencias;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import residentes.GradoDependencia;
import residentes.Residente;
import residentes.Provincia;

public class ResidenciaAutonomica extends Residencia{
	private Map<GradoDependencia, HashSet<Provincia>> mapProvincia;
	

	public ResidenciaAutonomica() {
		mapProvincia = new HashMap<>();
	}


	@Override
	public void almacenarEstadisticas(String nombreFichero) {
		procesar();
		try (PrintWriter pw = new PrintWriter(new File(nombreFichero))) {
			for(Entry<GradoDependencia, HashSet<Provincia>> entrada : mapProvincia.entrySet()) {
				GradoDependencia g = entrada.getKey();
				HashSet<Provincia> p = entrada.getValue();
				pw.append(g + ":" + p);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	@Override
	public void mostrarEstadisticas() {
		procesar();
		for(Entry<GradoDependencia, HashSet<Provincia>> entrada : mapProvincia.entrySet()) {
			GradoDependencia g = entrada.getKey();
			HashSet<Provincia> p = entrada.getValue();
			System.out.println(g + ":" + p);
		}
	}
		
	private void procesar() {
		mapProvincia.clear();
		for(Residente r: conjuntoResidentes) {
			GradoDependencia g = r.getGradoDependencia();
			if(mapProvincia.containsKey(g)) {
				HashSet<Provincia> p = mapProvincia.get(g);
				if(!p.contains(r.getProvincia())) {
					p.add(r.getProvincia());
					mapProvincia.put(g, p);
				}	
			}else {
				HashSet<Provincia> p = new HashSet<>();
				p.add(r.getProvincia());
				mapProvincia.put(g, p);
				
			}
		}
	}

}
