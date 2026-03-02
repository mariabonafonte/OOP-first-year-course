package reconocimientos;

public class EstudioSimple implements ICalculoSalud {

	//Se entiende que el estado de salud de un paciente es bueno si, 
	//en su análisis de sangre para ese año, no hay ningún parámetro fuera de rango.
	public EstudioSimple() {
		
	}
	@Override
	public boolean analizar(Paciente p, int anio) {
		boolean res = false;
		try {
			res = p.getAnalisisSangre(anio).getNumFueraRango()==0;
		
		}
		catch(NullPointerException e) {
			//p;uede que p no esté inicializado o que no existan analissi o electros para ese año
			e.printStackTrace();
		}
		return res;
	}

}
