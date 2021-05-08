package views.usuario;

import javax.swing.SwingConstants;

import entities.Usuario;
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
public class NewUsuarioPanel extends UsuarioEditorSuper {
	
	public NewUsuarioPanel(Handler handler) {
		super(handler);
		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(125, 45, 190, 20);
		add(textFieldUsername);
		textFieldUsername.setColumns(10);
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				try {
					String username = textFieldUsername.getText();
					String password = passwordField.getText();
					String password_1 = passwordField_1.getText();
					if(password.equals(password_1)) {
						Usuario u = new Usuario();
						u.setUsername(username);
						u.setPassword(password);
						int response = JOptionPane.showConfirmDialog(null, "Esta seguro de que desea crear el usuario: "+username+"?");
						if (response == JOptionPane.OK_OPTION) {
							handler.DarAltaUsuario(username, password);
						}
					} else {
						handler.mostrarAlert("Las dos contrasenas ingresadas son distintas");
					}
				} catch (NumberFormatException e) {
					handler.mostrarAlert("Por favor llene los campos con datos correctos");
				} catch (ServiceException e) {
					handler.mostrarAlert("No se pudo crear nuevo usuario");
				} finally {
					setVisible(false);
					handler.UsuarioPanel();
				}
				
			}
		});
		
		JLabel lblHead = new JLabel("Nuevo Usuario");
		lblHead.setHorizontalAlignment(SwingConstants.CENTER);
		lblHead.setBounds(100, 3, 238, 31);
		lblHead.setFont(new Font("Tahoma", Font.PLAIN, 25));
		add(lblHead);
		
		btnSubmit.setBounds(80, 232, 100, 23);
		add(btnSubmit);
	}
}
