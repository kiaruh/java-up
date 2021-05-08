package views.tables;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import entities.Asignacion;

@SuppressWarnings("serial")
public class AsignacionTableModel extends AbstractTableModel {
	
	private static final int COLUMNA_LEGAJO = 0;
	private static final int COLUMNA_GRUPO_ID = 1;
	
	private String[] ColumnasNames = {"Legajo", "Grupo ID"};
	@SuppressWarnings("rawtypes")
	private Class[] columnTypes = new Class[] {Integer.class, Integer.class};
	boolean[] columnEditables = new boolean[] {false, false};
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Class getColumnClass(int columnIndex) {
		return columnTypes[columnIndex];
	}

	public boolean isCellEditable(int row, int column) {
		return columnEditables[column];
	}
	
	private List<Asignacion> list;
	
	public AsignacionTableModel() {
		list = new ArrayList<Asignacion>();
	}
	
	public AsignacionTableModel(List<Asignacion> Init) {
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
	
	public Asignacion getAsignacion(int rowIndex){		
		Asignacion u = list.get(rowIndex);
		return u;
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Asignacion u = list.get(rowIndex);
		Object result = null;
		switch(columnIndex) {
		case COLUMNA_LEGAJO:
			result = u.getEmpleado();
			break;
		case COLUMNA_GRUPO_ID:
			result = u.getGrupo();
			break;
		default:
			result = new String("");
		}
	  	
		return result;
	}
	
	public String getColumnName(int col) {
        return ColumnasNames[col];
    }
    
    public List<Asignacion> getList() {
    	return list;
    }    
    public void setList(List<Asignacion> list) {
    	this.list = list;
    	this.fireTableDataChanged();
    }

}
