package dbImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import basics.DBManager;

import dao.GrupoDAO;
import entities.Grupo;
import exceptions.DAOException;

public class GrupoDAODBImpl implements GrupoDAO{

	@Override
	public void deleteGrupoById(int id_grupo) throws DAOException {
		String sql = "DELETE FROM grupos WHERE id_grupo = " + id_grupo;
		@SuppressWarnings("static-access")
		Connection c = DBManager.getInstance().connect();
		try {
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			c.commit();
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				System.out.println(e.getMessage());
				throw new DAOException("No se pudo conectar con el servidor");
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				throw new DAOException("No se pudo desconectar con el servidor");
			}
		}
	}

	@Override
	public List<Grupo> getAllGrupo() throws DAOException {
		List<Grupo> retorna = new ArrayList<Grupo>();;
		String sql = "SELECT * FROM grupos";
		@SuppressWarnings("static-access")
		Connection c = DBManager.getInstance().connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				Grupo u = new Grupo();
				u.setId(rs.getInt("id_grupo"));
				retorna.add(u);
			}
			
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				System.out.println(e.getMessage());
				throw new DAOException("No se pudo conectar con el servidor");
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				throw new DAOException("No se pudo desconectar con el servidor");
			}
		}
		return retorna;
	}

	@Override
	public Grupo getGrupoById(int id_grupo) throws DAOException {
		Grupo retorna = null;
		String sql = "SELECT * FROM grupos WHERE id_grupo = " + id_grupo;
		@SuppressWarnings("static-access")
		Connection c = DBManager.getInstance().connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			if(rs.next()) {
				int d = rs.getInt("id_grupo");
				retorna = new Grupo();
				retorna.setId(d);
			}
			
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				System.out.println(e.getMessage());
				throw new DAOException("No se pudo conectar con el servidor");
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				throw new DAOException("No se pudo desconectar con el servidor");
			}
		}
		return retorna;
	}

	@Override
	public void insertarGrupo(Grupo u) throws DAOException {
		String sql = "INSERT INTO grupos (id_grupo) VALUES (" + u.getId() + ")";
		@SuppressWarnings("static-access")
		Connection c = DBManager.getInstance().connect();
		try {
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			c.commit();
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
				System.out.println(e.getMessage());
				throw new DAOException("No se pudo conectar con el servidor");
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new DAOException("No se pudo desconectar con el servidor");
			}
		}
		
	}
	
}
