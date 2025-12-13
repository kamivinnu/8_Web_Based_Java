package JDBC;

import java.sql.*;

public class TransactionDemo {
    public static void main(String[] args) throws Exception {

    	DBConnection dbcon = new DBConnection();
		Connection con = dbcon.getDBConnection();
        con.setAutoCommit(false);

        try {
            PreparedStatement ps1 = con.prepareStatement("INSERT INTO student VALUES(101,'Amit',8.5,'Hyd')");
            ps1.executeUpdate();

            PreparedStatement ps2 = con.prepareStatement("UPDATE student SET gpa = gpa + 1 WHERE sid = 101");
            ps2.executeUpdate();

            con.commit();
            System.out.println("Transaction committed.");
        } 
        catch (Exception e) {
            con.rollback();
            System.out.println("Transaction rolled back!");
        }

        con.close();
    }
}
