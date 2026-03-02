package fidelizacion;

public class ServicioGasolinera extends Servicio {

	@Override
	public Transaccion hazTransaccion(int ca, Fecha fe, int nC) {
		return new Transaccion(ca, ca/20, fe, nC);
	}

}
