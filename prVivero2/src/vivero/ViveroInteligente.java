package vivero;

import java.util.List;

public class ViveroInteligente extends Vivero {
	private static int humedadOptima = 70;

	public ViveroInteligente(int c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	public ViveroInteligente(int c, List<Planta> plantas) {
		super(c, plantas);
		// TODO Auto-generated constructor stub
	}

	protected static int getHumedadOptima() {
		return humedadOptima;
	}

	protected static void setHumedadOptima(int humedadOptima) {
		ViveroInteligente.humedadOptima = humedadOptima;
	}

	@Override
	public void regarPlantas() {
		List<Planta> l = plantasNoRegadas();
		for (Planta p : l) {
			if (p.getNivelHumedad() < ViveroInteligente.getHumedadOptima()) {
				p.setEstaRegada(true);
				p.setNivelHumedad(ViveroInteligente.getHumedadOptima());
			}
		}
	}

	@Override
	public String toString() {
		return "Vivero Inteligente: [capacidad=" + super.getCapacidad() + ", humedad optima="
				+ ViveroInteligente.getHumedadOptima() + ", plantas=" + super.getPlantas() + "]";
	}
	
	

	

}
