package paciente;

import java.time.LocalDate;

public class Paciente {
	
	    private final int id;
	    private final String nombre;
	    private final LocalDate fechaNacimiento;
	    private String genero;
	    // constructores, getters/setters, toString…
		public Paciente(int id, String nombre, LocalDate fechaNacimiento, String genero) {
			super();
			this.id = id;
			this.nombre = nombre;
			this.fechaNacimiento = fechaNacimiento;
			this.genero = genero;
		}
		public String getGenero() {
			return genero;
		}
		public void setGenero(String genero) {
			this.genero = genero;
		}
		public int getId() {
			return id;
		}
		public String getNombre() {
			return nombre;
		}
		public LocalDate getFechaNacimiento() {
			return fechaNacimiento;
		}
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Paciente [id=");
			builder.append(id);
			builder.append(", nombre=");
			builder.append(nombre);
			builder.append(", fechaNacimiento=");
			builder.append(fechaNacimiento);
			builder.append(", genero=");
			builder.append(genero);
			builder.append("]");
			return builder.toString();
		}
		
		
		
		
	    

}
