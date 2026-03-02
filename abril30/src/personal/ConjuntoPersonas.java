package personal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ConjuntoPersonas implements GestionPersonas {
	private Set<Persona> conjunto;
	private Map<Integer, Integer> edadNumero;
	private Map<Integer, Set<Provincia>> edadProvincia;
	

	
	public ConjuntoPersonas() {
		conjunto = new HashSet<Persona>();
		edadNumero = new HashMap<Integer, Integer>();
		edadProvincia = new HashMap<Integer, Set<Provincia>>();
		
	}
	@Override
	public boolean add(Persona p) {
        if (p == null) throw new IllegalArgumentException("La persona no está inicializada");
        /*Integer valor = edadNumero.get(p.getEdad());
        if (valor != null) {
            edadNumero.put(p.getEdad(), valor+1);
        }
        else {
            edadNumero.put(p.getEdad(), 1);
        }*/
        Integer valorE = edadNumero.getOrDefault(p.getEdad(), 0);
        edadNumero.put(p.getEdad(), valorE + 1);
        
        /*Set<Provincia> valorP = edadProvincia.get(p.getEdad());
        if (valorP == null) {
            valorP = new HashSet<Provincia>();
        }*/
        Set<Provincia> valorP = edadProvincia.getOrDefault(p.getEdad(),new HashSet<Provincia>());
        valorP.add(p.getProvincia());
        edadProvincia.put(p.getEdad(), valorP);
        
        return conjunto.add(p);
    }
		
	}
	@Override
	public boolean remove(Persona p) {
		// TODO Auto-generated method stub
		if (p == null) {
			throw new IllegalArgumentException ("Objeto nulo");
		}
		Integer valor = edadNumero.get(p.getEdad());
		
		if(valor != null) {
			if(valor > 1) {
				edadNumero.put(p.getEdad(), valor - 1);
			}else {
				edadNumero.remove(p.getEdad());
			}
			
		}else {
			edadNumero.put(p.getEdad(), 1);
		}
		
		return conjunto.remove(p);
	}
	@Override
	public void guardarAFichero(String rutaFichero) {
		try (PrintWriter pw = new PrintWriter(rutaFichero)) {
            for(Persona p : conjunto) {
                pw.println(p.getName() + ";" + p.getEdad() + "\n");
            }
            } catch (FileNotFoundException e) {
                System.out.println("No se puede encotra el fichero");
            }
	}
	
	@Override
	public void leerDeFichero(String rutaFichero) {
		conjunto.clear();
		try (Scanner sc = new Scanner(new File("datos.txt"))) {
			while (sc.hasNextLine()) {
				String linea = sc.nextLine();
				try (Scanner usuario_linea = new Scanner(new File("datos.txt"))) {
					usuario_linea.useDelimiter(",");
					String nombre;
					int edad;
					nombre = usuario_linea.next();
					edad = usuario_linea.nextInt();
					//conjunto.add(new Persona(nombre,edad,provincia));
			}
			}
		} catch (FileNotFoundException e) {
			System.out.println("No se encuentra el fichero");
		}
	}
	
	private String mostrarEdadNumero() {
		StringBuilder sb = new StringBuilder();
		for(Map.Entry<Integer, Integer> par: edadNumero.entrySet()) {
			sb.append(par.getKey() + ":" + par.getValue() + "\n");
		}
		return sb.toString();
		}
	
	private String mostrarConjunto() {
		StringBuilder sb = new StringBuilder();
		sb.append("Conjunto personas: \n");
		for (Persona p: conjunto) {
			sb.append(p + "\n");
		}
		return sb.toString();
	}
	
	@Override
	public String toString() {
		return mostrarConjunto() + mostrarEdadNumero();
	}
	
	
	
	
	
}
