package dao;

import java.util.List;

import entities.Empleado;
import exceptions.DAOException;

public interface EmpleadoDAO {

	public void insertarEmpleado(Empleado u) throws DAOException;
	public void deleteEmpleadoByLegajo(int legajo) throws DAOException;
	public void updateEmpleado(Empleado u) throws DAOException;
	public Empleado getEmpleadoByLegajo(int legajo) throws DAOException;
	public List<Empleado> getAllEmpleado() throws DAOException;
	public int CalcularHoraByEmpleado(int legajo) throws DAOException;
	public List<Empleado> CalcularHora() throws DAOException;
	
}
