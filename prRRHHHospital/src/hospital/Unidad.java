package hospital;

import java.util.ArrayList;
import java.util.List;

public class Unidad {
	private String nombre;
	private List<PersonalSanitario> personal;

	public Unidad(String nombre) {
		this.nombre = nombre;
		personal = new LinkedList<PersonalSanitario>();
	}


	public Unidad(String nombre, String[] personal) {
		this(nombre);
		for (String linea : personal) {
			try {
				addTrabajador(new PersonalSanitario(linea));
			} catch (HospitalException e) {
			}
		}
	}
	

}
