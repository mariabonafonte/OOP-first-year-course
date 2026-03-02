package vivero;

import java.util.ArrayList;

public class ViveroInteligente extends Vivero {
	public int humedadOptima;

	public ViveroInteligente(int c, ArrayList<Planta> plantas) {
		super(c, plantas);
		this.humedadOptima = 70;
	}

	public ViveroInteligente(int c) {
		super(c);
		this.humedadOptima = 70;
	}

	public int getHumedadOptima() {
		return humedadOptima;
	}

	public void setHumedadOptima(int humedadOptima) {
		this.humedadOptima = humedadOptima;
	}
	
	public void regarPlantas() {
		for(Planta planta: plantas) {
			if(!planta.isEstaRegada() && planta.getNivelHumedad()< humedadOptima) {
				planta.setEstaRegada(true);
				planta.setNivelHumedad(humedadOptima);
			}
		}
	}

	@Override
	public String toString() {
		return "ViveroInteligente [capacidad=" + capacidad + ", humedad optima=" + humedadOptima +  ", plantas=" + plantas+ "]";
	}


}
