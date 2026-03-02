
import pruebas.*;

import java.util.*;

public class MainResultados {
	public static void main(String[] args) {
		try {
			Set<Practica> practicas = new HashSet<Practica>();
			practicas.add(new Practica("Practica", "pr1", 35, 0));
			practicas.add(new Practica("Practica", "pr2", 45, 0));
			practicas.add(new Practica("Practica", "pr3", 55, 0));
			Resultados resultados = new Resultados(practicas);
			resultados.cargarDeFichero("datos.txt");
			//----------------------
			System.out.println();
			System.out.println(resultados);
			//----------------------
			resultados.completarPracticas();
			//----------------------
			System.out.println();
			System.out.println(resultados);
			//----------------------
			resultados.guardarEnFichero("salida.txt");
			//----------------------
			Set<String> spr = new HashSet<>(Arrays.asList("ana luisa", "maria luisa"));
			System.out.println();
			System.out.println(resultados.seleccionar(new SelectorNombre(spr)));
			//----------------------
			System.out.println();
			System.out.println(resultados.seleccionar(new SelectorUmbralExito(20)));
			//----------------------
			resultados.anyadirPractica(new Practica("xxx", "xxx"));
			//----------------------
		} catch (Exception e) {
			System.out.println();
			System.out.println("Error: " + e.getMessage());
		}
	}
}
