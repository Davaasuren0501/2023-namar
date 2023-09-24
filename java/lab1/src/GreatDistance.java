import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class GreatDistance {
    final double RADIUS = 6371.01;
    double x1, y1, x2, y2;
    void input() {
        Scanner in = new Scanner(System.in);
        System.out.print("x1 : ");
        x1 = Math.toRadians(in.nextDouble());
        System.out.print("y1 : ");
        y1 = Math.toRadians(in.nextDouble());
        System.out.print("x2 : ");
        x2 = Math.toRadians(in.nextDouble());
        System.out.print("y2 : ");
        y2 = Math.toRadians(in.nextDouble());

    }
    double getGreatDistance() {
        double res = RADIUS * Math.acos(Math.sin(x1) * Math.sin(x2) + Math.cos(x1) * Math.cos(x2) * Math.cos(y1 - y2));
        return res;
    }

    public GreatDistance() {
        input();
        System.out.print("The distance between the two points is " + getGreatDistance() + " km" );

    }

    void greatDistance() {
        Scanner in = new Scanner(System.in);

        double earth_radius = 6371.01;

        System.out.print("Enter first coordinate : ");
        double x1 = Math.toRadians(in.nextDouble());
        double y1 = Math.toRadians(in.nextDouble());

        System.out.print("Enter second coordinate : ");
        double x2 = Math.toRadians(in.nextDouble());
        double y2 = Math.toRadians(in.nextDouble());

        double distance = earth_radius * Math.acos(Math.sin(x1) * Math.sin(x2) + Math.cos(x1) * Math.cos(x2) * Math.cos(y1 - y2));

        System.out.println("The great circle distance : " + distance + " km");

        in.close();
    }
    public static void main(String[] args) {
        new GreatDistance();
    }
}