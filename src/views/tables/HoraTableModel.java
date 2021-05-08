package views.tables;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import entities.Empleado;

@SuppressWarnings("serial")
public class HoraTableModel extends AbstractTableModel {
	
	private static final int COLUMNA_LEGAJO = 0;
	private static final int COLUMNA_NOMBRE = 1;
	private static final int COLUMNA_HORAS = 2;
	private static final int COLUMNA_SUELDO = 3;
	
	private String[] ColumnasNames = {"Legajo", "Nombre", "Horas", "Honorarios"};
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
	
	private List<Empleado> list;
	
	public HoraTableModel() {
		list = new ArrayList<Empleado>();
	}
	
	public HoraTableModel(List<Empleado> Init) {
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
	
	public Empleado getEmpleado(int rowIndex){		
		Empleado u = list.get(rowIndex);
		return u;
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Empleado u = list.get(rowIndex);
		Object result = null;
		switch(columnIndex) {
		case COLUMNA_LEGAJO:
			result = u.getLegajo();
			break;
		case COLUMNA_NOMBRE:
			result = u.getNombre();
			break;
		case COLUMNA_HORAS:
			result = u.getHora();
			break;
		case COLUMNA_SUELDO:
			result = u.getHora()*100;
			break;
		default:
			result = new String("");
		}
	  	
		return result;
	}
	
	public String getColumnName(int col) {
        return ColumnasNames[col];
    }
    
    public List<Empleado> getList() {
    	return list;
    }    
    public void setList(List<Empleado> list) {
    	this.list = list;
    	this.fireTableDataChanged();
    }

}
