package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cliente {

	private static final String ER_NOMBRE = "[A-Z][a-z]*(\s[A-Z][a-z]*)?";
	private static final String ER_DNI = "[0-9]{8}[A-Z]";
	private static final String ER_TELEFONO = "[0-9]{9}";
	private static final char[] LETRAS_DNI = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J',
			'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E' };
	private String nombre;
	private String dni;
	private String telefono;

	public Cliente(String nombre, String dni, String telefono) {
		setNombre(nombre);
		setDni(dni);
		setTelefono(telefono);
	}

	public Cliente(Cliente cliente) {
		if(cliente==null) {
			throw new NullPointerException("ERROR: No es posible copiar un cliente nulo.");
		}
		setNombre(cliente.nombre);
		setDni(cliente.dni);
		setTelefono(cliente.telefono);
		

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if(nombre==null) {
			throw new NullPointerException("ERROR: El nombre no puede ser nulo.");
		}

		if (!nombre.matches(ER_NOMBRE)) {
			throw new IllegalArgumentException("ERROR: El nombre no tiene un formato válido.");
		}

		this.nombre = nombre;

	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {

		if (dni == null) {
			throw new NullPointerException("ERROR: El DNI no puede ser nulo.");
		}
		if (!dni.matches(ER_DNI)) {
			throw new IllegalArgumentException("ERROR: El DNI no tiene un formato válido.");
		}

		if (!comprobarLetraDni(dni)) {
			throw new IllegalArgumentException("ERROR: La letra de DNI no es correcta.");
		}
		this.dni = dni;
	}

	public boolean comprobarLetraDni(String dni) {

		int numDni;
		char letraDni;

		letraDni = dni.charAt(8);

		numDni = Integer.parseInt(dni.substring(0, 8));

		char letraCorrecta = LETRAS_DNI[numDni % 23];

		if (letraDni != letraCorrecta) {
			throw new IllegalArgumentException("ERROR: La letra del DNI no es correcta.");
		}
		return true;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		if (telefono == null) {
			throw new NullPointerException("ERROR: El teléfono no puede ser nulo.");
		}
		if (!telefono.matches(ER_TELEFONO)) {
			throw new IllegalArgumentException("ERROR: El teléfono no tiene un formato válido.");
		}

		this.telefono = telefono;
	}

	public static Cliente getClienteConDni(String dni) {

        return new Cliente("Bob Esponja", dni, "950112233");
    }
	
	
	
	

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(dni, other.dni);
	}

	@Override
	public String toString() {
		return nombre+" - " + dni +" "+"("+telefono+")";
	}

}
