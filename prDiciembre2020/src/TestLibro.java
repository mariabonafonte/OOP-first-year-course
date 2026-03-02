import java.util.List;

import bibliotecas.Libro;

public class TestLibro {

	public static void main(String[] args) {
		Libro l1 = new Libro("Inteligencia Artificial: un enfoque moderno", List.of("Stuart Russell","Peter Norvig"), "842054003X" , 2013); {
		Libro l2 = new Libro("Inteligencia Artificial: Un Enfoque Moderno", List.of(), "978-8420540030" , 2013);
		System.out.println(l1);
		System.out.println(l2);
		
		if(l1.equals(l2)) {
			System.out.println("Los libros son iguales");
		}
		}

	}
}	
