import festivalcine.ExcepcionFestivalCine;
import festivalcine.Pelicula;

/**
 * Clase de prueba sencilla para la clase Pelicula.
 */
public class PruebaPelicula {
	public static void main(String[] args) {
		// Probando constructor con parámetros
		System.out.println("Probando constructor con parámetros...");
		Pelicula pelicula1 = null, pelicula2=null, pelicula3=null;
		try {
			pelicula1 = new Pelicula("Culpa Cero", "LARGOMETRAJES SECCIÓN OFICIAL A CONCURSO", 110,
					"Valeria Bertuccelli", 2024);
			pelicula2 = new Pelicula("El cielo de los animales", "LARGOMETRAJES SECCIÓN OFICIAL A CONCURSO", 84,
					"Santi Amodeo", 2024);
		} catch (ExcepcionFestivalCine e) {
			System.out.println("Error: " + e.getMessage());
		}
		try {
			System.out.println("Probando pelicula que debe dar error");
			pelicula3 = new Pelicula("El diablo en el camino", "LARGOMETRAJES SECCIÓN OFICIAL A CONCURSO", 108,
					"Carlos Armella", 2000);
		} catch (ExcepcionFestivalCine e) {
			System.err.println("Error: " + e.getMessage());
		}
		System.out.println("Películas creadas.");

		// Probando getters
		System.out.println("\nProbando getters...");
		System.out.println("Título de pelicula1: " + pelicula1.getTitulo());
		System.out.println("Sección de pelicula1: " + pelicula1.getSeccion());
		System.out.println("Duración de pelicula1: " + pelicula1.getDuracion());
		System.out.println("Director de pelicula1: " + pelicula1.getDirector());
		System.out.println("Año de pelicula1: " + pelicula1.getAnio());

		// Probando setters
		try {
		System.out.println("\nProbando setters...");
		pelicula1.setTitulo("Culpa Cero (Actualizado)");
		pelicula1.setSeccion("SECCIÓN ACTUALIZADA");
		pelicula1.setDuracion(115);
		pelicula1.setDirector("Nuevo Director");
		pelicula1.setAnio(2025);
		System.out.println("Título actualizado de pelicula1: " + pelicula1.getTitulo());
		System.out.println("Sección actualizada de pelicula1: " + pelicula1.getSeccion());
		System.out.println("Duración actualizada de pelicula1: " + pelicula1.getDuracion());
		System.out.println("Director actualizado de pelicula1: " + pelicula1.getDirector());
		System.out.println("Año actualizado de pelicula1: " + pelicula1.getAnio());
		}  catch (ExcepcionFestivalCine e) {
            System.err.println("Error: " + e.getMessage());
		}
		
		// Probando errores en setters
		  try {
              pelicula1.setAnio(2000);
          } catch (ExcepcionFestivalCine e) {
              System.err.println("Error al actualizar el año de pelicula1: " + e.getMessage());
          }

          try {
              pelicula2.setDuracion(60);
          } catch (ExcepcionFestivalCine e) {
              System.err.println("Error al actualizar la duración de pelicula2: " + e.getMessage());
          }
		
		// Probando toString
		System.out.println("\nProbando toString...");
		System.out.println(pelicula1.toString());
		System.out.println(pelicula2.toString());
		
		
		
	}
}