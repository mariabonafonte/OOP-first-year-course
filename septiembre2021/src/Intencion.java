
public interface Intencion {
	boolean inicializarFrases(String fichero);
	//Inicializa las frases de respuesta. Devuelve true si se inicializó correctamente.
	void inicializarSinonimos(String fichero);
	//Inicializa la lista de sinónimos del tema seleccionado.
	String consulta();
	//Devuelve una frase aleatoria sobre cualquier concepto.
	String consulta(String fraseUsuario);
	//Devuelve una frase relacionada con el concepto indicado
	String sugerencia();
	//Devuelve un tema (concepto) aleatoriamente de entre los disponibles
}
