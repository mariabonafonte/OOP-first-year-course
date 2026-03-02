package burgersempire;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Pedido implements Comparable<Pedido>{
	static int SiguientePedido=1;
	private int idPedido;
	private Set<Alimento> alimentos;
	
	public Pedido() {
		super();
		this.idPedido =SiguientePedido;
		this.alimentos = new HashSet<>();
		SiguientePedido++;
	}
	public int getIdPedido() {
		return idPedido;
	}
	public Set<Alimento> getAlimentos() {
		return alimentos;
	}
	public void addAlimentos(Alimento alimento) {
		alimentos.add(alimento);
	}
	public boolean isPreparado() {
		boolean res= true;
		for(Alimento a: alimentos) {
			if(!a.isPreparado()) {
				res=false;
			}
		}
		return res;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idPedido);
	}
	@Override
	public boolean equals(Object obj) {
		return (obj instanceof Pedido p)
				&&p.idPedido==idPedido;
		}
	@Override
	public int compareTo(Pedido o) {
		return Integer.compare(idPedido, o.idPedido);
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Pedido: "+ idPedido);
		sb.append("\n Estado=");
		if(isPreparado()) {
			sb.append("Listo");
		} else sb.append("Pendiente");
		sb.append("\n Alimentos=");
		for(Alimento a: alimentos) {
			sb.append(a.toString());
		}
		return sb.toString();
	}
	
	
	
	
	
	
	
}
