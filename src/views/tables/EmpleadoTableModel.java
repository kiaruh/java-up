package views.tables;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import entities.Empleado;

@SuppressWarnings("serial")
public class EmpleadoTableModel extends AbstractTableModel {
	
	private static final int COLUMNA_LEGAJO = 0;
	private static final int COLUMNA_NOMBRE = 1;
	private static final int COLUMNA_DNI = 2;
	private static final int COLUMNA_SEXO = 3;
	
	private String[] ColumnasNames = {"Legajo", "Nombre", "DNI", "Sexo"};
	@SuppressWarnings("rawtypes")
	private Class[] columnTypes = new Class[] {Integer.class, String.class, Integer.class, String.class};
	boolean[] columnEditables = new boolean[] {false, false, false, false};
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Class getColumnClass(int columnIndex) {
		return columnTypes[columnIndex];
	}

	public boolean isCellEditable(int row, int column) {
		return columnEditables[column];
	}
	
	private List<Empleado> list;
	
	public EmpleadoTableModel() {
		list = new ArrayList<Empleado>();
	}
	
	public EmpleadoTableModel(List<Empleado> Init) {
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
		case COLUMNA_DNI:
			result = u.getDni();
			break;
		case COLUMNA_SEXO:
			result = u.getSexo();
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
