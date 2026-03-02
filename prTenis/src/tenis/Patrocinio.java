package tenis;

public class Patrocinio {
	String marca;
	double cantidadMensual;
	
	public Patrocinio(String marca, double cantidadMensual) {
		this.marca = marca;
		this.cantidadMensual = cantidadMensual;
	}

	public double getCantidadMensual() {
		return cantidadMensual;
	}

	@Override
	public String toString() {
		return marca + "(" + cantidadMensual + ")";
	}
	
	

	

}
