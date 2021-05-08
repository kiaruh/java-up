package views.tarea;

import entities.Tarea;
import exceptions.ServiceException;
import views.Handler;
import views.MainPanelModel;
import views.tables.TareaTableModel;

import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

@SuppressWarnings("serial")
public class TareaMainPanel extends MainPanelModel {

	public TareaMainPanel(Handler handler, List<Tarea> lista) {
		super(handler,lista,true);
	}
	
	public void DefineEntity() {
		unaentidad="una tarea";
		laentidad="la tarea";
	}
	
	public void DefineNuevo(Handler handler, ActionEvent e) {
		handler.AltaTareaPanel();
	}
	
	public void DefineModificar(Handler handler, ActionEvent e, int id) {
		handler.ModiTareaPanel(id);
	}
	
	public void ShowModificar(JMenu mnEdit,JMenuItem mntmModificar) {
		mnEdit.add(mntmModificar);	
	}
	
	public void DefineBorrar(Handler handler, int id) throws ServiceException {
		handler.BorrarTarea(id);
	}

	@SuppressWarnings("unchecked")
	public void DefineTable(@SuppressWarnings("rawtypes") List list) {
		@SuppressWarnings("unused")
		List<Tarea> lista = list;
		table.setModel(new TareaTableModel(list));
	}
}