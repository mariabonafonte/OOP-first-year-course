package indices;

import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class IndicePosicionesEnLineas extends IndiceAbstracto {
    private Map<String, Map<Integer, Set<Integer>>> indice;

    public IndicePosicionesEnLineas() {
        this.indice = new TreeMap<>();
    }

    @Override
    public void resolver(String delimitadores) {
        indice.clear();
        for (int i = 0; i < texto.size(); i++) {
            String frase = texto.get(i);
            Scanner scanner = new Scanner(frase).useDelimiter(delimitadores);
            int posicion = 1;
            while (scanner.hasNext()) {
                String palabra = scanner.next().toLowerCase();
                indice.computeIfAbsent(palabra, k -> new TreeMap<>())
                      .computeIfAbsent(i + 1, k -> new TreeSet<>())
                      .add(posicion++);
            }
            scanner.close();
        }
    }

    @Override
    public void presentarIndice(PrintWriter pw) {
        for (Map.Entry<String, Map<Integer, Set<Integer>>> entry : indice.entrySet()) {
            pw.println(entry.getKey());
            for (Map.Entry<Integer, Set<Integer>> subEntry : entry.getValue().entrySet()) {
                pw.print("\t" + subEntry.getKey() + " <");
                pw.println(subEntry.getValue().toString().replaceAll("[\\[\\]]", "") + ">");
            }
        }
    }
}