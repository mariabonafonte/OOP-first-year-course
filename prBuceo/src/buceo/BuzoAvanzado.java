package buceo;

public class BuzoAvanzado extends OpenWaterDiver {
	LEVEL level;

	public BuzoAvanzado(String id, String nombre, int year, LEVEL level) {
		super(id, nombre, year);
		this.level = level;
	}

	public BuzoAvanzado(String id, String nombre) {
		super(id, nombre);
		this.level = level.AVANZADO;
	}
	
	public int getMaxProf() {
		int maxProf = 30;
		return maxProf;
	}

	public LEVEL getLevel() {
		return level;
	}

	public void setLevel(LEVEL level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return id + "," + nombre + "," + level+ "," + anioCertificacion + ","+ getMaxProf()+"," +inmersiones;
		}
}
