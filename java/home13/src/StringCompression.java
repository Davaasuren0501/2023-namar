import java.util.Scanner;

public class StringCompression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the string to compress: ");
        String input = scanner.nextLine();

        String compressed = compressString(input);
        System.out.println("Compressed string: " + compressed);
    }

    static String compressString(String input) {
        StringBuilder compressed = new StringBuilder();
        int count = 1;

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                count++;
            } else {
                compressed.append(count).append(input.charAt(i - 1));
                count = 1;
            }
        }

        compressed.append(count).append(input.charAt(input.length() - 1));

        return compressed.toString();
    }
}
