package genes;

public class RequisitoNucleotidos implements TipoRequisito {
	private int numNucleotidos;

	public RequisitoNucleotidos(int numNucleotidos) {
		super();
		this.numNucleotidos = numNucleotidos;
	}

	@Override
	public boolean cumplir(ADN secuencia) {
		boolean res = false;
		if(secuencia.getSecuencia().length()>= numNucleotidos) {
			res=true;
		}
		return res;
	}

}
