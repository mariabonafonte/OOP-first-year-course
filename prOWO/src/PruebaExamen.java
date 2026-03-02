import owo.MicroSensacion;
import owo.MicroSensacionMusculos;
import owo.Musculo;
import owo.Sensacion;
import java.util.List;

public class PruebaExamen {

	public static void main(String[] args) {
		// Crear microsensacion caida
		MicroSensacion caida= new MicroSensacion(100,50,0.5,0,0,0.0);
		System.out.println("\n*** pruebas Microsensacion:Constructor ***");
		System.out.println("Microsensacion caida: "+caida);
		System.out.println("\n*** pruebas Microsensacion:Parámetros incorrectos ***");
		try {
			MicroSensacion erronea= new MicroSensacion(100,150,0.5,0,0,0.0);
		} catch(RuntimeException e) {
			System.out.println(e);
		}
		// Crear microsensacion impacto
		MicroSensacionMusculos impacto= new MicroSensacionMusculos(100,90,0.2,0,100,1.0);
		impacto.addMusculo(Musculo.LeftDorsal);
		impacto.addMusculo(Musculo.RightDorsal);
		impacto.addMusculo(Musculo.LeftLumbar);
		impacto.addMusculo(Musculo.RightLumbar);
		impacto.addMusculo(Musculo.LeftAbdominal);
		System.out.println("\n*** pruebas MicrosensacionMusculos: Constructor y addMusculo ***");
		System.out.println("Microsensacion impacto: "+impacto);
		impacto.remMusculo(Musculo.LeftAbdominal);
		System.out.println("\n*** pruebas MicrosensacionMusculos: EliminarMusculo ***");
		System.out.println("Microsensacion impacto: "+impacto);
		
		// Crear sensación
		Sensacion sCaida=new Sensacion();
		sCaida.addMicroSensacion(caida);
		sCaida.addMicroSensacion(impacto);
		System.out.println("\n*** pruebas Sensacion: Constructor Defecto y addMicroSensacion ***");
		System.out.println("Sensacion sCaida: "+sCaida);
		
		Sensacion sCaida2=new Sensacion(List.of(caida,impacto));
		System.out.println("\n*** pruebas Sensacion: Constructor Lista ***");
		System.out.println("Sensacion sCaida2: "+sCaida2);
		
	}

}
