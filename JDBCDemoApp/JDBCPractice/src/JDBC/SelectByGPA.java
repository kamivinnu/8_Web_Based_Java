package JDBC;
import java.sql.*;
import java.util.*;

public class SelectByGPA {
    public static void main(String[] args) throws Exception {

    	DBConnection dbcon = new DBConnection();
		Connection con = dbcon.getDBConnection();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter GPA limit: ");
        double limit = sc.nextDouble();

        String sql = "SELECT * FROM student WHERE gpa < ?";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setDouble(1, limit);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getInt("sid") + "  " +
                               rs.getString("sname") + "  " +
                               rs.getDouble("gpa"));
        }

        con.close();
    }
}
