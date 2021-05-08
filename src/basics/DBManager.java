package basics;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//import db.DBManager;


public class DBManager {

	private static final String DB_DRIVER = "org.hsqldb.jdbcDriver";
	private static final String DB_URL = "jdbc:hsqldb:file:sql/db;shutdown=true;hsqldb.default_table_type=cached";
	private static final String DB_USERNAME = "sa";
	private static final String DB_PASSWORD = "";
	private static DBManager dbManager;
	
	public static Connection connect() {
		Connection c = null;
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(0);
		}
		try {
			c =  DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
			c.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		
		return c;
	}
	
	public static void shutdown() throws Exception {
		Connection c = connect();
		Statement s = c.createStatement();
		s.execute("SHUTDOWN");
		c.close();
	}
	
	public static DBManager getInstance() {
		if(dbManager == null) {
			dbManager = new DBManager();
		}
		return dbManager;
	}
	
}
