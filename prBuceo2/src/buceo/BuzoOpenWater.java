package buceo;

import java.util.ArrayList;
import java.util.List;

public class BuzoOpenWater {
	private String id;
	private String nombre;
	private int anioCertificacion;
	private List<Inmersion> inmersiones;
	
	public BuzoOpenWater( String nombre, String id, int anioCertificacion) {
		this.id = id;
		this.nombre = nombre;
		this.anioCertificacion = anioCertificacion;
		this.inmersiones = new ArrayList<>();
		
	}
	public BuzoOpenWater(String nombre, String id) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.anioCertificacion = 2023;
		this.inmersiones = new ArrayList<>();
	}
	protected String getId() {
		return id;
	}
	protected String getNombre() {
		return nombre;
	}
	protected int getAnioCertificacion() {
		return anioCertificacion;
	}
	protected List<Inmersion> getInmersiones() {
		return inmersiones;
	}
	
	public void aniadirInmersion (String loc, int duracion, Date fecha){
		
	}
	

}
