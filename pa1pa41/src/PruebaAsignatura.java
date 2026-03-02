import notas.Asignatura;
import notas.Estudiante;
import notas.EstudianteException;

public class PruebaAsignatura {
    public static void main(String[] args) {
     
        String[] datosEstudiantes = {
            "12455666F;Lopez Perez, Pedro;6.7",
            "33678999D;Merlo Gomez, Isabel;5.8",
            "23555875G;Martinez Herrera, Lucia;9.1"
        };

        Asignatura pa1 = new Asignatura("PA1", datosEstudiantes);

        try {
            System.out.println("Media de las calificaciones: " + pa1.getMedia());

            
            for (Estudiante est : pa1.getEstudiantes()) {
                System.out.println("DNI: " + est.getDni());
            }

            Estudiante lopezPerez = new Estudiante("12455666F", "Lopez Perez, Pedro");
            System.out.println("Calificación de Lopez Perez, Pedro: " + pa1.getCalificacion(lopezPerez));

            
            Estudiante lopezLopez = new Estudiante("12455666F", "Lopez Lopez, Pedro");
            System.out.println("Calificación de Lopez Lopez, Pedro: " + pa1.getCalificacion(lopezLopez));
        } catch (EstudianteException e) {
            System.err.println(e.getMessage());
        }
    }
}