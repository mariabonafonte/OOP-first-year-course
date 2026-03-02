package prLibreria;

public class LibroOferta extends Libro {
    private double porcDescuento;

    public LibroOferta(String autor, String titulo, double precioBase, double porcDescuento) {
        super(autor, titulo, precioBase);
        this.porcDescuento = porcDescuento;
    }

    public double getDescuento() {
        return porcDescuento;
    }

    @Override
    protected double getBaseImponible() {
        double baseImponibleSinDescuento = super.getBaseImponible();
        return baseImponibleSinDescuento - (baseImponibleSinDescuento * porcDescuento / 100);
    }

    @Override
    public String toString() {
        double baseImponible = getBaseImponible();
        double precioFinal = getPrecioFinal();
        return "("+ getAutor() + ";" + getTitulo() +";" + getPrecioBase() +";"+ porcDescuento + ";" + baseImponible +";"+getIVA()+";"+precioFinal+")";
    }
}