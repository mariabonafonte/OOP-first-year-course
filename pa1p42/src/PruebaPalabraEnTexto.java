import cuentapalabras.PalabraEnTexto;

public class PruebaPalabraEnTexto {
	
	public static void main(String[] args) {
		 PalabraEnTexto palabra1 = new PalabraEnTexto("gorra");
		 PalabraEnTexto palabra2 = new PalabraEnTexto("GORRA");
		 
		 palabra1.incrementa();
		 
		 System.out.println(palabra1);
		 System.out.println(palabra2);
		 
		 if (palabra1.equals(palabra2)) {
			 System.out.println("Las palabras son iguales");
		 }else {
			 System.out.println("Las palabras son diferentes");
		 }
		 
		 
		

}
}
