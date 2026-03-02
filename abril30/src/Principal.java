import personal.ConjuntoPersonas;
import personal.Persona;
import personal.Provincia;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConjuntoPersonas conjunto1 = new ConjuntoPersonas();
		
		System.out.println(conjunto1 );
		
		conjunto1.guardarAFichero("datos.txt");
		
		
		ConjuntoPersonas cp = new ConjuntoPersonas();
        System.out.println(cp);
        
        // Hombres
        cp.add(new Persona("Antonio", 10, Provincia.ALMERIA));
        cp.add(new Persona("Manuel", 11, Provincia.CADIZ));
        cp.add(new Persona("David", 12, Provincia.CORDOBA));
        cp.add(new Persona("José", 13, Provincia.GRANADA));
        cp.add(new Persona("Juan", 14, Provincia.HUELVA));
        cp.add(new Persona("Francisco", 15, Provincia.JAEN));
        cp.add(new Persona("Javier", 16, Provincia.MALAGA));
        cp.add(new Persona("Sergio", 17, Provincia.SEVILLA));
        cp.add(new Persona("Miguel", 18, Provincia.ALMERIA));
        cp.add(new Persona("Pablo", 19, Provincia.CADIZ));
        cp.add(new Persona("Álvaro", 20, Provincia.CORDOBA));
        cp.add(new Persona("Diego", 10, Provincia.GRANADA));
        cp.add(new Persona("Alberto", 11, Provincia.HUELVA));
        cp.add(new Persona("Fernando", 12, Provincia.JAEN));
        cp.add(new Persona("Ricardo", 13, Provincia.MALAGA));

        // Mujeres
        cp.add(new Persona("Carmen", 14, Provincia.SEVILLA));
        cp.add(new Persona("María", 15, Provincia.ALMERIA));
        cp.add(new Persona("Lucía", 16, Provincia.CADIZ));
        cp.add(new Persona("Ana", 17, Provincia.CORDOBA));
        cp.add(new Persona("Laura", 18, Provincia.GRANADA));
        cp.add(new Persona("Isabel", 19, Provincia.HUELVA));
        cp.add(new Persona("Elena", 20, Provincia.JAEN));
        cp.add(new Persona("Marta", 10, Provincia.MALAGA));
        cp.add(new Persona("Sonia", 11, Provincia.SEVILLA));
        cp.add(new Persona("Raquel", 12, Provincia.ALMERIA));
        cp.add(new Persona("Natalia", 13, Provincia.CADIZ));
        cp.add(new Persona("Patricia", 14, Provincia.CORDOBA));
        cp.add(new Persona("Cintia", 15, Provincia.GRANADA));
        cp.add(new Persona("Pilar", 16, Provincia.HUELVA));
        cp.add(new Persona("Sara", 17, Provincia.JAEN));
        
        System.out.println(cp);
	}
	

}
