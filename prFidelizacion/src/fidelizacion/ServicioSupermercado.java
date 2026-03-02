package fidelizacion;

public class ServicioSupermercado extends Servicio{

	@Override
	public Transaccion hazTransaccion(int ca, Fecha fe, int nC) {
		int p = 0;
		if(ca>25) {
			p=5;
		}
		return new Transaccion(ca, p, fe, nC);
	}

}
