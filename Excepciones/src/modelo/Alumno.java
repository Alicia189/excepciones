/**
 * 
 */
package modelo;

import java.util.Objects;

/**
 * 
 * @author David
 *
 */
public class Alumno {

	private String nombre;
	private double nota1;
	private double nota2;
	private double nota3;
	
	public Alumno(String nombre, double nota1, double nota2, double nota3) {
		super();
		this.nombre = nombre;
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.nota3 = nota3;
	}

	public Alumno() {
		this.nota1=10;
		this.nota2=10;
		this.nota3=10;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getNota1() {
		return nota1;
	}

	public void setNota1(double nota1) {
		this.nota1 = nota1;
	}

	public double getNota2() {
		return nota2;
	}

	public void setNota2(double nota2) {
		this.nota2 = nota2;
	}

	public double getNota3() {
		return nota3;
	}

	public void setNota3(double nota3) {
		this.nota3 = nota3;
	}
	
	public double getNotaMedia() {
		double res = (this.nota1+this.nota2+this.nota3)/3;
		return res;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", nota1=" + nota1 + ", nota2=" + nota2 + ", nota3=" + nota3
				+ ", media=" + getNotaMedia() + "]";
	}
	
	
	
	
	
	
}
