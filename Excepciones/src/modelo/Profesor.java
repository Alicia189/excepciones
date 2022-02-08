/**
 * 
 */
package modelo;

import java.util.Objects;

/**
 * @author David
 *
 */
public class Profesor {

	private String nombre;
	private String dni;
	private double salario;
	private boolean fijo;
	
	
	
	public Profesor() {
		this.nombre = "";
		this.dni = "";
	}
	
	
	public Profesor(String nombre, String dni, double salario, boolean fijo) {
		this.nombre = nombre;
		this.dni = dni;
		this.salario = salario;
		this.fijo = fijo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public boolean isFijo() {
		return fijo;
	}
	public void setFijo(boolean fijo) {
		this.fijo = fijo;
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
		Profesor other = (Profesor) obj;
		return Objects.equals(dni, other.dni);
	}


	@Override
	public String toString() {
		return "Profesor [nombre=" + nombre + ", dni=" + dni + ", salario=" + salario + ", fijo=" + fijo + "]";
	}
	
	
}
