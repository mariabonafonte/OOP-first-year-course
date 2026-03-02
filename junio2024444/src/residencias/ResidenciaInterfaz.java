package residencias;

import residentes.Residente;

public interface ResidenciaInterfaz {
	
	public void agregarResidente(Residente r );
	public void almacenarEstadisticas(String nombreFichero);
	public void mostrarEstadisticas();
	public void cargarResidentes(String fileName);
}
