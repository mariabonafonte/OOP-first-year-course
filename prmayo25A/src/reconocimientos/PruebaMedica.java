package reconocimientos;

public abstract class PruebaMedica {
	private int dia, mes, anio;


	public PruebaMedica(int dia, int mes, int anio) {
		super();
		if(dia<0 || dia>31) {
			throw new PruebaMedicaException("Día Inválido");
		}
		if(mes<0 || mes>12) {
			throw new PruebaMedicaException("Mes Inválido");
		}
		if(anio<0 || anio>2025) {
			throw new PruebaMedicaException("Año Inválido");
		}
		this.dia = dia;
		this.mes = mes;
		this.anio = anio;
	}


	public int getAnio() {
		return anio;
	}


	@Override
	public String toString() {
		return  dia + "/" + mes + "/" + anio;
	}
	
	

}
