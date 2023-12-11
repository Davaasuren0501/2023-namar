import java.util.Scanner;

public class SequenceArrayCreation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of n: ");
        int n = scanner.nextInt();

        if (n >= 1 && n <= 10000) {
            int[] sequenceArray = generateSequenceArray(n);
            System.out.println("Array containing the first " + n + " elements of the sequence:");
            printArray(sequenceArray);
        } else {
            System.out.println("Invalid input. Please enter a value of n between 1 and 10000.");
        }
    }

    static int[] generateSequenceArray(int n) {
        int[] sequenceArray = new int[n];
        sequenceArray[0] = 2;
        sequenceArray[1] = 3;
        sequenceArray[2] = 4;

        for (int i = 3; i < n; i++) {
            sequenceArray[i] = sequenceArray[i - 1] + sequenceArray[i - 3];
        }

        return sequenceArray;
    }

    static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
