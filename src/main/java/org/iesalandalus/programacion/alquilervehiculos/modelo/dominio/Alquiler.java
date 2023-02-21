package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Alquiler {
	static final DateTimeFormatter FORMATO_FECHA=DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private static final int PRECIO_DIA=20;
	private LocalDate fechaAlquiler;
	private LocalDate fechaDevolucion;
	private Cliente cliente;
	private Turismo turismo;
	
	public Alquiler(Cliente cliente,Turismo turismo,LocalDate fechaAlquiler) {
		setCliente(cliente);
		setTurismo(turismo);
		setFechaAlquiler(fechaAlquiler);
	}
	
	public Alquiler (Alquiler alquiler) {
		if (alquiler==null) {
			throw new NullPointerException("ERROR: No es posible copiar un alquiler nulo.");
		}
		setCliente(new Cliente(alquiler.cliente.getNombre(), alquiler.cliente.getDni(), alquiler.cliente.getTelefono()));
		setTurismo(new Turismo(alquiler.turismo.getMarca(), alquiler.turismo.getModelo(), alquiler.turismo.getCilindrada(),alquiler.turismo.getMatricula()));
		setFechaAlquiler(getFechaAlquiler());
	}

	
	public Cliente getCliente() {
		return cliente;
	}
	private void setCliente (Cliente cliente) {
	this.cliente = cliente;
		
	}
	public Turismo getTurismo() {
		return turismo;
	}
	private void setTurismo(Turismo turismo) {
		this.turismo = turismo;
	}
	public LocalDate getFechaAlquiler() {
		
		return fechaAlquiler;
	}

	public void setFechaAlquiler(LocalDate fechaAlquiler) {
		if (fechaAlquiler==null) {
			throw new NullPointerException("ERROR: La fecha de alquiler no puede ser nula.");
		}
		if (fechaAlquiler.isAfter(LocalDate.now())) {
			throw new IllegalArgumentException("ERROR: La fecha de alquiler no puede ser futura.");
		}
		this.fechaAlquiler = fechaAlquiler;
	}

	public LocalDate getFechaDevolucion() {
		
		return fechaDevolucion;
	}

	public void setFechaDevolucion(LocalDate fechaDevolucion) {
		if (fechaDevolucion.isBefore(this.fechaAlquiler)) {
			throw new IllegalArgumentException("ERROR: La fecha no puede ser anterior.");
		}
		if (fechaDevolucion.isAfter(LocalDate.now())) {
			throw new IllegalArgumentException("ERROR: La fecha de devolucion no puede ser posterior.");
		}
		this.fechaDevolucion = fechaDevolucion;
	}
	public void devolver(LocalDate fechaDevolucion) {
		
		this.fechaDevolucion = fechaDevolucion;
		
	}
	public int getPrecio() {
		int numDias = Period.between(fechaAlquiler, fechaDevolucion).getDays();
		int factorCilindrada = turismo.getCilindrada()/10;
		int precioTotal = (PRECIO_DIA + factorCilindrada)*numDias;
		return precioTotal;
	}

	@Override
	public String toString() {
		return String.format("%s <----> %s, %s - %s (%d€)", cliente, turismo,fechaAlquiler.format(FORMATO_FECHA), fechaDevolucion , getPrecio()); 
	}
	
	
	
	
	
	
	
}
