package com.davaa.desktop.database;
import java.sql.*;

public class PostgreSQLConnection {
    public static String db_url = "jdbc:postgresql://localhost:5432/db_desktop_java";
    public static String db_user = "postgres";
    public static String db_password = "davka0501";
    public static Connection con;

    public static int _functionLogin(String email, String userPassword) {

        String query = "SELECT * FROM users "
                + "WHERE email = ? AND password = ?";
        int rowCount = 0;	
        try {
        	// con = DriverManager.getConnection(db_url, db_user, db_password);
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, email);
            pst.setString(2, userPassword);
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                rowCount++; 
            }
            return  rowCount;
        } catch (SQLException ex) {
            System.out.print( ex );
            return  rowCount;
        }
//        try (Connection con = DriverManager.getConnection(db_url, db_user, db_password);
//             PreparedStatement pst = con.prepareStatement(query)) {
//            pst.setString(1, email);
//            pst.setString(2, userPassword);
//            ResultSet resultSet = pst.executeQuery();
//            while (resultSet.next()) {
//                int id = resultSet.getInt("id");
////                String email = resultSet.getString("email");
////                String lastName = resultSet.getString("password");
////                System.out.println("\n" +id + ", " + email + " " + lastName);
//                rowCount++; 
//            }
//            return  rowCount;
//        } catch (SQLException ex) {
//            System.out.print( ex );
//            return  rowCount;
//        }
    }

    public static int _functionSignUp(String name, String email, String userPassword) {

        String query = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
        try (Connection con = DriverManager.getConnection(db_url, db_user, db_password);
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, name);
            pst.setString(2, email);
            pst.setString(3, userPassword);
            int result = pst.executeUpdate();
            return  result;
        } catch (SQLException ex) {
            System.out.print( ex );
        }
        return 0;
    }

    public static void CreateTables(){
    	CreateUser();
    	CreateSaleOrder();
        CreateSaleOrderLine();
    	CreateProduct();
        CreateCustomer();
    }
    
    public static void CreateUser() {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS users ("
                + "id SERIAL PRIMARY KEY,"
                + "name VARCHAR(50) NOT NULL,"
                + "email VARCHAR(50) NOT NULL,"
                + "password VARCHAR(50) NOT NULL"
                + ");";
        try {
        	con = DriverManager.getConnection(db_url, db_user, db_password);
            PreparedStatement pst = con.prepareStatement(createTableQuery);
             pst.executeUpdate();
            System.out.println("Sucessfully created users table");
        } catch (SQLException e) {
            System.err.println("Table creation failed: " + e.getMessage());
        }
        // try(Connection con = DriverManager.getConnection(db_url, db_user, db_password);
        //     PreparedStatement pst = con.prepareStatement(createTableQuery)) {
        //     pst.executeUpdate();
        //     System.out.println("Sucessfully created users table");
        // } catch (SQLException e) {
        //     System.err.println("Table creation failed: " + e.getMessage());
        // }
    }
    
    public static void CreateSaleOrder() {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS sale_order ("
                + "id SERIAL PRIMARY KEY,"
                + "name VARCHAR(50) NULL,"
                + "partner_name VARCHAR(50) NULL, "
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
        // try(Connection con = DriverManager.getConnection(db_url, db_user, db_password);
        //     PreparedStatement pst = con.prepareStatement(createTableQuery)) {
        //     pst.executeUpdate();
        //     System.out.println("Sucessfully created sale_order table");
        // } catch (SQLException e) {
        //     System.err.println("Table creation failed: " + e.getMessage());
        // }
    }
    
    public static void CreateSaleOrderLine() {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS sale_order_line ("
                + "id SERIAL PRIMARY KEY,"
                + "order_id INTEGER NULL,"
                + "name VARCHAR(50) NULL,"
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
        // try(Connection con = DriverManager.getConnection(db_url, db_user, db_password);
        //     PreparedStatement pst = con.prepareStatement(createTableQuery)) {
        //     pst.executeUpdate();
        //     System.out.println("Sucessfully created sale_order_line table");
        // } catch (SQLException e) {
        //     System.err.println("Table creation failed: " + e.getMessage());
        // }
    }
    
    public static void CreateProduct() {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS product ("
                + "id SERIAL PRIMARY KEY,"
                + "name VARCHAR(50) NULL,"
                + "uom VARCHAR(50) NULL, "
                + "price VARCHAR(50) NULL, "
                + "tax VARCHAR(50) NULL"
                + ");";
        try {
            PreparedStatement pst = con.prepareStatement(createTableQuery);
            pst.executeUpdate();
            System.out.println("Sucessfully created product table");
        } catch (SQLException e) {
            System.err.println("Table creation failed: " + e.getMessage());
        }
        // try(Connection con = DriverManager.getConnection(db_url, db_user, db_password);
        //     PreparedStatement pst = con.prepareStatement(createTableQuery)) {
        //     pst.executeUpdate();
        //     System.out.println("Sucessfully created product table");
        // } catch (SQLException e) {
        //     System.err.println("Table creation failed: " + e.getMessage());
        // }
    }
    
    public static void CreateCustomer() {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS customer ("
                + "id SERIAL PRIMARY KEY,"
                + "name VARCHAR(50) NULL,"
                + "phone VARCHAR(50) NULL, "
                + "address VARCHAR(50) NULL, "
                + "tax VARCHAR(50) NULL"
                + ");";
        try {
            PreparedStatement pst = con.prepareStatement(createTableQuery);
            pst.executeUpdate();
            System.out.println("Sucessfully created customer table");
        } catch (SQLException e) {
            System.err.println("Table creation failed: " + e.getMessage());
        }
        // try(Connection con = DriverManager.getConnection(db_url, db_user, db_password);
        //     PreparedStatement pst = con.prepareStatement(createTableQuery)) {
        //     pst.executeUpdate();
        //     System.out.println("Sucessfully created customer table");
        // } catch (SQLException e) {
        //     System.err.println("Table creation failed: " + e.getMessage());
        // }
    }
    
    public static int CreateProductNew( String name,String uom,String price,String tax) {
    	String query = "INSERT INTO product (name, uom, price, tax) VALUES (?, ?, ?, ?)";
        int rowCount = 0;
        // try (Connection con = DriverManager.getConnection(db_url, db_user, db_password);
        //      PreparedStatement pst = con.prepareStatement(query)) {
        //     pst.setString(1, name);
        //     pst.setString(2, uom);
        //     pst.setString(3, price);
        //     pst.setString(4, tax);
        //     rowCount = pst.executeUpdate();
        //     return  rowCount;
        // } catch (SQLException ex) {
        //     System.out.print( ex );
        //     return  rowCount;
        // }
        try {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, name);
            pst.setString(2, uom);
            pst.setString(3, price);
            pst.setString(4, tax);
            rowCount = pst.executeUpdate();
            return  rowCount;
        } catch (SQLException ex) {
            System.out.print( ex );
            return  rowCount;
        }
        
    }

    
    public static int CreateCustomerNew( String name,String phone,String address,String tax) {
    	String query = "INSERT INTO customer (name, phone, address, tax) VALUES (?, ?, ?, ?)";
        int rowCount = 0;
        // try (Connection con = DriverManager.getConnection(db_url, db_user, db_password);
        //      PreparedStatement pst = con.prepareStatement(query)) {
        //     pst.setString(1, name);
        //     pst.setString(2, phone);
        //     pst.setString(3, address);
        //     pst.setString(4, tax);
        //     rowCount = pst.executeUpdate();
        //     return  rowCount;
        // } catch (SQLException ex) {
        //     System.out.print( ex );
        //     return  rowCount;
        // }
        try {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, name);
            pst.setString(2, phone);
            pst.setString(3, address);
            pst.setString(4, tax);
            rowCount = pst.executeUpdate();
            return  rowCount;
        } catch (SQLException ex) {
            System.out.print( ex );
            return  rowCount;
        }
    }
    
    public static ResultSet ReadProduct( String where ) {
    	String query = "Select * from product ";
    	if( where.length() > 0 ) {
    		query += where;
    	}
        // try (Connection con = DriverManager.getConnection(db_url, db_user, db_password);
        //      PreparedStatement pst = con.prepareStatement(query)) {
        //     ResultSet resultSet = pst.executeQuery();
        //     return  resultSet;
        // } catch (SQLException ex) {
        //     System.out.print( ex );
        //     return null;
        // }
        try {
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet resultSet = pst.executeQuery();
            return  resultSet;
        } catch (SQLException ex) {
            System.out.print( ex );
            return  null;
        }
    }
    
    public static ResultSet ReadCustomer( String where ) {
    	String query = "Select * from customer ";
    	if( where.length() > 0 ) {
    		query += where;
    	}
        // try (Connection con = DriverManager.getConnection(db_url, db_user, db_password);
        //      PreparedStatement pst = con.prepareStatement(query)) {
        //     ResultSet resultSet = pst.executeQuery();
        //     return  resultSet;
        // } catch (SQLException ex) {
        //     System.out.print( ex );
        //     return null;
        // }
        try {
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet resultSet = pst.executeQuery();
            return  resultSet;
        } catch (SQLException ex) {
            System.out.print( ex );
            return  null;
        }
    }
    public static int UpdateProduct(String name,String uom,String price,String tax, int id_select) {
    	String query = "UPDATE product SET name = ?, uom = ?,price = ?,tax = ? WHERE id = ?";
        int rowCount = 0;
        // try (Connection con = DriverManager.getConnection(db_url, db_user, db_password);
        //      PreparedStatement pst = con.prepareStatement(query)) {
        //     pst.setString(1, name);
        //     pst.setString(2, uom);
        //     pst.setString(3, price);
        //     pst.setString(4, tax);
        //     pst.setInt(5, id_select);
        //     rowCount = pst.executeUpdate();
        //     return  rowCount;
        // } catch (SQLException ex) {
        //     System.out.print( ex );
        //     return  rowCount;
        // }
        try {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, name);
            pst.setString(2, uom);
            pst.setString(3, price);
            pst.setString(4, tax);
            pst.setInt(5, id_select);
            rowCount = pst.executeUpdate();
            return  rowCount;
        } catch (SQLException ex) {
            System.out.print( ex );
            return  rowCount;
        }
    }
    public static int UpdateCustomer(String name,String phone,String address,String tax, int id_select) {
    	String query = "UPDATE customer SET name = ?, phone = ?,address = ?,tax = ? WHERE id = ?";
        int rowCount = 0;
        // try (Connection con = DriverManager.getConnection(db_url, db_user, db_password);
        //      PreparedStatement pst = con.prepareStatement(query)) {
        //     pst.setString(1, name);
        //     pst.setString(2, phone);
        //     pst.setString(3, address);
        //     pst.setString(4, tax);
        //     pst.setInt(5, id_select);
        //     rowCount = pst.executeUpdate();
        //     return  rowCount;
        // } catch (SQLException ex) {
        //     System.out.print( ex );
        //     return  rowCount;
        // }
        try {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, name);
            pst.setString(2, phone);
            pst.setString(3, address);
            pst.setString(4, tax);
            pst.setInt(5, id_select);;
            rowCount = pst.executeUpdate();
            return  rowCount;
        } catch (SQLException ex) {
            System.out.print( ex );
            return  rowCount;
        }
    }
    
    public static int DeleteProduct(int id_selected) {
    	String query = "DELETE FROM product WHERE id = ?";
        int rowCount = 0;
        // try (Connection con = DriverManager.getConnection(db_url, db_user, db_password);
        //      PreparedStatement pst = con.prepareStatement(query)) {
        //     pst.setInt(1, id_selected);
        //     rowCount = pst.executeUpdate();
        //     return  rowCount;
        // } catch (SQLException ex) {
        //     System.out.print( ex );
        //     return  rowCount;
        // }
        try {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, id_selected);
            rowCount = pst.executeUpdate();
            return  rowCount;
        } catch (SQLException ex) {
            System.out.print( ex );
            return  rowCount;
        }
    }
    
    public static int DeleteCustomer(int id_selected) {
    	String query = "DELETE FROM customer WHERE id = ?";
        int rowCount = 0;
        // try (Connection con = DriverManager.getConnection(db_url, db_user, db_password);
        //      PreparedStatement pst = con.prepareStatement(query)) {
        //     pst.setInt(1, id_selected);
        //     rowCount = pst.executeUpdate();
        //     return  rowCount;
        // } catch (SQLException ex) {
        //     System.out.print( ex );
        //     return  rowCount;
        // }
        try {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, id_selected);
            rowCount = pst.executeUpdate();
            return  rowCount;
        } catch (SQLException ex) {
            System.out.print( ex );
            return  rowCount;
        }
    }

    public static int CreateSaleOrderNew(String name, String partner_name, String total, String date ) {
    	String query = "INSERT INTO sale_order (name, partner_name, total, date, state) VALUES (?, ?, ?, ?, ?)";
        int rowCount = 0;
        // try (Connection con = DriverManager.getConnection(db_url, db_user, db_password);
        //      PreparedStatement pst = con.prepareStatement(query)) {
        //     pst.setString(1, name);
        //     pst.setString(2, partner_name);
        //     pst.setString(3, total);
        //     pst.setString(4, date);
        //     pst.setString(5, "draft");
        //     rowCount = pst.executeUpdate();
        //     return SO();
        // } catch (SQLException ex) {
        //     System.out.print( ex );
        //     return  rowCount;
        // }
        try {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, name);
            pst.setString(2, partner_name);
            pst.setString(3, total);
            pst.setString(4, date);
            pst.setString(5, "Draft");
            rowCount = pst.executeUpdate();
            return  SO();
        } catch (SQLException ex) {
            System.out.print( ex );
            return  rowCount;
        }
    }
    
    public static int SO() {
    	String query = "Select id from sale_order order by id desc limit 1;";
        // try (Connection con = DriverManager.getConnection(db_url, db_user, db_password);
        //      PreparedStatement pst = con.prepareStatement(query)) {
        //     ResultSet resultSet = pst.executeQuery();
        //     if (resultSet.next()) {
        //         int id_insert = resultSet.getInt(1);
        //         System.out.println(id_insert);
        //         return id_insert;
        //     }
        //     return 0;
        // } catch (SQLException ex) {
        //     System.out.print( ex );
        //     return 0;
        // }
        try {
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet resultSet = pst.executeQuery();
            if (resultSet.next()) {
                int id_insert = resultSet.getInt("id");
                System.out.println(id_insert);
                return id_insert;
            }
            return 0;
        } catch (SQLException ex) {
            System.out.print( ex );
            return 0;
        }
    }

    public static int CreateSaleOrderLineNew(int order_id, String name, String price, String qty, String unitprice ) {
    	String query = "INSERT INTO sale_order_line (order_id,name, qty, price, total_unit) VALUES (?,?, ?, ?, ?)";
        int rowCount = 0;
        // try (Connection con = DriverManager.getConnection(db_url, db_user, db_password);
        //      PreparedStatement pst = con.prepareStatement(query)) {
        //     pst.setInt(1, order_id);
        //     pst.setString(2, name);
        //     pst.setString(3, qty);
        //     pst.setString(4, price);
        //     pst.setString(5, unitprice);
        //     rowCount = pst.executeUpdate();
        //     return  rowCount;
        // } catch (SQLException ex) {
        //     System.out.print( ex );
        //     return  rowCount;
        // }
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
