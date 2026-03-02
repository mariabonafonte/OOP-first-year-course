package reconocimientos;

public class AnalisisSangre extends PruebaMedica {
	private TipoAnalisis tipo;
	private int numFueraRango;
	public AnalisisSangre(int dia, int mes, int anio, TipoAnalisis tipo, int numeroFueraRango) {
		super(dia, mes, anio);
		this.tipo=tipo;
		this.numFueraRango=numeroFueraRango;
	}
	public TipoAnalisis getTipo() {
		return tipo;
	}
	public int getNumFueraRango() {
		return numFueraRango;
	}
	@Override
	public String toString() {
		return "AnalisisSangre: " + super.toString() +" – tipo=" + tipo + " - numFueraRango=" + numFueraRango;
	}
	
	

}
