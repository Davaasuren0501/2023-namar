import java.io.Serializable;

public class Car implements Serializable {
    private String mark;
    private String registrationNumber;
    private String ownerName;

    public Car(String mark, String registrationNumber, String ownerName) {
        this.mark = mark;
        this.registrationNumber = registrationNumber;
        this.ownerName = ownerName;
    }

    public String getMark() {
        return mark;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    @Override
    public String toString() {
        return "Car Mark: " + mark + ", Registration Number: " + registrationNumber + ", Owner nam: " + ownerName;
    }
}
