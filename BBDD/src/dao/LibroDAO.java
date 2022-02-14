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
import modelo.Libro;

/**
 * @author David
 * Clase que implementa un CRUD de la base batos
 * (Create, Read, update y delete)
 */
public class LibroDAO {

	private ConexionBD conexion;
	
    public LibroDAO() {
        this.conexion = new ConexionBD();
    }


    public ArrayList<Libro> obtenerLibros() {
    	// Obtenemos una conexion a la base de datos.
		Connection con = conexion.getConexion();
		Statement consulta = null;
		ResultSet resultado = null;
		ArrayList<Libro> lista = new ArrayList<Libro>();
		
		try {
			consulta = con.createStatement();
			resultado = consulta.executeQuery("select * from libros");
			
			// Bucle para recorrer todas las filas que devuelve la consulta
			while(resultado.next()) {
				String isbn = resultado.getString("isbn");
				String titulo = resultado.getString("título");
				int codEditorial = resultado.getInt("codEditorial");
				int año = resultado.getInt("año");
				int num_pags = resultado.getInt("num_pags");
				float precio = resultado.getFloat("precio");
				int cantidad = resultado.getInt("cantidad");
				float precioCD = resultado.getFloat("precioCD");
				
				Libro l = new Libro(isbn,titulo, codEditorial,año,num_pags, 
						precio,cantidad,precioCD);
				lista.add(l);
			}
			
		} catch (SQLException e) {
			System.out.println("Error al realizar la consulta sobre libros: "+e.getMessage());
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

    
    public ArrayList<Libro> obtenerAutores(Autor a) {
    	// Obtenemos una conexion a la base de datos.
		Connection con = conexion.getConexion();
		Statement consulta = null;
		ResultSet resultado = null;
		ArrayList<Libro> lista = new ArrayList<Libro>();
		
		try {
			consulta = con.createStatement();
			resultado = consulta.executeQuery("select l.*\r\n"
					+ "from libros l inner join autorlibro al\r\n"
					+ "on l.isbn = al.isbn\r\n"
					+ "where idAutor=?;");
			
			// Bucle para recorrer todas las filas que devuelve la consulta
			while(resultado.next()) {
				String isbn = resultado.getString("isbn");
				String titulo = resultado.getString("título");
				int codEditorial = resultado.getInt("codEditorial");
				int año = resultado.getInt("año");
				int num_pags = resultado.getInt("num_pags");
				float precio = resultado.getFloat("precio");
				int cantidad = resultado.getInt("cantidad");
				float precioCD = resultado.getFloat("precioCD");
				Libro l = new Libro(isbn,titulo, codEditorial,año,num_pags, 
						precio,cantidad,precioCD);
				lista.add(l);
			}
			
		} catch (SQLException e) {
			System.out.println("Error al realizar la consulta de autores de un libro: "+e.getMessage());
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

    public Libro obtenerLibro(String isbn) {
    	// Obtenemos una conexion a la base de datos.
		Connection con = conexion.getConexion();
		PreparedStatement consulta = null;
		ResultSet resultado = null;
		Libro l = null;
		
		try {
			consulta = con.prepareStatement("select * from libros"
					+ " where isbn = ?");
			consulta.setString(1, isbn);
			resultado=consulta.executeQuery();
			
			// Bucle para recorrer todas las filas que devuelve la consulta
			if (resultado.next()) {
				String titulo = resultado.getString("título");
				int codEditorial = resultado.getInt("codEditorial");
				int año = resultado.getInt("año");
				int num_pags = resultado.getInt("num_pags");
				float precio = resultado.getFloat("precio");
				int cantidad = resultado.getInt("cantidad");
				float precioCD = resultado.getFloat("precioCD");
				
				l = new Libro(isbn,titulo, codEditorial,año,num_pags, 
						precio,cantidad,precioCD);
			}
			
		} catch (SQLException e) {
			System.out.println("Error al realizar la consulta sobre un libro: "
		         +e.getMessage());
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
		return l;
    }


    public int insertarLibro(Libro libro) {
    	// Obtenemos una conexion a la base de datos.
		Connection con = conexion.getConexion();
		PreparedStatement consulta = null;
		int resultado=0;
		
		try {
			consulta = con.prepareStatement("INSERT INTO `biblioteca`.`libros`\r\n"
					+ "VALUES\r\n"
					+ "(?,?,?,?,?,?,?,?)");
			
			consulta.setString(1, libro.getIsbn());
			consulta.setString(2, libro.getTitulo());
			consulta.setInt(3, libro.getCodEditorial());
			consulta.setInt(4, libro.getAño());
			consulta.setInt(5, libro.getNum_pags());
			consulta.setFloat(6, libro.getPrecio());
			consulta.setInt(7, libro.getCantidad());
			consulta.setFloat(8, libro.getPrecioCD());
			
			resultado=consulta.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al realizar la inserción del libro: "
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

    public int actualizarLibro(Libro libro) {
    	// Obtenemos una conexion a la base de datos.
		Connection con = conexion.getConexion();
		PreparedStatement consulta = null;
		int resultado=0;
		
		try {
			consulta = con.prepareStatement("UPDATE `biblioteca`.`libros`\r\n"
					+ "SET\r\n"
					+ "`título` = ?,\r\n"
					+ "`codEditorial` = ?,\r\n"
					+ "`año` = ?,\r\n"
					+ "`num_pags` = ?,\r\n"
					+ "`precio` = ?,\r\n"
					+ "`cantidad` = ?,\r\n"
					+ "`precioCD` = ?\r\n"
					+ "WHERE `isbn` = ?");
			

			consulta.setString(1, libro.getTitulo());
			consulta.setInt(2, libro.getCodEditorial());
			consulta.setInt(3, libro.getAño());
			consulta.setInt(4, libro.getNum_pags());
			consulta.setFloat(5, libro.getPrecio());
			consulta.setInt(6, libro.getCantidad());
			consulta.setFloat(7, libro.getPrecioCD());
			consulta.setString(8, libro.getIsbn());
			resultado=consulta.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al realizar la actualizacion de libro: "
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


    public int eliminarLibro(Libro libro) {
    	// Obtenemos una conexion a la base de datos.
		Connection con = conexion.getConexion();
		PreparedStatement consulta = null;
		int resultado=0;
		
		try {
			consulta = con.prepareStatement("DELETE FROM libros\r\n"
					+ "WHERE isbn = ?");
			
			consulta.setString(1, libro.getIsbn());
			resultado=consulta.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al realizar el borrado de Libro: "+e.getMessage());
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
