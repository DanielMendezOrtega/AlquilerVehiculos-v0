package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;

import java.util.ArrayList;
import java.util.List;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;

public class Turismos {
	private List<Turismos> turismos;
	
	public Turismos() {
		turismos = new ArrayList<Turismos>();
}
	public List<Turismos> get(){
		return turismos;
		
	}
	public void insertar (Turismo turismo) {
		
	}
	public Turismo buscar (Turismo turismo) {
		return turismo;
		
	}
	public void borrar(Turismo turismo) {
		
	}


}
