package views.tables;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import entities.Usuario;

@SuppressWarnings("serial")
public class UsuarioTableModel extends AbstractTableModel {
	
	private static final int COLUMNA_USERNAME = 0;
	private static final int COLUMNA_PASSWORD = 1;
	
	private String[] ColumnasNames = {"Username", "Password"};
	@SuppressWarnings("rawtypes")
	private Class[] columnTypes = new Class[] {String.class, String.class};
	boolean[] columnEditables = new boolean[] {false, false};
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Class getColumnClass(int columnIndex) {
		return columnTypes[columnIndex];
	}

	public boolean isCellEditable(int row, int column) {
		return columnEditables[column];
	}
	
	private List<Usuario> list;
	
	public UsuarioTableModel() {
		list = new ArrayList<Usuario>();
	}
	
	public UsuarioTableModel(List<Usuario> Init) {
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
	
	public Usuario getUsuario(int rowIndex){		
		Usuario u = list.get(rowIndex);
		return u;
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Usuario u = list.get(rowIndex);
		Object result = null;
		switch(columnIndex) {
		case COLUMNA_USERNAME:
			result = u.getUsername();
			break;
		case COLUMNA_PASSWORD:
			result = u.getPassword();
			break;
		default:
			result = new String("");
		}
	  	
		return result;
	}
	
	public String getColumnName(int col) {
        return ColumnasNames[col];
    }
    
    public List<Usuario> getList() {
    	return list;
    }    
    public void setList(List<Usuario> list) {
    	this.list = list;
    	this.fireTableDataChanged();
    }

}
