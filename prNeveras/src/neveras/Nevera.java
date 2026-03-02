package neveras;

public class Nevera {
	private Producto [] productos;
	private int numProductos;
	private double ocupacion;
	private final double capacidad;
	private static int TAMAÑO_INICIAL = 10;
	
	public Nevera(double c) {
		capacidad = c;
		productos = new Producto[TAMANO_INICIAL];
		numProductos = 0;
		ocupacion = 0;
	}

	public Nevera(double c, String lista) {
		this(c);
		procesaProductos(lista);
	}
	
	
	
	

}
