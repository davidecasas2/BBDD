/**
 * 
 */
package conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Autor;
import modelo.Editorial;
import modelo.Libro;


/**
 * @author David
 *
 */
public class FuncionesBD {
	
	private static ConexionBD conexion = new ConexionBD();
	
	public static ArrayList<Editorial> mostrarEditoriales() {
		// Obtenemos una conexion a la base de datos.
		Connection con = conexion.getConexion();
		Statement consulta = null;
		ResultSet resultado = null;
		ArrayList<Editorial> lista = new ArrayList<Editorial>();
		
		try {
			consulta = con.createStatement();
			resultado = consulta.executeQuery("select * from editoriales");
			
			// Bucle para recorrer todas las filas que devuelve la consulta
			while(resultado.next()) {
				int codEditorial = resultado.getInt("codeditorial");
				String nombre = resultado.getString("nombre");
				int año = resultado.getInt("año");
				
				Editorial ed = new Editorial(codEditorial, nombre,año);
				lista.add(ed);
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
		return lista;
	}
	
	public static ArrayList<Libro> mostrarLibros() {
		// Obtenemos una conexion a la base de datos.
		ArrayList<Libro> lista = new ArrayList<Libro>();
		Connection con = conexion.getConexion();
		Statement consulta = null;
		ResultSet resultado = null;
		
		
		try {
			consulta = con.createStatement();
			resultado = consulta.executeQuery("select * from libros\r\n"
					+ "order by num_pags DESC");
			
			// Bucle para recorrer todas las filas que devuelve la consulta
			while(resultado.next()) {
				String isbn = resultado.getString("isbn");
				String titulo = resultado.getString("título");
				int codigo = resultado.getInt("codeditorial");
				int año = resultado.getInt("año");
				int num = resultado.getInt("num_pags");
				float precio = resultado.getFloat("precio");
				int cantidad = resultado.getInt("cantidad");
				float precioCD = resultado.getFloat("precioCD");
				
				Libro l =new Libro(isbn,titulo,codigo, año, num, precio, cantidad, precioCD);
				lista.add(l);
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
		return lista;
	}
	
	
	public static ArrayList<Autor> mostrarAutores() {
		// Obtenemos una conexion a la base de datos.
		ArrayList<Autor> lista = new ArrayList<Autor>();
		Connection con = conexion.getConexion();
		Statement consulta = null;
		ResultSet resultado = null;
		
		
		try {
			consulta = con.createStatement();
			resultado = consulta.executeQuery("select * from autores");
			
			// Bucle para recorrer todas las filas que devuelve la consulta
			while(resultado.next()) {
				int codigo = resultado.getInt("idAutor");
				String nombre= resultado.getString("nombre");
				String apellidos = resultado.getString("apellidos");
				
				Autor a =  new Autor(codigo, nombre, apellidos);
				lista.add(a);
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
		return lista;
	}
	
	public static int insertarAutor(Autor a) {
		// Obtenemos una conexion a la base de datos.
		Connection con = conexion.getConexion();
		PreparedStatement consulta = null;
		int resultado=0;
		
		try {
			consulta = con.prepareStatement("INSERT INTO autores (nombre,apellidos)"
					+ " VALUES (?,?) ");
			
			consulta.setString(1, a.getNombre());
			consulta.setString(2, a.getApellidos());
			resultado=consulta.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al realizar la consulta: "+e.getMessage());
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
