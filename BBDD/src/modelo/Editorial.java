/**
 * 
 */
package modelo;

import java.util.Objects;

/**
 * @author David
 *
 */
public class Editorial {

	private int codEditorial;
	private String nombre;
	private int a�o;
	
	
	
	public Editorial() {
		this.nombre="";
	}
	public Editorial(int codEditorial, String nombre, int a�o) {
		super();
		this.codEditorial = codEditorial;
		this.nombre = nombre;
		this.a�o = a�o;
	}
	public int getCodEditorial() {
		return codEditorial;
	}
	public void setCodEditorial(int codEditorial) {
		this.codEditorial = codEditorial;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getA�o() {
		return a�o;
	}
	public void setA�o(int a�o) {
		this.a�o = a�o;
	}
	@Override
	public int hashCode() {
		return Objects.hash(codEditorial);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Editorial other = (Editorial) obj;
		return codEditorial == other.codEditorial;
	}
	@Override
	public String toString() {
		return this.codEditorial+" - "+this.nombre;
	}
	
	
}
