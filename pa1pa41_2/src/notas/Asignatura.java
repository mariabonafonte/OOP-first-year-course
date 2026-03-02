package notas;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Asignatura {
	private String nombre;
	private List<Estudiante> estudiantes;
	private List<String> errores;

	public Asignatura(String n, String[] ests) {
		this.nombre = n;
		this.estudiantes = new ArrayList<>(); 
		this.errores = new ArrayList<>(); 
		
		
		for(String datos: ests) {
			try {
				Scanner scanner = new Scanner(datos);
				scanner.useDelimiter("\\s*[;]\\s*");
				scanner.useLocale(Locale.ENGLISH);

                String dni = scanner.next();
                String nombreCompleto = scanner.next();
                double calificacion;
                
                try {
                	calificacion = scanner.nextDouble();
                }catch(NumberFormatException e) {
                	errores.add("ERROR. Nota no numérica: " + datos);
                    continue;
                }
                
                if (calificacion < 0) {
                    errores.add("ERROR. Calificación negativa: " + datos);
                    continue;
                }

                Estudiante estudiante = new Estudiante(dni, nombreCompleto, calificacion);
                estudiantes.add(estudiante);
                
			} catch (EstudianteException e) {
                errores.add("ERROR. Faltan datos: " + datos);
            }
		}
	}

	public String getNombre() {
		return nombre;
	}

	public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public List<String> getErrores() {
		return errores;
	}
	
	public double getCalificacion(Estudiante e) {
		double calificacion = 0;
		
		for (Estudiante estudiante: estudiantes) {
			if(estudiante.equals(e)) {
				calificacion = estudiante.getNota();
			}else {
				throw new EstudianteException("Estudiante "+ e.getNombre() + e.getDni() +" no se encuentra");	
				}
			}
		return calificacion;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
        sb.append(nombre).append(": { [");

        for (int i = 0; i < estudiantes.size(); i++) {
            Estudiante estudiante = estudiantes.get(i);
            sb.append(estudiante.getNombre())
              .append(" ")
              .append(estudiante.getDni());

            if (i < estudiantes.size() - 1) {
                sb.append(", ");
            }
        }

        sb.append("], [");
        
        for (int i = 0; i < errores.size(); i++) {
            sb.append(errores.get(i));
            if (i < errores.size() - 1) {
                sb.append(", ");
            }
        }

        sb.append("] }");

        return sb.toString();
    }
	
	public double getMedia() {
		
	}
	

}
