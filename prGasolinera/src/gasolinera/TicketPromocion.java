package gasolinera;

public class TicketPromocion extends Ticket {
	private double descuento;

	public TicketPromocion(int numero, String nombre, String matricula, double litros, double precio,
			double descuento) {
		super(numero, nombre, matricula, litros, precio);
		this.descuento = descuento;
	}

	@Override
	public double getPrecioTotal() {
		return super.getPrecioTotal()*(1-descuento);
	}
	
	public String toString() {
		return "PROMOCION "+ descuento*100 + "%: " + super.toString();
	}
	
	

}
