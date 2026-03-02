/*MARIA BONBAFONTE SANCHEZ
 * 1ºA ING DE LA SALUD
 * PC 1003
*/
package reconocimientos;

public class AnalisisSangre extends PruebaMedica {
	private TipoAnalisis tipo;
	private int numFueraRango;
	
	public AnalisisSangre(int dia, int mes, int anio, TipoAnalisis tipo, int numFueraRango) {
		super(dia, mes, anio);
		this.tipo = tipo;
		this.numFueraRango = numFueraRango;
	}

	public TipoAnalisis getTipo() {
		return tipo;
	}

	public int getNumFueraRango() {
		return numFueraRango;
	}
	
	@Override
	public String toString() {
		return "AnalisisSangre:" +  super.toString() + " - tipo="+ tipo + " - numFueraRango=" + numFueraRango;
	}

	
	
	
	
	
	

}
