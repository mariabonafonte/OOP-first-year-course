package pruebasclinicas;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Radiografia implements PruebaClinica {
	private LocalDate fechaPrueba;
	private TipoPrueba tipoPrueba;
	private String ubicacionImagen, diagnosticoMedico;
	

	

	public Radiografia(LocalDate fechaPrueba, String ubicacionImagen, String diagnosticoMedico) {
		super();
		this.fechaPrueba = fechaPrueba;
		tipoPrueba = TipoPrueba.RADIOGRAFIA;
		this.ubicacionImagen = ubicacionImagen;
		this.diagnosticoMedico = diagnosticoMedico;
	}

	public String getUbicacionImagen() {
		return ubicacionImagen;
	}

	public void setUbicacionImagen(String ubicacionImagen) {
		this.ubicacionImagen = ubicacionImagen;
	}

	public String getDiagnosticoMedico() {
		return diagnosticoMedico;
	}

	public void setDiagnosticoMedico(String diagnosticoMedico) {
		this.diagnosticoMedico = diagnosticoMedico;
	}

	@Override
	public String procesarResultado() {
		StringBuilder sb = new StringBuilder("Resultado de radiografia... \n");
		sb.append("Realizado:" + fechaPrueba.toString()+ "\n");
		sb.append("Ubicacion de la imagen: " + ubicacionImagen + "\n");
		sb.append("Diagnóstico del  médico: " + diagnosticoMedico + "\n");
		return sb.toString();
	}

	@Override
	public LocalDate getFechaPrueba() {
		// TODO Auto-generated method stub
		return fechaPrueba;
	}

	@Override
	public String toString() {
		return procesarResultado();
	}

	@Override
	public TipoPrueba getTipoPrueba() {
		// TODO Auto-generated method stub
		return tipoPrueba;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(fechaPrueba, tipoPrueba);
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof Radiografia r)
				&&fechaPrueba.equals(r.fechaPrueba)
				&&tipoPrueba.equals(r.tipoPrueba);
	}
	
	
	

}
