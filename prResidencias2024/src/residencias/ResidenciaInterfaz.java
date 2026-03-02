package residencias;

import residentes.Residente;

public interface ResidenciaInterfaz {
	void agregarResidente(Residente r );
	void almacenarEstadisticas(String nombreFichero);
	void mostrarEstadisticas();
	void cargarResidentes(String fileName);
}
