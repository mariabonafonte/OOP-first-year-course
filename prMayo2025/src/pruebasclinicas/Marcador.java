package pruebasclinicas;

public class Marcador {
	private String nombre;
	private double valorMinimo;
	private double valorMaximo;
	private double valorActual;
	public Marcador(String nombre, double valorMinimo, double valorMaximo, double valorActual) {
		super();
		this.nombre = nombre;
		this.valorMinimo = valorMinimo;
		this.valorMaximo = valorMaximo;
		this.valorActual = valorActual;
	}
	public double getValorActual() {
		return valorActual;
	}
	public void setValorActual(double valorActual) {
		this.valorActual = valorActual;
	}
	public String getNombre() {
		return nombre;
	}
	public double getValorMinimo() {
		return valorMinimo;
	}
	public double getValorMaximo() {
		return valorMaximo;
	}
	
	public String analizar() {
		StringBuilder sb = new StringBuilder(nombre);

		if(valorActual>valorMinimo && valorActual<valorMaximo) {
			sb.append(" normal: ");
		} else if(valorActual<valorMinimo) {
			sb.append(" bajo: ");
		}else if(valorActual>valorMaximo) {
			sb.append(" alto: ");
		}
		sb.append(valorActual +" (normal: " + valorMinimo + "-" + valorMaximo + ")" );
		return sb.toString();
	}
	

	

}
