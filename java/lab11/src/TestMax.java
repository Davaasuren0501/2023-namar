public class TestMax {
    @FunctionalInterface
    interface MaxFindable {
        int max(int a, int b);
    }

    public TestMax() {
        MaxFindable max = (a, b) -> {
            if (a > b) return a;
            else return b;
        };
        System.out.println(max.max(123, 28));
    }

    public static void main(String[] args) {
        new TestMax();
    }
}