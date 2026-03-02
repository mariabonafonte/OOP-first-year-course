package reconocimientos;

public class EstudioCompleto implements ICalculoSalud {
	private int ritmoCardiacoMin;
	private int ritmoCardiacoMax;
	public EstudioCompleto(int ritmoCardiacoMin, int ritmoCardiacoMax) {
		super();
		this.ritmoCardiacoMin = ritmoCardiacoMin;
		this.ritmoCardiacoMax = ritmoCardiacoMax;
	}
	
	public boolean analizar(Paciente p, int anio) {
		/*boolean res = false;
		if(p.getAnalisis(anio).getNumFueraRango()==0) {
			res = true;
		}
		return res;*/
		return(p.getAnalisis(anio).getNumFueraRango()==0 
				&& p.getElectros(anio).getRitmoCardiaco()>= ritmoCardiacoMin
				&& p.getElectros(anio).getRitmoCardiaco()<= ritmoCardiacoMax
				&& p.getElectros(anio).isAnormalidades());
	}
}
