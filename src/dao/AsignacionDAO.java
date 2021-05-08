package dao;

import java.util.List;

import entities.Asignacion;
import exceptions.DAOException;

public interface AsignacionDAO {

	public void insertarAsignacion(Asignacion u) throws DAOException;
	public void deleteAsignacion(int legajo, int id_grupo) throws DAOException;
	public void deleteAsignacionByEmpleado(int legajo) throws DAOException;
	public void deleteAsignacionByGrupo(int id_grupo) throws DAOException;
	public List<Asignacion> getAsignacionByLegajo(int legajo) throws DAOException;
	public List<Asignacion> getAsignacionByGrupo(int id_grupo) throws DAOException;
	public List<Asignacion> getAllAsignacion() throws DAOException;
	public Asignacion getAsignacion(int legajo, int id_grupo) throws DAOException;
	
}
