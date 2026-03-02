import paciente.GestorCitas;

public class Principal {

	public static void main(String[] args) {
		GestorCitas gc = new GestorCitas();
		gc.cargarDatos("fichero.txt");
		gc.mostrarDatos();

	}

}
