/**
 * 
 */
package modelo;

import java.util.Objects;

/**
 * @author David
 *
 */
public class AutorLibro {

	private Libro libro; 
	private Autor autor;
	
	public AutorLibro() {
		super();
	}

	public AutorLibro(Libro libro) {
		super();
		this.libro = libro;
	}

	public AutorLibro(Autor autor) {
		super();
		this.autor = autor;
	}

	public AutorLibro(Libro libro, Autor autor) {
		super();
		this.libro = libro;
		this.autor = autor;
	}

	/**
	 * @return el libro
	 */
	public Libro getLibro() {
		return libro;
	}

	/**
	 * @param libro el libro a establecer
	 */
	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	/**
	 * @return el autor
	 */
	public Autor getAutor() {
		return autor;
	}

	/**
	 * @param autor el autor a establecer
	 */
	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(autor, libro);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AutorLibro other = (AutorLibro) obj;
		return Objects.equals(autor, other.autor) && Objects.equals(libro, other.libro);
	}

	@Override
	public String toString() {
		return "AutorLibro [libro=" + libro + ", autor=" + autor + "]";
	}
	
	
	
	
}
