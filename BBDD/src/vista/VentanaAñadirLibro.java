package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;
import modelo.Autor;
import modelo.Editorial;
import modelo.Libro;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.SpinnerNumberModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	private JList listDisponibles;
	private JList listSeleccionados;
	private DefaultListModel modeloDisponibles;
	private DefaultListModel modeloSeleccionados;
	private JSpinner spinnerCantidad;
	private JSpinner spinnerPags;
	private JSpinner spinnerAño;


	/**
	 * Create the frame.
	 */
	public VentanaAñadirLibro() {
		setTitle("Insertar Libro Nuevo");
		setBounds(100, 100, 598, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][][grow]", "[][][72.00,grow][][]"));
		
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
		
		JLabel lblNewLabel_2 = new JLabel("Editorial: ");
		panel.add(lblNewLabel_2, "cell 0 4,alignx trailing");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		comboEditorial = new JComboBox();
		panel.add(comboEditorial, "cell 1 4 6 1,growx");
		
		JLabel lblNewLabel_3 = new JLabel("A\u00F1o:");
		panel.add(lblNewLabel_3, "cell 0 6,alignx right");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		spinnerAño = new JSpinner();
		spinnerAño.setModel(new SpinnerNumberModel(2022, 1800, 2500, 1));
		panel.add(spinnerAño, "cell 1 6");
		
		JLabel lblNewLabel_4 = new JLabel("Num. P\u00E1ginas:");
		panel.add(lblNewLabel_4, "cell 4 6");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		spinnerPags = new JSpinner();
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
		
		spinnerCantidad = new JSpinner();
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
		contentPane.add(lblNewLabel_8, "cell 0 1,growx");
		
		JLabel lblNewLabel_9 = new JLabel("Autores seleccionados:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(lblNewLabel_9, "cell 2 1,growx");
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 0 2 1 2,grow");
		
		listDisponibles = new JList();
		scrollPane.setViewportView(listDisponibles);
		
		JButton btnNewButton = new JButton(">");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				añadirSeleccionados();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(btnNewButton, "cell 1 2,alignx center,aligny center");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		contentPane.add(scrollPane_1, "cell 2 2 1 2,grow");
		
		listSeleccionados = new JList();
		scrollPane_1.setViewportView(listSeleccionados);
		
		JButton btnNewButton_3 = new JButton("<");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quitarSeleccionado();
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(btnNewButton_3, "cell 1 3");
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, "cell 0 4 3 1,grow");
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton_1 = new JButton("Aceptar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				recogerDatos();
			}
		});
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Cancelar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		panel_1.add(btnNewButton_2);
	}


	protected void recogerDatos() {
		String isbn = txtIsbn.getText();
		String titulo = txtTitulo.getText();
		Editorial e = (Editorial) comboEditorial.getSelectedItem();
		int año = (Integer) spinnerAño.getValue();
		int num_pags = (Integer) spinnerPags.getValue();
		float precio = Float.parseFloat(txtPrecio.getText());
		int cantidad = (Integer) spinnerCantidad.getValue();
		float precioCD = Float.parseFloat(txtPrecioCD.getText());
		
		Libro l = new Libro(isbn, titulo, e.getCodEditorial(), año,
				num_pags,precio, cantidad, precioCD);
		
		ArrayList<Autor> listaAutoresSeleccionados = new ArrayList<Autor>();
		for (int i = 0; i <modeloSeleccionados.size(); i++) {
			listaAutoresSeleccionados.add((Autor) modeloSeleccionados.get(i));
		}
		controlador.insertarLibro(l,listaAutoresSeleccionados);
	}


	protected void quitarSeleccionado() {
		Autor autor = (Autor) listSeleccionados.getSelectedValue();
		modeloSeleccionados.removeElement(autor);
		modeloDisponibles.addElement(autor);
		
	}


	protected void añadirSeleccionados() {
		Autor autor = (Autor) listDisponibles.getSelectedValue();
		modeloDisponibles.removeElement(autor);
		modeloSeleccionados.addElement(autor);
	}


	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
		
	}


	public void setEditoriales(ArrayList<Editorial> listaEditoriales) {
		this.listaEditoriales = listaEditoriales;
		for (Editorial editorial : listaEditoriales) {
			comboEditorial.addItem(editorial);
		}
	}


	public void setListaAutores(ArrayList<Autor> listaAutores) {
		this.listaAutores=listaAutores;
		modeloDisponibles = new DefaultListModel();
		modeloDisponibles.addAll(listaAutores);
		listDisponibles.setModel(modeloDisponibles);
		
		modeloSeleccionados = new DefaultListModel();
		listSeleccionados.setModel(modeloSeleccionados);
	}

}
