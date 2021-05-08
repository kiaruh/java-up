package dbImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import basics.DBManager;

import dao.TareaDAO;
import entities.Tarea;
import exceptions.DAOException;

public class TareaDAODBImpl implements TareaDAO{

	@Override
	public void deleteTareaById(int id_tarea) throws DAOException {
		String sql = "DELETE FROM tareas WHERE id_tarea = " + id_tarea;
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
	public List<Tarea> getAllTarea() throws DAOException {
		List<Tarea> retorna = new ArrayList<Tarea>();;
		String sql = "SELECT * FROM tareas";
		@SuppressWarnings("static-access")
		Connection c = DBManager.getInstance().connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				Tarea u = new Tarea();
				u.setId(rs.getInt("id_tarea"));
				u.setDesc(rs.getString("desc"));
				u.setGrupo(rs.getInt("id_grupo"));
				u.setHora(rs.getInt("hora"));
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
	public Tarea getTareaById(int id_tarea) throws DAOException {
		Tarea retorna = null;
		String sql = "SELECT * FROM tareas WHERE id_tarea = " + id_tarea;
		@SuppressWarnings("static-access")
		Connection c = DBManager.getInstance().connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			if(rs.next()) {
				int d = rs.getInt("id_tarea");
				String n = rs.getString("desc");
				int e = rs.getInt("id_grupo");
				int l = rs.getInt("hora");
				retorna = new Tarea();
				retorna.setId(d);
				retorna.setDesc(n);
				retorna.setGrupo(e);
				retorna.setHora(l);
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
	public void insertarTarea(Tarea u) throws DAOException {
		String sql = "INSERT INTO tareas (id_tarea, desc, id_grupo, hora) VALUES (" + u.getId() + ", '" + u.getDesc() + "', " + u.getGrupo() + ", " + u.getHora() + ")";
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

	@Override
	public void updateTarea(Tarea u) throws DAOException {
		String sql = "UPDATE tareas set id_grupo = " + u.getGrupo() + ", hora = " + u.getHora() + ", desc = '" + u.getDesc() + "' WHERE id_tarea = " + u.getId();
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

	
	
}
