package coches;

public class MismoModelo implements Criterio{
	private String modelo;

	public MismoModelo(String modelo) {
		super();
		if(modelo.isEmpty()|| modelo==null) {
			throw new CochesException("modelo erroneo");
		}
		this.modelo = modelo;
	}

	@Override
	public boolean cumpleCondicion(Coche c) {
		boolean res = false;
		if(this.modelo.equals(c.getModelo())) {
			res = true;
		}
		return res;
	}

}
