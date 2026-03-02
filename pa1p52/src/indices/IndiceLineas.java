package indices;

import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class IndiceLineas extends IndiceAbstracto {
    private Map<String, Set<Integer>> indice;

    public IndiceLineas() {
        this.indice = new TreeMap<>();
    }

    @Override
    public void resolver(String delimitadores) {
        indice.clear();
        for (int i = 0; i < texto.size(); i++) {
            String frase = texto.get(i);
            Scanner scanner = new Scanner(frase).useDelimiter(delimitadores);
            while (scanner.hasNext()) {
                String palabra = scanner.next().toLowerCase();
                indice.computeIfAbsent(palabra, k -> new TreeSet<>()).add(i + 1);
            }
            scanner.close();
        }
    }

    @Override
    public void presentarIndice(PrintWriter pw) {
        for (Map.Entry<String, Set<Integer>> entry : indice.entrySet()) {
            pw.print(entry.getKey() + "\t<");
            pw.println(entry.getValue().toString().replaceAll("[\\[\\]]", "") + ">");
        }
    }
}