package org.iesalandalus.programacion.alquilervehiculos;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;

public class MainApp {

	public static void main(String[] args) {
		// Ánimo!!!!
		
		Cliente cliente1 = new Cliente("Paco", "75720662Q", "628628628");
	
		System.out.println(cliente1.getTelefono());
		System.out.println(cliente1.getDni());
		System.out.println(cliente1.getNombre());
		
		
		
		
		
		
	}

}
