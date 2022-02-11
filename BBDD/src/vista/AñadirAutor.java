package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;
import modelo.Autor;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AñadirAutor extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private Controlador controlador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AñadirAutor dialog = new AñadirAutor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AñadirAutor() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[][grow]", "[][][][][]"));
		{
			JLabel lblNewLabel = new JLabel("Insercion de autores");
			lblNewLabel.setOpaque(true);
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setBackground(Color.BLACK);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
			contentPanel.add(lblNewLabel, "cell 0 0 2 1,growx");
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Nombre:");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			contentPanel.add(lblNewLabel_1, "cell 0 2,alignx trailing");
		}
		{
			txtNombre = new JTextField();
			contentPanel.add(txtNombre, "cell 1 2,growx");
			txtNombre.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Apellidos:");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			contentPanel.add(lblNewLabel_2, "cell 0 4,alignx right");
		}
		{
			txtApellidos = new JTextField();
			contentPanel.add(txtApellidos, "cell 1 4,growx");
			txtApellidos.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						llamarInsertar();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	protected void llamarInsertar() {
		String nombre = txtNombre.getText();
		String apellidos = txtApellidos.getText();
		
		Autor a = new Autor(0,nombre,apellidos);
		controlador.insertarAutor(a);
	}

	public void setControlador(Controlador controlador) {
		this.controlador=controlador;
		
	}

}
