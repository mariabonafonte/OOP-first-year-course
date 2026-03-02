package paciente;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class GestorCitas {
	
	private Map<Integer, Paciente> pacientes;
	private Map<Integer, CitaMedica> citas;
	
	public GestorCitas() {
		super();
		this.pacientes = new HashMap<>();
		this.citas = new HashMap<>();
		
	}
	
	private void splits(String linea) {
		String[] lista = linea.split(";");
		if(lista[0].compareToIgnoreCase("P") == 0) {
			int id = Integer.parseInt(lista[1]);
			String nombre = lista[2];
			LocalDate fechaNac = LocalDate.parse(lista[3]);
			String genero = lista[4];
			Paciente p = new Paciente(id, nombre, fechaNac, genero);
			pacientes.put(id, p);
			
		}else if (lista[0].compareToIgnoreCase("C") == 0){
			int id = Integer.parseInt(lista[1]);
			LocalDateTime fecha = LocalDateTime.parse(lista[2]);
			Especialidad esp = Especialidad.valueOf(lista[3]);
			String doctor = lista[4];
			CitaMedica c = new CitaMedica(id, fecha, esp, doctor);
			citas.put(id, c);
		}
		
	}
	public void mostrarDatos() {
        // Ejemplo: mostrar cuantos has cargado
       System.out.printf("Pacientes cargados: %d%n", pacientes.size());
       System.out.printf("Citas cargadas:    %d%n", citas.size());
       
       for(Map.Entry<Integer,Paciente> entry: pacientes.entrySet()) {
           System.out.println("Paciente id " + entry.getKey() + " " + entry.getValue());
       }
       
       for(Map.Entry<Integer,CitaMedica> entry: citas.entrySet()) {
           System.out.println("Paciente id " + entry.getKey() + " " + entry.getValue());
       }
       
   }

	
	public void cargarDatos (String nomFich) {
		try(Scanner sc = new Scanner(new File(nomFich))) {
			pacientes.clear();
			citas.clear();
			while(sc.hasNextLine()) {
				splits(sc.next());
				
			}
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	

}
