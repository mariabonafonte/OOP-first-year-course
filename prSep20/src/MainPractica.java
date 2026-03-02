import java.util.HashSet;
import java.util.Set;

import pruebas.Practica;

public class MainPractica {

	public static void main(String[] args) {
		Practica p1 = new Practica("Pepe", "pr1", 20, 15);
		Practica p2 = new Practica("pepe", "PR1", 22, 10);
		Practica p3 = new Practica ("paco", "pr3", 25, 12);
		Practica p4 = new Practica ("paco", "pr4", 30, 17);
	
	if(p1.equals(p2)) {
		System.out.println("iguales");
	}else {
		System.out.println("distintas");
	}
	if(p3.equals(p4)) {
		System.out.println("iguales");
	}else {
		System.out.println("distintas");
	}
	
	p1.setCntExito(18);
	p3.setCntRealizadas(40);
	
	Set<Practica> s = new HashSet<>();
	s.add(p1);
	s.add(p2);
	s.add(p3);
	s.add(p4);
	System.out.println(s);
	}

}
