package indices;

import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class IndiceContador extends IndiceAbstracto {
	SortedMap<String, Integer> indice;
	

	public IndiceContador() {
		SortedMap<String, Integer> indice = new TreeMap<>();
	}

	@Override
	public void resolver(String delimitadores) {
		indice.clear();
		for(String frase: texto) {
			try (Scanner sc = new Scanner(frase).useDelimiter(delimitadores)){
				while(sc.hasNext()) {
					String palabra = sc.next().toLowerCase();
					indice.put(palabra, indice.getOrDefault(palabra, 0)+1);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void presentarIndice(PrintWriter pw) {
		for (Map.Entry<String, Integer> entry : indice.entrySet()) {
            pw.println(entry.getKey() + "\t" + entry.getValue());
        }
    }

}
