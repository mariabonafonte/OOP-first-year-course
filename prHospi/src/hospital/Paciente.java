
package hospital;

import java.util.Objects;

public class Paciente implements Comparable<Paciente>{
	private String nombre, apellidos, nuss;
	private int anoDeNacimiento;
	
	public Paciente(String nombre, String apellidos, String nuss, int anoDeNacimiento) {
		super();
		if(nombre==null||apellidos==null||nuss==null) {
			throw new HospitalException("Valores nulos");
		}
		if(nombre.isEmpty()||apellidos.isEmpty()) {
			throw new HospitalException("Valores en blanco");
		}
		if(!validaNuss(nuss)) {
			throw new HospitalException("nuss invalido");
		}
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nuss = nuss;
		this.anoDeNacimiento = anoDeNacimiento;
	}
	
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

	private boolean validaNuss(String nuss) {
		boolean res = false;
		//FALTA HACER ESTO
		if(nuss.length()==10) {
			int primeros = Integer.parseInt(nuss.substring(0,8));
			int segundos = primeros%97;
			int finales = Integer.parseInt(nuss.substring(8,10));
			if(segundos==finales) {
				res=true;
			}
		}
		return res;
	}

	@Override
	public int hashCode() {
		return Objects.hash(anoDeNacimiento, apellidos.toLowerCase(), nombre.toLowerCase(), nuss);
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof Paciente p)
				&& anoDeNacimiento==p.anoDeNacimiento
				&&nombre.equalsIgnoreCase(p.nombre)
				&&apellidos.equalsIgnoreCase(p.apellidos)
				&&nuss.equals(p.nuss);
				
	}

	@Override
	public int compareTo(Paciente o) {
		int resultado = Integer.compare(anoDeNacimiento, o.anoDeNacimiento);
		if(resultado==0) {
			resultado = nuss.compareTo(o.nuss);
			if(resultado==0) {
				resultado = apellidos.compareToIgnoreCase(o.apellidos);
				if(resultado==0) {
					nombre.compareToIgnoreCase(o.nombre);
				}
			}
		}
		return resultado;
	}

	@Override
	public String toString() {
		return "Paciente [nombre=" + nombre + ", apellidos=" + apellidos + ", nuss=" + nuss + ", anoDeNacimiento="
				+ anoDeNacimiento + "]";
	}
	
	
	
	
	
	

	

}
