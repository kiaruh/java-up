package views.tarea;

import entities.Tarea;
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
public class TareaEditPanel extends TareaEditorSuper {

	public TareaEditPanel(Handler handler, Tarea tar) {
		super(handler);
		textFieldIdTarea = new JTextField();
		textFieldIdTarea.setEditable(false);
		textFieldIdTarea.setBounds(125, 45, 190, 20);
		add(textFieldIdTarea);
		textFieldIdTarea.setColumns(10);
		
		int oldid_grupo = tar.getGrupo();
		int oldid_tarea = tar.getId();
		String olddesc = tar.getDesc();
		int oldhora = tar.getHora();
		
		textFieldGrupo.setText(String.valueOf(oldid_grupo));
		textFieldIdTarea.setText(String.valueOf(oldid_tarea));
		textFieldDesc.setText(olddesc);
		textFieldHora.setText(String.valueOf(oldhora));

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int id_grupo = Integer.parseInt(textFieldGrupo.getText());
					int id_tarea = Integer.parseInt(textFieldIdTarea.getText());
					String desc = textFieldDesc.getText();
					int hora = Integer.parseInt(textFieldHora.getText());
					Tarea u = new Tarea();
					u.setId(id_tarea);
					u.setGrupo(id_grupo);
					u.setDesc(desc);
					u.setHora(hora);
					int response = JOptionPane.showConfirmDialog(null, "Esta seguro de que desea modificar la tarea \nLegajo: "+oldid_tarea+" \nNombre: "+olddesc+" "+" \nDNI: "+oldid_grupo+" "+" \nSexo: "+oldhora+" \nCon estos datos abajo"+" \nNuevo Nombre: "+desc+" \nNuevo DNI: "+id_grupo+"\nNuevo Sexo: "+hora);
					if (response == JOptionPane.OK_OPTION) {
						handler.ModiTarea(u);
					}
				} catch (Exception e1) {
					handler.mostrarAlert("Por favor llene los campos");
				} finally {
					setVisible(false);
					handler.TareaPanel();
				}
			}
		});
		btnSubmit.setBounds(80, 233, 100, 23);
		add(btnSubmit);
		
		JLabel lblHead = new JLabel("Modificar Tarea");
		lblHead.setHorizontalAlignment(SwingConstants.CENTER);
		lblHead.setBounds(100, 3, 238, 31);
		lblHead.setFont(new Font("Tahoma", Font.PLAIN, 25));
		add(lblHead);
	}

}
