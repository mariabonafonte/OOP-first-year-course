package jarras;

public class Jarra {

    private final int capacidad;  //final hace q una vez se haya establecido no se puede modificar
    private int contenido;
    
    public Jarra(int c) { //Constructor de la clase jarra (debe llamarse exactamente igual que la clase)
        if(c<=0) {
        	throw new RuntimeException("Error, capacidad incorrecta");
        }
    	capacidad = c;
        contenido = 0;
        
    }
    
    public int capacidad() {
        return capacidad;
    }
    
    public int contenido() {
        return contenido;
    }
    
    public void vacia() {
        contenido = 0;
    }
    
    public void llena() {
        contenido = capacidad;
    }
    
    public void llenaDesde(Jarra otra) {
        if(this == otra) {
            throw new RuntimeException("Las jarras son iguales");
        }
        int espacioLibre = this.capacidad - this.contenido;
        int c = Math.min(espacioLibre, otra.contenido);
            this.contenido += c;
            otra.contenido -= c;
        }
    
    
    @Override
    public String toString() {
        return "J(" + capacidad + "," + contenido + ")";
    }
}

