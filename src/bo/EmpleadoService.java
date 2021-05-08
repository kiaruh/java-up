package bo;

import java.util.List;

import dao.EmpleadoDAO;
import entities.Empleado;
import exceptions.DAOException;
import exceptions.ServiceException;

public class EmpleadoService {
	private EmpleadoDAO empleadoDAO;
	
	public void setDAOImpl(EmpleadoDAO empleadoDAO) {
		this.empleadoDAO = empleadoDAO;
	}
	
	public List<Empleado> getAllEmpleado() throws ServiceException {
		List<Empleado> respLista;
		try {
			 respLista = (List<Empleado>) empleadoDAO.getAllEmpleado();
		} catch (DAOException e) {
			throw new ServiceException("No se pudo buscar a los empleados", e);
		}
		return respLista;
	}
	
	public Empleado getEmpleadoByLegajo(Integer legajo) throws ServiceException {
		Empleado respEmpleado;
		try {
			respEmpleado = empleadoDAO.getEmpleadoByLegajo(legajo);
			} catch (DAOException e) {
			throw new ServiceException("No se pudo buscar el empleado", e);
		}
		return respEmpleado;
	}
	public void deleteEmpleadoByLegajo(Integer legajo) throws ServiceException {	
		try {
			empleadoDAO.deleteEmpleadoByLegajo(legajo);
		} catch (DAOException e) {
			throw new ServiceException("No se pudo borrar el empleado", e);
		}
	}
	public void insertarEmpleado(Empleado u) throws ServiceException {
		Empleado respEmpleado;
		try {
			respEmpleado = empleadoDAO.getEmpleadoByLegajo(u.getLegajo());		
			if(respEmpleado == null){
				try {
					 empleadoDAO.insertarEmpleado(u);
				} catch (DAOException e) {			
					throw new ServiceException("Ya existe el empleado", e);
				}
			}
		} catch (DAOException e) {			
			throw new ServiceException("Ya existe el empleado", e);
		}
	}
	
	public void updateEmpleado(Empleado emp) throws ServiceException {
		try {
			empleadoDAO.updateEmpleado(emp);
		} catch (DAOException e) {			
			throw new ServiceException("No se pudo modificar el empleado", e);
		}
	}
	
	public int getHoraByLegajo(Integer legajo) throws ServiceException {
		int respEmpleado;
		try {
			respEmpleado = empleadoDAO.CalcularHoraByEmpleado(legajo);
			} catch (DAOException e) {
			throw new ServiceException("No se pudo buscar el empleado", e);
		}
		return respEmpleado;
	}
	
	public List<Empleado> getAllHora() throws ServiceException {
		List<Empleado> respLista;
		try {
			 respLista = (List<Empleado>) empleadoDAO.CalcularHora();
		} catch (DAOException e) {
			throw new ServiceException("No se pudo buscar a los empleados", e);
		}
		return respLista;
	}
	
}
