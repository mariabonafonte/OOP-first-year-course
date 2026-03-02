package residencias;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;
import java.util.TreeMap;

import residentes.*;

public class ResidenciaAutonomica extends Residencia {

	private Map<GradoDependencia, HashSet<Provincia>> mapProvincia;

	public ResidenciaAutonomica() {
		super();
		mapProvincia = new TreeMap<>();
	}

	private void actualizarMap() {
		mapProvincia.clear();
		HashSet<Provincia> value;
		for (Residente r : conjuntoResidentes) {
			value = mapProvincia.get(r.getGradoDependencia());
			if (value == null) {
				value = new HashSet<Provincia>();
				value.add(r.getProvincia());
				mapProvincia.put(r.getGradoDependencia(), value);

			} else {
				value.add(r.getProvincia());
				mapProvincia.put(r.getGradoDependencia(), value);
			}

		}
	}

	private String listar() {
		actualizarMap();
		StringBuilder res = new StringBuilder("");
		StringJoiner sjProvincias;
		for (GradoDependencia gradoD : mapProvincia.keySet()) {
			sjProvincias = new StringJoiner(", ", "[", "]");
			for (Provincia p : mapProvincia.get(gradoD)) {
				sjProvincias.add(p.toString());
			}
			if (sjProvincias.toString().length() > 2)
				res.append(gradoD + ":" + sjProvincias.toString() + "\n");
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
