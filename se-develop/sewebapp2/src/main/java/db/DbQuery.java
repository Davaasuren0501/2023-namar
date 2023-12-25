package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.beans.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbQuery {
	DBUtil dbutil = new DBUtil();
	Connection con = dbutil.getConnection();
//	PreparedStatement ps;
//	Statement st;
//	ResultSet rs;

	
	public void CreateTable() {
		createProductTable();
	}
	
	private void createProductTable() {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS product ("
                + "id SERIAL PRIMARY KEY,"
                + "product_name VARCHAR(50) NULL,"
                + "qty VARCHAR(50) NULL, "
                + "price VARCHAR(50) NULL, "
                + "supplier_id VARCHAR(50) NULL"
                + ");";
        try {
            PreparedStatement pst = con.prepareStatement(createTableQuery);
            pst.executeUpdate();
            System.out.println("Sucessfully created product table");
        } catch (SQLException e) {
            System.err.println("Table creation failed: " + e.getMessage());
        }
	}

}
