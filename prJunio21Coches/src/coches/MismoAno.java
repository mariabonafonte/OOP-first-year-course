package coches;

public class MismoAno implements Criterio{
	private int ano;

	public MismoAno() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean cumpleCondicion(Coche c) {
		boolean res = false;
		if(c.getAno()==this.ano) {
			res=true;
		}
		return res;
	}

}
