/**
 * 
 */
package controlador;

import java.util.ArrayList;

import conexion.FuncionesBD;
import modelo.Editorial;
import vista.DialogoEditoriales;
import vista.VentanaPpal;

/**
 * @author David
 *
 */
public class Controlador {

	VentanaPpal ventanaPpal;
	DialogoEditoriales dialogoEditoriales;
	
	public Controlador() {
		// Creamos las ventanas de la aplicación
		ventanaPpal = new VentanaPpal();
		dialogoEditoriales = new DialogoEditoriales();
		
		// Dando acceso al controlador desde las vistas
		ventanaPpal.setControlador(this);
		dialogoEditoriales.setControlador(this);
	}
	
	public void inciarPrograma() {
		ventanaPpal.setVisible(true);
	}
	
	public void mostrarEditoriales() {
		ArrayList<Editorial> lista = FuncionesBD.mostrarEditoriales();
		dialogoEditoriales.setListaEditoriales(lista);
		dialogoEditoriales.setVisible(true);
	}
}
