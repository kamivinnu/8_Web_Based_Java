package JDBC;

import java.sql.*;
import java.io.*;

public class InsertFromFile {
    public static void main(String[] args) throws Exception {

    	DBConnection dbcon = new DBConnection();
		Connection con = dbcon.getDBConnection();

        BufferedReader br = new BufferedReader(new FileReader("student.txt"));

        String sql = "INSERT INTO student VALUES(?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);

        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split(" ");

            ps.setInt(1, Integer.parseInt(data[0]));
            ps.setString(2, data[1]);
            ps.setDouble(3, Double.parseDouble(data[2]));
            ps.setString(4, data[3]);

            ps.executeUpdate();
        }

        con.close();
    }
}

