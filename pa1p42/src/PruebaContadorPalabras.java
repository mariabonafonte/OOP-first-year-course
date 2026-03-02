import cuentapalabras.ContadorPalabras;

public class PruebaContadorPalabras {
    public static void main(String[] args) {
    	
        ContadorPalabras contador = new ContadorPalabras();

        String[] datos = {
            "Esta es la primera frase del ejemplo",
            "y esta es la segunda frase"
        };

        String delimitadores = " ";

        contador.incluyeTodas(datos, delimitadores);

        System.out.println(contador);
    }
}