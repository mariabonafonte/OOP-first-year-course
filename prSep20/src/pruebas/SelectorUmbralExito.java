package pruebas;

import java.util.Set;

public class SelectorUmbralExito implements Selector {
	private final int porcMinimo;
	
	
	

	public SelectorUmbralExito(int porcMinimo) {
		super();
		if(porcMinimo<0) {
			throw new AppException("Porcentaje negativo");
		}
		this.porcMinimo = porcMinimo;
	}


	public int getPorcMinimo() {
		return porcMinimo;
	}

	@Override
	public boolean esSeleccionable(Set<Practica> s) {
		boolean res=false;
	
		int contEx=0;
		int contRealizadas=0;
		for(Practica p: s) {
			contEx += p.getCntExito();
			contRealizadas +=p.getCntRealizadas();
		}
		
		int porcEx = 100*contEx/contRealizadas;
		
		if(porcEx>= porcMinimo) {
			res=true;
		}
		
		return res;
	}

}
