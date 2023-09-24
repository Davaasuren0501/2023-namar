import java.util.Scanner;

public class Home3 {
    public Home3() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("B tsegiin x coordinateo oruul: ");
        double x = scanner.nextDouble();

        System.out.print("B tsegiin y coordinateo oruul: ");
        double y = scanner.nextDouble();

        System.out.print("Zorvvnii hemjeeg oruulna uu:  ");
        double zorvv = scanner.nextDouble();

        double value_check = checkMethod(x);

        double zorvv2 = Math.abs(value_check - y);

        if (zorvv2 < zorvv) {
            System.out.println("Zorj boloh hemjeend muriu deer orshdog");
        } else {
            System.out.println("Zorj boloh hemjeend muriu deer orshdoggui");
        }

    }
    private double checkMethod(double x) {
        return 6 * Math.cos(2 * x) - 0.25 * Math.pow(x, 5) + 32 * Math.pow(x, 2) - 27;
    }
    public static void main(String[] args) {
        new Home3();
    }
}
