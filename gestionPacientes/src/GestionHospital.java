import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import pacientes.PAmbulatorios;
import pacientes.PHospitalizados;
import pacientes.Pacientes;
import personal.Medico;

public class GestionHospital {
	private List<Medico> listaMedicos;
	private List<Pacientes> listaPacientes;
	private Map<String,Boolean> habitaciones;

	public GestionHospital() {
	     listaMedicos= new ArrayList<Medico>();
	     listaPacientes= new ArrayList<Pacientes>();
	     habitaciones = new HashMap<String,Boolean>();
	  }
	    public void addMedico(Medico med) {
	       listaMedicos.add(med);    
	       }

	    public boolean removeMedico(String nombre, String apellido) {
	        boolean encontrado = false;
	        Iterator<Medico> iter = listaMedicos.iterator();
	        while (iter.hasNext()&&!(encontrado)) {
	            Medico aux = iter.next();
	            if (aux.getNombre().compareToIgnoreCase(nombre)==0&&
	            		aux.getApellido().compareToIgnoreCase(apellido)==0) {
	                iter.remove();
	                encontrado = true;
	            }
	        }
	        return encontrado;
	    }

	    public String listarMedicos() {
	        String result = "";
	        for (Medico m : listaMedicos) { //Bucle foreach de Java, permite iterar sobre todos los elementos.
	            result += m.toString() + "\n";
	        }
	        return result;
	    }
	    public void addPaciente(Pacientes paciente) {
	    	listaPacientes.add(paciente);
	    }

	    public boolean removePacientes(String nombre, String apellido) {
	        return false;
	    }

	    public String listarPacientes() {
	    	String hospitalizados = "";
	    	String ambulatorios = "";
	        for (Pacientes m : listaPacientes) {
	        	if (PHospitalizados.class.isInstance(m)){
	        		hospitalizados += m.toString() + "\n";
	        	}else {
	        	ambulatorios += m.toString() + "\n";
	        	}
	        }
	        return hospitalizados + "\n" + ambulatorios ;
	    }

	    public void asignarMedico(Medico med, Pacientes paciente) {
	       paciente.setMedico(med);
	    }
	    
		public void crearHabitacion(String nombre) {
			if(habitaciones.containsKey(nombre)) {
				throw new RuntimeException("Ya se ha introducido esta habitacion");
			}
			habitaciones.put(nombre, false);
			
		}
			
		public void eliminarHabitacion(String nombre) {
			if(!habitaciones.containsKey(nombre)) {
				throw new RuntimeException("La Habitacion" + nombre + "no se puede eliminar porque no existe");
			}
			habitaciones.remove(nombre);
			}
		
		public void asignarHabitacion(PHospitalizados p, String habitacion) {
		    if (!habitaciones.containsKey(habitacion) && !habitaciones.get(habitacion)) {
		        p.setHabitacion(habitacion);
		        habitaciones.put(habitacion, true);
		    } else {
		        throw new RuntimeException("Habitación no disponible o no existente");
		    }

		}
}
