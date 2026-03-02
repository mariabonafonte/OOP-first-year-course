import notas.Estudiante;
import notas.EstudianteException;

public class PruebaEstudiante {
    public static void main(String[] args) {
        try {
            Estudiante estudiante1 = new Estudiante("22456784F", "Gonzalez Perez, Juan", 5.5);
            Estudiante estudiante2 = new Estudiante("33456777S", "Gonzalez Perez, Juan", 3.4);

            System.out.println("Estudiante 1: " + estudiante1.getNombre() + ", DNI: " + estudiante1.getDni() + ", Nota: " + estudiante1.getNota());
            System.out.println("Estudiante 2: " + estudiante2.getNombre() + ", DNI: " + estudiante2.getDni() + ", Nota: " + estudiante2.getNota());

            if (estudiante1.equals(estudiante2)) {
                System.out.println("Los estudiantes son iguales.");
            } else {
                System.out.println("Los estudiantes son diferentes.");
            }

            // Modifying the second student's grade to -3.4 to trigger the exception
            try {
                Estudiante estudiante3 = new Estudiante("33456777S", "Gonzalez Perez, Juan", -3.4);
                System.out.println("Estudiante 3: " + estudiante3.getNombre() + ", DNI: " + estudiante3.getDni() + ", Nota: " + estudiante3.getNota());
            } catch (EstudianteException e) {
                System.out.println("Excepción capturada: " + e.getMessage());
            }

        } catch (EstudianteException e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        }
    }
}