package Model;

import java.util.ArrayList;

public class Supplier {
	
	public static ArrayList<Supplier> SupplierList = new ArrayList<Supplier>();

    // Fields
    private int id;
    private String name;
    private String address;
    private String phone;
    private Integer parentId;
    // Constructor
    public Supplier(int id, String name, String address, String phone, Integer parentId) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.parentId = parentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}
