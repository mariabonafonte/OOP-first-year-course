

import burgersempire.BurgerException;
import burgersempire.Cocina;
import burgersempire.Hamburguesa;
import burgersempire.Helado;
import burgersempire.Patatas;
import burgersempire.Pedido;
import burgersempire.TipoAlimento;

public class PruebaExamen {

	public static void main(String[] args) {
		
		System.out.println("*** PRUEBA CREACION ALIMENTOS ***");
		// Creación de Hamburguesas
		Hamburguesa[] burgers = new Hamburguesa[10];
		for (int i=0;i<5;i++) {
			burgers[i]=new Hamburguesa(((i+2)%3==0)?true:false,((i+1)%2==0)?true:false,(i%2==0)?true:false,(i%3==0)?true:false,((i+1)%3==0)?true:false,(i%4==0)?true:false);
			System.out.println(burgers[i]);
		}
		
		// Creación de Helados
		Helado[] helados=new Helado[10];
		for (int i=0;i<4;i++) {
			helados[i]=new Helado(((i+2)%3==0)?true:false,((i+1)%2==0)?true:false);
			System.out.println(helados[i]);
		}
		
		// Creación de Patatas
		Patatas[] patatas=new Patatas[10];
		try {
				for (int i=0;i<4;i++) {
			
					patatas[i]=new Patatas(((i+2)%3==0)?"Grande":"Mediana",((i+1)%2==0)?"Clasica":"Gajos");
					System.out.println(patatas[i]);
				}
		} catch(BurgerException e) {
			System.err.println(e.getMessage());
		}

		
		System.out.println("*** PRUEBA CREACION PEDIDOS ***");
		// Crear Pedido
		Pedido p1=new Pedido();
		p1.addAlimento(burgers[0]);
		p1.addAlimento(burgers[1]);
		p1.addAlimento(helados[0]);
		p1.addAlimento(helados[1]);
		p1.addAlimento(patatas[0]);
		System.out.println(p1);
		
		// Crear otro pedido
		Pedido p2=new Pedido();
		p2.addAlimento(burgers[2]);
		p2.addAlimento(burgers[3]);
		p2.addAlimento(burgers[4]);
		p2.addAlimento(helados[2]);
		p2.addAlimento(helados[3]);
		p2.addAlimento(patatas[1]);
		p2.addAlimento(patatas[2]);
		System.out.println(p1);
		
		System.out.println("*** PRUEBA CREACION COCINA ***");
		
		// Crear cocina Añadir pedido a cocina
		Cocina cocina=new Cocina();
		cocina.addPedido(p1);
		cocina.addPedido(p2);
		System.out.println(cocina);
		
		System.out.println("*** PRUEBA CREACION COCINA ***");
		try {
			cocina.toFile("cocina.txt");
			System.out.println("Escritura de fichero cocina.txt con exito");
		} catch (BurgerException e) {
			System.out.println("No puede crear fichero cocina.txt");
		}
		System.out.println("*** PRUEBA COCINAR ***");
		// Cocinar
		cocina.cocinar(TipoAlimento.HAMBURGUESA);
		cocina.cocinar(TipoAlimento.HAMBURGUESA);
		cocina.cocinar(TipoAlimento.HAMBURGUESA);
		cocina.cocinar(TipoAlimento.HELADO);
		cocina.cocinar(TipoAlimento.HELADO);
		cocina.cocinar(TipoAlimento.PATATAS);
		System.out.println("Después de cocinar 3 hamburguesas, 2 helados Y 1 patatas");
		System.out.println(cocina);
		
		System.out.println("*** PRUEBA PEDIDOS COMPLETADOS ***");
		System.out.println(p1);
		System.out.println(p2);
		
	}

}
/*
 * *** PRUEBA CREACION ALIMENTOS ***
Hamburguesa.  (cebolla queso doble )
Hamburguesa.  (mostaza ketchup )
Hamburguesa.  (cebolla pollo )
Hamburguesa.  (ketchup queso )
Hamburguesa.  (mostaza cebolla doble )
Helado.  ()
Helado.  (con Nata Con Cacahuetes )
Helado.  ()
Helado.  (Con Cacahuetes )
Patatas.  (Mediana Gajos)
Patatas.  (Grande Clasica)
Patatas.  (Mediana Gajos)
Patatas.  (Mediana Clasica)
*** PRUEBA CREACION PEDIDOS ***
Pedido: 1
  Estado=Pendiente
  Alimentos=[Helado. Pedido: 1 (), Helado. Pedido: 1 (con Nata Con Cacahuetes ), Hamburguesa. Pedido: 1 (mostaza ketchup ), Hamburguesa. Pedido: 1 (cebolla queso doble ), Patatas. Pedido: 1 (Mediana Gajos)]
Pedido: 1
  Estado=Pendiente
  Alimentos=[Helado. Pedido: 1 (), Helado. Pedido: 1 (con Nata Con Cacahuetes ), Hamburguesa. Pedido: 1 (mostaza ketchup ), Hamburguesa. Pedido: 1 (cebolla queso doble ), Patatas. Pedido: 1 (Mediana Gajos)]
*** PRUEBA CREACION COCINA ***
Estado de la cocina:
  HAMBURGUESA: [Hamburguesa. Pedido: 1 (mostaza ketchup ), Hamburguesa. Pedido: 1 (cebolla queso doble ), Hamburguesa. Pedido: 2 (ketchup queso ), Hamburguesa. Pedido: 2 (mostaza cebolla doble ), Hamburguesa. Pedido: 2 (cebolla pollo )]
  PATATAS: [Patatas. Pedido: 1 (Mediana Gajos), Patatas. Pedido: 2 (Mediana Gajos), Patatas. Pedido: 2 (Grande Clasica)]
  HELADO: [Helado. Pedido: 1 (), Helado. Pedido: 1 (con Nata Con Cacahuetes ), Helado. Pedido: 2 (), Helado. Pedido: 2 (Con Cacahuetes )]

*** PRUEBA CREACION COCINA ***
Escritura de fichero cocina.txt con exito
*** PRUEBA COCINAR ***
Después de cocinar 3 hamburguesas, 2 helados Y 1 patatas
Estado de la cocina:
  HAMBURGUESA: [Hamburguesa. Pedido: 2 (mostaza cebolla doble ), Hamburguesa. Pedido: 2 (cebolla pollo )]
  PATATAS: [Patatas. Pedido: 2 (Mediana Gajos), Patatas. Pedido: 2 (Grande Clasica)]
  HELADO: [Helado. Pedido: 2 (), Helado. Pedido: 2 (Con Cacahuetes )]

*** PRUEBA PEDIDOS COMPLETADOS ***
Pedido: 1
  Estado=Completado
  Alimentos=[Helado. Pedido: 1 (), Helado. Pedido: 1 (con Nata Con Cacahuetes ), Hamburguesa. Pedido: 1 (mostaza ketchup ), Hamburguesa. Pedido: 1 (cebolla queso doble ), Patatas. Pedido: 1 (Mediana Gajos)]
Pedido: 2
  Estado=Pendiente
  Alimentos=[Patatas. Pedido: 2 (Mediana Gajos), Hamburguesa. Pedido: 2 (ketchup queso ), Helado. Pedido: 2 (), Helado. Pedido: 2 (Con Cacahuetes ), Hamburguesa. Pedido: 2 (mostaza cebolla doble ), Patatas. Pedido: 2 (Grande Clasica), Hamburguesa. Pedido: 2 (cebolla pollo )]
*/
