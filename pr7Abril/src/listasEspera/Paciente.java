package listasEspera;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Scanner;

public class Paciente {
	private final String nombreCompleto;
	private int edad;
	private int tiempoEspera;
	private boolean trabajando;
	private  boolean urgente;
	
	public Paciente(String nombreCompleto, int edad, int tiempoEspera, boolean trabajando, boolean urgente) {
		this.nombreCompleto = nombreCompleto;
		this.edad = edad;
		this.tiempoEspera = tiempoEspera;
		this.trabajando = trabajando;
		this.urgente = urgente;
	}

	protected int getEdad() {
		return edad;
	}

	protected void setEdad(int edad) {
		this.edad = edad;
	}

	protected int getTiempoEspera() {
		return tiempoEspera;
	}

	protected void setTiempoEspera(int tiempoEspera) {
		this.tiempoEspera = tiempoEspera;
	}

	protected boolean isTrabajando() {
		return trabajando;
	}

	protected void setTrabajando(boolean trabajando) {
		this.trabajando = trabajando;
	}

	protected boolean isUrgente() {
		return urgente;
	}

	protected void setUrgente(boolean urgente) {
		this.urgente = urgente;
	}

	protected String getNombreCompleto() {
		return nombreCompleto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(edad, nombreCompleto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if ((obj == null)||!(obj instanceof Paciente))
			return false;
		Paciente other = (Paciente) obj;
		return edad == other.edad && Objects.equals(nombreCompleto, other.nombreCompleto);
	}

	@Override
	public String toString() {
		return "Paciente [nombreCompleto=" + nombreCompleto + ", edad=" + edad + ", tiempoEspera=" + tiempoEspera
				+ ", trabajando=" + trabajando + ", urgente=" + urgente + "]";
	}
	
	public static Paciente valueOf (String s) {
		try(Scanner obj = new Scanner(s)){
			obj.useDelimiter(";");
			String nombre = obj.next();
			int edad = obj.nextInt();
			int tiempoEspera = obj.nextInt();
			boolean trabajando =  obj.nextBoolean();
			boolean urgente = obj.nextBoolean();
			return new Paciente(nombre, edad, tiempoEspera, trabajando, urgente);
		}catch(NoSuchElementException e) {
			return null;
		}
		
		
	}
	
	
	
	
	
}
