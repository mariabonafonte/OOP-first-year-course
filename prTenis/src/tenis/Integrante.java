package tenis;

public class Integrante {
	private String nombre;
	private int edad;
	protected double sueldo;
	protected double cuenta;
	private TipoParticipante tipo;
	
	public Integrante(String nombre, int edad, double sueldo, double cuenta) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.sueldo = sueldo;
		this.cuenta = cuenta;
		this.tipo = TipoParticipante.trabajador;
	}

	protected TipoParticipante getTipo() {
		return tipo;
	}

	protected void setTipo(TipoParticipante tipo) {
		this.tipo = tipo;
	}

	protected String getNombre() {
		return nombre;
	}
	
	public void cobrar() {
		cuenta = cuenta + sueldo;
	}

	@Override
	public String toString() {
		return tipo + ":" + nombre + ";" + edad + "años. cuenta=" + cuenta + ", sueldo=" + sueldo;
	}
	
	

	
}
