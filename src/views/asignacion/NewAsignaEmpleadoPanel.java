package views.asignacion;

import views.Handler;

@SuppressWarnings("serial")
public class NewAsignaEmpleadoPanel extends AsignaEditorSuper {
	
	public NewAsignaEmpleadoPanel(Handler handler, int legajo) {
		super(handler,legajo,true);
		textFieldLegajo.setEditable(false);
		textFieldLegajo.setText(String.valueOf(legajo));
	}
}
