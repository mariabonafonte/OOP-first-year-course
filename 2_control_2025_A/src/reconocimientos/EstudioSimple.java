package reconocimientos;

public class EstudioSimple implements ICalculoSalud {

	public EstudioSimple() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean analizar(Paciente p, int anio) {
		boolean res = false;
		AnalisisSangre a = p.getAnalisisSangre(anio);
		if(a.getNumFueraRango()!= 0 && a!=null) {
			res = true;
		}
		return res;
	}

}
