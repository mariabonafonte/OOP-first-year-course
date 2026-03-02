package buceo;

public class Fecha {
	private int dia;
	private int mes;
	private int anio;
	
	public Fecha(int d, int m, int y) {
		super();
		if(d<1 || d>31) {
			throw new RuntimeException("Introduzca un día válido");
		}
		if(y<1970){
			throw new RuntimeException("El año debe ser posterior a 1970");
		}
		if(m<1 || m>12){
			throw new RuntimeException("Introduzca un mes válido");
		}
		this.dia = d;
		this.mes = m;
		this.anio = y;
	}

	public int getDia() {
		return dia;
	}

	public int getMes() {
		return mes;
	}

	public int getAnio() {
		return anio;
	}

	@Override
	public String toString() {
		String[] meses = {"", "Ene", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Ago", "Sep", "Oct", "Nov", "Dic"};
        return dia + "/" + meses[mes] + "/" + anio;
	}
	

	
}
