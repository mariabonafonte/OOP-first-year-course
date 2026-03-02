package buceo;

public class Fecha {
	private int dia;
	private int mes;
	private int anio;
	
	private static final String[] MESES = {"Ene", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Ago", "Sep", "Oct", "Nov", "Dic"};
	
	public Fecha(int dia, int mes, int anio) {
		if( dia<1 || dia>31||mes<1||mes>12||anio<1970) {
			throw new RuntimeException("Introduce una fecha válida");
		}
		this.dia = dia;
		this.mes = mes;
		this.anio = anio;
	}

	 @Override
	   public String toString() {
	       String mesStr = MESES[mes - 1];
	       return dia + "/" + mesStr + "/" + anio;
	    }
	
	
	

	
}
