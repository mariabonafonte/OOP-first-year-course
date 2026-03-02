import java.util.SortedSet;
import java.util.TreeSet;

import pruebas.Practica;

public class MainPractica {
	
	public static void main(String[] args) {
		Practica p1 = new Practica("Pepe", "pr1", 20, 15);
		Practica p2 = new Practica("pepe", "PR1", 22, 10);
		Practica p3 = new Practica("paco", "pr3", 25, 12);
		Practica p4 = new Practica("paco", "pr4", 30, 17);
		
		if(p1.equals(p2)) {
			System.out.println("iguales");
		}else{
			System.out.println("distintas");
		}
		if(p2.equals(p3)) {
			System.out.println("iguales");
		}else{
			System.out.println("distintas");
		}
		if(p3.equals(p4)) {
			System.out.println("iguales");
		}else{
			System.out.println("distintas");
		}
		
		p1.setCntExito(18);
		p3.setCntRealizadas(40);
		
		SortedSet<Practica> conjunto = new TreeSet<>();
		conjunto.add(p1);
		conjunto.add(p2);
		conjunto.add(p3);
		conjunto.add(p4);
		
		System.out.println(conjunto);
		
	
	}

}
