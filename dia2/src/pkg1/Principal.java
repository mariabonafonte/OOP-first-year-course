package pkg1;

import humanos.Estudiante;
import humanos.Programador;

public class Principal {
	public static void main(String[] args) {  
		Estudiante yo = new Estudiante(14, "Maria", "Bonafonte");
		Estudiante alguien = new Estudiante("Maria", "Bonafonte");
		yo.cambiarEdad(20);
		System.out.println(yo.getNombreCompleto());
		
		System.out.println(yo.esMayor(alguien));
		System.out.println(yo.mismoApellido(alguien));
		
		Estudiante veterano = new Programador(27,"Carlos","Cantalejo","C");
		Programador novel = new Programador(20,"Vicente","Cantalejo","Java");
		Estudiante alumno = new Estudiante(19,"Maria","Bonafonte","Phyton");
		
		System.out.println(novel.getLenguajeFavorito());
		System.out.println(((Programador)veterano).getLenguajeFavorito());
		System.out.println(novel.mismoLenguaje((Programador)veterano));
		System.out.print(Estudiante.getestudiantesInstanciados());
		
		
    }
	}
	