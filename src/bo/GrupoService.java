package bo;
import java.util.List;

import dao.GrupoDAO;
import entities.Grupo;
import exceptions.*;

public class GrupoService {
	
	private GrupoDAO grupoDAO;
	
	public void setDAOImpl(GrupoDAO grupoDAO) {
		this.grupoDAO = grupoDAO;
	}
	
	public List<Grupo> getAllGrupo() throws ServiceException {
		List<Grupo> respLista;
		try {
			 respLista = (List<Grupo>) grupoDAO.getAllGrupo();
		} catch (DAOException e) {
			throw new ServiceException("No se pudo buscar a los grupos", e);
		}
		return respLista;
	}

	public Grupo getGrupoById(int id) throws ServiceException {
		Grupo respGrupo;
		try {
			respGrupo = grupoDAO.getGrupoById(id);
		} catch (DAOException e) {
			throw new ServiceException("No se pudo buscar el grupo", e);
		}
		return respGrupo;
	}
	
	public void deleteGrupoById(int id) throws ServiceException {		
		try {
			grupoDAO.deleteGrupoById(id);
		} catch (DAOException e) {
			throw new ServiceException("No se pudo borrar el grupo", e);
		}
	}

	public void insertarGrupo(Grupo u) throws ServiceException {
		Grupo respGrupo;
		try {
			respGrupo = grupoDAO.getGrupoById(u.getId());			
			if(respGrupo == null){				
				try {
					grupoDAO.insertarGrupo(u);
				} catch (DAOException e) {			
					throw new ServiceException("Ya existe el grupo", e);
				}
			}
		} catch (DAOException e) {			
			throw new ServiceException("Ya existe el grupo", e);
		}
	}


}
