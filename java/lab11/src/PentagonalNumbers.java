public class PentagonalNumbers {
    @FunctionalInterface
    interface PentagonalGeneratable {
        int generatePentagonal(int n);
    }

    public PentagonalNumbers() {
        PentagonalGeneratable p = n -> (n * (3 * n - 1)) / 2;
        for (int i = 1; i <= 100; i++) {
            System.out.printf("%7d", p.generatePentagonal(i));
            if (i % 10 == 0) System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        new PentagonalNumbers();
    }
}
