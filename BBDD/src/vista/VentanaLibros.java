package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import controlador.Controlador;
import modelo.Editorial;
import modelo.Libro;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaLibros extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Controlador controlador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLibros frame = new VentanaLibros();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaLibros() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow]", "[][grow][]"));
		
		JLabel lblNewLabel = new JLabel("Lista de Libros:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblNewLabel, "cell 0 0");
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 0 1,grow");
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"isbn", "T\u00EDtulo", "C\u00F3digo Editorial", "A\u00F1o", "N\u00FAmero P\u00E1ginas", "Precio", "Cantidad", "Precio CD"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, Integer.class, Integer.class, Integer.class, Float.class, Integer.class, Float.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, true, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(2).setPreferredWidth(97);
		table.getColumnModel().getColumn(4).setPreferredWidth(94);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("Borrar Libro");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				llamarBorrarLibro();
			}
		});
		contentPane.add(btnNewButton_1, "flowx,cell 0 2,alignx right");
		
		JButton btnNewButton = new JButton("Cerrar");
		contentPane.add(btnNewButton, "cell 0 2,alignx right");
	}

	protected void llamarBorrarLibro() {
		int fila=table.getSelectedRow();
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		String isbn = (String) modelo.getValueAt(fila, 0);
		
		int res=controlador.borrarLibro(isbn);
		if (res!=0) {
			modelo.removeRow(fila);
		} else {
			JOptionPane.showMessageDialog(null, "Error al borrar el libro "+isbn);
		}
		
	}

	/**
	 * @param controlador el controlador a establecer
	 */
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}

	public void setListaLibros(ArrayList<Libro> lista) {
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setRowCount(0);
		for (Libro libro : lista) {
			Object [] fila = {
					libro.getIsbn(), libro.getTitulo(),libro.getCodEditorial(),
					libro.getAño(), libro.getNum_pags(), libro.getPrecio(),
					libro.getCantidad(), libro.getPrecioCD()
			};
			modelo.addRow(fila);
		}
		
	}

	
}
