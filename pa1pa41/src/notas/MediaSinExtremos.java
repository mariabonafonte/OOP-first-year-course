package notas;

import java.util.List;

public class MediaSinExtremos implements CalculoMedia {
    private double min;
    private double max;

    public MediaSinExtremos(double min, double max) {
        this.min = min;
        this.max = max;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }

    @Override
    public double calcular(List<Estudiante> estudiantes) throws EstudianteException {
        double suma = 0;
        int count = 0;
        for (Estudiante estudiante : estudiantes) {
            double nota = estudiante.getNota();
            if (nota >= min && nota <= max) {
                suma += nota;
                count++;
            }
        }
        if (count == 0) {
            throw new EstudianteException("No hay estudiantes");
        }
        return suma / count;
    }
}