package JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class JoinExample {

	public static void main(String[] args) throws Exception {
		DBConnection dbcon = new DBConnection();
		
		Connection con = dbcon.getDBConnection();
		
		String query = "select c.cname, c.city, s.sname, s.city FROM customers c, student s WHERE c.city = s.city";
		
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery(query);
		
		while(rs.next()) {
			System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
		}
		
		con.close();

	}

}
