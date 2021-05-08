package views.tarea;

import javax.swing.JPanel;
import views.Handler;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class TareaEditorSuper extends JPanel {
	protected JTextField textFieldIdTarea;
	protected JTextField textFieldDesc;
	protected JTextField textFieldGrupo;
	protected JTextField textFieldHora;
	
	public TareaEditorSuper(Handler handler) {
		setLayout(null);
		
		JLabel lblIdTarea = new JLabel("Tarea ID");
		lblIdTarea.setBounds(51, 47, 50, 14);
		add(lblIdTarea);
		
		JLabel lblDesc = new JLabel("Descripcion");
		lblDesc.setBounds(51, 91, 73, 14);
		add(lblDesc);
		
		JLabel lblGrupo = new JLabel("Grupo ID");
		lblGrupo.setBounds(51, 133, 50, 14);
		add(lblGrupo);
		
		JLabel lblHora = new JLabel("Hora");
		lblHora.setBounds(51, 179, 50, 14);
		add(lblHora);
		
		textFieldDesc = new JTextField();
		textFieldDesc.setBounds(125, 89, 190, 20);
		add(textFieldDesc);
		textFieldDesc.setColumns(10);
		
		textFieldGrupo = new JTextField();
		textFieldGrupo.setBounds(125, 131, 190, 20);
		add(textFieldGrupo);
		textFieldGrupo.setColumns(10);
		
		textFieldHora = new JTextField();
		textFieldHora.setBounds(125, 176, 190, 20);
		add(textFieldHora);
		textFieldHora.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				handler.TareaPanel();
			}
		});
		btnBack.setBounds(260, 232, 100, 23);
		add(btnBack);

	}

}
