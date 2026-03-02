package alturas;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Mundo {
    private List<Pais> paises;

    private Mundo(List<Pais> paises) {
        this.paises = paises;
    }

    public List<Pais> getPaises() {
        return paises;
    }

    public static Mundo createFromFile(String fich) throws FileNotFoundException {
        return cargar(fich);
    }

    public static Mundo cargar(String fich) throws FileNotFoundException {
        List<Pais> paises = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(fich))) {
            while (sc.hasNextLine()) {
                String linea = sc.nextLine().trim();
                if (linea.isEmpty()) continue;
                String[] partes = linea.split(",");
                if (partes.length != 3) continue;
                try {
                    String nombre = partes[0].trim();
                    String continente = partes[1].trim();
                    double altura = Double.parseDouble(partes[2].trim());
                    paises.add(new Pais(nombre, continente, altura));
                } catch (Exception ignored) {}
            }
        }
        return new Mundo(paises);
    }

    public static <K,V> void presentaEnConsola(Map<K,V> map) {
        for (Map.Entry<K,V> e : map.entrySet()) {
            System.out.println(e.getKey() + "\t" + e.getValue());
        }
    }

    public Map<String, Integer> numeroDePaisesPorContinente() {
        Map<String, Integer> res = new TreeMap<>();
        for (Pais p : paises) {
            res.put(p.getContinente(), res.getOrDefault(p.getContinente(), 0) + 1);
        }
        return res;
    }

    public Map<Double, List<Pais>> paisesPorAltura() {
        Map<Double, List<Pais>> res = new TreeMap<>();
        for (Pais p : paises) {
            double alturaTruncada = Math.floor(p.getAltura() * 10) / 10;
            res.computeIfAbsent(alturaTruncada, k -> new ArrayList<>()).add(p);
        }
        // Ordenar cada lista por altura
        for (List<Pais> lp : res.values()) {
            lp.sort(Comparator.comparing(Pais::getAltura).thenComparing(Pais::getNombre));
        }
        return res;
    }

    public Map<String, SortedSet<Pais>> paisesPorContinente() {
        Map<String, SortedSet<Pais>> res = new TreeMap<>();
        for (Pais p : paises) {
            res.computeIfAbsent(p.getContinente(), k -> new TreeSet<>()).add(p);
        }
        return res;
    }

    public SortedSet<Pais> paisesOrdenadosPorAltura() {
        SortedSet<Pais> set = new TreeSet<>(new ComAltura());
        set.addAll(paises);
        return set;
    }

    public Map<String, SortedSet<Pais>> paisesPorContinenteAltura() {
        Map<String, SortedSet<Pais>> res = new TreeMap<>();
        Comparator<Pais> comp = new ComAltura();
        for (Pais p : paises) {
            res.computeIfAbsent(p.getContinente(), k -> new TreeSet<>(comp)).add(p);
        }
        return res;
    }

    public Map<String, SortedSet<Pais>> paisesPorContinenteAlturaDec() {
        Map<String, SortedSet<Pais>> res = new TreeMap<>();
        Comparator<Pais> comp = new ComAltura().reversed();
        for (Pais p : paises) {
            res.computeIfAbsent(p.getContinente(), k -> new TreeSet<>(comp)).add(p);
        }
        return res;
    }

    public Map<Character, SortedSet<Pais>> paisesPorInicial() {
        Map<Character, SortedSet<Pais>> res = new TreeMap<>();
        for (Pais p : paises) {
            char inicial = p.getNombre().charAt(0);
            res.computeIfAbsent(inicial, k -> new TreeSet<>()).add(p);
        }
        return res;
    }

    public Map<String, Double> mediaPorContinente() {
        Map<String, SortedSet<Pais>> agrupados = paisesPorContinente();
        Map<String, Double> res = new TreeMap<>();
        for (Map.Entry<String, SortedSet<Pais>> e : agrupados.entrySet()) {
            double media = e.getValue().stream().mapToDouble(Pais::getAltura).average().orElse(0.0);
            res.put(e.getKey(), media);
        }
        return res;
    }

    public List<String> continentesConMasPaises() {
        Map<String, Integer> mapa = numeroDePaisesPorContinente();
        int max = mapa.values().stream().max(Comparator.naturalOrder()).orElse(0);
        return mapa.entrySet().stream()
                .filter(e -> e.getValue() == max)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}