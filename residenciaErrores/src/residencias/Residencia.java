package residencias;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;

import residentes.Residente;

public abstract class Residencia implements ResidenciaInterfaz {
	protected TreeSet<Residente> conjuntoResidentes;
	
	public Residencia() {
		super();
		conjuntoResidentes = new TreeSet<>();
	}

	@Override
	public void agregarResidente(Residente r) { 
		conjuntoResidentes.add(r);
	}

	@Override
	public void cargarResidentes(String fileName) {
		try (Scanner sc = new Scanner(new File(fileName))) {
			Residente res;
			while (sc.hasNextLine()) {
				res = Residente.toResidente(sc.nextLine());
				conjuntoResidentes.add(res);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Residentes:\n");
		for (Residente r : conjuntoResidentes) {
			sb.append(r + "\n");
		}
		return sb.toString();
	}


}
