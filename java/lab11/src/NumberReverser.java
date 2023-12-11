import java.util.Scanner;

public class NumberReverser {
    @FunctionalInterface
    interface Reversable {
        int reverse(int a);
    }

    public NumberReverser() {
        int input = readInput();
        Reversable r = num -> {
            String stringNum = Integer.toString(num);
            String reversedNum = new StringBuilder(stringNum).reverse().toString();
            return Integer.parseInt(reversedNum);
        };
        System.out.println("Reversed number: " + r.reverse(input));
    }

    int readInput() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a number to reverse: ");
        return in.nextInt();
    }

    public static void main(String[] args) {
        new NumberReverser();
    }
}