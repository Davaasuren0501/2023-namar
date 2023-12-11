package ch7.catalogue.persistent;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.text.NumberFormat;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Entity
public class ShoppingCartPersist<Item>
    extends shared.PersistentBase implements Serializable {
        
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static NumberFormat currency = 
        NumberFormat.getCurrencyInstance();
    private double total;
    private int count;
    
    public ShoppingCartPersist() {
        resetItems();
    }
    
    public final void resetItems() {
        items = new ArrayList<CatalogueItemPersist>();
        total = 0.0;
        count = 0;
    }
    
    public void addItem(CatalogueItemPersist item) {
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
    
    @Transient
    public String getTotalAsCurrency() {
        return currency.format(total);
    }
 
    public void incrCount() {
        count++;
    } 
    
    protected String accountNumber;

    @Pattern(regexp="[a-zA-Z]{2}\\d{3}", 
             message="must be in the format AA999.")
    @NotNull
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    
     
    protected List<CatalogueItemPersist> items;
    
    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany
    public List<CatalogueItemPersist> getItems() {
        return items;
    }
    
    public void setItems(List<CatalogueItemPersist> items) {
        this.items = items;
    } 
}
