import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Cube implements Serializable {
    private double size;
    private String color;
    private String material;

    public Cube(double size, String color, String material) {
        this.size = size;
        this.color = color;
        this.material = material;
    }

    public double getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public String getMaterial() {
        return material;
    }
}