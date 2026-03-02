package alergias;

public abstract class Alergia {
	private static final int minSeveridad = 0 ;
	private static final int maxSeveridad = 10 ;
	protected String descripcion;
	protected int severidad;
	
	public Alergia(String descripcion, int severidad) {
		this.descripcion = descripcion;
		setSeveridad(severidad);
	}

	public Alergia(String descripcion) {
		this.descripcion = descripcion;
		severidad = minSeveridad;
	}

	public int getSeveridad() {
		return severidad;
	}

	public void setSeveridad(int severidad) {
		if(severidad > maxSeveridad || severidad < minSeveridad) {
			throw new AlergiasException("Severidad debe estar en el rango["+ minSeveridad + "," + maxSeveridad + "]");
		}
		this.severidad = severidad;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	
	
	

}
