package bo;
import java.util.List;

import dao.UsuarioDAO;
import entities.Usuario;
import exceptions.*;

public class UsuarioService {
	
	private UsuarioDAO usuarioDAO;
	
	public void setDAOImpl(UsuarioDAO UsuarioDAO) {
		this.usuarioDAO = UsuarioDAO;
	}
	
	public List<Usuario> getAllUsuarios() throws ServiceException {
		List<Usuario> respLista;
		try {
			 respLista = (List<Usuario>) usuarioDAO.getAllUsuarios();
		} catch (DAOException e) {
			throw new ServiceException("No se pudo buscar a los usuarios", e);
		}
		return respLista;
	}

	public Usuario getUsuarioByUsername(String username) throws ServiceException {
		Usuario respUsuario;
		try {
			respUsuario = usuarioDAO.getUsuarioByUsername(username);
		} catch (DAOException e) {
			throw new ServiceException("No se pudo buscar el usuario", e);
		}
		return respUsuario;
	}
	
	public void deleteUsuarioByUsername(String username) throws ServiceException {		
		try {
			usuarioDAO.deleteUsuarioByUsername(username);
		} catch (DAOException e) {
			throw new ServiceException("No se pudo borrar el usuario", e);
		}
	}

	public void insertarUsuario(Usuario u) throws ServiceException {
		Usuario respUsuario;
		try {
			respUsuario = usuarioDAO.getUsuarioByUsername(u.getUsername());			
			if(respUsuario == null){				
				try {
					usuarioDAO.insertarUsuario(u);
				} catch (DAOException e) {			
					throw new ServiceException("Ya existe el usuario", e);
				}
			}
		} catch (DAOException e) {			
			throw new ServiceException("Ya existe el usuario", e);
		}
	}
	public void updateUsuario(Usuario user) throws ServiceException {
		try {
			usuarioDAO.updateUsuario(user);
		} catch (DAOException e) {			
			throw new ServiceException("Ya existe el usuario", e);
		}
	}
	
	
	public Usuario checkPassword(String username, String pw) throws ServiceException{
		Usuario respUsuario;
		try {
			respUsuario = usuarioDAO.getUsuarioByUsername(username);
			if(respUsuario != null && respUsuario.getUsername().equals(username) && respUsuario.getPassword().equals(pw)){
				return respUsuario;
			}else{
				throw new ServiceException("Usuario/password no valido");
			}
		} catch (DAOException e) {
			throw new ServiceException("No se pudo buscar a los usuarios", e);
		}			
	}

	public Usuario busquedaUnUsuarioUsername(String username) throws ServiceException {
		Usuario respUsuario;
		try {
			 respUsuario = usuarioDAO.getUsuarioByUsername(username);
		} catch (DAOException e) {
			throw new ServiceException("No se pudo buscar el usuario", e);
		}
		return respUsuario;
	}
	
}
