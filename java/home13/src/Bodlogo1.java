import java.util.Scanner;

public class Bodlogo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number => ");
        int N = scanner.nextInt();

        int result = findSmallestNumber(N);

        System.out.println("The smallest natural number => " + result);
    }

    static int findSmallestNumber(int N) {
        if (N == 0) {
            return 10;
        }

        if (N == 1) {
            return 1;
        }
        for (int digit = 9; digit > 1; digit--) {
            while (N % digit == 0) {
                N /= digit;
                if (N > 1e9) {
                    return -1;
                }
            }
        }
        if (N > 1) {
            return -1;
        }

        int result = 0;
        for (int i = 9; i >= 2; i--) {
            while (N % i == 0) {
                result = result * 10 + i;
                N /= i;
            }
        }

        return reverseNumber(result);
    }

    static int reverseNumber(int num) {
        int reversed = 0;
        while (num != 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }
        return reversed;
    }
}
