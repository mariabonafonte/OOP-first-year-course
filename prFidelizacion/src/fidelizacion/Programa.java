package fidelizacion;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.HashSet;
import java.io.File;

public class Programa {
	private Map<IdServicio, Servicio> servicios;
	private Set<Cliente> clientes;
	private Set<Transaccion> transacciones;

	public Programa() {
		Map<IdServicio, Servicio> servicios = new HashMap<>();
		servicios.put(IdServicio.GASOLINERA, new ServicioGasolinera());
		servicios.put(IdServicio.SUPERMERCADO, new ServicioSupermercado());
		
		this.clientes = new HashSet<>();
		this.transacciones =new HashSet<>();
	}
	
	public Servicio servicio (IdServicio id) {
		return servicios.get(id);
	}
	
	public Cliente cliente(int id) {
		Cliente cl = null;
		for(Cliente c: clientes) {
			if(c.getNumero() == id){
				cl = c;
			}
		}
		return cl;
	}
	
	public void agregaCliente(Cliente c) {
		clientes.add(c);
		
	}
	
	public void realizaTransaccion(IdServicio id, int ca, Fecha fe, int nC) {
		Cliente c = cliente(nC);
		if(!servicios.containsKey(id)) {
			throw new FidelizacionException("Servicio no encontrado");
		}
		if(c==null) {
			throw new FidelizacionException("Cliente no encontrado");
		}
		if(ca<0) {
			throw new FidelizacionException("Cantudiad negativa");

		}
		Transaccion tr = servicio(id).hazTransaccion(ca, fe, nC);
		c.actualiza(tr);
		transacciones.add(tr);
	}
	
	public SortedSet<Cliente> buenosClientesCantidad(){
		SortedSet<Cliente> buenosClientes = new TreeSet();
		for(Cliente c: clientes) {
			if(c.getCantidad()>300) {
				buenosClientes.add(c);
			}
		}
		return buenosClientes;
	}
	
	public void muestraTransacciones(String fichero) throws FileNotFoundException{
		try (PrintWriter pw = new PrintWriter(new File(fichero))){
			muestraTransacciones(pw);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void muestraTransacciones(PrintWriter pw) {
		for(Transaccion t: transacciones) {
			pw.append(t.toString());
		}
		
	}
	
	void leeTransacciones (String fichero) throws FileNotFoundException{
		try (Scanner sc = new Scanner(new File(fichero))){
			leeTransacciones(sc);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	void leeTransacciones (Scanner sc) {
		while(sc.hasNextLine()) {
			String [] s = sc.nextLine().split(":");
			int numCliente = Integer.parseInt(s[0]);
			Fecha fecha = Fecha.parseFecha(s[1]);
			double cantidad = Double.parseDouble(s[2]);
			int puntos = Integer.parseInt(s[3]);
			
			Transaccion tr = new Transaccion(cantidad, puntos, fecha, numCliente);
		}
		
	}

}
