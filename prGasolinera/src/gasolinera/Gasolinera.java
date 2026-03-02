package gasolinera;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Gasolinera {
	private String nombre;
	protected int contador;
	private Map<Combustible, Double> depositos;
	public Map<String, SortedSet<Ticket>> repostajes;
	private final Map<Combustible,Double> precios;
	
	public Gasolinera(String nombre, Map<Combustible, Double> precios) {
		super();
		this.nombre = nombre;
		this.precios = precios;
		contador = 1;
		crearDeposito();
		repostajes = new HashMap();
		
	}
	
	private void crearDeposito() {
		depositos = new HashMap<>();
		depositos.put(Combustible.DIESEL, 0.0);
		depositos.put(Combustible.DIESELPLUS, 0.0);
		depositos.put(Combustible.GASOLINA95, 0.0);
		depositos.put(Combustible.GASOLINA98, 0.0);
		
	}
	
	public void llenarDepositos(String ficheroDepositos) {
		try (Scanner sc = new Scanner(new File(ficheroDepositos))){
			while(sc.hasNextLine()) {
				procesar(sc.nextLine());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void procesar(String sc) {
		String [] s = sc.split(" ");
		Combustible comb = null;
		double litros = 0;
		try {
			 comb = Combustible.valueOf(s[1].toUpperCase());
			 litros = Integer.parseInt(s[2]);
		} catch (Exception e) {
			throw new GasolineraException("No se ha podido leer la línea");
		}
		if(comb != null) {
			depositos.put(comb, litros);
		}
		
	}
	
	public void agregarTicket(String matr, double cant, double prec) {
		Ticket t = new Ticket(contador, nombre, matr, cant, prec);
		if(repostajes.containsKey(matr)) {
			SortedSet<Ticket> tickets = repostajes.get(matr);
			tickets.add(t);
		} else {
			repostajes.put(matr, (SortedSet<Ticket>) Set.of(t));
		}
		contador +=1;
	}
	
	public void repostar(String matr, Combustible tipo, double cant) {
		if(cant<=0) {
			throw new GasolineraException("cantidad nula o negativa");
		}
		for(Combustible b: depositos.keySet()) {
			if(b.equals(tipo)) {
				double valor = depositos.get(b);
				depositos.put(tipo, valor - cant);
			}
		}
		double precio = 0;
		for(Combustible b: precios.keySet()) {
			if(b.equals(tipo)){
				precio = precios.get(b);
			}
		}
		agregarTicket(matr, cant, precio);
	}
	
	public void emitirFactura(String matricula, PrintWriter pw) {
		SortedSet<Ticket> tickets = repostajes.getOrDefault(matricula.toUpperCase(), new TreeSet<>());
		double total = 0.0;
		for (Ticket ticket : tickets) {
			if (!ticket.isFacturado()) {
				pw.println(ticket);
				total = total + ticket.getPrecioTotal();
				ticket.setFacturado(true);
			}
		}
		pw.println("TOTAL = " + total);
	}
	public void emitirFactura(String matricula, String factura) throws FileNotFoundException {
		try(PrintWriter pw = new PrintWriter(factura)){
			emitirFactura(matricula.toUpperCase(),pw);
		}
	}
	
	
	public boolean pagosPendientes(String matricula) {
		boolean existePagoPendiente = false;
		SortedSet<Ticket> tickets = repostajes.getOrDefault(matricula, new TreeSet<>());
		Iterator<Ticket> it = tickets.iterator();
		while (it.hasNext() && ! existePagoPendiente) {
			existePagoPendiente = ! it.next().isFacturado();
		}
		return existePagoPendiente;
	}
	
	public double obtenerConsumoFacturado(String matricula) {
		double consumo = 0.0;
		SortedSet<Ticket> tickets = repostajes.getOrDefault(matricula.toUpperCase(), new TreeSet<>());
		for (Ticket t: tickets) {
			if (t.isFacturado()) {
				consumo = consumo + t.getLitros();
			}
		}
		return consumo;
	}

	
}
