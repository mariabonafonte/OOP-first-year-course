package gasolineras;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedSet;
import java.io.File;
import java.io.FileNotFoundException;

public class Gasolinera {
	private String nombre;
	protected int contador;
	private static enum Combustible {GASOLINA95, GASOLINA98, DIESEL, DIESELPLUS};
	private Map<Combustible,Double> depositos;
	private Map<String, SortedSet<Ticket>> repostajes;
	private Map<Combustible,Double> precios;
	
	public Gasolinera(String nombre, Map<Combustible, Double> precios) {
		super();
		this.nombre = nombre;
		this.precios = precios;
		this.contador = 1;
		crearDepositos();
		this.repostajes = new HashMap<>();
	}
	
	private void crearDepositos() {
		depositos = new HashMap<>();
		depositos.put(Combustible.GASOLINA95, 0.0);
		depositos.put(Combustible.GASOLINA98, 0.0);
		depositos.put(Combustible.DIESEL, 0.0);
		depositos.put(Combustible.DIESELPLUS, 0.0);
	}
	
	public void llenarDepositos(String ficheroDepositos) {
		try (Scanner sc = new Scanner(new File(ficheroDepositos))){
			while(sc.hasNextLine()) {
				String [] s = sc.nextLine().split("");
				Combustible c = Combustible.valueOf(s[0].toUpperCase());
				double litros = Double.parseDouble(s[1]);
				if(depositos.get(c)!=0) {
					depositos.put(c, depositos.get(c) + litros);
				}else depositos.put(c, litros);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	
}
