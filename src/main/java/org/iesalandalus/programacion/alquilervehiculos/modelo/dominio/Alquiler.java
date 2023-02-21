package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import javax.naming.OperationNotSupportedException;

public class Alquiler {
	static final DateTimeFormatter FORMATO_FECHA=DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private static final int PRECIO_DIA=20;
	private LocalDate fechaAlquiler;
	private LocalDate fechaDevolucion;
	private Cliente cliente;
	private Turismo turismo;
	
	public Alquiler(Cliente cliente,Turismo turismo,LocalDate fechaAlquiler) {
		if (cliente==null) {
			throw new NullPointerException("ERROR: El cliente no puede ser nulo.");
		}
		if (turismo==null) {
			throw new NullPointerException("ERROR: El turismo no puede ser nulo.");
		}
		if (fechaAlquiler==null) {
			throw new NullPointerException("ERROR: La fecha de alquiler no puede ser nula.");
		}
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
		setFechaAlquiler(alquiler.fechaAlquiler);
		setFechaDevolucion(alquiler.fechaDevolucion);
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	private void setCliente (Cliente cliente) {
		if (cliente==null) {
			throw new NullPointerException("ERROR: El cliente no puede ser nulo.");
		}
	this.cliente = cliente;
		
	}
	public Turismo getTurismo() {
		return turismo;
	}
	private void setTurismo(Turismo turismo) {
		if (turismo==null) {
			throw new NullPointerException("ERROR: El turismo no puede ser nulo.");
		}
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
		if (fechaDevolucion.isBefore(getFechaAlquiler())) {
			throw new IllegalArgumentException("ERROR: La fecha no puede ser anterior.");
		}
		if (fechaDevolucion.isAfter(LocalDate.now())) {
			throw new IllegalArgumentException("ERROR: La fecha de devolucion no puede ser posterior.");
		}
		this.fechaDevolucion = fechaDevolucion;
	}
	public void devolver(LocalDate fechaDevolucion) throws OperationNotSupportedException {
		if (fechaDevolucion==null) {
			throw new NullPointerException("ERROR: La fecha de devolución no puede ser nula.");
		}
		if (fechaDevolucion.isAfter(LocalDate.now())){
			throw new IllegalArgumentException("ERROR: La fecha de devolución no puede ser futura.");
		}
		if (fechaDevolucion.isBefore(getFechaAlquiler())) {
			throw new IllegalArgumentException("ERROR: La fecha de devolución debe ser posterior a la fecha de alquiler.");
		}
		if (fechaDevolucion==getFechaDevolucion()) {
			throw new OperationNotSupportedException("ERROR: La devolución ya estaba registrada.");
		}
		
		
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
		return cliente.getNombre() +"," +cliente.getTelefono() +"<--->"+turismo+","+ fechaAlquiler+"Aún no devuelto ("+getPrecio()+")";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cliente, fechaAlquiler, fechaDevolucion, turismo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alquiler other = (Alquiler) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(fechaAlquiler, other.fechaAlquiler)
				&& Objects.equals(fechaDevolucion, other.fechaDevolucion) && Objects.equals(turismo, other.turismo);
	}

	
	
	
	
	
	
	
}
