package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectWithConditions {

	public static void main(String[] args) throws Exception {
		
		DBConnection dbcon = new DBConnection();
		
		Connection con = dbcon.getDBConnection();
		
		String query = "SELECT cname, balance FROM customers WHERE city=? AND balance > ?";
		
		PreparedStatement pst = con.prepareStatement(query);
		
		pst.setString(1, "Hyderabad");
		
		pst.setDouble(2, 5000);
		
		ResultSet rs = pst.executeQuery();
		
		
		while(rs.next()) {
			System.out.println(rs.getString("cname") + " " + rs.getDouble("balance"));
		}
		
		con.close();

	}

}
