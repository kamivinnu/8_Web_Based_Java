package JDBC;

import java.sql.*;

public class GroupByDemo {
    public static void main(String[] args) throws Exception {

    	DBConnection dbcon = new DBConnection();
		Connection con = dbcon.getDBConnection();
        Statement st = con.createStatement();

        // Group by city and show count
        System.out.println("CUSTOMER COUNT BY CITY:");
        ResultSet rs = st.executeQuery(
            "SELECT city, COUNT(*) AS total FROM customers GROUP BY city"
        );

        while (rs.next()) {
            System.out.println(rs.getString("city") + " : " + rs.getInt("total"));
        }

        // Richest customer per city
        System.out.println("\nRICH CUSTOMERS PER CITY:");
        rs = st.executeQuery(
            "SELECT city, MAX(balance) AS rich FROM customers GROUP BY city HAVING MAX(balance) > 50000"
        );

        while (rs.next()) {
            System.out.println(rs.getString("city") + " : " + rs.getDouble("rich"));
        }

        con.close();
    }
}

