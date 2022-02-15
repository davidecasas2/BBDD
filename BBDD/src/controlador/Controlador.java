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
import vista.AñadirAutor;
import vista.AñadirEditorial;
import vista.DialogoEditoriales;
import vista.VentanaAutores;
import vista.VentanaAñadirLibro;
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
	private AñadirAutor añadirAutor;
	private AñadirEditorial añadirEditorial;
	private VentanaAñadirLibro ventanaAñadirLibro;
	
	// Objetos DAO o CRUD de la base de datos
	private EditorialDAO editorialDAO;
	private AutorDAO autorDAO;
	private LibroDAO libroDAO;
	private AutorLibroDAO autorLibroDAO;
	
	public Controlador() {
		// Creamos las ventanas de la aplicación
		ventanaPpal = new VentanaPpal();
		dialogoEditoriales = new DialogoEditoriales();
		ventanaLibros = new VentanaLibros();
		ventanaAutores = new VentanaAutores();
		añadirAutor = new AñadirAutor();
		añadirEditorial = new AñadirEditorial();
		ventanaAñadirLibro = new VentanaAñadirLibro();
		
		// Dando acceso al controlador desde las vistas
		ventanaPpal.setControlador(this);
		dialogoEditoriales.setControlador(this);
		ventanaLibros.setControlador(this);
		ventanaAutores.setControlador(this);
		añadirAutor.setControlador(this);
		añadirEditorial.setControlador(this);
		ventanaAñadirLibro.setControlador(this);
		
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
	
	public void mostrarAñadirAutor() {
		añadirAutor.setVisible(true);
	}
	
	public void insertarAutor(Autor a) {
		int res=FuncionesBD.insertarAutor(a);
		if (res==0) {
			JOptionPane.showMessageDialog(añadirAutor, "Error no se ha podido insertar");
		} else {
			JOptionPane.showMessageDialog(añadirAutor, "Autor añadido correctamente.");
			añadirAutor.setVisible(false);
		}
	}
	
	public void mostrarAñadirEditorial() {
		añadirEditorial.setVisible(true);
	}
	
	public void insertarEditorial(Editorial ed) {
		int res=editorialDAO.insertarEditorial(ed);
		if (res==0) {
			JOptionPane.showMessageDialog(añadirEditorial, "Error no se ha podido insertar");
		} else {
			JOptionPane.showMessageDialog(añadirEditorial, "Editorial añadido correctamente.");
			añadirEditorial.setVisible(false);
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
		ventanaAñadirLibro.setEditoriales(listaEditoriales);
		
		// pasar la lista de autores
		ventanaAñadirLibro.setListaAutores(listaAutores);
		// mostrar la ventana
		ventanaAñadirLibro.setVisible(true);
	}

	public void insertarLibro(Libro l, ArrayList<Autor> listaAutores) {
		// Insertamos el libro
		libroDAO.insertarLibro(l);
		
		for (Autor autor : listaAutores) {
			autorLibroDAO.insertarAutorLibro(autor.getIdAutor(), l.getIsbn());
		}
		
		ventanaAñadirLibro.setVisible(false);
	}
}
