package views;

import entities.Empleado;
import views.Handler;
import views.tables.HoraTableModel;

import java.util.List;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

@SuppressWarnings("serial")
public class HoraListPanel extends MyPanel {
	private JTable table;

	public HoraListPanel(Handler handler, List<Empleado> lista) {
		super(handler);
		//table
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		table.setModel(new HoraTableModel(lista));
	}
}