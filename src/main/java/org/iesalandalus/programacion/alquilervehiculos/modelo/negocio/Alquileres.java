package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;

public class Alquileres {
	private List<Alquileres> alquileres;
	
	public Alquileres() {
		alquileres = new ArrayList<Alquileres>();
}
	public List<Alquileres> get(){
		return alquileres;
		
	}
	public List<Alquileres> get(Cliente cliente){
		return alquileres;
		
	}
	public int getCantidad() {
		return 0;
		
	}
	public void insertar (Alquiler alquiler) {
		
	}
	private void comprobarAlquiler(Cliente cliente,Turismo turismo,LocalDate fechaAlquiler) {
		
	}
	public void devolver(Cliente cliente,LocalDate fechaDevolucion) {
		
	}
	public void borrar(Alquiler alquiler) {
		
	}
	public Alquiler buscar(Alquiler alquiler) {
		return alquiler;
		
	}
	
	

}
