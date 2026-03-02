package tenis;

public class Entrenador extends Integrante {
	double porcObjetivoCumplido;
	double complementoObjetivos;

	public Entrenador(String nombre, int edad, double sueldo, double cuenta, double porcObjetivoCumplido,
			double complementoObjetivos) {
		super(nombre, edad, sueldo, cuenta);
		this.porcObjetivoCumplido = porcObjetivoCumplido;
		this.complementoObjetivos = complementoObjetivos;
		this.setTipo(TipoParticipante.entrenador);
	}

	@Override public void cobrar() {
		cuenta+=sueldo+complementoObjetivos*porcObjetivoCumplido/100;	
	}
	
	@Override public String toString() {
		return super.toString()+" Objetivos: "+ this.complementoObjetivos+"("+porcObjetivoCumplido+")";
	}
}

