
package ch7.catalogue.persistent;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

@Entity
public class CatalogueItemPersist 
extends shared.PersistentBase implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CatalogueItemPersist() {
        this(null, "", "", 0.00);
    }

  private String name;
  private String description;
  private String itemId;
  private double price;
    
  public CatalogueItemPersist(String itemId, String name,
                     String description, double price) 
  {
    this.itemId = itemId;
    this.name = name;
    this.description = description;
    this.price = price;
  }
  
  @Length(min=1,max=50)
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  @Lob
  public String getDescription() {
    return description;
  }
  
  public void setDescription(String description) {
    this.description = description;
  }
  
  @NotNull
  @Length(min=1,max=10)
  public String getItemId() {
    return itemId;
  }
  
  public void setItemId(String itemId) {
    this.itemId = itemId;
  }
  
  public double getPrice() {
    return price;
  }
  
  public void setPrice(double price) {
    this.price = price;
  }
}
