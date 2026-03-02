package cuentapalabras;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringJoiner;

public class ContadorPalabras {
	private List<PalabraEnTexto> palabras;

	public ContadorPalabras() {
		palabras = new ArrayList<>();
	}
	
	private int esta (String pal) {
		PalabraEnTexto auxiliar = new PalabraEnTexto(pal);
		int posicion = 0;
		int esta = -1;
		
		for (PalabraEnTexto palabra: palabras) {
			if(palabra.equals(auxiliar)){
				esta = posicion;
			}
			posicion += 1; 
		}
		return esta; 
	}
	
	protected void incluye (String pal) {
		int posicion = esta(pal); 
		
		if(posicion!= -1) {
			palabras.get(posicion).incrementa();
			
		}else {
			palabras.add(new PalabraEnTexto(pal));
		}
	}
	
	private void incluyeTodas(String linea, String del) {
		String [] palabras = linea.split(del);
		
		for (String palabra: palabras){
			if(!palabra.isEmpty()) {
				incluye(palabra);
			}
		}
	}
	
	public void incluyeTodas(String [] texto, String del) {
		for(String linea: texto) {
			if (!linea.isEmpty()) {
				incluyeTodas(linea, del);
			}
		}
	}
	
	
	public void incluyeTodasFichero(String nomFich, String del) throws IOException {
	    if (nomFich == null || nomFich.isEmpty()) {
	        System.out.println("ERROR: falta el nombre del fichero");
	        return;
	    }

	    try (Scanner sc = new Scanner(new File(nomFich))) {
	        while (sc.hasNextLine()) {
	            String linea = sc.nextLine();
	          
	            incluyeTodas(linea, del);
	        }
	    } catch (IOException e) {
	        System.out.println("ERROR: no se puede leer del fichero");
	        throw e; 
	    }
	}
	
	public PalabraEnTexto encuentra (String pal) {
		PalabraEnTexto auxiliar = new PalabraEnTexto(pal.toUpperCase());
		
		for (PalabraEnTexto palabra: palabras) {
			if(palabra.equals(auxiliar)){
				return palabra;
				}
			}
		throw new NoSuchElementException("No existe la palabra " + pal);
		}
		
	

	@Override
	 public String toString() {
        StringJoiner joiner = new StringJoiner(" - ", "[", "]");
        for (PalabraEnTexto palabra : palabras) {
            joiner.add(palabra.toString());
        }
        return joiner.toString();
    }
	
	public void presentaPalabras(String fichero) throws FileNotFoundException {
        try (PrintWriter pw = new PrintWriter(fichero)) {
            presentaPalabras(pw); //
        }
    }

    public void presentaPalabras(PrintWriter pw) {
        for (PalabraEnTexto palabra : palabras) {
            pw.println(palabra.toString()); 
        }
    }

	
	
	
	
	
	
	
}
