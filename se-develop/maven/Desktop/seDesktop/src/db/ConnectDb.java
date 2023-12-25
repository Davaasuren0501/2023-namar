package db;
import javax.swing.*;


import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDb {
	public static final String username = "postgres";
	public static final String password = "davka0501";
	public static final String url = "jdbc:postgresql://localhost:5432/foodfast";
	public static Connection con = null;
	
	public static Connection getConcnection() {
		try {
			con = DriverManager.getConnection(url, username, password);
			System.out.println("Connected to PostgreSQL!");
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ""+ex,"",JOptionPane.WARNING_MESSAGE);
		}
		return con;
	}
}
