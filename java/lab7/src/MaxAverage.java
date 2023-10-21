import java.util.Arrays;

public class MaxAverage {
    public static void main(String[] args) {
        double[] arr = {4, 3, 2, 6, 1, 7, 5};
        double result = maxAve(arr);
        System.out.println("Average: " + result);
    }

    public static double maxAve(double[] arr) {
        while (arr.length > 1) {
            Arrays.sort(arr);
            double index0 = arr[0];
            double index1 = arr[1];

            double average = (index0 + index1) / 2;

            arr = Arrays.copyOfRange(arr, 2, arr.length);
            arr = Arrays.copyOf(arr, arr.length + 1);
            arr[arr.length - 1] = average;
        }

        return arr[0];
    }
}
