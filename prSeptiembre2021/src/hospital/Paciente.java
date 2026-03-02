package hospital;

import java.util.Objects;

public class Paciente implements Comparable<Paciente>{
	private String nombre, apellidos, nuss;
	private int anoDeNacimiento;

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getNuss() {
		return nuss;
	}

	public int getAnoDeNacimiento() {
		return anoDeNacimiento;
	}

	public Paciente() {
		// TODO Auto-generated constructor stub
	}

	public Paciente(String nom, String ape, String num, int ano) throws HospitalException {
		super();
		if(nom==null|| nom.isEmpty()) {
			throw new HospitalException("Error en el nombre");
		}
		if(ape==null||ape.isEmpty()) {
			throw new HospitalException("Error en el apellido");	
		}
		if(!validarNuss(num)) {
			throw new HospitalException("Error en el nuss");	
		}
		this.nombre = nom;
		this.apellidos = ape;
		this.nuss = num;
		this.anoDeNacimiento = ano;
	}
	
	private boolean validarNuss(String num) {
		boolean res = false;
		int ocho = Integer.parseInt(num.substring(0,8));
		int control = Integer.parseInt(num.substring(9,10));
		int controlCalculado = ocho % 97;
        String controlEsperado = String.format("%02d", controlCalculado);
		return controlEsperado.equals(control);
	}

	@Override
	public int hashCode() {
		return Objects.hash(anoDeNacimiento, apellidos.toLowerCase(), nombre.toLowerCase(), nuss);
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof Paciente p)
				&&p.nombre.equalsIgnoreCase(nombre)
				&&p.apellidos.equalsIgnoreCase(apellidos)
				&&p.nuss.equals(nuss)
				&p.anoDeNacimiento==anoDeNacimiento;
				}

	@Override
	public int compareTo(Paciente o) {
		int resultado = Integer.compare(anoDeNacimiento, o.anoDeNacimiento);
		if(resultado==0) {
			resultado=nuss.compareTo(o.nuss);
			if(resultado==0) {
				resultado=apellidos.compareTo(o.apellidos);
				if(resultado==0) {
					resultado=nombre.compareTo(o.nombre);
				}
			}
		}
		return 0;
	}

	@Override
	public String toString() {
		return "Paciente [nombre=" + nombre + ", apellidos=" + apellidos + ", nuss=" + nuss + ", anoDeNacimiento="
				+ anoDeNacimiento + "]";
	}
	
	
	
	

}
