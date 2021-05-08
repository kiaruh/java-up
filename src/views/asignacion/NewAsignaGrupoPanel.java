package views.asignacion;

import views.Handler;

@SuppressWarnings("serial")
public class NewAsignaGrupoPanel extends AsignaEditorSuper {

	public NewAsignaGrupoPanel(Handler handler, int id_grupo) {
		super(handler,id_grupo,false);
		textFieldIdGrupo.setEditable(false);
		textFieldIdGrupo.setText(String.valueOf(id_grupo));
	}
}
