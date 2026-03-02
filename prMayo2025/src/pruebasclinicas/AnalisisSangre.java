package pruebasclinicas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AnalisisSangre implements PruebaClinica {
	private LocalDate fechaPrueba;
	private TipoPrueba tipoPrueba;
	private List<Marcador> marcadores;

	public AnalisisSangre(LocalDate fechaPrueba) {
		this.fechaPrueba = fechaPrueba;
		tipoPrueba = TipoPrueba.ANALISIS_DE_SANGRE;
		marcadores = new ArrayList<>();
	}

	public List<Marcador> getMarcadores() {
		return marcadores;
	}
	
	public void agregarMarcador(Marcador m) {
		marcadores.add(m);
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(fechaPrueba, tipoPrueba);
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof AnalisisSangre as)
				&&fechaPrueba.equals(as.fechaPrueba)
				&&tipoPrueba.equals(as.tipoPrueba);
	}
	

	@Override
	public String procesarResultado() {
		StringBuilder sb = new StringBuilder("Resultado de analisis de sangre... \n");
		sb.append("Realizado:" + fechaPrueba.toString() + "\n");
		
		for(Marcador m: marcadores) {
			sb.append(m.analizar() + "\n");
		}
		return sb.toString();
	}

	@Override
	public LocalDate getFechaPrueba() {
		// TODO Auto-generated method stub
		return fechaPrueba;
	}

	@Override
	public TipoPrueba getTipoPrueba() {
		// TODO Auto-generated method stub
		return tipoPrueba;
	}

	@Override
	public String toString() {
		return procesarResultado();
	}
	

}
