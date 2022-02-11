/**
 * 
 */
package modelo;

import java.util.Objects;

/**
 * @author David
 *
 */
public class Libro {

	private String isbn;
	private String titulo;
	private int codEditorial;
	private int año;
	private int num_pags;
	private float precio;
	private int cantidad;
	private float precioCD;
	
	
	public Libro() {
		isbn="";
		titulo="";
	}


	/**
	 * Constructo de la clase
	 * @param isbn String con el isbn del libro
	 * @param titulo cadena String con el título hasta 50 carcacteres
	 * @param codEditorial int con el código de la editorial
	 * @param año int con el año del libro
	 * @param num_pags int con el núemro de páginas
	 * @param precio float con el precio del libro
	 * @param cantidad int con el el numero del¡ libros en stock
	 * @param precioCD precio del CD incluido o 0 en caso de no tener CD
	 * @throws PaginaNegativasException 
	 * @throws PrcioMenorque10Exception 
	 */
	public Libro(String isbn, String titulo, int codEditorial, int año, int num_pags, float precio, int cantidad,
			float precioCD)  {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.codEditorial = codEditorial;
		this.año = año;
		this.num_pags = num_pags;
		this.precio = precio;
		this.cantidad = cantidad;
		this.precioCD = precioCD;
	}


	/**
	 * @return el isbn
	 */
	public String getIsbn() {
		return isbn;
	}


	/**
	 * @param isbn el isbn a establecer
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	/**
	 * @return el titulo
	 */
	public String getTitulo() {
		return titulo;
	}


	/**
	 * @param titulo el titulo a establecer
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	/**
	 * @return el codEditorial
	 */
	public int getCodEditorial() {
		return codEditorial;
	}


	/**
	 * @param codEditorial el codEditorial a establecer
	 */
	public void setCodEditorial(int codEditorial) {
		this.codEditorial = codEditorial;
	}


	/**
	 * @return el año
	 */
	public int getAño() {
		return año;
	}


	/**
	 * @param año el año a establecer
	 */
	public void setAño(int año) {
		this.año = año;
	}


	/**
	 * @return el num_pags
	 */
	public int getNum_pags() {
		return num_pags;
	}


	/**
	 * @param num_pags el num_pags a establecer
	 */
	public void setNum_pags(int num_pags) {
		this.num_pags = num_pags;
	}


	/**
	 * @return el precio
	 */
	public float getPrecio() {
		return precio;
	}


	/**
	 * @param precio el precio a establecer
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}


	/**
	 * @return el cantidad
	 */
	public int getCantidad() {
		return cantidad;
	}


	/**
	 * @param cantidad el cantidad a establecer
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	/**
	 * @return el precioCD
	 */
	public float getPrecioCD() {
		return precioCD;
	}


	/**
	 * @param precioCD el precioCD a establecer
	 */
	public void setPrecioCD(float precioCD) {
		this.precioCD = precioCD;
	}


	@Override
	public int hashCode() {
		return Objects.hash(isbn);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return Objects.equals(isbn, other.isbn);
	}


	@Override
	public String toString() {
		return "Libro [isbn=" + isbn + ", titulo=" + titulo + ", codEditorial=" + codEditorial + ", año=" + año
				+ ", num_pags=" + num_pags + ", precio=" + precio + ", cantidad=" + cantidad + ", precioCD=" + precioCD
				+ "]";
	}
	
	
	
	
	
}
