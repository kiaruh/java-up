package bo;

import java.util.List;

import dao.AsignacionDAO;
import entities.Asignacion;
import exceptions.DAOException;
import exceptions.ServiceException;

public class AsignacionService {
	private AsignacionDAO asignacionDAO;
	
	public void setDAOImpl(AsignacionDAO asignacionDAO) {
		this.asignacionDAO = asignacionDAO;
	}
	
	public Asignacion getAsignacion(int legajo,int id_grupo) throws ServiceException {
		Asignacion respAsignacion;
		try {
			respAsignacion = asignacionDAO.getAsignacion(legajo,id_grupo);
			} catch (DAOException e) {
			throw new ServiceException("No se pudo buscar la asignacion", e);
		}
		return respAsignacion;
	}
	
	public List<Asignacion> getAsignacionByLegajo(Integer legajo) throws ServiceException {
		List<Asignacion> respAsignacion;
		try {
			respAsignacion = (List<Asignacion>) asignacionDAO.getAsignacionByLegajo(legajo);
			} catch (DAOException e) {
			throw new ServiceException("No se pudo buscar la asignacion", e);
		}
		return respAsignacion;
	}
	
	public List<Asignacion> getAsignacionByGrupo(Integer id) throws ServiceException {
		List<Asignacion> respAsignacion;
		try {
			respAsignacion = (List<Asignacion>) asignacionDAO.getAsignacionByGrupo(id);
			} catch (DAOException e) {
			throw new ServiceException("No se pudo buscar la asignacion", e);
		}
		return respAsignacion;
	}
	
	public void deleteAsignacion(Integer legajo,Integer id) throws ServiceException {	
		try {
			asignacionDAO.deleteAsignacion(legajo,id);
		} catch (DAOException e) {
			throw new ServiceException("No se pudo borrar la asignacion", e);
		}
	}

	public void insertarAsignacion(Asignacion u) throws ServiceException {
		Asignacion respAsignacion;
		try {
			respAsignacion = asignacionDAO.getAsignacion(u.getEmpleado(),u.getGrupo());
			if(respAsignacion.getEmpleado()==0 && respAsignacion.getGrupo()==0){
				try {
					 asignacionDAO.insertarAsignacion(u);
				} catch (DAOException e) {			
					throw new ServiceException("Ya existe la asignacion", e);
				}
			}
		} catch (DAOException e) {			
			throw new ServiceException("Ya existe la asignacion", e);
		}
	}
}
