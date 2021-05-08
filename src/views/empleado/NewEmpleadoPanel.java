package views.empleado;

import javax.swing.SwingConstants;

import views.Handler;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import exceptions.ServiceException;

@SuppressWarnings("serial")
public class NewEmpleadoPanel extends EmpleadoEditorSuper {
	
	public NewEmpleadoPanel(Handler handler) {
		super(handler);
		textFieldLegajo = new JTextField();
		textFieldLegajo.setBounds(125, 45, 190, 20);
		add(textFieldLegajo);
		textFieldLegajo.setColumns(10);
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int dni = Integer.parseInt(textFieldDni.getText());
					int legajo = Integer.parseInt(textFieldLegajo.getText());
					String nombre = textFieldNombre.getText();
					String sexo = textFieldSexo.getText();
					int response = JOptionPane.showConfirmDialog(null, "Esta seguro de que desea crear el empleado con estos datos abajo"+" \nLegajo: "+legajo+" \nNombre: "+nombre+" \nDNI: "+dni+"\nSexo: "+sexo);
					if (response == JOptionPane.OK_OPTION) {
						handler.DarAltaEmpleado(dni, legajo, nombre, sexo);
					}
				} catch (NumberFormatException e) {
					handler.mostrarAlert("Por favor llene los campos con datos correctos");
				} catch (ServiceException e) {
					handler.mostrarAlert("No se pudo crear nuevo empleado");
				} finally {
					setVisible(false);
					handler.EmpleadoPanel();
				}
				
			}
		});
		
		JLabel lblHead = new JLabel("Nuevo Empleado");
		lblHead.setHorizontalAlignment(SwingConstants.CENTER);
		lblHead.setBounds(100, 3, 238, 31);
		lblHead.setFont(new Font("Tahoma", Font.PLAIN, 25));
		add(lblHead);
		
		btnSubmit.setBounds(80, 232, 100, 23);
		add(btnSubmit);
	}

}
