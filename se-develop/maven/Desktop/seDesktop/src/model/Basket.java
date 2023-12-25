package model;

import java.util.ArrayList;
import java.util.List;

import seDesktop.client.Main;

public class Basket {
    private String image;
    private String name;
    private int price;
    private int quantity;
    private int total;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public int getTotal() {
        return total;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getString() {
        return "Basket{" +
                "image='" + image + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", total=" + total +
                '}';
    }
    public Basket( String Image, String name, int price, int qty ) {
    	this.image = Image;
    	this.name = name;
    	this.price = price;
    	this.quantity = qty;
    	Main.qty_basket.setText((Integer.parseInt(Main.qty_basket.getText()) + 1 ) + "");
    	this.total = qty * price;
    }
}
