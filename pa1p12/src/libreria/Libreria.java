package libreria;

import java.util.ArrayList;
import java.util.List;

public class Libreria {
    private List<Libro> libros;

    public Libreria() {
        libros = new ArrayList<>();
    }

    public void addLibro(String autor, String titulo, double precioBase) {
        Libro libro = new Libro(autor, titulo, precioBase);
        anyadirLibro(libro);
    }
    
    private int buscarLibro(String autor, String titulo) {
        int i = 0;
        boolean found = false;
        while (i < libros.size() && !found) {
            Libro libro = libros.get(i);
            if (libro.getAutor() == autor && libro.getTitulo() == titulo) {
                found = true;
            }
            i++;
        }
        return  i-1;
    }

    public void remLibro(String autor, String titulo) {
        int index = buscarLibro(autor, titulo);
        if (index != -1) {
            libros.remove(index);
        } else {
            throw new RuntimeException("Libro no encontrado (" + autor + ", " + titulo + ")");
        }
    }

    public double getPrecioFinal(String autor, String titulo) {
    	int index = buscarLibro(autor,titulo);
    	if (index != -1) { 
    		Libro l = libros.get(index);
    		return l.getPrecioFinal();
    	}else{
    		throw new RuntimeException("Libro no encontrado (" + autor + ", " + titulo + ")");
    	}
    }

    @Override
    public String toString() {
        return libros.toString();
    }

    protected void anyadirLibro(Libro libro) {
    libros.add(libro);
    }
  
}