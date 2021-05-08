package views.asignacion;

import javax.swing.JPanel;
import views.Handler;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import exceptions.ServiceException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class AsignaEditorSuper extends JPanel {
	protected JTextField textFieldLegajo;
	protected JTextField textFieldIdGrupo;
	public AsignaEditorSuper(Handler handler, int id, boolean flag) {
		setLayout(null);
		
		JLabel lblLegajo = new JLabel("Legajo");
		lblLegajo.setBounds(51, 47, 50, 14);
		add(lblLegajo);
		
		JLabel lblGrupo = new JLabel("Grupo ID");
		lblGrupo.setBounds(51, 133, 50, 14);
		add(lblGrupo);
		
		JButton btnSubmit = new JButton("Submit");
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int id_grupo = Integer.parseInt(textFieldIdGrupo.getText());
					int legajo = Integer.parseInt(textFieldLegajo.getText());
					int response = JOptionPane.showConfirmDialog(null, "Esta seguro de que desea asignar al empleado: "+legajo+" al grupo "+id_grupo+"?");
					if (response == JOptionPane.OK_OPTION) {
						handler.DarAltaAsignacion(legajo, id_grupo);
					}
				} catch (NumberFormatException e) {
					handler.mostrarAlert("Por favor llene los campos con datos correctos");
				} catch (ServiceException e) {
					handler.mostrarAlert("No se pudo crear nueva asignacion");
				} finally {
					setVisible(false);
					handler.AsignacionPanel(id, flag);
				}
				
			}
		});
		btnSubmit.setBounds(80, 232, 100, 23);
		add(btnSubmit);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				handler.AsignacionPanel(id, flag);
			}
		});
		btnBack.setBounds(260, 232, 100, 23);
		add(btnBack);
		
		JLabel lblHead = new JLabel("Nuevo Asignacion");
		lblHead.setHorizontalAlignment(SwingConstants.CENTER);
		lblHead.setBounds(100, 3, 238, 31);
		lblHead.setFont(new Font("Tahoma", Font.PLAIN, 25));
		add(lblHead);
		
		textFieldLegajo = new JTextField();
		textFieldLegajo.setBounds(125, 45, 190, 20);
		add(textFieldLegajo);
		textFieldLegajo.setColumns(10);
		
		textFieldIdGrupo = new JTextField();
		textFieldIdGrupo.setBounds(125, 131, 190, 20);
		add(textFieldIdGrupo);
		textFieldIdGrupo.setColumns(10);

	}
}
