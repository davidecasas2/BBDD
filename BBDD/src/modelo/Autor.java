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

	private int idAutores;
	private String nombre;
	private String apellidos;
	public Autor(int idAutores, String nombre, String apellidos) {
		super();
		this.idAutores = idAutores;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}
	public Autor() {
		super();
	}
	/**
	 * @return el idAutores
	 */
	public int getIdAutores() {
		return idAutores;
	}
	/**
	 * @param idAutores el idAutores a establecer
	 */
	public void setIdAutores(int idAutores) {
		this.idAutores = idAutores;
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
		return Objects.hash(idAutores);
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
		return idAutores == other.idAutores;
	}
	@Override
	public String toString() {
		return "Autor [idAutores=" + idAutores + ", nombre=" + nombre + ", apellidos=" + apellidos + "]";
	}
	
	
	
	
	
}
