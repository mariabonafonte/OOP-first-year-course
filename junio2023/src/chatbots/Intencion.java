package chatbots;

public interface Intencion {
	public boolean inicializarFrases(String fichero);
	//Inicializa las frases de respuesta. Devuelve true si se inicializó correctamente.
	public void inicializarSinonimos(String fichero);
	//Inicializa la lista de sinónimos del tema seleccionado.
	public String consulta();
	//Devuelve una frase aleatoria sobre cualquier concepto.
	public String consulta(String fraseUsuario);
	//Devuelve una frase relacionada con el concepto indicado
	public String sugerencia();
	//Devuelve un tema (concepto) aleatoriamente de entre los disponibles
}
