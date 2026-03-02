import prLibreria.Libreria;
import prLibreria.LibreriaOfertaFlex;
import prLibreria.OfertaAutor;

public class PruebaLibreriaOfertaFlex {

	public static void main(String[] args) {

        OfertaAutor oferta = new OfertaAutor(20, new String[] {"George Orwell", "Isaac Asimov"});
        LibreriaOfertaFlex libreria = new LibreriaOfertaFlex(oferta);

        libreria.addLibro("george orwell", "1984", 8.20);
        libreria.addLibro("Philip K. Dick", "¿Sueñan los androides con ovejas eléctricas?", 3.50);
        libreria.addLibro("Isaac Asimov", "Fundación e Imperio", 9.40);
        libreria.addLibro("Ray Bradbury", "Fahrenheit 451", 7.40);
        libreria.addLibro("Aldous Huxley", "Un Mundo Feliz", 6.50);
        libreria.addLibro("Isaac Asimov", "La Fundación", 7.30);
        libreria.addLibro("William Gibson", "Neuromante", 8.30);
        libreria.addLibro("Isaac Asimov", "Segunda Fundación", 8.10);
        libreria.addLibro("Isaac Newton", "arithmetica universalis", 7.50);
        libreria.addLibro("George Orwell", "1984", 6.20);
        libreria.addLibro("Isaac Newton", "Arithmetica Universalis", 10.50);

        System.out.println(libreria);
        System.out.println();
        libreria.remLibro("George Orwell", "1984");
        libreria.remLibro("Aldous Huxley", "Un Mundo Feliz");
        libreria.remLibro("Isaac Newton", "Arithmetica Universalis");
        libreria.remLibro("James Gosling", "The Java Language Specification");

        //System.out.println(libreria);
        System.out.println();

        mostrarPrecioFinal(libreria, "George Orwell", "1984");
        mostrarPrecioFinal(libreria, "Philip K. Dick", "¿Sueñan los androides con ovejas eléctricas?");
        mostrarPrecioFinal(libreria, "isaac asimov", "fundación e imperio");
        mostrarPrecioFinal(libreria, "Ray Bradbury", "Fahrenheit 451");
        mostrarPrecioFinal(libreria, "Aldous Huxley", "Un Mundo Feliz");
        mostrarPrecioFinal(libreria, "Isaac Asimov", "La Fundación");
        mostrarPrecioFinal(libreria, "william gibson", "neuromante");
        mostrarPrecioFinal(libreria, "Isaac Asimov", "Segunda Fundación");
        mostrarPrecioFinal(libreria, "Isaac Newton", "Arithmetica Universalis");
    }
	private static void mostrarPrecioFinal(Libreria libreria, String autor, String titulo) {
        try {
            double precioFinal = libreria.getPrecioFinal(autor, titulo);
            System.out.printf("PrecioFinal(" + autor +","+ titulo+"): " + precioFinal+ "\n");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
