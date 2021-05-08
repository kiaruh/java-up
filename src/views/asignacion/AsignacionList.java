package views.asignacion;

import javax.swing.JPanel;

import entities.Asignacion;
import exceptions.ServiceException;
import views.Handler;
import views.tables.AsignacionTableModel;

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
public class AsignacionList extends JPanel {
	private JTable table;

	public AsignacionList(Handler handler, List<Asignacion> lista, int id, boolean flag) {
		setLayout(new BorderLayout(0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		add(menuBar, BorderLayout.NORTH);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmBack = new JMenuItem("Back");
		mntmBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				if(flag) {
					handler.EmpleadoPanel();
				} else {
					handler.GrupoPanel();
				}
			}
		});
		mnFile.add(mntmBack);
		
		JMenuItem mntmMenu = new JMenuItem("Menu");
		mntmMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				handler.MenuPanel();
			}
		});
		mnFile.add(mntmMenu);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenuItem mntmNuevo = new JMenuItem("Nuevo");
		mntmNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				handler.AltaAsignacionPanel(id,flag);
			}
		});
		mnEdit.add(mntmNuevo);
		
		JMenuItem mntmEliminar = new JMenuItem("Eliminar");
		mntmEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int legajo = (int) table.getValueAt(table.getSelectedRow(), 0);
					int id_grupo = (int) table.getValueAt(table.getSelectedRow(), 1);
					int response = JOptionPane.showConfirmDialog(null, "Esta seguro de que desea eliminar la asignacion del empleado "+legajo+" al grupo "+id_grupo+" ?");
					if (response == JOptionPane.OK_OPTION) {
						handler.BorrarAsignacion(legajo,id_grupo,flag);
					}
				} catch (ServiceException e1) {
					handler.mostrarAlert("No pudo eliminar el empleado");
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
		table.setModel(new AsignacionTableModel(lista));
	}
}