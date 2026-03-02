package hospital;

import java.util.Objects;

public class Paciente implements Comparable<Paciente>{
	private String nombre;
	private String apellidos;
	private String nuss;
	private int anoDeNacimiento;

	
	
	public Paciente(String nom, String ape, String num, int ano) {
		super();
		if(nom==null|| ape==null|| !validarNUSS(nuss)) {
			throw new HospitalException("Los valores no pueden ser nulos");
		}
		if(nom.isEmpty()||ape.isEmpty()) {
			throw new HospitalException("Los valores no pueden estan vacios");
		}
		this.nombre = nom;
		this.apellidos = ape;
		this.nuss = num;
		this.anoDeNacimiento = ano;
	}



	private boolean validarNUSS(String nuss) {
	    if (nuss == null || nuss.length() != 10) {
	        throw new HospitalException("Nuss invalido");
	    }
	    for (int i = 0; i < nuss.length(); i++) {
	        if (!Character.isDigit(nuss.charAt(i))) {
	            throw new HospitalException("Nuss invalido");
	        }
	    }
	    int num = Integer.parseInt(nuss.substring(0, 8));
	    String con = nuss.substring(8, 10);
	    int controlCalc = num % 97;
	    String controlForm = (controlCalc < 10) ? "0" + controlCalc : "" + controlCalc;
	    return con.equals(controlForm);
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



	@Override
	public int hashCode() {
		return Objects.hash(anoDeNacimiento, apellidos.toLowerCase(), 
				nombre.toLowerCase(), nuss);
	}



	@Override
	public boolean equals(Object o) {
		return(o instanceof Paciente p)
				&&p.anoDeNacimiento == anoDeNacimiento
				&&p.apellidos.equalsIgnoreCase(apellidos)
				&&p.nombre.equalsIgnoreCase(nombre)
				&&p.nuss.equals(nuss);
	}



	@Override
	public int compareTo(Paciente o) {
		int resultado = Integer.compare(anoDeNacimiento, o.anoDeNacimiento);
		if(resultado == 0) {
			resultado= nuss.compareTo(o.nuss);
			if(resultado==0) {
				resultado = apellidos.compareTo(o.apellidos);
				if(resultado==0) {
					resultado = nombre.compareTo(o.nombre);
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
