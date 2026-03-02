package notas;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Asignatura {
    private String nombre;
    private List<Estudiante> estudiantes;
    private List<String> errores;

    public Asignatura(String nombre, String[] datosEstudiantes) {
        this.nombre = nombre;
        this.estudiantes = new ArrayList<>();
        this.errores = new ArrayList<>();

        for (String datos : datosEstudiantes) {
            try {
                Scanner sc = new Scanner(datos).useDelimiter("\\s*[;]\\s*");
                sc.useLocale(Locale.ENGLISH);
                String dni = sc.next();
                String nombreCompleto = sc.next();
                double calificacion = sc.nextDouble();

                if (calificacion < 0) {
                    errores.add("ERROR. Calificación negativa: " + datos);
                } else {
                    estudiantes.add(new Estudiante(dni, nombreCompleto, calificacion));
                }
            } catch (Exception e) {
                String errorMessage = e.getMessage();
                if (errorMessage == null) {
                    errores.add("ERROR. Desconocido: " + datos);
                } else if (errorMessage.contains("No line found")) {
                    errores.add("ERROR. Faltan datos: " + datos);
                } else if (errorMessage.contains("For input string")) {
                    errores.add("ERROR. Nota no numérica: " + datos);
                } else {
                    errores.add("ERROR. Desconocido: " + datos);
                }
            }
        }
    }

    public double getCalificacion(Estudiante est) throws EstudianteException {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.equals(est)) {
                return estudiante.getNota();
            }
        }
        throw new EstudianteException("Estudiante " + est.toString() + " no se encuentra");
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public List<String> getErrores() {
        return errores;
    }

    public double getMedia() throws EstudianteException {
        if (estudiantes.isEmpty()) {
            throw new EstudianteException("No hay estudiantes");
        }
        double suma = 0;
        for (Estudiante estudiante : estudiantes) {
            suma += estudiante.getNota();
        }
        return suma / estudiantes.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nombre).append(": { ");
        sb.append("[");
        for (int i = 0; i < estudiantes.size(); i++) {
            sb.append(estudiantes.get(i));
            if (i < estudiantes.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("], ");
        sb.append("[");
        for (int i = 0; i < errores.size(); i++) {
            sb.append(errores.get(i));
            if (i < errores.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("] }");
        return sb.toString();
    }
}