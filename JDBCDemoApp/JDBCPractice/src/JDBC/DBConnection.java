package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	public Connection getDBConnection() throws Exception {
		
		// 1. loading the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		// 2.connection establishment
		String url = "jdbc:mysql://localhost:3306/jdbc";
		String user = "root";
		String pwd = "Welcome@123";
		
		Connection con = DriverManager.getConnection(url, user, pwd);
		
        return con;
	}
}
