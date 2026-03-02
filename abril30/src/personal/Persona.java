package personal;

import java.util.Objects;

public class Persona {
	private final String nombre;
    private int edad;
    private Provincia provincia;
    
    public Persona(String nombre, int edad, Provincia provincia) {
        this.nombre = nombre;
        setEdad(edad);
        this.provincia = provincia;
    }

    public void setEdad(int edad){
    if(edad<0 || edad >120) {
        throw new IllegalArgumentException("Edad de la persona no vÃ¡lida, rango [0-120]");
        }
        else this.edad = edad;
    }

    public String getName(){ 
        return nombre;
    }
    public int getEdad(){
        return edad;
    }
    
    
    
	@Override
	public int hashCode() {
		return Objects.hash(edad, nombre, provincia);
	}

	@Override
	public boolean equals(Object o) {
		return (o instanceof Persona p)
		&& p.edad == edad
		&& p.nombre.equals(nombre)
		&& p.provincia.equals(provincia);
	}

	@Override
	public String toString() {
		return "Persona [nombre = " + nombre + ", edad = " + edad + "]";
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	
    
    
}


