package bo;

import java.util.List;

import dao.TareaDAO;
import entities.Tarea;
import exceptions.DAOException;
import exceptions.ServiceException;

public class TareaService {
	private TareaDAO tareaDAO;
	
	public void setDAOImpl(TareaDAO tareaDAO) {
		this.tareaDAO = tareaDAO;
	}
	
	public List<Tarea> getAllTarea() throws ServiceException {
		List<Tarea> respLista;
		try {
			 respLista = (List<Tarea>) tareaDAO.getAllTarea();
		} catch (DAOException e) {
			throw new ServiceException("No se pudo buscar a los tareas", e);
		}
		return respLista;
	}
	
	public Tarea getTareaById(Integer id) throws ServiceException {
		Tarea respTarea;
		try {
			respTarea = tareaDAO.getTareaById(id);
			} catch (DAOException e) {
			throw new ServiceException("No se pudo buscar el tarea", e);
		}
		return respTarea;
	}
	public void deleteTareaById(Integer id) throws ServiceException {	
		try {
			tareaDAO.deleteTareaById(id);
		} catch (DAOException e) {
			throw new ServiceException("No se pudo borrar el tarea", e);
		}
	}
	public void insertarTarea(Tarea u) throws ServiceException {
		Tarea respTarea;
		try {
			respTarea = tareaDAO.getTareaById(u.getId());		
			if(respTarea == null){
				try {
					 tareaDAO.insertarTarea(u);
				} catch (DAOException e) {			
					throw new ServiceException("Ya existe el tarea", e);
				}
			}
		} catch (DAOException e) {			
			throw new ServiceException("Ya existe el tarea", e);
		}
	}
	
	public void updateTarea(Tarea u) throws ServiceException {
		try {
			tareaDAO.updateTarea(u);
		} catch (DAOException e) {			
			throw new ServiceException("Ya existe el tarea", e);
		}
	}
	
}
