package ch7.catalogue;

import java.util.List;
import java.util.ArrayList;
import java.text.NumberFormat;

public class ShoppingCart<Item> {
    
    private static NumberFormat currency = 
        NumberFormat.getCurrencyInstance(); 
    private List<Item> items;
    private double total;
    private int count;
    
    public ShoppingCart() {
        resetItems();
    }
    
    public final void resetItems() {
        items = new ArrayList<Item>();
        total = 0.0;
        count = 0;
    }
    
    public void setItems(List<Item> items) {
        this.items = items;
    }
    
    public List<Item> getItems() {
        return items;
    }
    
    public void addItem(Item item) {
        items.add(item);
    }
    
    public void setTotal(double total) {
        this.total = total;
    }
    
    public double getTotal() {
        return total;
    }
   
    public void setCount(int count) {
        this.count = count;
    }
    
    public int getCount() {
        return count;
    }
    
    public void addTotal(double amount) {
        total += amount;
    }
    
    public String getTotalAsCurrency() {
        return currency.format(total);
    }
 
    public void incrCount() {
        count++;
    }
}
