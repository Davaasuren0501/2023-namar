import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class CubeInfo {
    public static void main(String[] args) {
        // Create and write Cube objects to a binary file
        List<Cube> cubes = new ArrayList<>();
        cubes.add(new Cube(5.0, "red", "wood"));
        cubes.add(new Cube(4.0, "yellow", "wood"));
        cubes.add(new Cube(6.0, "green", "metal"));
        cubes.add(new Cube(5.0, "blue", "wood"));
        cubes.add(new Cube(4.5, "yellow", "cardboard"));

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("cubes.dat"))) {
            for (Cube cube : cubes) {
                outputStream.writeObject(cube);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Read the binary file and perform queries
        List<Cube> readCubes = new ArrayList<>();
        Map<String, Integer> colorCounts = new HashMap<>();
        double maxSize = 0.0;

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("cubes.dat"))){
            while (true) {
                Cube cube = (Cube) inputStream.readObject();
                readCubes.add(cube);

                // Calculate the number of cubes for each color
                colorCounts.put(cube.getColor(), colorCounts.getOrDefault(cube.getColor(), 0) + 1);

                // Find the largest cube
                maxSize = Math.max(maxSize, cube.getSize());
            }
        } catch (EOFException e) {
            // End of file reached
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Query results
        System.out.println("Cubes of each color:");
        for (Map.Entry<String, Integer> entry : colorCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        double edgeLengthM = 5.0; // Change this to your desired edge length
        System.out.println("\nWooden cubes with edge length " + edgeLengthM + " cm:");
        for (Cube cube : readCubes) {
            if (cube.getMaterial().equals("wood") && cube.getSize() == edgeLengthM) {
                System.out.println("Color: " + cube.getColor());
            }
        }

        System.out.println("\nThe largest number of colored cubes: " + maxSize);
    }
}