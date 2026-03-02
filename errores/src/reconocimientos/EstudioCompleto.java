package reconocimientos;

public class EstudioCompleto implements ICalculoSalud {

	private int ritmoCardiacoMin;
	private int ritmoCardiacoMax;
	
	public EstudioCompleto(int min, int max) {
		ritmoCardiacoMin=min;
		ritmoCardiacoMax=max;
	}
	
	
	// En esta clase, el método analiza tendrá en cuenta que una persona tiene buen estado de salud si: 
	// no hay ningún parámetro fuera de rango en el análisis de sangre de ese año, 
	//el ritmo cardiaco está en el rango dado por los atributos de la clase y no se han detectado anomalías.
	@Override
	public boolean analizar(Paciente p, int anio) {
		// TODO Auto-generated method stub
		boolean res = false;
		try {
			res = p.getAnalisisSangre(anio).getNumFueraRango()==0 
					&& (p.getElectro(anio).getRitmoCardiaco()>=ritmoCardiacoMin
					&& p.getElectro(anio).getRitmoCardiaco()<=ritmoCardiacoMax
					&& !p.getElectro(anio).isAnormalidades());
		}
		catch(NullPointerException e) {
			//p;uede que p no esté inicializado o que no existan analisis para ese año
			e.printStackTrace();
		}
		return res;
	}

}
