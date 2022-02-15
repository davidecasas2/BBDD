/**
 * 
 */
package controlador;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import conexion.FuncionesBD;
import dao.AutorDAO;
import dao.AutorLibroDAO;
import dao.EditorialDAO;
import dao.LibroDAO;
import modelo.Autor;
import modelo.Editorial;
import modelo.Libro;
import vista.A�adirAutor;
import vista.A�adirEditorial;
import vista.DialogoEditoriales;
import vista.VentanaAutores;
import vista.VentanaA�adirLibro;
import vista.VentanaLibros;
import vista.VentanaPpal;

/**
 * @author David
 *
 */
public class Controlador {

	// VEntanas del sistema
	private VentanaPpal ventanaPpal;
	private DialogoEditoriales dialogoEditoriales;
	private VentanaLibros ventanaLibros;
	private VentanaAutores ventanaAutores;
	private A�adirAutor a�adirAutor;
	private A�adirEditorial a�adirEditorial;
	private VentanaA�adirLibro ventanaA�adirLibro;
	
	// Objetos DAO o CRUD de la base de datos
	private EditorialDAO editorialDAO;
	private AutorDAO autorDAO;
	private LibroDAO libroDAO;
	private AutorLibroDAO autorLibroDAO;
	
	public Controlador() {
		// Creamos las ventanas de la aplicaci�n
		ventanaPpal = new VentanaPpal();
		dialogoEditoriales = new DialogoEditoriales();
		ventanaLibros = new VentanaLibros();
		ventanaAutores = new VentanaAutores();
		a�adirAutor = new A�adirAutor();
		a�adirEditorial = new A�adirEditorial();
		ventanaA�adirLibro = new VentanaA�adirLibro();
		
		// Dando acceso al controlador desde las vistas
		ventanaPpal.setControlador(this);
		dialogoEditoriales.setControlador(this);
		ventanaLibros.setControlador(this);
		ventanaAutores.setControlador(this);
		a�adirAutor.setControlador(this);
		a�adirEditorial.setControlador(this);
		ventanaA�adirLibro.setControlador(this);
		
		// Creamos los objetos DAO
		editorialDAO = new EditorialDAO();
		autorDAO = new AutorDAO();
		libroDAO = new LibroDAO();
		autorLibroDAO = new AutorLibroDAO();
	}
	
	public void inciarPrograma() {
		ventanaPpal.setVisible(true);
	}
	
	public void mostrarEditoriales() {
		ArrayList<Editorial> lista = editorialDAO.obtenerEditoriales();
		dialogoEditoriales.setListaEditoriales(lista);
		dialogoEditoriales.setVisible(true);
	}
	
	public void mostrarLibros() {
		ArrayList<Libro> lista = FuncionesBD.mostrarLibros();
		ventanaLibros.setListaLibros(lista);
		ventanaLibros.setVisible(true);
	}
	
	public void mostrarAutores() {
		ArrayList<Autor> lista = FuncionesBD.mostrarAutores();
		ventanaAutores.setListaAutores(lista);
		ventanaAutores.setVisible(true);
	}
	
	public void mostrarA�adirAutor() {
		a�adirAutor.setVisible(true);
	}
	
	public void insertarAutor(Autor a) {
		int res=FuncionesBD.insertarAutor(a);
		if (res==0) {
			JOptionPane.showMessageDialog(a�adirAutor, "Error no se ha podido insertar");
		} else {
			JOptionPane.showMessageDialog(a�adirAutor, "Autor a�adido correctamente.");
			a�adirAutor.setVisible(false);
		}
	}
	
	public void mostrarA�adirEditorial() {
		a�adirEditorial.setVisible(true);
	}
	
	public void insertarEditorial(Editorial ed) {
		int res=editorialDAO.insertarEditorial(ed);
		if (res==0) {
			JOptionPane.showMessageDialog(a�adirEditorial, "Error no se ha podido insertar");
		} else {
			JOptionPane.showMessageDialog(a�adirEditorial, "Editorial a�adido correctamente.");
			a�adirEditorial.setVisible(false);
		}
	}

	public int borrarLibro(String isbn) {
		return FuncionesBD.borraLibro(isbn);
	}

	public void mostrarInsertarLibro() {
		// Consultar las editoriales
		ArrayList<Editorial> listaEditoriales = editorialDAO.obtenerEditoriales();
		// Consultar los autores deisponibles
		ArrayList<Autor> listaAutores = autorDAO.obtenerAutores();
		// pasarle la lista de editoriales 
		ventanaA�adirLibro.setEditoriales(listaEditoriales);
		
		// pasar la lista de autores
		ventanaA�adirLibro.setListaAutores(listaAutores);
		// mostrar la ventana
		ventanaA�adirLibro.setVisible(true);
	}

	public void insertarLibro(Libro l, ArrayList<Autor> listaAutores) {
		// Insertamos el libro
		libroDAO.insertarLibro(l);
		
		for (Autor autor : listaAutores) {
			autorLibroDAO.insertarAutorLibro(autor.getIdAutor(), l.getIsbn());
		}
		
		ventanaA�adirLibro.setVisible(false);
	}
}
