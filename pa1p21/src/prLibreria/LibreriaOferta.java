package prLibreria;

import java.util.Arrays;

public class LibreriaOferta extends Libreria {
	 private double porcDescuento;
	 private String [] autoresOferta;

	public LibreriaOferta(double porcDescuento, String [] autoresOferta) {
		this.porcDescuento = porcDescuento;
		this.autoresOferta = autoresOferta;
	}

	public String[] getOferta() {
		return autoresOferta;
	}

	public void setOferta(double porcDescuento, String [] autoresOferta) {
		this.porcDescuento = porcDescuento;
		this.autoresOferta = autoresOferta;
	}

	public double getDescuento() {
		return porcDescuento;
	}
	
	
	@Override
    public void addLibro(String autor, String titulo, double precio){
        if(oferta(autor)){
            anyadirLibro(new LibroOferta(autor, titulo, precio, porcDescuento));

        }else{
            anyadirLibro(new Libro(autor, titulo, precio));
        }
    }

    private boolean oferta(String autor){
        int i = 0;
        while(i < autoresOferta.length && !autor.equalsIgnoreCase(autoresOferta[i])){
            i++;
        }
        return i < autoresOferta.length;
    }

	 @Override
	 public String toString(){
		 System.out.println(porcDescuento+"% "+ Arrays.toString(autoresOferta));
		 return super.toString();
	    }
	 
}