

import java.util.List;

import rehab.Tratamiento;
import rehab.TratamientoLocalizado;
import rehab.Zona;
import rehab.Sesion;

public class PruebaExamen {

	public static void main(String[] args) {
		// Crear tratamiento completo
		Tratamiento completo = new Tratamiento(100, 5, 120.0, 10, 10, 0);
		System.out.println("\n*** pruebas Tratamiento:Constructor ***");
		System.out.println("Tratamiento completo: " + completo);
		System.out.println("\n*** pruebas Tratamiento:Parámetros incorrectos ***");
		try {
			Tratamiento erronea = new Tratamiento(100, 10, 0.5, 0, 0, 0);
		} catch (RuntimeException e) {
			System.out.println(e);
		}
		// Crear tratamiento localizado
		TratamientoLocalizado localizadot = new TratamientoLocalizado(100, 3, 490.0, 0, 100, 120);
		localizadot.addZona(Zona.ZonaLumbar);
		localizadot.addZona(Zona.ZonaCervical);
		localizadot.addZona(Zona.ZonaDorsal);
		localizadot.addZona(Zona.ZonaDorsal);
		

		System.out.println("\n*** pruebas Tratamiento Localizado: Constructor y addZona ***");
		System.out.println("Tratamiento Localizado: " + localizadot);
		localizadot.remZona(Zona.ZonaDorsal);
		localizadot.remZona(Zona.Caderas);

		System.out.println("\n*** pruebas Tratamiento Localizado: Eliminar Zona Dorsal ***");
		System.out.println("Tratamiento Localizado: " + localizadot);

		// Crear Sesión
		Sesion completa = new Sesion();
		completa.addTratamiento(completo);
		completa.addTratamiento(localizadot);
		System.out.println("\n*** pruebas Sesión: Constructor Defecto y addTratamiento ***");
		System.out.println("Sesión completa: " + completa);

		Sesion completaylocalizada = new Sesion(List.of(completo, localizadot));
		System.out.println("\n*** pruebas Sesión: Constructor Lista ***");
		System.out.println("Sesión completaylocalizada: " + completaylocalizada);

	}

}
