package dbImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import basics.DBManager;

import dao.UsuarioDAO;
import entities.Usuario;
import exceptions.DAOException;

public class UsuarioDAODBImpl implements UsuarioDAO{

	@Override
	public void deleteUsuarioByUsername(String username) throws DAOException {
		String sql = "DELETE FROM usuarios WHERE user = '" + username + "'";
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
	public List<Usuario> getAllUsuarios() throws DAOException {
		List<Usuario> retorna = new ArrayList<Usuario>();;
		String sql = "SELECT * FROM usuarios";
		@SuppressWarnings("static-access")
		Connection c = DBManager.getInstance().connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				Usuario u = new Usuario();
				u.setPassword(rs.getString("pass"));
				u.setUsername(rs.getString("user"));
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
	public Usuario getUsuarioByUsername(String username) throws DAOException {
		Usuario retorna = null;
		String sql = "SELECT * FROM usuarios WHERE user = '" + username + "'";
		@SuppressWarnings("static-access")
		Connection c = DBManager.getInstance().connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			if(rs.next()) {
				String u = rs.getString("user");
				String p = rs.getString("pass");
				retorna = new Usuario();
				retorna.setPassword(p);
				retorna.setUsername(u);
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
	public void insertarUsuario(Usuario u) throws DAOException {
		String sql = "INSERT INTO usuarios (user, pass) VALUES ('" + u.getUsername() + "', '" + u.getPassword() + "')";
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
	public void updateUsuario(Usuario u) throws DAOException {
		String sql = "UPDATE usuarios set pass = '" + u.getPassword() + "' WHERE user = '" + u.getUsername() + "'";
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
