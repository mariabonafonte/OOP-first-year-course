package cuentapalabras;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContadorPalabrasSig extends ContadorPalabras {
	
	private List<String> noSignificativas;

	public ContadorPalabrasSig() {
		super();
		this.noSignificativas = new ArrayList<>();
	}
	
	public void leeArrayNoSig (String[] palsNS) {
		noSignificativas.clear();
		
		for (String palabraNS: palsNS) {
			if(!palabraNS.isEmpty()|| palabraNS == null) {
				noSignificativas.add(palabraNS.toUpperCase());
			}
		}
	}
	
	public void leeFicheroNoSig(String filNoSig, String del) throws IOException {
	    noSignificativas.clear();
	    try (Scanner scanner = new Scanner(new FileReader(filNoSig))) {
	        while (scanner.hasNextLine()) {
	            String linea = scanner.nextLine();
	            anyadePalabrasNoSignificativas(linea, del);
	        }
	    }
	}
	 
	 private void anyadePalabrasNoSignificativas(String linea, String del) {
	        String[] palabras = linea.split("[" + del + "]");
	        for (String palabra : palabras) {
	            if (palabra != null && !palabra.isEmpty()) {
	                noSignificativas.add(palabra.toUpperCase());
	            }
	        }
	    }
	 
	    @Override
	    protected void incluye(String pal) {
	        if (pal == null || pal.isEmpty() || noSignificativas.contains(pal.toUpperCase())) {
	            return;
	        }

	        super.incluye(pal);
	    }
}
