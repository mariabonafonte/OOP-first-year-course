package residentes;

import java.util.Objects;
import java.util.Scanner;

import residencias.Residencia;

public class Residente implements Comparable<Residente> {
	private String nombre;
	private int edad;
	private String dni;
	private Provincia provincia;
	private GradoDependencia gradoDependencia;

	public Residente(String nombre, int edad, String dni, Provincia provincia) {
		this.nombre = nombre;
		setDNI(dni);
		setEdad(edad);
		this.provincia = provincia;
		gradoDependencia = GradoDependencia.GradoI;
	}

	public Residente(String nombre, int edad, String dni, Provincia provincia, GradoDependencia gradoDependencia) {
		this.nombre = nombre;
		setDNI(dni);
		setEdad(edad);
		this.provincia = provincia;
		this.gradoDependencia = gradoDependencia;
	}

	public String getDNI() {
		return dni;
	}

	public int getEdad() {
		return edad;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public GradoDependencia getGradoDependencia() {
		return gradoDependencia;
	}

	public void setDNI(String dni) {
		if (!DNI.esValido(dni))
			throw new ExcepcionResidente("No se puede asignar, DNI invalido ");
		this.dni = dni;
	}

	public void setEdad(int edad) {
		if (edad <= 18 || edad >= 120)
			throw new ExcepcionResidente("Edad incorrecta " + edad);
		this.edad = edad;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	public void setGradoDependencia(GradoDependencia gradoDependencia) {
		this.gradoDependencia = gradoDependencia;
	}

	public static Residente toResidente(String st) {
		Residente res = null;
		try (Scanner sc = new Scanner(st)) {
			sc.useDelimiter(";");
			String nombre = sc.next();
			int edad = sc.nextInt();
			String dni = sc.next();
			Provincia provincia = Provincia.valueOf(sc.next());
			GradoDependencia gradoDependencia = GradoDependencia.valueOf(sc.next());
			res = new Residente(nombre, edad, dni, provincia, gradoDependencia);

		} catch (Exception e) {
			throw new ExcepcionResidente("No se puede convertir el string " + st);
		}
		return res;

	}

	@Override
	public int hashCode() {
		return Objects.hash(dni.toLowerCase());
	}

	@Override
	public boolean equals(Object obj) {
		Residente other = (Residente) obj;
		return obj != null && obj instanceof Residente && dni.compareToIgnoreCase(other.dni) == 0;
	}

	@Override
	public String toString() {
		return "[" + nombre + ", " + edad + " años, residente en " + provincia + ", " + gradoDependencia + "]";
	}

	@Override
	public int compareTo(Residente o) {
		int res = 0;
		if (!this.equals(o)) {
			if (this.edad > o.edad)
				res = 1;
			else if (this.edad < o.edad)
				res = -1;
		}
		return res;
	}

}
