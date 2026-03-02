

import java.util.List;

import festivalcine.ExcepcionFestivalCine;
import festivalcine.FestivalMalaga;
import festivalcine.Pelicula;
import festivalcine.PeliculaPremiada;
import festivalcine.TipoPremio;



public class PruebaFestivalMalaga {
    public static void main(String[] args) {
        // Crear instancia del festival
        FestivalMalaga festival = new FestivalMalaga();

        // Añadir películas al festival
      
        System.out.println("Añadiendo películas al festival...");
        System.out.println("**********************************");
        try {
        	festival.addPelicula(new Pelicula("Aullar", "LARGOMETRAJES SECCIÓN OFICIAL FUERA DE CONCURSO", 90, "Sergio Siruela", 2025));
        	festival.addPelicula(new Pelicula("El diablo en el camino", "LARGOMETRAJES SECCIÓN OFICIAL A CONCURSO", 108, "Carlos Armella", 2024));
        	festival.addPelicula(new Pelicula("El Ladrón de Perros", "LARGOMETRAJES SECCIÓN OFICIAL A CONCURSO", 90, "Vinko Tomičić", 2024));
        	festival.addPelicula(new Pelicula("La furia", "LARGOMETRAJES SECCIÓN OFICIAL A CONCURSO", 107, "Gemma Blasco", 2025));
        	festival.addPelicula(new Pelicula("Lo que queda de ti", "LARGOMETRAJES SECCIÓN OFICIAL A CONCURSO", 91, "Gala Gracia", 2023));
        	festival.addPelicula(new Pelicula("Los Tortuga", "LARGOMETRAJES SECCIÓN OFICIAL A CONCURSO", 109, "Belén Funes", 2024));
        	festival.addPelicula(new Pelicula("Muy lejos", "LARGOMETRAJES SECCIÓN OFICIAL A CONCURSO", 100, "Gerard Oms", 2025));
        	festival.addPelicula(new Pelicula("Perros", "LARGOMETRAJES SECCIÓN OFICIAL A CONCURSO", 102, "Gerardo Minutti", 2025));
        	festival.addPelicula(new Pelicula("Sorda", "LARGOMETRAJES SECCIÓN OFICIAL A CONCURSO", 100, "Eva Libertad", 2025));
        	festival.addPelicula(new Pelicula("Sugar Island", "LARGOMETRAJES SECCIÓN OFICIAL A CONCURSO", 90, "Johanné Gómez Terrero", 2024));
        	festival.addPelicula(new Pelicula("Un año y un día", "LARGOMETRAJES SECCIÓN OFICIAL FUERA DE CONCURSO", 107, "Alex San Martín", 2024));


            System.out.println("Películas añadidas.");

            // Ver todas las películas (premiadas y no premiadas)
            System.out.println("\nTodas las películas (premiadas y no premiadas):");
            System.out.println("*************************************************");
           System.out.println(festival.toString());
           
            // Otorgar premios
            System.out.println("\nOtorgando premios...");
            System.out.println("**********************");
            festival.darPremio("Aullar",TipoPremio.BIZNAGA_MALAGA_CINEMA_MEJOR_ACTRIZ);
            festival.darPremio("Sorda", TipoPremio.BIZNAGA_ORO_MEJOR_PELICULA_ESPANOLA);
            festival.darPremio("Sorda", TipoPremio.PREMIO_DEL_PUBLICO);
            festival.darPremio("Sorda", TipoPremio.MEJOR_INTERPRETACION_FEMENINA);
            festival.darPremio("Sorda", TipoPremio.MEJOR_INTERPRETACION_MASCULINA);
            festival.darPremio("El Ladrón de Perros", TipoPremio.BIZNAGA_ORO_MEJOR_PELICULA_IBEROAMERICANA);
            festival.darPremio("La furia", TipoPremio.MEJOR_INTERPRETACION_FEMENINA);
            festival.darPremio("La furia", TipoPremio.MEJOR_INTERPRETACION_MASCULINA_REPARTO);
            festival.darPremio("La furia", TipoPremio.MEJOR_MONTAJE);
            festival.darPremio("Muy lejos", TipoPremio.MEJOR_INTERPRETACION_MASCULINA);
            festival.darPremio("Muy lejos", TipoPremio.PREMIO_ESPECIAL_DEL_JURADO_CRITICA);
            festival.darPremio("Los Tortuga", TipoPremio.MEJOR_DIRECCION);
            festival.darPremio("Los Tortuga", TipoPremio.MEJOR_GUION);
            festival.darPremio("Los Tortuga", TipoPremio.PREMIO_ESPECIAL_DEL_JURADO);
            festival.darPremio("Perros", TipoPremio.MEJOR_INTERPRETACION_FEMENINA_REPARTO);
            festival.darPremio("Lo que queda de ti", TipoPremio.MEJOR_MUSICA);
            festival.darPremio("Sugar Island", TipoPremio.MEJOR_FOTOGRAFIA);
            

            System.out.println("Premios otorgados.");

            // Ver películas premiadas
            System.out.println("\nPelículas premiadas:");
            System.out.println("**********************");
            List<Pelicula> peliculasPremiadas = festival.verPeliculasPremiadas();
            MostrarPeliculas(festival.verPeliculasPremiadas());

            // Probar excepción al otorgar premio a una película no existente
            System.out.println("\nProbando excepción al otorgar premio a una película no existente...");
            System.out.println("*********************************************************************");
            try {
                festival.darPremio("Película No Existente", TipoPremio.BIZNAGA_ORO_MEJOR_PELICULA_ESPANOLA);
            } catch (ExcepcionFestivalCine e) {
                System.out.println("Error: " + e.getMessage());
            }

            // Probar eliminación de películas
            System.out.println("\nEliminando películas del festival...");
            System.out.println("**************************************");
            festival.removePelicula("Sorda");
            festival.removePelicula("El Ladrón de Perros");
            festival.removePelicula("El diablo en el camino");
            festival.removePelicula("La Furia");
            festival.removePelicula("Muy lejos");
            festival.removePelicula("Los Tortuga");
            festival.removePelicula("PERROS");
            
            System.out.println("Películas eliminadas. Han quedado...");

           MostrarPeliculas(festival.getPeliculas());
        } catch (ExcepcionFestivalCine e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public static void MostrarPeliculas(List<Pelicula> peliculas) {
    	for (Pelicula pelicula:peliculas)  {
    		System.out.println(pelicula);
    	}
    }
}
