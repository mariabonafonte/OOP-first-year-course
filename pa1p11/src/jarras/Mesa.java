package jarras;

public class Mesa {
	
	public enum Posicion {Izquierda, Derecha}
	
	private Jarra JIzq,JDch;
	
	public Mesa (Jarra jI, Jarra jD) {
		if (jI==jD) {
			throw new RuntimeException("Las jarras no pueden ser iguales");
		}
		JIzq = jI;
		JDch = jD;
	}
	
	public Mesa(int cI, int cD) {
		JIzq = new Jarra(cI);
		JDch = new Jarra(cD);
	}
	
	public int capacidad(Posicion p) {
		if (p == Posicion.Izquierda) {
			return JIzq.capacidad();
			
		}else{
			return JDch.capacidad();
		}
	}
	
	public int contenido(Posicion p) {
		if (p == Posicion.Izquierda) {
			return JIzq.contenido();
			
		}else{
			return JDch.contenido();
		}
	}
	
	public void llena(Posicion p) {
		if (p == Posicion.Izquierda) {
			 JIzq.llena();
			
		}else{
			 JDch.llena();
		}
	}
	
	
	public void vacia(Posicion p) {
		if (p == Posicion.Izquierda) {
			JIzq.vacia();
			
		}else{
			JDch.vacia();
		}
	}
	
	public void llenarDesde(Posicion p) {
		if (p == Posicion.Izquierda) {
			 JDch.llenaDesde(JIzq);
			
		}else{
			 JIzq.llenaDesde(JDch);
		}
	}
	
	 @Override
	    public String toString() {
	        return "M(" + JIzq + "," + JDch + ")";
	    }
}
