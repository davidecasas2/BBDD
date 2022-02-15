package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;
import modelo.Editorial;
import net.miginfocom.swing.MigLayout;

public class AñadirEditorial extends JFrame {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtAño;
	private Controlador controlador;
	private Editorial editorial;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AñadirEditorial frame = new AñadirEditorial();
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
	public AñadirEditorial() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[][grow]", "[][][][][]"));
		{
			JLabel lblNewLabel = new JLabel("Insercion de editoriales");
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
			JLabel lblNewLabel_2 = new JLabel("A\u00F1o:");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			contentPanel.add(lblNewLabel_2, "cell 0 4,alignx right");
		}
		{
			txtAño = new JTextField();
			contentPanel.add(txtAño, "cell 1 4,growx");
			txtAño.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						insertarEditorial();
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

	protected void insertarEditorial() {
		try {
			String nombre = txtNombre.getText();
			int año = Integer.parseInt(txtAño.getText());
			
			//Editorial ed = new Editorial(0,nombre,año);
			Editorial ed = new Editorial();
			
			ed.setNombre(nombre);
			ed.setAño(año);
			if (this.editorial == null)
				controlador.insertarEditorial(ed);
			else {
				ed.setCodEditorial(this.editorial.getCodEditorial());
				controlador.actualizarEditorial(ed);
				
			}
		} catch (NumberFormatException e ) {
			JOptionPane.showMessageDialog(null, "Introduzca un año correcto");
		}
		
		
	}

	/**
	 * @param controlador el controlador a establecer
	 */
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}

	public void setEditorial(Editorial e) {
		editorial = e;
		if (e!=null) {
			txtNombre.setText(editorial.getNombre());
			txtAño.setText(""+editorial.getAño());
		} else {
			txtNombre.setText("");
			txtAño.setText("");
		}
		
	}
	
	

}
