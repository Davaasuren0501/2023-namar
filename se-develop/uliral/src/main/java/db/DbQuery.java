package db;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Product;
import Model.Supplier;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbQuery {
	DBUtil dbutil = new DBUtil();
	Connection con = dbutil.getConnection();

	
	public void CreateTable() {
		createProductTable();
		createSupplierTable();
	}
	
	private void createProductTable() {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS product_product ("
                + "id SERIAL PRIMARY KEY,"
                + "product_name VARCHAR(50) NULL,"
                + "qty VARCHAR(50) NULL, "
                + "price VARCHAR(50) NULL, "
                + "description VARCHAR(50) NULL, "
                + "supplier_id integer NULL"
                + ");";
        try {
            PreparedStatement pst = con.prepareStatement(createTableQuery);
            pst.executeUpdate();
            System.out.println("Sucessfully created product table");
        } catch (SQLException e) {
            System.err.println("Table creation failed: " + e.getMessage());
        }
	}
	
	private void createSupplierTable() {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS supplier_supplier ("
                + "id SERIAL PRIMARY KEY,"
                + "name VARCHAR(50) NULL,"
                + "address VARCHAR(50) NULL, "
                + "phone VARCHAR(50) NULL, "
                + "parent_id Integer NULL"
                + ");";
        try {
            PreparedStatement pst = con.prepareStatement(createTableQuery);
            pst.executeUpdate();
            System.out.println("Sucessfully created supplier_supplier table");
        } catch (SQLException e) {
            System.err.println("Table creation failed: " + e.getMessage());
        }
	}
	public ArrayList<Product> selectProduct(String searchQuery) {
    	String query ;
    	if( searchQuery == null ) {
    		query = "Select * from product_product order by id desc;";
    	} else {
    		query = "Select * from product_product where product_name like ? order by id desc;";
    	}
        try {
            PreparedStatement pst = con.prepareStatement(query);
            if( searchQuery != null ) {
                pst.setString(1, "%" + searchQuery + "%");
            }
            
            ResultSet resultSet = pst.executeQuery();
            ArrayList<Product> list_data = new ArrayList<Product>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String product_name = resultSet.getString("product_name");
                String qty = resultSet.getString("qty");
                String price = resultSet.getString("price");
                String description = resultSet.getString("description");
                int supplier_id = resultSet.getInt("supplier_id");
                System.out.println(id);
            	Product productNew = new Product(
            			id,	product_name,qty,price, description, supplier_id
    			);
            	list_data.add(productNew);
            }
            return list_data;
        } catch (SQLException ex) {
            System.out.print( ex );
        }
		return null;
    }
	public ArrayList<Supplier> selectSupplier(String searchQuery) {
    	String query ;
    	if( searchQuery == null ) {
    		query = "Select * from supplier_supplier order by id desc;";
    	} else {
    		query = "Select * from supplier_supplier where name like ? order by id desc;";
    	}
    	
        try {
            PreparedStatement pst = con.prepareStatement(query);
            if( searchQuery != null ) {
                pst.setString(1, "%" + searchQuery + "%");
            }
            ResultSet resultSet = pst.executeQuery();
            ArrayList<Supplier> list_data = new ArrayList<Supplier>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                int parent_id = resultSet.getInt("parent_id");
                
                System.out.println(id);
                
                Supplier supplierNew = new Supplier(id, name,address, phone, parent_id);
                list_data.add(supplierNew);
            }
            return list_data;
        } catch (SQLException ex) {
            System.out.print( ex );
        }
		return null;
    }
	
	public int insertProduct(String product_name, String qty, String price, String description, int supplier_id ) {
		String query = "INSERT INTO product_product (product_name, qty, price, description, supplier_id) VALUES (?, ?, ?, ?, ?)";
        int rowCount = 0;
        try {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, product_name);
            pst.setString(2, qty);
            pst.setString(3, price);
            pst.setString(4, description);
            pst.setInt(5, supplier_id);
            rowCount = pst.executeUpdate();
            if( rowCount > 0 ) {
            	return lastProductId();
            } else {
                return rowCount;
            }
        } catch (SQLException ex) {
            System.out.print( ex );
            return  rowCount;
        }
    }

	
	public int insertSupplier(String name, String address, String phone, int parent_id ) {
		String query = "INSERT INTO supplier_supplier (name, address, phone, parent_id) VALUES (?, ?, ?, ?)";
        int rowCount = 0;
        try {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, name);
            pst.setString(2, address);
            pst.setString(3, phone);
            pst.setInt(4, parent_id);
            rowCount = pst.executeUpdate();
            if( rowCount > 0 ) {
            	return lastSupplierId();
            } else {
                return rowCount;
            }
        } catch (SQLException ex) {
            System.out.print( ex );
            return  rowCount;
        }
    }
	
	public int lastProductId() {
    	String query = "Select id from product_product order by id desc limit 1;";
        try {
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet resultSet = pst.executeQuery();
            if (resultSet.next()) {
                int id_insert = resultSet.getInt("id");
//                System.out.println(id_insert);
                return id_insert;
            }
            return 0;
        } catch (SQLException ex) {
            System.out.print( ex );
            return 0;
        }
    }
	
	public int lastSupplierId() {
    	String query = "Select id from supplier_supplier order by id desc limit 1;";
        try {
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet resultSet = pst.executeQuery();
            if (resultSet.next()) {
                int id_insert = resultSet.getInt("id");
//                System.out.println(id_insert);
                return id_insert;
            }
            return 0;
        } catch (SQLException ex) {
            System.out.print( ex );
            return 0;
        }
    }
	
	public int updateSupplier(String name, String address, String phone, int id_update ) {
		String query = "UPDATE supplier_supplier SET name = ?, phone = ?,address = ? WHERE id = ?";
        int rowCount = 0;
        try {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, name);
            pst.setString(2, phone);
            pst.setString(3,address );
            pst.setInt(4, id_update);
            rowCount = pst.executeUpdate();
            return rowCount;
        } catch (SQLException ex) {
            System.out.print( ex );
            return  rowCount;
        }
    }
	
	public int updateProduct(String product_name, String qty, String price,int supplier_id, int id_update ) {
		String query = "UPDATE product_product SET product_name = ?, qty = ?,price = ?,supplier_id=? WHERE id = ?";
        int rowCount = 0;
        try {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, product_name);
            pst.setString(2, qty);
            pst.setString(3,price );
            pst.setInt(4,supplier_id );
            pst.setInt(5, id_update);
            rowCount = pst.executeUpdate();
            return rowCount;
        } catch (SQLException ex) {
            System.out.print( ex );
            return  rowCount;
        }
    }
	
	public Product getProduct(int id_product) {
		String query = "Select * from product_product where id = ?";
        Product product = new Product();
        try {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, id_product);
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String product_name = resultSet.getString("product_name");
                String qty = resultSet.getString("qty");
                String price = resultSet.getString("price");
                String description = resultSet.getString("description");
                int supplier_id = resultSet.getInt("supplier_id");
                System.out.println(id);
                product.setId(id);
                product.setProductName(product_name);
                product.setQty(qty);
                product.setPrice(price);
                product.setDescription(description);
                product.setSupplierId(supplier_id);
            }
            return product;
        } catch (SQLException ex) {
            System.out.print( ex );
        }
		return null;
	}

}
