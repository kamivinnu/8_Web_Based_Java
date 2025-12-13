package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateDeleteStudent {

	public static void main(String[] args) throws Exception {
		DBConnection dbcon = new DBConnection();
		Connection con = dbcon.getDBConnection();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter student id to UPDATE: ");
		int id = sc.nextInt();
		
		System.out.println("Enter new GPA: ");
		double gpa = sc.nextDouble();
		
		String u = "update student set gpa = ? WHERE sid = ?";
		
		PreparedStatement pst = con.prepareStatement(u);
		
		pst.setDouble(1, gpa);
		pst.setInt(2, id);
		
		System.out.println(pst.executeUpdate() + " records updated");
		
		System.out.println("Enter student id to DELETE : ");
		int sid = sc.nextInt();
		
		
		
		String d = "delete from student WHERE sid = ?";
		
		PreparedStatement pst2 = con.prepareStatement(d);
		
		pst2.setInt(1, sid);
		
		System.out.println(pst.executeUpdate() + " records deleted");

	}

}
