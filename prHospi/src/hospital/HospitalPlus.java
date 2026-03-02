package hospital;

import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class HospitalPlus extends Hospital {

	public HospitalPlus(String nombre, int plantas, int habs) {
		super(nombre, plantas, habs);
		// TODO Auto-generated constructor stub
	}
	public SortedMap<Integer, SortedSet<Paciente>> pacientesPorAno(){
		SortedMap<Integer, SortedSet<Paciente>> res = new TreeMap<>();
		for(Paciente p: habitaciones.keySet()) {
			int ano = p.getAnoDeNacimiento();
			if(res.containsKey(ano)) {
				SortedSet<Paciente> set = res.get(ano);
				set.add(p);
				res.put(ano, set);
			}else {
				SortedSet<Paciente> set = new TreeSet<>();
				set.add(p);
				res.put(ano, set);
			}
		}
		return res;
	}
	public SortedMap<Integer, Integer> numeroDePacientesPorAno(){
		SortedMap<Integer, Integer> res = new TreeMap<>();
		for(Paciente p: habitaciones.keySet()) {
			int ano = p.getAnoDeNacimiento();
			if(res.containsKey(ano)) {
				res.put(ano, res.get(ano)+1);
			}else {
				res.put(ano, 1);
			}
		}
		return res;
		
	}
}
