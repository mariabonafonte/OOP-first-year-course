package vivero;

public class Prueba {

public static void main(String[] args) {
		
		Vivero v1 = new Vivero(4);
		Planta p1 = new Planta("001", "Limonero", 50);
		Planta p2 = new Planta("002", "Manzano", 40);
		Planta p3 = new Planta("003", "Mango", 80);
		Planta p4 = new Planta("004", "Aguacate", 80);
		v1.aniadirPlanta(p1);
		v1.aniadirPlanta(p2);
		v1.aniadirPlanta(p3);
		v1.aniadirPlanta(p4);
	
		System.out.println(v1);
		v1.regarPlantas();
		System.out.println(v1);
		v1.eliminarPlanta("003");
		System.out.println(v1+"\n");
		
		/* Vivero Inteligente */
		ViveroInteligente v2 = new ViveroInteligente(2);
		v2.aniadirPlanta("101", "Pino", 30);
		v2.aniadirPlanta("102", "Abeto", 20);
		System.out.println(v2);
		v2.regarPlantas();
		System.out.println(v2);
		
	}

}
