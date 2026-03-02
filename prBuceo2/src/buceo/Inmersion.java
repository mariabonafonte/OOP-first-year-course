package buceo;

import java.sql.Date;

public class Inmersion {
	private Date fecha;
	private String nombreUbicacion;
	private int duracion;

	
	public Inmersion(Date fecha, String nombreUbicacion, int duracion) {
		this.fecha = fecha;
		this.nombreUbicacion = nombreUbicacion;
		this.duracion = duracion;
	}
	
	protected Date getFecha() {
		return fecha;
	}

	protected String getUbicacion() {
		return nombreUbicacion;
	}


	protected int getDuracion() {
		return duracion;
	}

	@Override
	public String toString() {
		return "(" + nombreUbicacion + "," + fecha + "," + duracion + ")";
	}
	
	
	
	
	
	
	
	
}
