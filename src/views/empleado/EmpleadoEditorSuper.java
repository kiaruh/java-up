package views.empleado;

import javax.swing.JPanel;
import views.Handler;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class EmpleadoEditorSuper extends JPanel {
	protected JTextField textFieldLegajo;
	protected JTextField textFieldNombre;
	protected JTextField textFieldDni;
	protected JTextField textFieldSexo;
	
	public EmpleadoEditorSuper(Handler handler) {
		setLayout(null);
		
		JLabel lblLegajo = new JLabel("Legajo");
		lblLegajo.setBounds(51, 47, 50, 14);
		add(lblLegajo);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(51, 91, 50, 14);
		add(lblNombre);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(51, 133, 50, 14);
		add(lblDni);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(51, 179, 50, 14);
		add(lblSexo);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(125, 89, 190, 20);
		add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldDni = new JTextField();
		textFieldDni.setBounds(125, 131, 190, 20);
		add(textFieldDni);
		textFieldDni.setColumns(10);
		
		textFieldSexo = new JTextField();
		textFieldSexo.setBounds(125, 176, 190, 20);
		add(textFieldSexo);
		textFieldSexo.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				handler.EmpleadoPanel();
			}
		});
		btnBack.setBounds(260, 232, 100, 23);
		add(btnBack);

	}

}
