package bibliotecas;

import java.util.List;
import java.util.Objects;

public class Libro implements Comparable<Libro>{
	private String titulo, codigo;
	private List<String> autores;
	private int ano;
	public Libro(String titulo, List<String> autores, String codigo, int ano) {
		super();
		this.titulo = titulo;
		this.autores = autores;
		this.codigo = codigo;
		this.ano = ano;
	}
	public String getTitulo() {
		return titulo;
	}
	public String getCodigo() {
		return codigo;
	}
	public List<String> getAutores() {
		return autores;
	}
	public int getAno() {
		return ano;
	}
	@Override
	public String toString() {
		return "[" + titulo + ", " + autores + ", " + codigo + ", " + ano + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(ano, titulo.toLowerCase());
	}
	@Override
	public boolean equals(Object o) {
		return (o instanceof Libro l)
				&&ano==l.ano
				&&titulo.equalsIgnoreCase(l.titulo);
	}
	@Override
	public int compareTo(Libro o) {
		int resultado = titulo.compareTo(o.titulo);
		if(resultado==0) {
			resultado=Integer.compare(ano, o.ano);
		}
		return resultado;
	}
	
	
	
	
	

	

}
