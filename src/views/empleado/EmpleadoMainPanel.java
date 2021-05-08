package views.empleado;

import entities.Empleado;
import exceptions.ServiceException;
import views.Handler;
import views.MainPanelModel;
import views.tables.EmpleadoTableModel;

import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

@SuppressWarnings("serial")
public class EmpleadoMainPanel extends MainPanelModel {

	public EmpleadoMainPanel(Handler handler, List<Empleado> lista) {
		super(handler,lista,true);
	}
	
	public void DefineEntity() {
		unaentidad="un empleado";
		laentidad="el empleado";
	}
	
	public void DefineNuevo(Handler handler, ActionEvent e) {
		handler.AltaEmpleadoPanel();
	}
	
	public void DefineModificar(Handler handler, ActionEvent e, int id) {
		handler.ModiEmpleadoPanel(id);
	}
	
	public void ShowModificar(JMenu mnEdit,JMenuItem mntmModificar) {
		mnEdit.add(mntmModificar);	
	}
	
	public void DefineBorrar(Handler handler, int id) throws ServiceException {
		handler.BorrarEmpleado(id);
	}

	public void DefineTools(JMenuBar menuBar,JMenu mnTools,JMenuItem mntmAsignacion) {
		menuBar.add(mnTools);
		mnTools.add(mntmAsignacion);
	}
	@SuppressWarnings("unchecked")
	public void DefineTable(@SuppressWarnings("rawtypes") List list) {
		@SuppressWarnings("unused")
		List<Empleado> lista = list;
		table.setModel(new EmpleadoTableModel(list));
	}
}