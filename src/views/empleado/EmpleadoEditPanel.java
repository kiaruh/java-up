package views.empleado;

import entities.Empleado;
import views.Handler;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class EmpleadoEditPanel extends EmpleadoEditorSuper {

	public EmpleadoEditPanel(Handler handler, Empleado emp) {
		super(handler);
		textFieldLegajo = new JTextField();
		textFieldLegajo.setEditable(false);
		textFieldLegajo.setBounds(125, 45, 190, 20);
		add(textFieldLegajo);
		textFieldLegajo.setColumns(10);
		
		int olddni = emp.getDni();
		int oldlegajo = emp.getLegajo();
		String oldnombre = emp.getNombre();
		String oldsexo = emp.getSexo();
		
		textFieldDni.setText(String.valueOf(olddni));
		textFieldLegajo.setText(String.valueOf(oldlegajo));
		textFieldNombre.setText(oldnombre);
		textFieldSexo.setText(oldsexo);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int dni = Integer.parseInt(textFieldDni.getText());
					int legajo = Integer.parseInt(textFieldLegajo.getText());
					String nombre = textFieldNombre.getText();
					String sexo = textFieldSexo.getText();
					Empleado u = new Empleado();
					u.setLegajo(legajo);
					u.setDni(dni);
					u.setNombre(nombre);
					u.setSexo(sexo);
					int response = JOptionPane.showConfirmDialog(null, "Esta seguro de que desea modificar el empleado \nLegajo: "+oldlegajo+" \nNombre: "+oldnombre+" "+" \nDNI: "+olddni+" "+" \nSexo: "+oldsexo+" \nCon estos datos abajo"+" \nNuevo Nombre: "+nombre+" \nNuevo DNI: "+dni+"\nNuevo Sexo: "+sexo);
					if (response == JOptionPane.OK_OPTION) {
						handler.ModiEmpleado(u);
					}
				} catch (Exception e1) {
					handler.mostrarAlert("Por favor llene los campos");
				} finally {
					setVisible(false);
					handler.EmpleadoPanel();
				}
			}
		});
		btnSubmit.setBounds(80, 233, 100, 23);
		add(btnSubmit);
		
		JLabel lblHead = new JLabel("Modificar Empleado");
		lblHead.setHorizontalAlignment(SwingConstants.CENTER);
		lblHead.setBounds(100, 3, 238, 31);
		lblHead.setFont(new Font("Tahoma", Font.PLAIN, 25));
		add(lblHead);
	}

}
