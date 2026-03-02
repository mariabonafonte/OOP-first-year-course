
package humanos;

public class Estudiante implements Comparable {
    protected static int estudiantesInstanciados = 0; 
    protected int edad;
    protected String nombre;
    protected String primerApellido;
    
    public Estudiante(int edad, String nombre, String primerApellido) {
    	this.edad = edad;
    	this.nombre = nombre;
    	this.primerApellido = primerApellido;
    	getestudiantesInstanciados();
    	
    }
    public Estudiante(String nombre, String primerApellido) {
    	this.edad = 18;
    	this.nombre = nombre;
    	this.primerApellido = primerApellido;
    	getestudiantesInstanciados();
    }
    
    public Estudiante(int i, String string, String string2, String string3) {
		// TODO Auto-generated constructor stub
	}
	public void cambiarEdad(int nuevaEdad) {
        edad = nuevaEdad;
    }
    public int getEdad(){
        return edad;
    }
    public String  getNombreCompleto(){
        return nombre + primerApellido ;
    }
    public boolean esMayor(Estudiante otro) {
        return this.getEdad() > otro.getEdad(); 
    }
    public boolean esMenor(Estudiante otro){
    	return this.getEdad() < otro.getEdad(); 
    }
    public boolean mismoApellido(Estudiante otro){
        return this.primerApellido == otro.primerApellido;
    }
    public static int getestudiantesInstanciados() {
        return estudiantesInstanciados += 1;
    }
    
    @Override
    public int compareTo(Object o) {
    int resultado=0;//asumo que son iguales
    if (this.edad>((Estudiante)o).edad){
        resultado=1;
    }
    else if (this.edad<((Estudiante)o).edad){
        resultado=-1;
    }
        return resultado;
    }
    
    public enum Curso {
        Primero, Segundo, Tercero, Cuarto
    }
    
    protected int obtener_ultimo_curso(){
        return 0 ;
    }
    
    public void cambiar_ultimo_curso(Curso_u){
        curso = Curso_u;
    }
    
}
    

