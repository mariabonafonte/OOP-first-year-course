import libreria.Libreria;

public class PruebaLibreria {
    public static void main(String[] args) {
        Libreria libreria = new Libreria();

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

        libreria.remLibro("George Orwell", "1984");
        libreria.remLibro("Aldous Huxley", "Un Mundo Feliz");
        libreria.remLibro("Isaac Newton", "Arithmetica Universalis");

        System.out.println(libreria);

        String[][] librosParaConsultar = {
            {"Philip K. Dick", "¿Sueñan los androides con ovejas eléctricas?"},
            {"isaac asimov", "fundación e imperio"},
            {"Ray Bradbury", "Fahrenheit 451"},
            {"Isaac Asimov", "La Fundación"},
            {"william gibson", "neuromante"},
            {"Isaac Asimov", "Segunda Fundación"},
            {"Isaac Newton", "Arithmetica Universalis"},
        };

        for (String[] libro : librosParaConsultar) {
            imprimirPrecioFinal(libreria, libro);
        }
    }

    private static void imprimirPrecioFinal(Libreria libreria, String[] libro) {
        try {
            double precioFinal = libreria.getPrecioFinal(libro[0], libro[1]);
            System.out.printf("PrecioFinal(%s, %s): %.2f%n", libro[0], libro[1], precioFinal);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}