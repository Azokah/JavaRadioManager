package dbmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import exceptions.RadioException;

public class DBManager {
	
	private static final String DB_DRIVER = "org.hsqldb.jdbcDriver";
	private static final String DB_URL = "jdbc:hsqldb:file:sql/testdb;shutdown=true;hsqldb.default_table_type=cached";
	private static final String DB_USERNAME = "sa";
	private static final String DB_PASSWORD = "";
	
	private static DBManager instance;
	
	private DBManager(){}
	
	public static DBManager getInstance(){
		if(instance == null)
		{
			instance = new DBManager();
		}
		return instance;
	}
	
	public Connection connect() throws RadioException {
		Connection c = null;
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RadioException("Hubo un error en la conexion", e);
		}
		try {
			c = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
			c.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RadioException("Hubo un error en la conexion", e);
		}

		return c;
	}

	public void shutdown() throws Exception {
		Connection c = connect();
		Statement s = c.createStatement();
		s.execute("SHUTDOWN");
		c.close();
	}

}
