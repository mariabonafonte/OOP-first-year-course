package residentes;

import java.util.Objects;

public class Residente implements Comparable<Residente>{
	private String nombre;
	private int edad;
	private String dni;
	private Provincia provincia;
	private GradoDependencia gradoDependencia;
	
	
	public Residente(String nombre, int edad, String dni, Provincia provincia, GradoDependencia gradoDependencia) {
		super();
		this.nombre = nombre;
		setEdad(edad);
		setDni(dni);
		this.provincia = provincia;
		this.gradoDependencia = gradoDependencia;
	}
	public Residente(String nombre, int edad, String dni, Provincia provincia) {
		super();
		this.nombre = nombre;
		setEdad(edad);
		setDni(dni);
		this.provincia = provincia;
		this.gradoDependencia = GradoDependencia.GradoI;
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
		if(edad<18||edad>180) {
			throw new ExcepcionResidente("Edad inválida");
		}
		this.edad = edad;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		if(!DNI.esValido(dni)) {
			throw new ExcepcionResidente("Dni inválido");
		}
		this.dni = dni;
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
				&&dni.equalsIgnoreCase(r.dni);
	}
	@Override
	public String toString() {
		return "[" + nombre + ", " + edad + " años, residente en "  + provincia
				+ ", " + gradoDependencia + "]";
	}
	@Override
	public int compareTo(Residente o) {
		return Integer.compare(edad, o.edad);
	}
	
	public static Residente toResidente(String st) {
		Residente res =null;
		try {
			String [] s = st.split(";");
			String nombre = s[0];
			int edad = Integer.parseInt(s[1]);
			String dni = s[2];
			Provincia provincia = Provincia.valueOf(s[3]);
			GradoDependencia grado = GradoDependencia.valueOf(s[4]);
			
			res = new Residente(nombre,edad,dni,provincia,grado);
			
		} catch (NumberFormatException e) {
			throw new ExcepcionResidente("Cadena mal formada");
		}
		
		return res;
		
	}
	
	
	
	
	

}
