package busbookingjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnection {

	private static final String url="jdbc:mysql://localhost:3306/busresv";
	private static final String username="root";
	private static final String password="2003";
	
	  public static Connection getconnection() throws SQLException {
		 return  DriverManager.getConnection(url, username, password);
	  }
}
