package hospital;

public class NacidoAntesDe implements Criterio {
	private int ano;

	public NacidoAntesDe(int ano) {
		// TODO Auto-generated constructor stub
		this.ano = ano;
		
	}

	@Override
	public boolean cumpleCondicion(Paciente p, Habitacion h) {
		// TODO Auto-generated method stub
		boolean res = false;
		if(p.getAnoDeNacimiento() < this.ano) {
			res = true;
		}
		return res;
	}

}
