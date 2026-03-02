package burgersempire;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.security.KeyStore.Entry;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class Cocina {
	private SortedMap<TipoAlimento, Queue<Alimento>> pendientes;

	public Cocina() {
		super();
		pendientes = new TreeMap<>();
	}
	
	public void addPedido(Pedido pedido) {
		TipoAlimento tipo;
		Queue<Alimento> valor;
		Set<Alimento> alimentos=pedido.getAlimentos();
		for (Alimento al:alimentos) {
			tipo=al.getTipo();
			valor=pendientes.get(tipo);
			if (valor==null) {
				valor=new LinkedList<>();
				pendientes.put(tipo, valor);
			}
			valor.add(al);
		}
	}
	
	public boolean cocinar(TipoAlimento tipo)  {
		boolean ok=false;
		Queue<Alimento> cola=pendientes.get(tipo);
		Alimento alimento=cola.poll();
		if (alimento!=null) {
			alimento.setPreparado(true);
			ok=true;
		} 
		return ok;
	}
	
	@Override 
	public String toString() {
		StringBuilder sb=new StringBuilder("Estado de la cocina:\n");
		for(java.util.Map.Entry<TipoAlimento, Queue<Alimento>> elem: pendientes.entrySet()) {
			sb.append("  "+elem.getKey()+": "+ elem.getValue()+"\n");
		}
		return sb.toString();
	}
	public void toFile(String nombreFich) throws BurgerException {
		try (PrintWriter fw=new PrintWriter(nombreFich)) {
			fw.print(this.toString());
		} catch (FileNotFoundException e) {
			throw new BurgerException("No puedo abrir fichero: "+ nombreFich);
		} 
	}
	
	

}
