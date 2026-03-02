package Ingredientes;

	public class Ingredientes {

	    private String nombre;  
	    private String categoria;
	    private int cantidad;

	    public Ingredientes (String nombre, String categoria, int cantidad) {
	        this.nombre = nombre;
	        this.categoria = categoria;
	        this.cantidad = cantidad;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public String getCategoria() {
	        return categoria;
	    }

	    public int getCantidad() {
	        return cantidad;
	    }

	    @Override
	    public String toString() {
	        return "Ingrediente: " + nombre + ", Categoría: " + categoria + ", Cantidad: " + cantidad;
	    }
	}
