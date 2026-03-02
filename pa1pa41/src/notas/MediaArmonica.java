package notas;

import java.util.List;

public class MediaArmonica implements CalculoMedia{

	@Override
	public double calcular(List<Estudiante> estudiantes) throws EstudianteException {
        double sumaInversos = 0;
        int count = 0;
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getNota() > 0) {
                sumaInversos += 1 / estudiante.getNota();
                count++;
            }
        }
        if (count == 0) {
            throw new EstudianteException("No hay estudiantes");
        }
        return count / sumaInversos;
    }
}