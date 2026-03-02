import java.util.List;

import canciones.Cancion;
import canciones.Estilo;

public class MainCancion {

	public static void main(String[] args) {
		Cancion c1 = new Cancion("Musica ligera", List.of("Ana Mena"), 235);
		System.out.println(c1);
		
		Cancion c2 = new Cancion("Formentera", List.of("Aitana", "Nicki Nicole"), 207, Estilo.POP);
		System.out.println(c2);
	}

}