package reconocimientos;

public class Electrocardiograma extends PruebaMedica {
	private int ritmoCardiaco;
	private boolean anormalidades;
	public Electrocardiograma(int dia, int mes, int anio, int ritmoCardiaco, boolean anormalidades) {
		super(dia, mes, anio);
		this.ritmoCardiaco = ritmoCardiaco;
		this.anormalidades = anormalidades;
	}
	public int getRitmoCardiaco() {
		return ritmoCardiaco;
	}
	public boolean isAnormalidades() {
		return anormalidades;
	}
	@Override
	public String toString() {
		return "Electrocardiograma:"+ super.toString() + " - ritmoCardiaco=" + ritmoCardiaco + " - anormalidades=" + anormalidades;
	}
	
	

	

}
