/**
 * 
 */
package prueba;



import java.sql.Connection;

import conexion.ConexionBD;
import conexion.FuncionesBD;

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
		FuncionesBD.mostrarEditoriales();
		System.out.println("Mostando los libros:\n");
		FuncionesBD.mostrarLibros();

	}

}
