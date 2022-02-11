package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import controlador.Controlador;
import modelo.Autor;
import modelo.Editorial;

public class VentanaAutores extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Controlador controlador;



	/**
	 * Create the frame.
	 */
	public VentanaAutores() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow]", "[][grow][]"));
		
		JLabel lblNewLabel = new JLabel("Lista de Autores:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblNewLabel, "cell 0 0");
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 0 1,grow");
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo Autor", "Nombre", "Apellidos"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Salir");
		contentPane.add(btnNewButton, "cell 0 2,alignx right");
	}

	public void setControlador(Controlador controlador) {
		this.controlador=controlador;
		
	}

	public void setListaAutores(ArrayList<Autor> lista) {
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setRowCount(0);
		for (Autor autor : lista) {
			Object [] fila = {
					autor.getIdAutores(), autor.getNombre(), autor.getApellidos()
			};
			modelo.addRow(fila);
		}
		
	}

}
