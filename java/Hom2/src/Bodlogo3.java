import java.io.File;
import java.io.IOException;

public class Bodlogo3 {
    public static void main(String[] args) {
        String filePath = "matrix.txt"; // Replace with the desired file path

        int[][] matrix = {
                {14, -2, 3},
                {4, 10, 6},
                {20, 8,0}
        };

        try {
            File file = new File(filePath);
            java.io.PrintWriter output = new java.io.PrintWriter(file);

            // Iterate through the matrix and write each element to the file
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    output.print(matrix[i][j]+" ");
                }
                output.println();
            }

            output.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
