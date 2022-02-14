/**
 * 
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexion.ConexionBD;
import modelo.Autor;
import modelo.Editorial;
import modelo.Libro;

/**
 * @author David
 * Clase que implementa un CRUD de la base batos
 * (Create, Read, update y delete)
 */
public class AutorLibroDAO {

	private ConexionBD conexion;
	
    public AutorLibroDAO() {
        this.conexion = new ConexionBD();
    }


    public int insertarAutorLibro(int idAutor, String isbn) {
    	// Obtenemos una conexion a la base de datos.
		Connection con = conexion.getConexion();
		PreparedStatement consulta = null;
		int resultado=0;
		
		try {
			consulta = con.prepareStatement("INSERT INTO autorlibro (isbn,idAutor)"
					+ " VALUES (?,?) ");
			
			consulta.setString(1, isbn);
			consulta.setInt(2, idAutor);
			resultado=consulta.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al realizar la inserción del autor libro: "
		        +e.getMessage());
		} finally {
			try {
				consulta.close();
				conexion.desconectar();
			} catch (SQLException e) {
				System.out.println("Error al liberar recursos: "+e.getMessage());
			} catch (Exception e) {
				
			}
		}
		return resultado;
    }

   
}
