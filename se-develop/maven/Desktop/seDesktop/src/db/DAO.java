package db;

import java.sql.*;

public class DAO {
	Connection con = ConnectDb.getConcnection();
	PreparedStatement ps;
	Statement st;
	ResultSet rs;
	
	public void CreateTable() {
		CreateTableUser();
		CreateTableOrder();
		CreateSaleOrderLine();
	}
	
	private void CreateTableUser() {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS users ("
                + "id SERIAL PRIMARY KEY,"
                + "name VARCHAR(50) NOT NULL,"
                + "email VARCHAR(50) NOT NULL,"
                + "password VARCHAR(50) NOT NULL"
                + ");";
        try {
            PreparedStatement pst = con.prepareStatement(createTableQuery);
             pst.executeUpdate();
            System.out.println("Sucessfully created users table");
        } catch (SQLException e) {
            System.err.println("Table creation failed: " + e.getMessage());
        }
	}
	
	private void CreateTableOrder() {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS sale_order ("
                + "id SERIAL PRIMARY KEY,"
                + "date VARCHAR(50) NULL,"
                + "total VARCHAR(50) NULL, "
                + "state VARCHAR(50) NULL"
                + ");";
        try {
            PreparedStatement pst = con.prepareStatement(createTableQuery);
            pst.executeUpdate();
            System.out.println("Sucessfully created sale_order table");
        } catch (SQLException e) {
            System.err.println("Table creation failed: " + e.getMessage());
        }
	}
    
	private void CreateSaleOrderLine() {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS sale_order_line ("
                + "id SERIAL PRIMARY KEY,"
                + "order_id INTEGER NULL,"
                + "product_name VARCHAR(50) NULL,"
                + "qty VARCHAR(50) NULL, "
                + "price VARCHAR(50) NULL, "
                + "total_unit VARCHAR(50) NULL"
                + ");";
        try {
            PreparedStatement pst = con.prepareStatement(createTableQuery);
            pst.executeUpdate();
            System.out.println("Sucessfully created sale_order_line table");
        } catch (SQLException e) {
            System.err.println("Table creation failed: " + e.getMessage());
        }
    }
	 public int CreateSaleOrderNew( int total, String date ) {
    	String query = "INSERT INTO sale_order (total, date, state) VALUES (?, ?, ?)";
        int rowCount = 0;
        try {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, total);
            pst.setString(2, date);
            pst.setString(3, "Хийгдэж байгаа");
            rowCount = pst.executeUpdate();
            return  SO();
        } catch (SQLException ex) {
            System.out.print( ex );
            return  rowCount;
        }
    }
	 private int SO() {
    	String query = "Select id from sale_order order by id desc limit 1;";
        try {
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet resultSet = pst.executeQuery();
            if (resultSet.next()) {
                int id_insert = resultSet.getInt("id");
                System.out.println("id_insert =>" + id_insert);
                return id_insert;
            }
            return 0;
        } catch (SQLException ex) {
            System.out.print( ex );
            return 0;
        }
    }
	 public int CreateSaleOrderLineNew(int order_id, String name, String price, String qty, String unitprice ) {
	    	String query = "INSERT INTO sale_order_line (order_id,product_name, qty, price, total_unit) VALUES (?,?, ?, ?, ?)";
	        int rowCount = 0;
	        try {
	            PreparedStatement pst = con.prepareStatement(query);
	            pst.setInt(1, order_id);
	            pst.setString(2, name);
	            pst.setString(3, qty);
	            pst.setString(4, price);
	            pst.setString(5, unitprice);
	            rowCount = pst.executeUpdate();
	            return  rowCount;
	        } catch (SQLException ex) {
	            System.out.print( ex );
	            return  rowCount;
	        }
	    }
}
