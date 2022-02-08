/**
 * 
 */
package prueba;



import java.sql.Connection;

import conexion.ConexionBD;

/**
 * @author David
 *
 */
public class PruebaConexion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ConexionBD conexionBD = new ConexionBD();
		
		Connection conn = conexionBD.getConexion();
		// ...
		conexionBD.desconectar();

	}

}
