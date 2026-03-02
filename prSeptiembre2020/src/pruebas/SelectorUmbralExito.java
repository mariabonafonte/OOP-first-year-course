package pruebas;

import java.util.Set;

public class SelectorUmbralExito implements Selector {
	private final int porcMinimo;

	

	public SelectorUmbralExito(int porcMinimo) {
		super();
		if(porcMinimo<0) {
			throw new AppException("El porcMinimo es negativo");
		}
		this.porcMinimo = porcMinimo;
	}
	
	public int getPorcMinimo() {
		return porcMinimo;
	}

	@Override
	public boolean esSeleccionable(Set<Practica> set) {
		int contEx= 0;
		int contRe= 0;
		boolean res;
		for(Practica p: set) {
			contEx += p.getCntExito();
			contRe += p.getCntRealizadas();
		}
		int porcEx = 100*contEx/contRe;
		
		if(porcEx>=porcMinimo) {
			res=true;
		}else res = false;
		return res;
	}

}
