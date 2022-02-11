/**
 * 
 */
package controlador;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import conexion.FuncionesBD;
import modelo.Autor;
import modelo.Editorial;
import modelo.Libro;
import vista.AñadirAutor;
import vista.DialogoEditoriales;
import vista.VentanaAutores;
import vista.VentanaLibros;
import vista.VentanaPpal;

/**
 * @author David
 *
 */
public class Controlador {

	private VentanaPpal ventanaPpal;
	private DialogoEditoriales dialogoEditoriales;
	private VentanaLibros ventanaLibros;
	private VentanaAutores ventanaAutores;
	private AñadirAutor añadirAutor;
	
	public Controlador() {
		// Creamos las ventanas de la aplicación
		ventanaPpal = new VentanaPpal();
		dialogoEditoriales = new DialogoEditoriales();
		ventanaLibros = new VentanaLibros();
		ventanaAutores = new VentanaAutores();
		añadirAutor = new AñadirAutor();
		
		// Dando acceso al controlador desde las vistas
		ventanaPpal.setControlador(this);
		dialogoEditoriales.setControlador(this);
		ventanaLibros.setControlador(this);
		ventanaAutores.setControlador(this);
		añadirAutor.setControlador(this);
	}
	
	public void inciarPrograma() {
		ventanaPpal.setVisible(true);
	}
	
	public void mostrarEditoriales() {
		ArrayList<Editorial> lista = FuncionesBD.mostrarEditoriales();
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
}
