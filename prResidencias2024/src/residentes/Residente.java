package residentes;

import java.util.Objects;

public class Residente implements Comparable<Residente>{
	private String nombre;
	private int edad;
	private String dni;
	private Provincia provincia;
	private GradoDependencia gradoDependencia;
	
	public Residente(String nombre, int edad, String dni, Provincia provincia) {
		super();
		this.nombre = nombre;
		setEdad(edad);
		setDni(dni);
		this.provincia = provincia;
		gradoDependencia = GradoDependencia.GradoI;
	}

	public Residente(String nombre, int edad, String dni, Provincia provincia, GradoDependencia gradoDependencia) {
		super();
		this.nombre = nombre;
		setEdad(edad);
		setDni(dni);
		this.provincia = provincia;
		this.gradoDependencia = gradoDependencia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		if(edad<18||edad>120) {
			throw new ExcepcionResidente("Edad inválida");
		}
		this.edad = edad;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		if(DNI.esValido(dni)) {
			this.dni = dni;
		}
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public GradoDependencia getGradoDependencia() {
		return gradoDependencia;
	}

	public void setGradoDependencia(GradoDependencia gradoDependencia) {
		this.gradoDependencia = gradoDependencia;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni.toUpperCase());
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof Residente r)
				&& dni.equalsIgnoreCase(r.dni);
	}

	@Override
	public String toString() {
		return "[" + nombre + ", " + edad + " años, residente en " + provincia
				+ ", " + gradoDependencia + "]";
	}

	@Override
	public int compareTo(Residente o) {
		int resultado = Integer.compare(edad, o.edad);
		return resultado;
	}
	
	public static Residente toResidente (String st) {
		String nom, dni;
		int edad;
		Provincia prov;
		GradoDependencia grado;
		try {
			String[] s = st.split(";");
			nom = s[0];
			edad = Integer.parseInt(s[1]);
			dni = s[2];
			prov = Provincia.valueOf(s[3]);
			grado = GradoDependencia.valueOf(s[4]);
			
		} catch (NumberFormatException e) {
			throw new ExcepcionResidente("Cadena de texto inválida");
		}
		return new Residente(nom,edad,dni,prov,grado);
	}
	
	
	
	
	
	
	
	

}
