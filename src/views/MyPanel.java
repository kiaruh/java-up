package views;

import javax.swing.JPanel;

import views.Handler;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.BorderLayout;

@SuppressWarnings("serial")
public class MyPanel extends JPanel {
	protected String unaentidad;
	protected String laentidad;
	protected JMenuBar menuBar;

	public MyPanel(Handler handler) {
		setLayout(new BorderLayout(0, 0));
		
		menuBar = new JMenuBar();
		add(menuBar, BorderLayout.NORTH);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmBack = new JMenuItem("Menu");
		mntmBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				handler.MenuPanel();
			}
		});
		
		JMenuItem mntmEmpleado = new JMenuItem("Empleado");
		mntmEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				handler.EmpleadoPanel();
			}
		});
		mnFile.add(mntmEmpleado);
		
		JMenuItem mntmGrupos = new JMenuItem("Grupos");
		mntmGrupos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				handler.GrupoPanel();
			}
		});
		mnFile.add(mntmGrupos);
		
		JMenuItem mntmTareas = new JMenuItem("Tareas");
		mntmTareas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				handler.TareaPanel();
			}
		});
		mnFile.add(mntmTareas);
		mnFile.add(mntmBack);
		
		JMenuItem menuItem_2 = new JMenuItem("Logout");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				handler.logout();
			}
		});
		mnFile.add(menuItem_2);
	}
}