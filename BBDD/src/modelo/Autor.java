/**
 * 
 */
package modelo;

import java.util.Objects;

/**
 * @author David
 *
 */
public class Autor {

	private int idAutor;
	private String nombre;
	private String apellidos;
	
	
	public Autor(int idAutor, String nombre, String apellidos) {
		super();
		this.idAutor = idAutor;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}
	public Autor() {
		super();
	}
	/**
	 * @return el idAutores
	 */
	public int getIdAutor() {
		return idAutor;
	}
	/**
	 * @param idAutores el idAutores a establecer
	 */
	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}
	/**
	 * @return el nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre el nombre a establecer
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return el apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}
	/**
	 * @param apellidos el apellidos a establecer
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idAutor);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autor other = (Autor) obj;
		return idAutor == other.idAutor;
	}
	@Override
	public String toString() {
		return "Autor [idAutores=" + idAutor + ", nombre=" + nombre + ", apellidos=" + apellidos + "]";
	}
	
	
	
	
	
}
