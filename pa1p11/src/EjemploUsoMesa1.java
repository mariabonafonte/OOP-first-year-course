import jarras.Mesa;
import jarras.Mesa.Posicion;

public class EjemploUsoMesa1 {
	
	public static void main(String[] args) {
		Mesa mesa = new Mesa(7, 5);
		System.out.println(mesa); // M(J(7, 0), J(5, 0))

		mesa.llena(Posicion.Derecha);
		System.out.println(mesa); // M(J(7, 0), J(5, 5))

		mesa.llenarDesde(Posicion.Derecha);
		System.out.println(mesa); // M(J(7, 5), J(5, 0))

		mesa.llena(Posicion.Derecha);
		System.out.println(mesa); // M(J(7, 5), J(5, 5))

		mesa.llenarDesde(Posicion.Derecha);
		System.out.println(mesa); // M(J(7, 7), J(5, 3))

		mesa.vacia(Posicion.Izquierda);
		System.out.println(mesa); // M(J(7, 0), J(5, 3))

		mesa.llenarDesde(Posicion.Derecha);
		System.out.println(mesa); // M(J(7, 3), J(5, 0))

		mesa.llena(Posicion.Derecha);
		System.out.println(mesa); // M(J(7, 3), J(5, 5))

		mesa.llenarDesde(Posicion.Derecha);
		System.out.println(mesa); // M(J(7, 7), J(5, 1))
	}
}
