package datos;
import java.util.ArrayList;

public class Datos {
	public ArrayList<Double> datos;
	public ArrayList<String> errores;
	public Double min;
	public Double max;
	

	public Datos(String[] secuencia, Double min, Double max) {
		this.datos = new ArrayList<>();
		this.errores = new ArrayList<>();
		this.min = min;
		this.max = max;
		
		for (String d: secuencia) {
			try{
				Double valor = Double.parseDouble(d);
				datos.add(valor);
				
			} catch (NumberFormatException e) {
                errores.add(d);
            }
		}
	}
	
	public double calcMedia() {
		double suma = 0.0;
		int contador = 0;
		for (double k: datos) {
			if (k <= max && k >= min) {
				suma += k;
				contador++;
			}	
		}
		if (contador == 0) {
			throw new DatosException("No hay datos en el rango especificado");
		}
		return suma/contador;
	}
	
	public double calcDesvTipica() {
		double desvTipica = 0.0;
		int contador = 0;
		double media = calcMedia();
		for (double k: datos) {
			desvTipica += ((Math.pow(k - media,2)));
			contador++;
		}
		return Math.sqrt(desvTipica/contador);
	}
	
	public void setRango(String rango) {
		try {
			int separador = rango.indexOf(";");
			this.min = Double.parseDouble(rango.substring(0,separador));
			this.max = Double.parseDouble(rango.substring(separador + 1));
			
		} catch (IndexOutOfBoundsException | NumberFormatException e) {
			throw new DatosException("Error en los datos al establecer el rango");
		}
		
	}


	public ArrayList<Double> getDatos() {
		return datos;
	}


	public ArrayList<String> getErrores() {
		return errores;
	}
	
	@Override
	public String toString() {
		return "("+ "Min" + ":"+ min +"," + "Max" + ":" + max + "," + getDatos() + "," + getErrores() + "," + "Media" + ":" + calcMedia() + "," +  "DesvTipica" + ":" + calcDesvTipica() + ")";
	}

}
