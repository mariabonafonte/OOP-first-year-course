package genes;

import java.util.Objects;

public class ADN implements Comparable<ADN>{
	private String secuencia;
	private TipoADN tipo;
	private int na, nc, ng, nt;
	
	
	public ADN(String secuencia, TipoADN tipo) {
		if(secuencia.isEmpty()||secuencia==null) {
			throw new ADNException("La secuencia esta vacia");
		}
		this.secuencia = secuencia;
		this.tipo = tipo;
		procesarSecuencia(secuencia);
	}
	
	protected void procesarSecuencia (String s) {
		s = s.toUpperCase();
		for (int i = 0; i < s.length(); i++) {
			 char nucl = s.charAt(i);
			 if(nucl == 'A') {na+=1;
			 }else if(nucl == 'C') { nc+=1;
			 }else if(nucl == 'G') { ng+=1;
			 }else if(nucl == 'T') { nt+=1;}
		}
	}

	public String getSecuencia() {
		return secuencia.toUpperCase();
	}

	public TipoADN getTipo() {
		return tipo;
	}
	
	public int numeroNucleotidos() {
		return na+nc+ng+nt;
	}
	
	public double porcSemejanza(ADN otraSecuencia) {
		int len = this.secuencia.length();
		int coincidencias = 0;
		if (len == otraSecuencia.getSecuencia().length()) {
			for(int i = 0; i< len; i++) {
				if (secuencia.charAt(i) == otraSecuencia.getSecuencia().charAt(i)) {
					coincidencias++;
				}
			}
		}
		return coincidencias * 100.0 / len;
	}

	@Override
	public int hashCode() {
		return Objects.hash(secuencia.toUpperCase(), tipo);
	}

	@Override
	public boolean equals(Object o) {
		return (o instanceof ADN a)
				&&a.secuencia.equalsIgnoreCase(secuencia)
				&&a.tipo.equals(tipo);
		}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(secuencia);
		if(tipo==TipoADN.ANIMAL) {sb.append(" (A)");
		}else if(tipo==TipoADN.VEGETAL) {sb.append(" (V)");
		}else if(tipo==TipoADN.DESCONOCIDO) {sb.append(" (D)");}
		return sb.toString();
	}

	@Override
	public int compareTo(ADN o) {
		int resultado = tipo.compareTo(o.tipo);
		if(resultado==0){
			resultado=secuencia.compareToIgnoreCase(o.secuencia);
		}
		return resultado;
	}
	
	
	
	
}
