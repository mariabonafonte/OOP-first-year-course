package hospital;

public class PersonalSanitario {
	private String nombre;
	private TURNO turno;

	public PersonalSanitario(String nombre, TURNO turno) {
		super();
		this.nombre = nombre;
		this.turno = turno;
	}
	
	public PersonalSanitario(String datos) {
		try {
			String[] persona = datos.split("\\s*[,]\\s*");
			if (persona.length != 2) {
				throw new HospitalException("ERROR: formato incorrecto en " + datos);
			} else {
				this.nombre = persona[0];
				this.turno = TURNO.valueOf(persona[1]);
			}
		} catch (IllegalArgumentException e) {
			throw new HospitalException("ERROR: formato incorrecto en " + datos);
		}
	}

	public String getNombre() {
		return nombre;
	}

	public TURNO getTurno() {
		return turno;
	}

	public void setTurno(TURNO turno) {
		this.turno = turno;
	}

	@Override
	public String toString() {
		return nombre + "(turno de" + turno + ")";
	}
	@Override
	public boolean equals(Object obj) {
		return obj instanceof PersonalSanitario && ((PersonalSanitario) obj).nombre.equalsIgnoreCase(nombre);
	}

	@Override
	public int hashCode() {
		return nombre.toUpperCase().hashCode();
	}
}
