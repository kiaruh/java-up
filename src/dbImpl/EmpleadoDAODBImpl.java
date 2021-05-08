package dbImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import basics.DBManager;

import dao.EmpleadoDAO;
import entities.Empleado;
import exceptions.DAOException;

public class EmpleadoDAODBImpl implements EmpleadoDAO{

	@Override
	public void deleteEmpleadoByLegajo(int legajo) throws DAOException {
		String sql = "DELETE FROM empleados WHERE legajo = " + legajo;
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
	public List<Empleado> getAllEmpleado() throws DAOException {
		List<Empleado> retorna = new ArrayList<Empleado>();
		String sql = "SELECT * FROM empleados";
		@SuppressWarnings("static-access")
		Connection c = DBManager.getInstance().connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				Empleado u = new Empleado();
				u.setDni(rs.getInt("dni"));
				u.setNombre(rs.getString("nombre"));
				u.setSexo(rs.getString("sexo"));
				u.setLegajo(rs.getInt("legajo"));
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
	public Empleado getEmpleadoByLegajo(int legajo) throws DAOException {
		Empleado retorna = null;
		String sql = "SELECT * FROM empleados WHERE legajo = " + legajo;
		@SuppressWarnings("static-access")
		Connection c = DBManager.getInstance().connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			if(rs.next()) {
				int d = rs.getInt("dni");
				String n = rs.getString("nombre");
				String se = rs.getString("sexo");
				int l = rs.getInt("legajo");
				retorna = new Empleado();
				retorna.setDni(d);
				retorna.setNombre(n);
				retorna.setSexo(se);
				retorna.setLegajo(l);
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
	public void insertarEmpleado(Empleado u) throws DAOException {
		String sql = "INSERT INTO empleados (legajo, nombre, dni, sexo) VALUES (" + u.getLegajo() + ", '" + u.getNombre() + "', " + u.getDni() + ", '" + u.getSexo() + "')";
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
	public void updateEmpleado(Empleado u) throws DAOException {
		String sql = "UPDATE empleados set dni = " + u.getDni() + ", nombre = '" + u.getNombre() + "', sexo = '" + u.getSexo() + "' WHERE legajo = " + u.getLegajo();
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
	public int CalcularHoraByEmpleado(int legajo) throws DAOException {
		int retorna = 0;
		String sql = "SELECT SUM(hora) as totalhora FROM asignaciones JOIN tareas ON asignaciones.id_grupo=tareas.id_grupo WHERE legajo = " + legajo;
		@SuppressWarnings("static-access")
		Connection c = DBManager.getInstance().connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			if(rs.next()) {
				retorna = rs.getInt("totalhora");
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
	public List<Empleado> CalcularHora() throws DAOException {
		List<Empleado> retorna = new ArrayList<Empleado>();
		String sql = "SELECT SUM(hora) as totalhora, empleados.* FROM asignaciones JOIN tareas ON asignaciones.id_grupo=tareas.id_grupo JOIN empleados ON asignaciones.legajo=empleados.legajo GROUP BY legajo, nombre, dni, sexo";
		@SuppressWarnings("static-access")
		Connection c = DBManager.getInstance().connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				Empleado u = new Empleado();
				u.setHora(rs.getInt("totalhora"));
				u.setLegajo(rs.getInt("legajo"));
				u.setDni(rs.getInt("dni"));
				u.setNombre(rs.getString("nombre"));
				u.setSexo(rs.getString("sexo"));
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
	
}
