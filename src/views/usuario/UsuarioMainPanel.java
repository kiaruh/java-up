package views.usuario;

import javax.swing.JPanel;

import entities.Usuario;
import exceptions.ServiceException;
import views.Handler;
import views.tables.UsuarioTableModel;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.ListSelectionModel;

import java.awt.BorderLayout;

@SuppressWarnings("serial")
public class UsuarioMainPanel extends JPanel {
	private JTable table;

	public UsuarioMainPanel(Handler handler, List<Usuario> lista) {
		setLayout(new BorderLayout(0, 0));
		
		JMenuBar menuBar = new JMenuBar();
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
		
		JMenuItem menuItem_1 = new JMenuItem("Empleado");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				handler.EmpleadoPanel();
			}
		});
		mnFile.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("Grupos");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				handler.GrupoPanel();
			}
		});
		mnFile.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("Tareas");
		mnFile.add(menuItem_3);
		mnFile.add(mntmBack);
		
		JMenuItem menuItem = new JMenuItem("Logout");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				handler.logout();
			}
		});
		mnFile.add(menuItem);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenuItem mntmNuevo = new JMenuItem("Nuevo");
		mntmNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				handler.AltaUsuarioPanel();
			}
		});
		mnEdit.add(mntmNuevo);
		
		JMenuItem mntmModificar = new JMenuItem("Cambiar Contrasena");
		mntmModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String username = (String) table.getValueAt(table.getSelectedRow(), 0);
					setVisible(false);
					handler.ModiUsuarioPanel(username);
				} catch (ArrayIndexOutOfBoundsException e1) {
					handler.mostrarAlert("Opcion no valido");
				}
			}
		});
		mnEdit.add(mntmModificar);
		
		JMenuItem mntmEliminar = new JMenuItem("Eliminar");
		mntmEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String username = (String) table.getValueAt(table.getSelectedRow(), 0);
					int response = JOptionPane.showConfirmDialog(null, "Esta seguro de que desea eliminar el usuario "+username+" ?");
					if (response == JOptionPane.OK_OPTION) {
						handler.BorrarUsuario(username);
					}
				} catch (ServiceException e1) {
					handler.mostrarAlert("No pudo eliminar el usuario");
				} catch (ArrayIndexOutOfBoundsException e2) {
					handler.mostrarAlert("Opcion no valido");
				}
			}
		});
		mnEdit.add(mntmEliminar);
		//table
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		table.setModel(new UsuarioTableModel(lista));
	}
}