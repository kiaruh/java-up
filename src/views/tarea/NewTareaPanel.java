package views.tarea;

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
public class NewTareaPanel extends TareaEditorSuper {
	
	public NewTareaPanel(Handler handler) {
		super(handler);
		textFieldIdTarea = new JTextField();
		textFieldIdTarea.setBounds(125, 45, 190, 20);
		add(textFieldIdTarea);
		textFieldIdTarea.setColumns(10);
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int id_grupo = Integer.parseInt(textFieldGrupo.getText());
					int id_tarea = Integer.parseInt(textFieldIdTarea.getText());
					String desc = textFieldDesc.getText();
					int hora = Integer.parseInt(textFieldHora.getText());
					int response = JOptionPane.showConfirmDialog(null, "Esta seguro de que desea crear la tarea con estos datos abajo"+" \nTarea ID: "+id_tarea+" \nDescripcion: "+desc+" \nGrupo ID: "+id_grupo+"\nHora: "+hora);
					if (response == JOptionPane.OK_OPTION) {
						handler.DarAltaTarea(id_tarea, id_grupo, desc, hora);
					}
				} catch (NumberFormatException e) {
					handler.mostrarAlert("Por favor llene los campos con datos correctos");
				} catch (ServiceException e) {
					handler.mostrarAlert("No se pudo crear nueva tarea");
				} finally {
					setVisible(false);
					handler.TareaPanel();
				}
				
			}
		});
		
		JLabel lblHead = new JLabel("Nuevo Tarea");
		lblHead.setHorizontalAlignment(SwingConstants.CENTER);
		lblHead.setBounds(100, 3, 238, 31);
		lblHead.setFont(new Font("Tahoma", Font.PLAIN, 25));
		add(lblHead);
		
		btnSubmit.setBounds(80, 232, 100, 23);
		add(btnSubmit);
	}

}
