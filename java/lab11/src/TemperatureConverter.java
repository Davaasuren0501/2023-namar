import java.util.Scanner;
import java.util.function.BiFunction;

public class TemperatureConverter {
    public TemperatureConverter() {
        String toUnit = readUnit();
        double temperature = readTemperature();
        BiFunction<String, Double, Double> converter = (unit, t) -> {
            return unit.equals("f") || unit.equals("F") ? 9 / 5 * t + 32 : 5 / 9 * t - 32;
        };
        System.out.println("Converted to " + toUnit + ": " + converter.apply(toUnit, temperature));
    }

    String readUnit() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the unit you want to convert to (F/C): ");
        return in.next();
    }

    double readTemperature() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter temperature: ");
        return in.nextDouble();
    }

    public static void main(String[] args) {
        new TemperatureConverter();
    }
}