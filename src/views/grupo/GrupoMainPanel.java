package views.grupo;

import entities.Grupo;
import exceptions.ServiceException;
import views.Handler;
import views.MainPanelModel;
import views.tables.*;

import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

@SuppressWarnings("serial")
public class GrupoMainPanel extends MainPanelModel {

	public GrupoMainPanel(Handler handler, List<Grupo> lista) {
		super(handler,lista,false);
	}
	
	public void DefineEntity() {
		unaentidad="un grupo";
		laentidad="el grupo";
	}
	
	public void DefineNuevo(Handler handler, ActionEvent e) {
		handler.AltaGrupoPanel();
	}
	
	public void DefineBorrar(Handler handler, int id) throws ServiceException {
		handler.BorrarGrupo(id);
	}

	public void DefineTools(JMenuBar menuBar,JMenu mnTools,JMenuItem mntmAsignacion) {
		menuBar.add(mnTools);
		mnTools.add(mntmAsignacion);
	}
	@SuppressWarnings("unchecked")
	public void DefineTable(@SuppressWarnings("rawtypes") List list) {
		@SuppressWarnings("unused")
		List<Grupo> lista = list;
		table.setModel(new GrupoTableModel(list));
	}
}