package pkg1;

import pkg2.Persona;

public class Principal {
	public static void main(String[] args) {  
		Persona yo = new Persona(14, "Maria", "Bonafonte");
		Persona alguien = new Persona("Maria", "Bonafonte");
		yo.cambiarEdad(20);
		System.out.println(yo.getNombreCompleto());
		
		System.out.println(yo.esMayor(alguien));
		System.out.println(yo.mismoApellido(alguien));
		
		
		
	}
}