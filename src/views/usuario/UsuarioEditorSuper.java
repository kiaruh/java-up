package views.usuario;

import javax.swing.JPanel;
import views.Handler;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class UsuarioEditorSuper extends JPanel {
	protected JTextField textFieldUsername;
	protected JPasswordField passwordField;
	protected JPasswordField passwordField_1;
	
	public UsuarioEditorSuper(Handler handler) {
		setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(51, 47, 71, 14);
		add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(51, 91, 71, 14);
		add(lblPassword);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				handler.UsuarioPanel();
			}
		});
		
		passwordField = new JPasswordField();
		passwordField.setBounds(125, 89, 190, 20);
		add(passwordField);
		btnBack.setBounds(260, 232, 100, 23);
		add(btnBack);
		
		JLabel lblPasswordCom = new JLabel("Re-enter");
		lblPasswordCom.setBounds(51, 134, 71, 14);
		add(lblPasswordCom);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(125, 131, 190, 20);
		add(passwordField_1);

	}
}
