import chatbots.Categoria;
import chatbots.Intencion;
import chatbots.IntencionSimple;
import chatbots.MiChatBot;
import java.util.Scanner;

public class MainChatbot {

	public static void main(String[] args) {
		Intencion chChiste = new IntencionSimple();
		chChiste.inicializarFrases("chistes.txt");
		chChiste.inicializarSinonimos("sinonimos-chistes.txt");

		Intencion chConsejo = new IntencionSimple();
		chConsejo.inicializarFrases("consejos.txt");
		chConsejo.inicializarSinonimos("sinonimos-consejos.txt");

		MiChatBot miChatBot = new MiChatBot(chChiste);
		Scanner sc = new Scanner(System.in);
		System.out.println(
				"Bienvenido a SaludUMABot, estoy entrenado para divertirte contandote chistes" + " o curiosidades.");
		int opcion;
		do {
			System.out.println("Que te apetece oir: \n1.Chiste  \n2. Consejo ");
			opcion = leerOpcion(sc, 1, 2);
			switch (opcion) {
			case 1:
				miChatBot.setIntencion(chChiste);
				break;
			case 2:
				miChatBot.setIntencion(chConsejo);
				break;
			default:
				System.out.println("Chatbot no valido");
			}

			System.out.println("De que te gustaria que te contase el " + Categoria.values()[opcion - 1] + " ?");
			System.out.println("Te dejo aqui algunas sugerencias si pones * te sorprendo: \n");
			for (int i = 0; i < 5; i++) {
				System.out.print(miChatBot.sugerencia() + " ");
			}
			System.out.println();
			String busqueda=sc.next();
			if (busqueda.equals("*")){
				System.out.println(miChatBot.consulta());
			} else {
				System.out.println(miChatBot.consulta(busqueda));
			}

			System.out.println("Quieres seguir? (1- continuar, 0- salir)");
			opcion = leerOpcion(sc, 0, 1);
		} while (opcion != 0);
		System.out.println("Espero verte pronto...");
	}

	public static int leerOpcion(Scanner sc, int min, int max) {
		int opcion = -1;
		do {
			System.out.println("Escribe un valor entre " + min + " y " + max);
			while (!sc.hasNextInt()) {
				System.out.println("Escribe un numero no letritas :-)");
				sc.next();
			}
			opcion = sc.nextInt();
		} while (opcion != min && opcion != max);
		return opcion;
	}
}
