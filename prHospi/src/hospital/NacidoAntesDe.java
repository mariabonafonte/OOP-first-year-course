package hospital;

public class NacidoAntesDe implements Criterio {
	private int ano;

	
	public NacidoAntesDe(int ano) {
		super();
		this.ano = ano;
	}


	@Override
	public boolean cumpleCondicion(Paciente p, Habitacion h) {
		boolean res = false;
		if(p.getAnoDeNacimiento()<ano) {
			res=true;
		}
		
		return res;
	}

}
