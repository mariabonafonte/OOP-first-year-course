package personal;

public interface GestionPersonas {
	/**
     * Añade una persona al sistema.
     * @param p Persona a añadir.
     * @return true si se añadió correctamente, false si ya existía.
     */
    boolean add(Persona p);

    /**
     * Elimina una persona del sistema.
     * @param p Persona a eliminar.
     * @return true si se eliminó correctamente, false si no existía.
     */
    boolean remove(Persona p);

    /**
     * Guarda la colección de personas en un fichero.
     * @param rutaFichero Ruta o nombre del fichero donde guardar.
     */
    void guardarAFichero(String rutaFichero);
    
    /**
     * Lee personas desde un fichero y las carga en el sistema, borrando antes su contenido.
     * @param rutaFichero Ruta o nombre del fichero desde donde leer.
     */
    void leerDeFichero(String rutaFichero);

}

