package hospital;

public class MismaPlanta implements Criterio {
	private int planta;

	public MismaPlanta(int p) {
		this.planta = p;}

	@Override
	public boolean cumpleCondicion(Paciente p, Habitacion h) {
		boolean res = false;
		if(h.getPlanta()==planta) {
			res = true;}
		return res;
	}

}
