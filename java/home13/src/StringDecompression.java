import java.util.Scanner;

public class StringDecompression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the compressed string: ");
        String compressed = scanner.nextLine();

        String decompressed = decompressString(compressed);
        System.out.println("Decompressed string: " + decompressed);
    }

    static String decompressString(String compressed) {
        StringBuilder decompressed = new StringBuilder();
        int count = 0;

        for (char c : compressed.toCharArray()) {
            if (Character.isDigit(c)) {
                count = count * 10 + (c - '0');
            } else {
                for (int i = 0; i < count; i++) {
                    decompressed.append(c);
                }
                count = 0;
            }
        }

        return decompressed.toString();
    }
}
