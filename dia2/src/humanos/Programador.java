package humanos;

public class Programador extends Estudiante {
	
	protected String lenguajeFavorito;

	public Programador(int edad, String nombre, String primerApellido) {
		super(edad, nombre, primerApellido);
		lenguajeFavorito = "ninguno";
		// TODO Auto-generated constructor stub
	}

	public Programador(String nombre, String primerApellido) {
		super(nombre, primerApellido);
		lenguajeFavorito = "ninguno";
		// TODO Auto-generated constructor stub
	}
	
	 public Programador(int edad, String nombre, String primerApellido, String lengFavorito) {
		 super(edad, nombre, primerApellido);
		 this.lenguajeFavorito = lengFavorito;

	 }
	 public Programador(String nombre, String primerApellido, String lengFavorito) {
		 super(nombre, primerApellido);
		 this.lenguajeFavorito = lengFavorito;
	 }
	 public void setLenguajeFavorito(String nuevoLenguaje){
		 this.lenguajeFavorito = nuevoLenguaje;
	 }
	 public String getLenguajeFavorito(){
		 return lenguajeFavorito;
	 }
	 public boolean mismoLenguaje(Programador otro){
		 return this.lenguajeFavorito == otro.lenguajeFavorito;
	 }
	
}