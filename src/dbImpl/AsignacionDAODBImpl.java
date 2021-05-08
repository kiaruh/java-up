package dbImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import basics.DBManager;
import dao.AsignacionDAO;
import entities.Asignacion;
import exceptions.DAOException;

public class AsignacionDAODBImpl implements AsignacionDAO{

	@Override
	public void deleteAsignacion(int legajo, int id_grupo) throws DAOException {
		String sql = "DELETE FROM asignaciones WHERE legajo = " + legajo + " AND id_grupo = " + id_grupo;
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
	public void deleteAsignacionByGrupo(int id_grupo) throws DAOException {
		String sql = "DELETE FROM asignaciones WHERE id_grupo = " + id_grupo;
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
	public void deleteAsignacionByEmpleado(int legajo) throws DAOException {
		String sql = "DELETE FROM asignaciones WHERE legajo = " + legajo;
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
	public List<Asignacion> getAllAsignacion() throws DAOException {
		List<Asignacion> retorna = new ArrayList<Asignacion>();
		String sql = "SELECT * FROM asignaciones";
		@SuppressWarnings("static-access")
		Connection c = DBManager.getInstance().connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				Asignacion u = new Asignacion();
				u.setGrupo(rs.getInt("id_grupo"));
				u.setEmpleado(rs.getInt("legajo"));
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
	public List<Asignacion> getAsignacionByGrupo(int grupo) throws DAOException {
		List<Asignacion> retorna = new ArrayList<Asignacion>();
		String sql = "SELECT * FROM asignaciones WHERE id_grupo = " + grupo;
		@SuppressWarnings("static-access")
		Connection c = DBManager.getInstance().connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				Asignacion u = new Asignacion();
				u.setGrupo(rs.getInt("id_grupo"));
				u.setEmpleado(rs.getInt("legajo"));
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
	public List<Asignacion> getAsignacionByLegajo(int legajo) throws DAOException {
		List<Asignacion> retorna = new ArrayList<Asignacion>();
		String sql = "SELECT * FROM asignaciones WHERE legajo = " + legajo;
		@SuppressWarnings("static-access")
		Connection c = DBManager.getInstance().connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				Asignacion u = new Asignacion();
				u.setGrupo(rs.getInt("id_grupo"));
				u.setEmpleado(rs.getInt("legajo"));
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
	public Asignacion getAsignacion(int legajo,int id_grupo) throws DAOException {
		Asignacion retorna = new Asignacion();
		String sql = "SELECT * FROM asignaciones WHERE legajo = " + legajo + " AND id_grupo = " + id_grupo;
		@SuppressWarnings("static-access")
		Connection c = DBManager.getInstance().connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);

			if(rs.next()) {
				int d = rs.getInt("legajo");
				int l = rs.getInt("id_grupo");
				retorna = new Asignacion();
				retorna.setEmpleado(d);
				retorna.setGrupo(l);
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
	public void insertarAsignacion(Asignacion u) throws DAOException {
		String sql = "INSERT INTO asignaciones (legajo, id_grupo) VALUES (" + u.getEmpleado() + ", " + u.getGrupo() + ")";
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
	
	public List<Asignacion> filtrarAsignacion(Asignacion filtro) throws DAOException{
		List<Asignacion> busquedaLista = new ArrayList<Asignacion>();
		@SuppressWarnings("static-access")
		Connection c = DBManager.getInstance().connect();
		String query;
		if(filtro.getGrupo() == 0 && filtro.getEmpleado() == 0){
			query = "SELECT * FROM asignaciones";
		}else{
			query = "SELECT * FROM asignaciones where";
		}		
		query += (filtro.getGrupo() != 0)? " grupo = " + filtro.getGrupo() + "'": ""; 
		query += (filtro.getEmpleado() != 0)? " empleado = " + filtro.getEmpleado() + "'": ""; 
				
		try {
			Statement stmt = c.createStatement();
			ResultSet rs;
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				
				Asignacion u = new Asignacion();
				u.setGrupo(rs.getInt("id_grupo"));
				u.setEmpleado(rs.getInt("legajo"));
				busquedaLista.add(u);
			}
				
		} catch (SQLException e) {
			throw new DAOException("No se pudo conectar con el servidor");
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				throw new DAOException("No se pudo desconectar con el servidor");
			}
		}
		return busquedaLista;
		
	}


}
