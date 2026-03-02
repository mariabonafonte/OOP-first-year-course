package hospital;

import java.util.Objects;

public class Paciente {

    private String nombre;
    private String apellidos;
    private String nuss;
    private int anoDeNacimiento;
    public Paciente(String nombre, String apellidos, String nuss, int anoDeNacimineto) throws HospitalException {
        if(nombre == null || apellidos == null || nuss == null ) {
            throw new HospitalException("No se admiten elementos nulos");
        }
        if(nuss.length() != 10) {
            throw new HospitalException("El nuss debe tener 10 dígitos: " + nuss);
        }
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nuss = nuss;
        this.anoDeNacimiento = anoDeNacimineto;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public String getNuss() {
        return nuss;
    }
    public int getAnoDeNacimiento() {
        return anoDeNacimiento;
    }
    
	@Override
    public boolean equals(Object o) {
    return (o instanceof Paciente p)
    		&& p.nombre.equalsIgnoreCase(apellidos)
    		&& p.apellidos.equalsIgnoreCase(apellidos)
    		&& p.anoDeNacimiento == anoDeNacimiento;
    }
    @Override
    public int hashCode() {
    return Objects.hash(nombre.toLowerCase(),apellidos.toLowerCase(),anoDeNacimiento);
    }
    @Override
    public String toString() {
        return "Paciente [nombre=" + nombre + ", apellido=" + apellidos + ", anoDeNacimiento="
                + anoDeNacimiento + "]";
    }
    public int compareTo(Paciente p) {
        int res = 0;
        if(this.anoDeNacimiento < p.getAnoDeNacimiento()) {
            res = 1;
        }
        else if(this.anoDeNacimiento > p.getAnoDeNacimiento()) {
            res = -1;
        }
        else {
            if(res == 0) {
                res = apellidos.compareToIgnoreCase(p.apellidos);
                if(res  == 0) {
                    res = nombre.compareToIgnoreCase(p.nombre);
                }
            }
        }
        return res;
    }
    
    
}