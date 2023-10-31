import java.io.Serializable;
public class Icecream implements Serializable {
    public String order_date;
    public String flavor;
    private String status_nuts;
    private String status_cherries;

    public String getOrder_date() {
        return order_date;
    }

    public String getStatus_cherries() {
        return status_cherries;
    }

    public String getFlavor() {
        return flavor;
    }

    public String getStatus_nuts() {
        return status_nuts;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public void setStatus_cherries(String status_cherries) {
        this.status_cherries = status_cherries;
    }

    public void setStatus_nuts(String status_nuts) {
        this.status_nuts = status_nuts;
    }
    @Override
    public String toString() {
        return "Icecream order{" +
                " order_date = " + order_date +
                ", flavor='" + flavor + '\'' +
                ", cherrries=" + status_cherries +'\'' +
                ", nuts='" + status_nuts + '\'' +
                '}';
    }
    public Icecream(String order_date, String flavor, String status_cherries, String status_nuts) {
        this.order_date = order_date;
        this.flavor = flavor;
        this.status_cherries = status_cherries;
        this.status_nuts = status_nuts;
    }
}
