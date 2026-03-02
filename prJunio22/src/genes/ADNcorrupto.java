package genes;

public class ADNcorrupto extends ADN{

	public ADNcorrupto(String secuencia, TipoADN tipo) {
		super(secuencia, tipo);
		procesarSecuencia(secuencia);
	}

	@Override
	protected void procesarSecuencia(String s) {
		String sMay = s.toUpperCase();
		StringBuilder sb = new StringBuilder(sMay);
		for(int i = 0; i< s.length(); i++) {
			char gen = sMay.charAt(i);
			if (gen != 'T' && gen != 'G' && gen != 'A' && gen != 'C') {
				sb.replace(i, i+1, "-");
			}
		}
		super.procesarSecuencia(sb.toString());
	}
	
	public int numNucleotidosDesconocidos() {
		int res = 0;
		for (int i = 0; i <= this.getSecuencia().length(); i++) {
			char gen = this.getSecuencia().charAt(i);
			if (gen != 'T' && gen != 'G' && gen != 'A' && gen != 'C') {
				res+=1;
			}
		}
		return res;
	}
}
