package reconocimientos;

public class PruebaMedica {
	
	private int dia;
	private int mes;
	private int anio;
	public PruebaMedica(int dia, int mes, int anio) {
		super();
		if (!fechaValida(dia,mes,anio)) throw new PruebaMedicaException("Fecha inválida");
		this.dia = dia;
		this.mes = mes;
		this.anio = anio;
	}
	private boolean fechaValida(int dia, int mes, int anio) {
		// TODO Auto-generated method stub
		return dia>0 || dia < 32 || mes >0 || mes < 13 || anio >2020;
	}
	public int getAnio() {
		return anio;
	}
	@Override
	public String toString() {
		return dia + "/" + mes + "/" + anio;
	}

	
}
