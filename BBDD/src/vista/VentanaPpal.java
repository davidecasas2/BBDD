package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import conexion.FuncionesBD;
import controlador.Controlador;
import modelo.Editorial;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class VentanaPpal extends JFrame {

	private JPanel contentPane;
	private Controlador controlador;



	/**
	 * Create the frame.
	 */
	public VentanaPpal() {
		
		setTitle("Base de datos de Biblioteca");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][grow][][grow][]", "[][][][][]"));
		
		JButton btnNewButton = new JButton("MostarEditoriales");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.mostrarEditoriales();
			}
		});
		contentPane.add(btnNewButton, "cell 1 1");
		
		JButton btnNewButton_1 = new JButton("Mostrar Libros");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.mostrarLibros();
			}
		});
		contentPane.add(btnNewButton_1, "cell 3 1");
		
		JButton btnNewButton_2 = new JButton("Mostrar Autores");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.mostrarAutores();
			}
		});
		contentPane.add(btnNewButton_2, "cell 2 3");
		
		JButton btnNewButton_3 = new JButton("InsertarAutor");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.mostrarAñadirAutor();
			}
		});
		contentPane.add(btnNewButton_3, "cell 2 4,growx");
	}



	/**
	 * @param controlador el controlador a establecer
	 */
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}
	
	

}
