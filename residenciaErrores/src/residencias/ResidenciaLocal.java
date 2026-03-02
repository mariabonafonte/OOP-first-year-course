package residencias;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;

import residentes.GradoDependencia;
import residentes.Residente;

public class ResidenciaLocal extends Residencia {

	private Map<GradoDependencia, Integer> mapGrado;

	public ResidenciaLocal() {
		super();
		mapGrado = new TreeMap<>();
	}

	private void actualizarMap() {
		mapGrado.clear();
		Integer value;
		for (Residente r : conjuntoResidentes) {
			value = mapGrado.getOrDefault(r.getGradoDependencia(), 0);
			mapGrado.put(r.getGradoDependencia(), value + 1);		
		}

	}

	private String listar() {
		actualizarMap();
		Integer aux;
		StringBuilder res = new StringBuilder("");
		for (GradoDependencia gradoD : mapGrado.keySet()) {
			aux = mapGrado.get(gradoD);
			res.append(gradoD + ": " + aux + " residente" + (aux > 1 ? "s\n" : "\n"));
		}
		return res.toString();
	}

	@Override
	public void almacenarEstadisticas(String nombreFichero) {
		try (PrintWriter pw = new PrintWriter(new File(nombreFichero))) {
			pw.println(listar());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void mostrarEstadisticas() {
		System.out.println(listar());
	}

}
