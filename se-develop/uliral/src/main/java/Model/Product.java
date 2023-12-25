package Model;
import java.util.ArrayList;

public class Product {
	
	public static ArrayList<Product> ProductList = new ArrayList<Product>();
	
    // Fields
    private int id;
    private String productName;
    private String qty;
    private String price;
    private String description;
    private int supplierId;

    // Constructor
    public Product(int id, String productName, String qty, String price, String description, int supplierId) {
        this.id = id;
        this.productName = productName;
        this.qty = qty;
        this.price = price;
        this.description = description;
        this.supplierId = supplierId;
    }

    // Getters and Setters for each field

    public Product() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + productName + '\'' +
                ", price=" + price +
                ", qty=" + qty +
                ", description='" + description + '\'' +
                ", supplierId=" + supplierId +
                '}';
    }
}

