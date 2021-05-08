package views.grupo;

import javax.swing.SwingConstants;
import javax.swing.JPanel;

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
public class NewGrupoPanel extends JPanel {
	private JTextField textFieldIdgrupo;
	
	public NewGrupoPanel(Handler handler) {
		setLayout(null);
		
		JLabel lblGrupo_ID = new JLabel("Grupo ID");
		lblGrupo_ID.setBounds(51, 91, 50, 14);
		add(lblGrupo_ID);
		
		textFieldIdgrupo = new JTextField();
		textFieldIdgrupo.setBounds(125, 89, 190, 20);
		add(textFieldIdgrupo);
		textFieldIdgrupo.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				handler.GrupoPanel();
			}
		});
		btnBack.setBounds(260, 232, 100, 23);
		add(btnBack);
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int id_grupo = Integer.parseInt(textFieldIdgrupo.getText());
					int response = JOptionPane.showConfirmDialog(null, "Esta seguro de que desea crear el nuevo grupo : "+id_grupo);
					if (response == JOptionPane.OK_OPTION) {
						handler.DarAltaGrupo(id_grupo);
					}
				} catch (NumberFormatException e) {
					handler.mostrarAlert("Por favor llene los campos con datos correctos");
				} catch (ServiceException e) {
					handler.mostrarAlert("No se pudo crear nuevo grupo");
				} finally {
					setVisible(false);
					handler.GrupoPanel();
				}
				
			}
		});
		
		JLabel lblHead = new JLabel("Nuevo Grupo");
		lblHead.setHorizontalAlignment(SwingConstants.CENTER);
		lblHead.setBounds(100, 3, 238, 31);
		lblHead.setFont(new Font("Tahoma", Font.PLAIN, 25));
		add(lblHead);
		
		btnSubmit.setBounds(80, 232, 100, 23);
		add(btnSubmit);
	}

}
