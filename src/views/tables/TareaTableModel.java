package views.tables;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import entities.Tarea;

@SuppressWarnings("serial")
public class TareaTableModel extends AbstractTableModel {
	
	private static final int COLUMNA_TAREA_ID = 0;
	private static final int COLUMNA_DESCRIPCION = 1;
	private static final int COLUMNA_GRUPO_ID = 2;
	private static final int COLUMNA_HORA = 3;
	
	private String[] ColumnasNames = {"Tarea ID", "Descripcion", "Grupo ID", "Hora"};
	@SuppressWarnings("rawtypes")
	private Class[] columnTypes = new Class[] {Integer.class, String.class, Integer.class, Integer.class};
	boolean[] columnEditables = new boolean[] {false, false, false, false};
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Class getColumnClass(int columnIndex) {
		return columnTypes[columnIndex];
	}

	public boolean isCellEditable(int row, int column) {
		return columnEditables[column];
	}
	
	private List<Tarea> list;
	
	public TareaTableModel() {
		list = new ArrayList<Tarea>();
	}
	
	public TareaTableModel(List<Tarea> Init) {
		list = Init;
	}
	@Override
	public int getColumnCount() {
		return ColumnasNames.length;
	}

	@Override
	public int getRowCount() {
		return list.size();
	}
	
	public Tarea getTarea(int rowIndex){		
		Tarea u = list.get(rowIndex);
		return u;
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Tarea u = list.get(rowIndex);
		Object result = null;
		switch(columnIndex) {
		case COLUMNA_TAREA_ID:
			result = u.getId();
			break;
		case COLUMNA_DESCRIPCION:
			result = u.getDesc();
			break;
		case COLUMNA_GRUPO_ID:
			result = u.getGrupo();
			break;
		case COLUMNA_HORA:
			result = u.getHora();
			break;
		default:
			result = new String("");
		}
	  	
		return result;
	}
	
	public String getColumnName(int col) {
        return ColumnasNames[col];
    }
    
    public List<Tarea> getList() {
    	return list;
    }    
    public void setList(List<Tarea> list) {
    	this.list = list;
    	this.fireTableDataChanged();
    }

}
