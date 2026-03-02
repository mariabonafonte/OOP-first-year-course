import java.util.Arrays;

import datos.*;

public class PruebaDatos {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        if (args.length<3) {
            throw new DatosException("Entrada incorrecta, faltan valores");
        }
        
        try {
        Double maximo = Double.parseDouble(args[1]);
        Double minimo = Double.parseDouble(args[0]);
        Datos datos=new Datos(Arrays.copyOfRange(args, 2, args.length),minimo,maximo);
        System.out.println(datos);
        }catch (NumberFormatException e) {
            System.out.println("Error, no se puede convertir el número real"+e.getMessage());
        }catch (DatosException e) {
            System.out.println(e.getMessage());
        }
    }

}