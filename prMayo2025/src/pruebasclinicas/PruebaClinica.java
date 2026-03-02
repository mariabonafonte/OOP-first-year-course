package pruebasclinicas;

import java.time.LocalDate;

public interface PruebaClinica {
	String procesarResultado();//: Método para procesar el resultado de la prueba.
	LocalDate getFechaPrueba();//: Método para obtener la fecha de la prueba.
	TipoPrueba getTipoPrueba();//; Método para obtener el tipo de prueba.
	boolean equals(Object obj);//: Método para comparar objetos de tipo PruebaClinica.
}
