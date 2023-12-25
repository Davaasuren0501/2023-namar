package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static final String URL = "jdbc:postgresql://localhost:5432/db_desktop_java";
    private static final String USER = "postgres";
    private static final String PASSWORD = "davka0501";
	Connection conn;

    public Connection getConnection() {
    	try {
    		conn = DriverManager.getConnection(URL, USER, PASSWORD);
    	} catch(Exception ex) {
    		System.out.println( "ex :" +ex );
    	}
        return conn;
    }
}
