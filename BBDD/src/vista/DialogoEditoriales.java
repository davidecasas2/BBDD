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
import javax.swing.SwingConstants;

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
			{
				JPanel panel = new JPanel();
				contentPanel.add(panel, "cell 0 2,grow");
				panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
				{
					JButton btnNewButton_1 = new JButton("Modificar");
					btnNewButton_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							llamarActualizar();
						}
					});
					panel.add(btnNewButton_1);
					btnNewButton_1.setHorizontalAlignment(SwingConstants.RIGHT);
				}
				JButton btnNewButton = new JButton("Cerrar");
				panel.add(btnNewButton);
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
			}
		}
	}
	
	protected void llamarActualizar() {
		int fila=table.getSelectedRow();
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		int codEditorial = (int) modelo.getValueAt(fila, 0);
		
		controlador.mostrarActualizar(codEditorial);
		
	}

	public void setListaEditoriales(ArrayList<Editorial> lista) {
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setRowCount(0);
		for (Editorial editorial : lista) {
			Object [] fila = {
					editorial.getCodEditorial(),editorial.getNombre(),editorial.getA�o()
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
