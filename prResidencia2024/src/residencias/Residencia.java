package residencias;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;

import residentes.Residente;

public abstract class Residencia implements ResidenciaInterfaz{
	protected TreeSet<Residente> conjuntoResidentes;

	public Residencia() {
		this.conjuntoResidentes = new TreeSet<>();
	}

	@Override
	public void agregarResidente(Residente r) {
		conjuntoResidentes.add(r);
		
	}

	@Override
	public void cargarResidentes(String fileName) {
		try(Scanner sc = new Scanner(new File(fileName))){
			while(sc.hasNextLine()) {
				agregarResidente(Residente.toResidente(sc.nextLine()));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Residente r: conjuntoResidentes) {
			sb.append(r.toString() + "\n");
		}
		return sb.toString();
	}
	
	
}