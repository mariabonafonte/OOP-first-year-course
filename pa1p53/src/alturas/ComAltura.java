package alturas;

import java.util.Comparator;

public class ComAltura implements Comparator<Pais> {
    @Override
    public int compare(Pais p1, Pais p2) {
        // Suponiendo que la clase Pais tiene un método getAltura() que devuelve un double o float
        return Double.compare(p1.getAltura(), p2.getAltura());
    }
}