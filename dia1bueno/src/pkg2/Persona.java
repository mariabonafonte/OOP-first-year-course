
package pkg2;

public class Persona {
    protected static int personasInstanciadas = 0; 
    protected int edad;
    protected String nombre;
    protected String primerApellido;
    
    public Persona(int edad, String nombre, String primerApellido) {
    	this.edad = edad;
    	this.nombre = nombre;
    	this.primerApellido = primerApellido;
    	getPersonasInstanciadas();
    	
    }
    public Persona(String nombre, String primerApellido) {
    	this.edad = 18;
    	this.nombre = nombre;
    	this.primerApellido = primerApellido;
    	getPersonasInstanciadas();
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
    public boolean esMayor(Persona otro) {
        return this.getEdad() > otro.getEdad(); 
    }
    public boolean esMenor(Persona otro){
    	return this.getEdad() < otro.getEdad(); 
    }
    public boolean mismoApellido(Persona otro){
        return this.primerApellido == otro.primerApellido;
    }
    private static int getPersonasInstanciadas() {
        return personasInstanciadas += 1;
    }
    
}

