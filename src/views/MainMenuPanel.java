package views;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

@SuppressWarnings("serial")
public class MainMenuPanel extends MyPanel {

	public MainMenuPanel(Handler handler) {
		super(handler);
		
		JMenu mnFunction = new JMenu("Function");
		menuBar.add(mnFunction);
		
		JMenuItem mntmCalculateHours = new JMenuItem("Calculate Hours");
		mntmCalculateHours.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				handler.HoraPanel();
			}
		});
		mnFunction.add(mntmCalculateHours);
		
		JMenu mnSettings = new JMenu("Settings");
		menuBar.add(mnSettings);
		
		JMenuItem mntmUsers = new JMenuItem("Users");
		mntmUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				handler.UsuarioPanel();
			}
		});
		mnSettings.add(mntmUsers);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(0, 3, 0, 0));
		
		JButton btnEmpleados = new JButton("Empleados");
		panel.add(btnEmpleados);
		
		JButton btnGrupos = new JButton("Grupos");
		btnGrupos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				handler.GrupoPanel();
			}
		});
		panel.add(btnGrupos);
		
		JButton btnTareas = new JButton("Tareas");
		btnTareas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				handler.TareaPanel();
			}
		});
		panel.add(btnTareas);
		
		JLabel lblWelcome = new JLabel("Bienvenido!");
		add(lblWelcome, BorderLayout.CENTER);
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		btnEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				handler.EmpleadoPanel();
			}
		});
	}
}
