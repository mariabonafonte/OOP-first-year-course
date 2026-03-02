package reconocimientos;

public class EstudioCompleto implements ICalculoSalud{
	private int ritmoCardiacoMin;
	private int ritmoCardiacoMax;
	
	public EstudioCompleto(int ritmoCardiacoMin, int ritmoCardiacoMax) {
		super();
		this.ritmoCardiacoMin = ritmoCardiacoMin;
		this.ritmoCardiacoMax = ritmoCardiacoMax;
	}

	@Override
	public boolean analizar(Paciente p, int anio) {
		boolean res = false;
		if(p.getAnalisisSangre(anio)==null || p.getElectro(anio)==null) {
			throw new PruebaMedicaException();
		} else if (analizaAnalisis(p,anio) 
				&& analizaRitmo(p,anio)
				&& analizaAnormalidad(p,anio)) {
			res = true;
		} 
		
		return res;
	}
	
	private boolean analizaAnalisis(Paciente p, int anio) {
		boolean res = false;
		AnalisisSangre a = p.getAnalisisSangre(anio);
		if(a.getNumFueraRango()!= 0 && a!=null) {
			res = true;
		}
		return res;
	}
	
	private boolean analizaRitmo(Paciente p, int anio) {
		boolean res = false;
		Electrocardiograma e = p.getElectro(anio);
		if(e.getRitmoCardiaco()>ritmoCardiacoMin 
				&& e.getRitmoCardiaco()<ritmoCardiacoMax
				&& e!=null) {
			res = true;
		}
		return res;
	}
	private boolean analizaAnormalidad(Paciente p, int anio) {
		boolean res = false;
		Electrocardiograma e = p.getElectro(anio);
		if(!e.isAnormalidades() && e!=null) {
			res = true;
		}
		return res;
	}

}
