package burgersempire;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class Pedido implements Comparable<Pedido>{
	private static int SiguientePedido =1;
	private int idPedido;
	private Set<Alimento> alimentos;
	
	public Pedido() {
		super();
		this.idPedido = Pedido.SiguientePedido++;
		alimentos = new HashSet<>();
	}
	
	public void addAlimento(Alimento a) {
		a.setPedidoAsociado(this);
		this.alimentos.add(a);
	}

	public int getIdPedido() {
		return this.idPedido;
	}

	public Set<Alimento> getAlimentos() {
		return alimentos;
	}
	
	public boolean isPreparado() {
		boolean preparado=true;
		Iterator<Alimento> it=alimentos.iterator();
		while (preparado && it.hasNext()) {
			preparado=it.next().isPreparado();
		}
		
		return preparado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idPedido);
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof Pedido p)
				&& idPedido == p.idPedido;
	}

	@Override
	public int compareTo(Pedido o) {
		return Integer.compare(idPedido, o.idPedido);
	}

	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder("Pedido: "+idPedido+"\n");
		sb.append("  Estado="+(isPreparado()?"Completado":"Pendiente"));
		sb.append("\n  Alimentos=");
		sb.append(alimentos.toString());
		
		return sb.toString();
	}
	
	
	
	
	
	
	

}
