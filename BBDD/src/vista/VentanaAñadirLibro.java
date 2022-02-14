package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;
import modelo.Autor;
import modelo.Editorial;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.SpinnerNumberModel;

public class VentanaAñadirLibro extends JFrame {

	private JPanel contentPane;
	private JTextField txtIsbn;
	private JTextField txtTitulo;
	private JTextField txtPrecio;
	private JTextField txtPrecioCD;
	private Controlador controlador;
	private ArrayList<Editorial> listaEditoriales;
	private JComboBox comboEditorial;
	private ArrayList<Autor> listaAutores;


	/**
	 * Create the frame.
	 */
	public VentanaAñadirLibro() {
		setTitle("Insertar Libro Nuevo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 598, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][][grow]", "[][][41.00,grow][]"));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, "cell 0 0 3 1,grow");
		panel.setLayout(new MigLayout("", "[][][grow][grow][][][grow]", "[][][][][][][][][]"));
		
		JLabel lblNewLabel = new JLabel("ISBN:");
		panel.add(lblNewLabel, "cell 0 0,alignx trailing");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		txtIsbn = new JTextField();
		panel.add(txtIsbn, "cell 1 0 6 1,growx");
		txtIsbn.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("T\u00EDtulo:");
		panel.add(lblNewLabel_1, "cell 0 2,alignx trailing");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		txtTitulo = new JTextField();
		panel.add(txtTitulo, "cell 1 2 6 1,growx");
		txtTitulo.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Edirorial: ");
		panel.add(lblNewLabel_2, "cell 0 4,alignx trailing");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		comboEditorial = new JComboBox();
		panel.add(comboEditorial, "cell 1 4 6 1,growx");
		
		JLabel lblNewLabel_3 = new JLabel("A\u00F1o:");
		panel.add(lblNewLabel_3, "cell 0 6,alignx right");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JSpinner spinnerAño = new JSpinner();
		spinnerAño.setModel(new SpinnerNumberModel(2022, 1800, 2500, 1));
		panel.add(spinnerAño, "cell 1 6");
		
		JLabel lblNewLabel_4 = new JLabel("Num. P\u00E1ginas:");
		panel.add(lblNewLabel_4, "cell 4 6");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JSpinner spinnerPags = new JSpinner();
		spinnerPags.setModel(new SpinnerNumberModel(250, 1, 999, 1));
		panel.add(spinnerPags, "cell 5 6");
		
		JLabel lblNewLabel_5 = new JLabel("Precio:");
		panel.add(lblNewLabel_5, "cell 0 7,alignx trailing");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		txtPrecio = new JTextField();
		panel.add(txtPrecio, "cell 1 7 2 1,growx");
		txtPrecio.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Cantidad:");
		panel.add(lblNewLabel_6, "cell 4 7");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JSpinner spinnerCantidad = new JSpinner();
		spinnerCantidad.setModel(new SpinnerNumberModel(1, 1, 999, 1));
		panel.add(spinnerCantidad, "cell 5 7");
		
		JLabel lblNewLabel_7 = new JLabel("PrecioCD:");
		panel.add(lblNewLabel_7, "cell 0 8,alignx trailing");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		txtPrecioCD = new JTextField();
		panel.add(txtPrecioCD, "cell 1 8 2 1,growx");
		txtPrecioCD.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Autores Disponibles:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(lblNewLabel_8, "cell 0 1");
		
		JLabel lblNewLabel_9 = new JLabel("Autores seleccionados:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(lblNewLabel_9, "cell 2 1");
		
		JList listDisponibles = new JList();
		contentPane.add(listDisponibles, "cell 0 2,grow");
		
		JButton btnNewButton = new JButton(">");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(btnNewButton, "cell 1 2,alignx center,aligny center");
		
		JList listSeleccionados = new JList();
		contentPane.add(listSeleccionados, "cell 2 2,grow");
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, "cell 0 3 3 1,grow");
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton_1 = new JButton("Aceptar");
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Cancelar");
		panel_1.add(btnNewButton_2);
	}


	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
		
	}


	public void setEditoriales(ArrayList<Editorial> listaEditoriales) {
		this.listaEditoriales = listaEditoriales;
		for (Editorial editorial : listaEditoriales) {
			comboEditorial.addItem(editorial.getNombre());
		}
	}


	public void setListaAutores(ArrayList<Autor> listaAutores) {
		this.listaAutores=listaAutores;
		
		
	}

}
