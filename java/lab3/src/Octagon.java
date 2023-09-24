public class Octagon extends  GeometricObject implements Cloneable, Comparable{
    public double side;

    public  Octagon( double side ) {
        this.side = side;
    }
    public  Octagon( ) {
        this.side = 0;
    }

    public double area() {
        return  1;
    }
}
