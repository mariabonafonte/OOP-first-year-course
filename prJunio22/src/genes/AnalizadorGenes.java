package genes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class AnalizadorGenes {
	private SortedMap<Integer, SortedSet<ADN>> secuencias;

	public AnalizadorGenes() {
		this.secuencias = new TreeMap<>();
	}
	
	public void incluye(int year, ADN sec) {
		SortedSet<ADN> conjunto = secuencias.get(year);
		if(conjunto==null) {
			conjunto = new TreeSet<>();
			conjunto.add(sec);
			secuencias.put(year, conjunto);	
		} else {
			conjunto.add(sec);
			secuencias.put(year, conjunto);
		}
	}
	
	public void incluye(int year, String nucleotidos, TipoADN tipo) {
		ADN adn = new ADN(nucleotidos, tipo);
		incluye(year, adn);
	}
	
	public void incluyeGenes(String nomFich, String del) {
		try (Scanner sc = new Scanner(new File(nomFich))){
			while(sc.hasNextLine()) {
				procesar(sc.nextLine(), del);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	private void procesar(String sc, String del) {
	    String[] s = sc.split(del);
	    if (s.length != 3) {
	        throw new ADNException("La línea " + Arrays.toString(s) + " no puede ser procesada");
	    }
	    int ano;
	    try {
	        ano = Integer.parseInt(s[0]);
	    } catch (NumberFormatException e) {
	        e.printStackTrace();
	        throw new ADNException("Error en el año de la línea: " + Arrays.toString(s));
	    }
	    String secuencia = s[1].toUpperCase();
	    if (secuencia == null || secuencia.isEmpty()) {
	        throw new ADNException("La secuencia de la línea " + Arrays.toString(s) + " no puede ser procesada");
	    }
	    TipoADN tipo;
	    try {
	        tipo = TipoADN.valueOf(s[2]);
	    } catch (IllegalArgumentException e) {
	        throw new ADNException("TipoADN inválido en la línea: " + Arrays.toString(s));
	    }
	    incluye(ano, secuencia, tipo);
	}
	
	public List<ADN> buscar(TipoRequisito r){
		List<ADN> lista = new ArrayList<>();
		for(int ano: secuencias.keySet()) {
			SortedSet<ADN> setADN = secuencias.get(ano);
			for(ADN a: setADN) {
				if(r.cumplir(a)&&!lista.contains(a)) {
					lista.add(a);
				}
			}
		}
		return lista;
	}
	
	public void escribeGenes(String nomFich) {
		try (PrintWriter pw = new PrintWriter(new File(nomFich))){
			escribeGenes(pw);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public void escribeGenes(PrintWriter pw) {
		for(int ano: secuencias.keySet()) {
			pw.append(ano + ": \n");
			for(ADN a: secuencias.get(ano)) {
				pw.append("\t" + a.toString()+ "\n");
			}
		}
		pw.flush();
	}
}
