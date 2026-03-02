package notas;

import java.util.List;

public class MediaAritmetica implements CalculoMedia{

	@Override
	public double calcular(List<Estudiante> estudiantes) throws EstudianteException {
		// TODO Auto-generated method stub
		if(estudiantes.isEmpty()) {
			throw new EstudianteException ("No hay estudiantes");
		}
		double suma = 0;
		for (Estudiante estudiante : estudiantes) {
			suma += estudiante.getNota();
		}
		
		return suma/estudiantes.size();
	}

}
