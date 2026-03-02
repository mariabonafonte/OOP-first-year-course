package vuelos;

public class VueloConRetraso extends Vuelo{
	private static java.util.Random rnd = new java.util.Random();
	private int retraso;
	
	public VueloConRetraso(String aerolinea, String codigo, Hora horaSalida, int duracion, String apOrigen,
			String apDestino, int retraso) {
		super(aerolinea, codigo, horaSalida, duracion, apOrigen, apDestino);
		retraso = rnd.nextInt(3 * getDuracion());
	}
	
	public Hora getHoraSalida() {
		return super.getHoraSalida().horaTrasMinutos(getDuracion() + retraso);
	}
	

	

}
