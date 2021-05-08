package basics;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DataManager {

	public void crearEmpDatos() {
		String sql = "INSERT INTO empleados (legajo, nombre, dni, sexo) VALUES (11111, 'Pepe Sapo', 33000000, 'Masculino');INSERT INTO empleados (legajo, nombre, dni, sexo) VALUES (11112, 'Juan Gonzalez', 28000234, 'Masculino');INSERT INTO empleados (legajo, nombre, dni, sexo) VALUES (11113, 'Ariel Del Mar', 25000333, 'Masculino');INSERT INTO empleados (legajo, nombre, dni, sexo) VALUES (11114, 'Santiago Ortega', 21000666, 'Masculino');INSERT INTO empleados (legajo, nombre, dni, sexo) VALUES (11115, 'Patricio Rey', 30222089, 'Masculino');INSERT INTO empleados (legajo, nombre, dni, sexo) VALUES (11116, 'Elena Bosque', 33000100, 'Femenino');INSERT INTO empleados (legajo, nombre, dni, sexo) VALUES (11117, 'Ana Gonzalez', 28000237, 'Femenino');INSERT INTO empleados (legajo, nombre, dni, sexo) VALUES (11118, 'Elsa Capunta', 25006333, 'Femenino');INSERT INTO empleados (legajo, nombre, dni, sexo) VALUES (11119, 'Dolores Fuertes', 21900666, 'Masculino');INSERT INTO empleados (legajo, nombre, dni, sexo) VALUES (11120, 'Francisco Doblado', 30522089, 'Masculino');INSERT INTO empleados (legajo, nombre, dni, sexo) VALUES (11121, 'Armando Bronca', 33000004, 'Masculino');INSERT INTO empleados (legajo, nombre, dni, sexo) VALUES (11122, 'Domingo Festivo', 28006234, 'Masculino');INSERT INTO empleados (legajo, nombre, dni, sexo) VALUES (11123, 'Armando Paredes', 25000322, 'Masculino');INSERT INTO empleados (legajo, nombre, dni, sexo) VALUES (11124, 'Beatriz Alegre', 21990666, 'Femenino');INSERT INTO empleados (legajo, nombre, dni, sexo) VALUES (11125, 'Margarita Campo', 30222789, 'Femenino');INSERT INTO empleados (legajo, nombre, dni, sexo) VALUES (11126, 'Miguel Guerra', 33000450, 'Masculino');INSERT INTO empleados (legajo, nombre, dni, sexo) VALUES (11127, 'Emiliano Del Pozo', 28000444, 'Masculino');INSERT INTO empleados (legajo, nombre, dni, sexo) VALUES (11128, 'Silvia Silva', 25111333, 'Femenino');INSERT INTO empleados (legajo, nombre, dni, sexo) VALUES (11129, 'Tomás Blanco', 21000789, 'Masculino');INSERT INTO empleados (legajo, nombre, dni, sexo) VALUES (11130, 'Cristian Castro', 30333089, 'Masculino');INSERT INTO empleados (legajo, nombre, dni, sexo) VALUES (11131, 'Fernando Cuadrado', 29333089, 'Masculino');";
		Connection c = DBManager.connect();
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
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public void crearTareaDatos() {
		String sql = "INSERT INTO tareas (desc, id_grupo, hora) VALUES ('Relevamiento', 90001, 50);INSERT INTO tareas (desc, id_grupo, hora) VALUES ('Analisis de Proceso', 90001, 50);INSERT INTO tareas (desc, id_grupo, hora) VALUES ('Analisis de Negocio', 90001, 50);INSERT INTO tareas (desc, id_grupo, hora) VALUES ('Diseno de Aplicacion', 90001, 100);INSERT INTO tareas (desc, id_grupo, hora) VALUES ('Diseno de Base de Datos', 90001, 100);INSERT INTO tareas (desc, id_grupo, hora) VALUES ('Codificacion - Etapa 1', 90002, 50);INSERT INTO tareas (desc, id_grupo, hora) VALUES ('Codificacion - Etapa 2', 90002, 50);INSERT INTO tareas (desc, id_grupo, hora) VALUES ('Codificacion - Etapa 3', 90002, 50);INSERT INTO tareas (desc, id_grupo, hora) VALUES ('Pruebas unitarias', 90002, 100);INSERT INTO tareas (desc, id_grupo, hora) VALUES ('Pruebas intergrales', 90002, 100);";
		Connection c = DBManager.connect();
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
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public void crearAsigDatos() {
		String sql = "INSERT INTO asignaciones (legajo, id_grupo) VALUES (11111, 90001);INSERT INTO asignaciones (legajo, id_grupo) VALUES (11112, 90001);INSERT INTO asignaciones (legajo, id_grupo) VALUES (11113, 90001);INSERT INTO asignaciones (legajo, id_grupo) VALUES (11114, 90001);INSERT INTO asignaciones (legajo, id_grupo) VALUES (11115, 90001);INSERT INTO asignaciones (legajo, id_grupo) VALUES (11116, 90001);INSERT INTO asignaciones (legajo, id_grupo) VALUES (11117, 90001);INSERT INTO asignaciones (legajo, id_grupo) VALUES (11118, 90001);INSERT INTO asignaciones (legajo, id_grupo) VALUES (11119, 90001);INSERT INTO asignaciones (legajo, id_grupo) VALUES (11121, 90002);INSERT INTO asignaciones (legajo, id_grupo) VALUES (11122, 90002);INSERT INTO asignaciones (legajo, id_grupo) VALUES (11123, 90002);INSERT INTO asignaciones (legajo, id_grupo) VALUES (11124, 90002);INSERT INTO asignaciones (legajo, id_grupo) VALUES (11125, 90002);INSERT INTO asignaciones (legajo, id_grupo) VALUES (11126, 90002);INSERT INTO asignaciones (legajo, id_grupo) VALUES (11127, 90002);INSERT INTO asignaciones (legajo, id_grupo) VALUES (11128, 90002);INSERT INTO asignaciones (legajo, id_grupo) VALUES (11129, 90002);";
		Connection c = DBManager.connect();
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
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public void crearUsuario(String user, String pass) {
		String sql = "INSERT INTO usuarios (user, pass) VALUES ('" + user + "', '" + pass + "')";
		Connection c = DBManager.connect();
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
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public void borraUsuario(String username) {
		String sql = "DELETE FROM usuarios WHERE user = '" + username + "'";
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			c.commit();
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				//no hago nada
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				//no hago nada
			}
		}
	}
	
	public void actualizaUsuario(String user, String pass) {
		String sql = "UPDATE usuarios set pass = '" + user + "' WHERE user = '" + user + "'";
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			s.executeUpdate(sql);
			c.commit();
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				//no hago nada
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				//no hago nada
			}
		}

	}
	
	public void muestraUsuario(String username) {
		String sql = "SELECT * FROM usuarios WHERE user = '" + username + "'";
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			if(rs.next()) {
				System.out.println("Usuario:");
				System.out.print("\t" + rs.getInt("id"));
				System.out.print("\t" + rs.getString("user"));
				System.out.print("\t" + rs.getString("pass"));
				System.out.println();
			}
			
		} catch (SQLException e) {
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1) {
				//no hago nada
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				//no hago nada
			}
		}
	}
	
	
	public void muestraTodosLosusuarios() {
		String sql = "SELECT * FROM usuarios";
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println("Usuario:");
				System.out.print("\t" + rs.getInt("id"));
				System.out.print("\t" + rs.getString("user"));
				System.out.print("\t" + rs.getString("pass"));
				System.out.println();
			}
			
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
				//no hago nada
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				//no hago nada
			}
		}
	}
	
	public void muestraTodosEmpleados() {
		String sql = "SELECT * FROM empleados";
		Connection c = DBManager.connect();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println("Empleado:");
				System.out.print("\t" + rs.getInt("legajo"));
				System.out.print("\t" + rs.getString("nombre"));
				System.out.print("\t" + rs.getString("dni"));
				System.out.println();
			}
			
		} catch (SQLException e) {
			try {
				c.rollback();
			} catch (SQLException e1) {
				//no hago nada
			}
		} finally {
			try {
				c.close();
			} catch (SQLException e1) {
				//no hago nada
			}
		}
	}
}
