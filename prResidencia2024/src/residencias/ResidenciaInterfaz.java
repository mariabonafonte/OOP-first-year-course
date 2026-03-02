package residencias;

import residentes.Residente;

public interface ResidenciaInterfaz {
	public void agregarResidente(Residente r);
	public void cargarResidentes(String fileName);
	public void almacenarEstadisticas(String nombreFichero);
	public void mostrarEstadisticas();

}
