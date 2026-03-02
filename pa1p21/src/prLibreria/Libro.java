package prLibreria;

public class Libro {
    private String autor;
    private String titulo;
    private double precioBase;
    protected static double IVA = 10.0;

    public Libro(String autor, String titulo, double precioBase) {
    	if(precioBase<0)throw new RuntimeException("El precio no puede ser negativo");
        this.autor = autor;
        this.titulo = titulo;
        this.precioBase = precioBase;
    }

    public String getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    protected double getBaseImponible() {
        return precioBase;
    }

    public double getPrecioFinal() {
        double baseImponible = getBaseImponible();
        return baseImponible + baseImponible * IVA / 100;
    }

    @Override
	public String toString() {
    	 return "("+autor+"; "+titulo+"; "+precioBase+";"+IVA+"%; "+getPrecioFinal()+")";
    }

    public static double getIVA() {
        return IVA;
    }

    public static void setIVA(double iva) {
        IVA = iva;
    }
}