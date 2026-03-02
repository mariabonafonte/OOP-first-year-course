/*MARIA BONBAFONTE SANCHEZ
 * 1ºA ING DE LA SALUD
 * PC 1003
*/
package reconocimientos;

import java.util.ArrayList;

public abstract class PruebaMedica {
	private int dia;
	private int mes;
	private int anio;
	public PruebaMedica(int dia, int mes, int anio) {
		super();
		if(dia<1 || dia>31){
			throw new PruebaMedicaException("Día inválido");
		}
		this.dia = dia;
		if(mes<1 || mes>12){
			throw new PruebaMedicaException("Mes inválido");
		}
		this.mes = mes;
		if(anio<1 || anio>2025){
			throw new PruebaMedicaException("Año inválido");
		}
		this.anio = anio;
	}
	@Override
	public String toString() {
		return dia + "/" + mes + "/" + anio;
	}
	
	
	
	
}

