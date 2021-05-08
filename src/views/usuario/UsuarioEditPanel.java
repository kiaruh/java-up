package views.usuario;

import entities.Usuario;
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
public class UsuarioEditPanel extends UsuarioEditorSuper {

	public UsuarioEditPanel(Handler handler, Usuario u) {
		super(handler);
		textFieldUsername = new JTextField();
		textFieldUsername.setEditable(false);
		textFieldUsername.setBounds(125, 45, 190, 20);
		add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		String oldusername = u.getUsername();
		String oldpassword = u.getPassword();
		
		textFieldUsername.setText(oldusername);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try {
					String username = textFieldUsername.getText();
					String password = passwordField.getText();
					String password_1 = passwordField_1.getText();
					if(password.equals(password_1)) {
						if(!password.equals(oldpassword)) {
							Usuario u = new Usuario();
							u.setUsername(username);
							u.setPassword(password);
							int response = JOptionPane.showConfirmDialog(null, "Esta seguro de que desea modificar la contrasena del usuario: "+username+"?");
							if (response == JOptionPane.OK_OPTION) {
								handler.ModiUsuario(u);
							}
						} else {
							handler.mostrarAlert("La contrasena ingresada es igual a la vieja");
						}
					} else 
						handler.mostrarAlert("Las dos contrasenas ingresadas son distintas");
				} catch (Exception e1) {
					handler.mostrarAlert("Por favor llene los campos");
				} finally {
					setVisible(false);
					handler.UsuarioPanel();
				}
			}
		});
		btnSubmit.setBounds(80, 233, 100, 23);
		add(btnSubmit);
		
		JLabel lblHead = new JLabel("Modificar Usuario");
		lblHead.setHorizontalAlignment(SwingConstants.CENTER);
		lblHead.setBounds(100, 3, 238, 31);
		lblHead.setFont(new Font("Tahoma", Font.PLAIN, 25));
		add(lblHead);
	}

}
