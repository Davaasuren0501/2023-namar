import java.util.function.Supplier;
public class TestCircleWithPrivateDataFields {
    public static void main(String[] args) {
        CircleFactory c = Circle::new;
        Circle myCircle = c.getCircle(12.0);
        printC(myCircle::getRadius, myCircle::getArea);
    }
    private static void printC(Supplier<Double> circleSupplier, Supplier<Double> areaSupplier) {
        System.out.println("The area of the circle of radius " + circleSupplier.get() + "; area is " + areaSupplier.get());
    }
}
