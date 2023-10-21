import java.io.*;

public class CopyFile {
    public static void main(String[] args) {
        String[] inputFiles = {"f1.txt", "f2.txt", "f3.txt", "f4.txt", "f5.txt"};
        String outputFile = "output.txt";

        try (FileOutputStream outputStream = new FileOutputStream(outputFile)) {
            for (String inputFile : inputFiles) {
                try (FileInputStream inputStream = new FileInputStream(inputFile)) {
                    int byteRead;
                    double sum = 0;
                    int count = 0;
                    while ((byteRead = inputStream.read()) != -1) {
                        sum += byteRead;
                        count++;
                    }

                    if (count > 0) {
                        double average = sum / count;
                        outputStream.write((Double.toString(average) + "\n").getBytes());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
