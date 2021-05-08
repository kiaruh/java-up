package basics;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TableManager {

	public void createUserTable() {

		Connection c = DBManager.connect();
		
		String sql = "CREATE TABLE usuarios (id INTEGER IDENTITY, user VARCHAR(256), pass VARCHAR(50))";
		
		try {
			Statement s = c.createStatement();
			s.execute(sql);
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}
	
	public void createEmpTable() {

		Connection c = DBManager.connect();
		
		String sql = "CREATE TABLE empleados (legajo INTEGER IDENTITY, nombre VARCHAR(256), dni INTEGER, sexo VARCHAR(50))";
		
		try {
			Statement s = c.createStatement();
			s.execute(sql);
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}
	
	public void createGrupoTable() {

		Connection c = DBManager.connect();
		
		String sql = "CREATE TABLE grupos (id_grupo INTEGER IDENTITY)";
		
		try {
			Statement s = c.createStatement();
			s.execute(sql);
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}

	public void createTareaTable() {

		Connection c = DBManager.connect();
		
		String sql = "CREATE TABLE tareas (id_tarea INTEGER IDENTITY, desc VARCHAR(256), id_grupo INTEGER, hora INTEGER, FOREIGN KEY (id_grupo) REFERENCES grupos(id_grupo))";
		
		try {
			Statement s = c.createStatement();
			s.execute(sql);
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}

	public void createAsigTable() {

		Connection c = DBManager.connect();
		
		String sql = "CREATE TABLE asignaciones (legajo INTEGER, id_grupo INTEGER, PRIMARY KEY(legajo, id_grupo))";
		
		try {
			Statement s = c.createStatement();
			s.execute(sql);
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}
	
	public void AltAsigTable() {

		Connection c = DBManager.connect();
		
		String sql = "ALTER TABLE asignaciones DROP PRIMARY KEY, ADD PRIMARY KEY(legajo, id_grupo)";
		
		try {
			Statement s = c.createStatement();
			s.execute(sql);
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}


	
	public void dropAsigTable() {

		Connection c = DBManager.connect();
		
		String sql = "DROP TABLE asignaciones";
		
		try {
			Statement s = c.createStatement();
			s.execute(sql);
			c.commit();
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		

	}

}
