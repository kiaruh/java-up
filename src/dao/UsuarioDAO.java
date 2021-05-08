package dao;

import java.util.List;
import entities.Usuario;
import exceptions.DAOException;

public interface UsuarioDAO {

	public void insertarUsuario(Usuario u) throws DAOException;
	public void deleteUsuarioByUsername(String username) throws DAOException;
	public void updateUsuario(Usuario u) throws DAOException;
	public Usuario getUsuarioByUsername(String username) throws DAOException;
	public List<Usuario> getAllUsuarios() throws DAOException;
	
}
