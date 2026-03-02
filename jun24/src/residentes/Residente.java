package residentes;

import java.util.Objects;

public class Residente implements Comparable<Residente>{
	private String nombre, dni;
	private int edad;
	private Provincia provincia;
	private GradoDependencia gradodependencia;
	
	public Residente(String nombre, int edad, String dni, Provincia provincia) {
		super();
		this.nombre = nombre;
		setDni(dni);
		setEdad(edad);
		this.provincia = provincia;
		gradodependencia = GradoDependencia.GradoI;
	}
	public Residente(String nombre, int edad, String dni, Provincia provincia, GradoDependencia gradodependencia) {
		super();
		this.nombre = nombre;
		setDni(dni);
		setEdad(edad);
		this.provincia = provincia;
		this.gradodependencia = gradodependencia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		if(!DNI.esValido(dni)) {
			throw new ExcepcionResidente("DNI Inválido");
		}
		this.dni = dni;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		if(edad<18||edad>120) {
			throw new ExcepcionResidente("Edad Inválida");
		}
		this.edad = edad;
	}
	public Provincia getProvincia() {
		return provincia;
	}
	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
	public GradoDependencia getGradodependencia() {
		return gradodependencia;
	}
	public void setGradodependencia(GradoDependencia gradodependencia) {
		this.gradodependencia = gradodependencia;
	}
	@Override
	public int hashCode() {
		return Objects.hash(dni.toLowerCase());
	}
	@Override
	public boolean equals(Object obj) {
		return (obj instanceof Residente r)
				&& r.dni.equalsIgnoreCase(dni);
	}
	@Override
	public String toString() {
		return "[" + nombre + ", "+ edad + " años, residente en " + provincia
				+ ", " + gradodependencia + "]";
	}
	@Override
	public int compareTo(Residente o) {
		int resultado = Integer.compare(edad, o.edad);
		return resultado;
	}
	
	public static Residente toResidente(String st) {
		String[] s = st.split(";");
		String nombre = s[0];
		int edad= Integer.parseInt(s[1]);
		String dni = s[2];
		Provincia prov = Provincia.valueOf(s[3]);
		GradoDependencia grad = GradoDependencia.valueOf(s[4]);
		return new Residente(nombre,edad,dni,prov,grad);
	}
		
	
	
	
	
	
	
	
	
	
	

	

}
