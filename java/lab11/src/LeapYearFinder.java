import java.util.Scanner;
import java.util.function.Function;

public class LeapYearFinder {
    public LeapYearFinder() {
        int year = readInput();
        Function<Integer, Integer> f = yr -> {
            return yr % 4 == 0 ? 366 : 365;
        };
        System.out.println("Number of years in the year " + year + ": " + f.apply(year));
    }

    int readInput() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a year: ");
        return in.nextInt();
    }

    public static void main(String[] args) {
        new LeapYearFinder();
    }
}