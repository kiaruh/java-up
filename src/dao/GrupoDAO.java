package dao;

import java.util.List;
import entities.Grupo;
import exceptions.DAOException;

public interface GrupoDAO {

	public void insertarGrupo(Grupo u) throws DAOException;
	public void deleteGrupoById(int id_grupo) throws DAOException;
	public Grupo getGrupoById(int id_grupo) throws DAOException;
	public List<Grupo> getAllGrupo() throws DAOException;
	
}
