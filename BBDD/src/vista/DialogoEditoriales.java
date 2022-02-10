package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import controlador.Controlador;
import modelo.Editorial;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogoEditoriales extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private Controlador controlador;


	/**
	 * Create the dialog.
	 */
	public DialogoEditoriales() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[grow]", "[][grow][]"));
		{
			JLabel lblNewLabel = new JLabel("Listado de editoriales:");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
			contentPanel.add(lblNewLabel, "cell 0 0");
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane, "cell 0 1,grow");
			{
				table = new JTable();
				table.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"C\u00F3digo Editorial", "Nombre", "A\u00F1o"
					}
				) {
					Class[] columnTypes = new Class[] {
						Integer.class, String.class, Integer.class
					};
					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				});
				table.getColumnModel().getColumn(0).setPreferredWidth(99);
				scrollPane.setViewportView(table);
			}
		}
		{
			JButton btnNewButton = new JButton("Cerrar");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}
			});
			contentPanel.add(btnNewButton, "cell 0 2,alignx right");
		}
	}
	
	public void setListaEditoriales(ArrayList<Editorial> lista) {
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setRowCount(0);
		for (Editorial editorial : lista) {
			Object [] fila = {
					editorial.getCodEditorial(),editorial.getNombre(),editorial.getAño()
			};
			modelo.addRow(fila);
		}
	}

	/**
	 * @param controlador el controlador a establecer
	 */
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}
	
	

}
