/**
 * 
 */
package conexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * @author David
 *
 */
public class FuncionesBD {
	
	
	
	public static void mostrarEditoriales() {
		// Obtenemos una conexion a la base de datos.
		ConexionBD conexion = new ConexionBD();
		Connection con = conexion.getConexion();
		Statement consulta = null;
		ResultSet resultado = null;
		
		
		try {
			consulta = con.createStatement();
			resultado = consulta.executeQuery("select * from editoriales");
			
			// Bucle para recorrer todas las filas que devuelve la consulta
			while(resultado.next()) {
				int codEditorial = resultado.getInt("cod_editorial");
				String nombre = resultado.getString("nombre");
				int año = resultado.getInt("año");
				
				System.out.printf("codEDitorial: %d\tNombre: %s\tAño: %d\n",
						codEditorial, nombre, año);
			}
			
		} catch (SQLException e) {
			System.out.println("Error al realizar la consulta: "+e.getMessage());
		} finally {
			try {
				resultado.close();
				consulta.close();
				conexion.desconectar();
			} catch (SQLException e) {
				System.out.println("Error al liberar recursos: "+e.getMessage());
			} catch (Exception e) {
				
			}
		}
	}
	
	
	
	
	
}
