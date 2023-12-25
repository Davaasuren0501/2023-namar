package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static final String URL = "jdbc:postgresql://localhost:5432/se_uliral";
    private static final String USER = "postgres";
    private static final String PASSWORD = "davka0501";
	Connection conn;

    public Connection getConnection() {
    	try {
            Class.forName("org.postgresql.Driver");
            
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to the database.");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection failed. Check output console.");
            e.printStackTrace();
        }
        return conn;
    }
}
