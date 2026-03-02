package chatbots;

public interface Intencion {
	boolean inicializarFrases(String fichero);
	void inicializarSinonimos(String fichero);
	String consulta();
	String consulta(String fraseUsuario);
	String sugerencia();
}
