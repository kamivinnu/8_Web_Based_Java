package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertStudent {

	public static void main(String[] args) throws Exception {
		
		DBConnection dbcon = new DBConnection();
		Connection con = dbcon.getDBConnection();
		
		Scanner sc = new Scanner(System.in);
		
		String insert = "INSERT INTO student (sid, sname, gpa, age, city) VALUES (?, ?, ?, ?, ?)";
		
		PreparedStatement pst = con.prepareStatement(insert);
		
		for (int i=0; i<10; i++) {
			
			System.out.print("SID: ");
            pst.setInt(1, sc.nextInt());

            System.out.print("Name: ");
            pst.setString(2, sc.next());

            System.out.print("GPA: ");
            pst.setDouble(3, sc.nextDouble());
            
            System.out.print("Age: ");
            pst.setInt(4, sc.nextInt());

            System.out.print("City: ");
            pst.setString(5, sc.next());

            pst.executeUpdate();
		}
		
		con.close();
		
		
	}

}
