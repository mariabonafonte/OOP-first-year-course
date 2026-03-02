package buceo;

import java.util.Date;

public class Inmersion {
	private Date fecha;
	private String nombreUbicacion;
	private int duracion;
	
	public Inmersion(String I, int d, Date F) {
		this.fecha = F;
		this.nombreUbicacion = I;
		this.duracion = d;
	}

	public Date getFecha() {
		return fecha;
	}

	public String getUbicacion() {
		return nombreUbicacion;
	}

	public int getDuracion() {
		return duracion;
	}

	@Override
	public String toString() {
		return "("+ nombreUbicacion + "," + fecha +  "," + duracion + ")";
	}
	

}
