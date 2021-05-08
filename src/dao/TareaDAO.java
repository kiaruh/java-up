package dao;

import java.util.List;
import entities.Tarea;
import exceptions.DAOException;

public interface TareaDAO {

	public void insertarTarea(Tarea u) throws DAOException;
	public void deleteTareaById(int id) throws DAOException;
	public void updateTarea(Tarea u) throws DAOException;
	public Tarea getTareaById(int id) throws DAOException;
	public List<Tarea> getAllTarea() throws DAOException;
	
}
