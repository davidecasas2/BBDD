/**
 * 
 */
package controlador;

import java.util.ArrayList;

import conexion.FuncionesBD;
import modelo.Editorial;
import modelo.Libro;
import vista.DialogoEditoriales;
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
	
	public Controlador() {
		// Creamos las ventanas de la aplicación
		ventanaPpal = new VentanaPpal();
		dialogoEditoriales = new DialogoEditoriales();
		ventanaLibros = new VentanaLibros();
		
		// Dando acceso al controlador desde las vistas
		ventanaPpal.setControlador(this);
		dialogoEditoriales.setControlador(this);
		ventanaLibros.setControlador(this);
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
}
