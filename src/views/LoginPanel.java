package views;

import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import exceptions.ServiceException;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

@SuppressWarnings("serial")
public class LoginPanel extends JPanel {
	private JTextField usernameField;
	private JPasswordField passwordField;
	Handler handler;

	public LoginPanel(Handler handler) {
		super();
		this.handler = handler;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{88, 85, 160, 0};
		gridBagLayout.rowHeights = new int[]{80, 30, 47, 30, 42, 23, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblUsername = new JLabel("Username");
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.fill = GridBagConstraints.BOTH;
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.gridx = 1;
		gbc_lblUsername.gridy = 1;
		add(lblUsername, gbc_lblUsername);
		
		usernameField = new JTextField();
		GridBagConstraints gbc_usernameField = new GridBagConstraints();
		gbc_usernameField.fill = GridBagConstraints.BOTH;
		gbc_usernameField.insets = new Insets(0, 0, 5, 0);
		gbc_usernameField.gridx = 2;
		gbc_usernameField.gridy = 1;
		add(usernameField, gbc_usernameField);
		usernameField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.fill = GridBagConstraints.BOTH;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 1;
		gbc_lblPassword.gridy = 3;
		add(lblPassword, gbc_lblPassword);
		
		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.fill = GridBagConstraints.BOTH;
		gbc_passwordField.insets = new Insets(0, 0, 5, 0);
		gbc_passwordField.gridx = 2;
		gbc_passwordField.gridy = 3;
		add(passwordField, gbc_passwordField);
		
		JButton btnSubmit = new JButton("Submit");
		GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
		gbc_btnSubmit.anchor = GridBagConstraints.NORTH;
		gbc_btnSubmit.gridwidth = 2;
		gbc_btnSubmit.gridx = 1;
		gbc_btnSubmit.gridy = 5;
		add(btnSubmit, gbc_btnSubmit);
		
		btnSubmit.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				String usuario = usernameField.getText();
				@SuppressWarnings("deprecation")
				String pass = passwordField.getText();
				try {
					handler.enviarSubmit(usuario,pass);
					usernameField.setText("");
					passwordField.setText("");
				} 
				catch (ServiceException e1) {
					handler.mostrarAlert("No se pudo enviar los datos del logueo");
				}				
			}
		});

	}
}
