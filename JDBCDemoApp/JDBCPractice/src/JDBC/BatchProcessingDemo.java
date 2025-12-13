package JDBC;
import java.sql.*;

public class BatchProcessingDemo {
    public static void main(String[] args) throws Exception {

    	DBConnection dbcon = new DBConnection();
		Connection con = dbcon.getDBConnection();
        Statement st = con.createStatement();

        // a. Add 10000 balance for Hyd & Pune customers
        st.addBatch("UPDATE customers SET balance = balance + 10000 WHERE city IN ('Hyd','Pune')");

        // b. Delete customers with balance < 50000
        st.addBatch("DELETE FROM customers WHERE balance < 50000");

        // c & d. Insert two customers
        st.addBatch("INSERT INTO customers VALUES(3001,'Ravi','Hyd',90000)");
        st.addBatch("INSERT INTO customers VALUES(3002,'Kiran','Pune',85000)");

        // e. Update with +15000 for cid between 3000 and 7000
        st.addBatch("UPDATE customers SET balance = balance + 15000 WHERE cid BETWEEN 3000 AND 7000");

        int[] result = st.executeBatch();

        System.out.println("Batch executed successfully!");

        con.close();
    }
}
