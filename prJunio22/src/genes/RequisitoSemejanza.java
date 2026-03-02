package genes;

public class RequisitoSemejanza implements TipoRequisito {
	private ADN muestra;
	private double porcMin;
	private double porcMax;
	
	public RequisitoSemejanza() {
		// TODO Auto-generated constructor stub
	}

	public RequisitoSemejanza(ADN muestra, double porcMin, double porcMax) {
		super();
		if(porcMin<0||porcMax>100) {
			throw new ADNException("Los valores de los porcentajes deben estar comprendidos en el intervalo [0,100]");
		}
		this.muestra = muestra;
		this.porcMin = porcMin;
		this.porcMax = porcMax;
	}

	@Override
	public boolean cumplir(ADN secuencia) {
		boolean res = false;
		if(muestra.porcSemejanza(secuencia)<porcMax && muestra.porcSemejanza(secuencia)>porcMin) {
			res=true;
		}
		return res;
	}

}
