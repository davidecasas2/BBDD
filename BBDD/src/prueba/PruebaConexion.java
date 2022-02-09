/**
 * 
 */
package prueba;



import java.sql.Connection;
import java.util.ArrayList;

import conexion.ConexionBD;
import conexion.FuncionesBD;
import modelo.Editorial;
import modelo.Libro;

/**
 * @author David
 *
 */
public class PruebaConexion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("Programa que muestra la tabla Editoriales por pantalla");
		ArrayList<Editorial> lista = FuncionesBD.mostrarEditoriales();
		for (Editorial editorial : lista) {
			System.out.println(editorial);
		}
		
		System.out.println("Mostando los libros:\n");
		ArrayList<Libro> listaLibros = FuncionesBD.mostrarLibros();
		for (Libro libro : listaLibros) {
			System.out.println(libro);
		}

	}

}
