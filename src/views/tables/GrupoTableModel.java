package views.tables;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import entities.Grupo;

@SuppressWarnings("serial")
public class GrupoTableModel extends AbstractTableModel {
	
	private static final int COLUMNA_GRUPO_ID = 0;
	
	private String[] ColumnasNames = {"Grupo ID"};
	@SuppressWarnings("rawtypes")
	private Class[] columnTypes = new Class[] {Integer.class};
	boolean[] columnEditables = new boolean[] {false};
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Class getColumnClass(int columnIndex) {
		return columnTypes[columnIndex];
	}

	public boolean isCellEditable(int row, int column) {
		return columnEditables[column];
	}
	
	private List<Grupo> list;
	
	public GrupoTableModel() {
		list = new ArrayList<Grupo>();
	}
	
	public GrupoTableModel(List<Grupo> Init) {
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
	
	public Grupo getGrupo(int rowIndex){		
		Grupo u = list.get(rowIndex);
		return u;
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Grupo u = list.get(rowIndex);
		Object result = null;
		switch(columnIndex) {
		case COLUMNA_GRUPO_ID:
			result = u.getId();
			break;
		default:
			result = new String("");
		}
	  	
		return result;
	}
	
	public String getColumnName(int col) {
        return ColumnasNames[col];
    }
    
    public List<Grupo> getList() {
    	return list;
    }    
    public void setList(List<Grupo> list) {
    	this.list = list;
    	this.fireTableDataChanged();
    }

}
