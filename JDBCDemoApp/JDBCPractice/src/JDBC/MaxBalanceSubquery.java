package JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MaxBalanceSubquery {
	
	public static void main(String[] args) throws Exception {
		DBConnection dbcon = new DBConnection();
		
		Connection con = dbcon.getDBConnection();
		
		String query = "select * FROM customers WHERE balance = (select MAX(balance) from customers)";
		
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery(query);
		
		while(rs.next()) {
			System.out.println(rs.getInt("cid") + " " + rs.getDouble("balance"));
		}
		
		con.close();
	}
	
}
