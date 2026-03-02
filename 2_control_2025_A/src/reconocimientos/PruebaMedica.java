package reconocimientos;

public abstract class PruebaMedica {
	private int dia;
	private int mes;
	private int anio;
	
	public PruebaMedica(int dia, int mes, int anio) {
		super();
		setDia(dia);
		setMes(mes);
		setAnio(anio);
	}
	
	private void setDia(int dia) {
		if(dia<0 || dia>31) {
			throw new PruebaMedicaException("Día inválido");
		}
		this.dia = dia;
	}
	
	private void setMes(int mes) {
		if(mes<0 || mes>12) {
			throw new PruebaMedicaException("Mes inválido");
		}
		this.mes = mes;
	}
	private void setAnio(int anio) {
		if(anio<0 || anio>2025) {
			throw new PruebaMedicaException("Año inválido");
		}
		this.anio = anio;
	}

	public int getAnio() {
		return anio;
	}
	@Override
	public String toString() {
		return dia + "/" + mes + "/" + anio;
	}

}
