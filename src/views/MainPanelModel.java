package views;

import exceptions.ServiceException;
import views.Handler;

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

@SuppressWarnings("serial")
public class MainPanelModel extends MyPanel {
	protected JTable table;
	protected String unaentidad;
	protected String laentidad;

	public MainPanelModel(Handler handler, @SuppressWarnings("rawtypes") List list,boolean flag) {
		super(handler);
		DefineEntity();
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);

		
		JMenuItem mntmNuevo = new JMenuItem("Nuevo");
		mntmNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				DefineNuevo(handler,e);
			}
		});
		mnEdit.add(mntmNuevo);
		
		JMenuItem mntmModificar = new JMenuItem("Modificar");
		mntmModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int id = (int) table.getValueAt(table.getSelectedRow(), 0);
					setVisible(false);
					DefineModificar(handler, e, id);
				} catch (ArrayIndexOutOfBoundsException e1) {
					handler.mostrarAlert("Elija a "+unaentidad);
				}
			}
		});
		
		ShowModificar(mnEdit, mntmModificar);
		
		JMenuItem mntmEliminar = new JMenuItem("Eliminar");
		mntmEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int id = (int) table.getValueAt(table.getSelectedRow(), 0);
					int response = JOptionPane.showConfirmDialog(null, "Esta seguro de que desea eliminar "+laentidad+" "+id+" ?");
					if (response == JOptionPane.OK_OPTION) {
						DefineBorrar(handler, id);
					}
				} catch (ServiceException e1) {
					handler.mostrarAlert("No pudo eliminar "+laentidad);
				} catch (ArrayIndexOutOfBoundsException e2) {
					handler.mostrarAlert("Elija a "+unaentidad);
				}
			}
		});
		mnEdit.add(mntmEliminar);
		
		JMenu mnTools = new JMenu("Tools");
		
		JMenuItem mntmAsignacion = new JMenuItem("Asignacion");
		mntmAsignacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int id = (int) table.getValueAt(table.getSelectedRow(), 0);
					setVisible(false);
					handler.AsignacionPanel(id, flag);
				} catch (ArrayIndexOutOfBoundsException e1) {
					handler.mostrarAlert("Elija a "+unaentidad);
				}
			}
		});
		
		DefineTools(menuBar,mnTools,mntmAsignacion);
		
		JMenu menu_1 = new JMenu("Function");
		menuBar.add(menu_1);
		
		JMenuItem menuItem_1 = new JMenuItem("Calculate Hours");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				handler.HoraPanel();
			}
		});
		menu_1.add(menuItem_1);
		
		JMenu menu = new JMenu("Settings");
		menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				handler.UsuarioPanel();
			}
		});
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("Users");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				handler.UsuarioPanel();
			}
		});
		menu.add(menuItem);
		//table
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		DefineTable(list);
		table.getColumnModel().getColumn(0).setResizable(false);
		scrollPane.setViewportView(table);
	}
	
	public void DefineEntity() {}
	
	public void DefineNuevo(Handler handler, ActionEvent e) {}
	
	public void DefineModificar(Handler handler, ActionEvent e, int id) {}
	
	public void ShowModificar(JMenu mnEdit,JMenuItem mntmModificar) {}
	
	public void DefineBorrar(Handler handler, int id) throws ServiceException {}

	public void DefineTools(JMenuBar menuBar,JMenu mnTools,JMenuItem mntmAsignacion) {}
	public void DefineTable(@SuppressWarnings("rawtypes") List list) {}
}