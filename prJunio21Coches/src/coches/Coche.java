package coches;

import java.util.Objects;

public class Coche implements Comparable<Coche>{
	private final String modelo, niv;
	private final int ano, mes, dia;
	public Coche(String modelo, String niv, int mes, int dia, int ano) {
		niv = niv.toUpperCase();
		if(modelo.isEmpty()) {
			throw new CochesException("Modelo erroneo");
		}
		if(niv.length()!=17||niv.contains("O")
				|| niv.contains("I")|| niv.contains("Q")) {
			throw new CochesException("NIV erroneo");
		}
		if(dia<1 || dia>31 ||mes<1||mes>12|| ano<0) {
			throw new CochesException("Fecha erronea");
		}
		this.modelo = modelo;
		this.niv = niv;
		this.ano = ano;
		this.mes = mes;
		this.dia = dia;
	}
	
	public String getModelo() {
		return modelo;
	}
	public String getNiv() {
		return niv;
	}
	public int getAno() {
		return ano;
	}
	public int getMes() {
		return mes;
	}
	public int getDia() {
		return dia;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ano, dia, mes, niv.toUpperCase());
	}

	@Override
	public boolean equals(Object obj) {
		return(obj instanceof Coche c)
				&&ano==c.ano
				&&dia==c.dia
				&&mes==c.mes
				&&niv.equalsIgnoreCase(c.niv);
	}

	@Override
	public int compareTo(Coche o) {
		int resultado = Integer.compare(ano, o.ano);
		if(resultado==0) {
			resultado=Integer.compare(mes, o.mes);
			if(resultado==0) {
				resultado=Integer.compare(dia, o.dia);
				if(resultado==0) {
					resultado = niv.compareTo(o.niv);
				}
			}
		}
		return resultado;
	}

	@Override
	public String toString() {
		return "[" + niv +", " + dia+"/"+mes+"/"+ano+"]";
	}
	
	
	

	
}
