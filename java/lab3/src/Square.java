public class Square extends GeometricObject implements Colorable{
    private double side;

    public Square(){
        this.side = 0;
    }
    public Square(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }
    @Override
    public void howToColor() {
        System.out.println("Color all four sides.");
    }
    public static void main(String[] args) {
    }
}
