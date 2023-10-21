import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountKeywords {
    public void ReadFile( File file) throws IOException {
        Map<String, Integer> map = new TreeMap<>();
        Scanner input = new Scanner(file);
        String line;
        while ((line = input.nextLine()) != null) {
            String[] words = line.split("\\s+|\\p{P}");

            for (String word : words) {
                if (!word.isEmpty()) {
                    String key = word.toLowerCase();
                    map.put(key, map.getOrDefault(key, 0) + 1);
                }
            }
        }
        input.close();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Word: " + entry.getKey() + ", Count: " + entry.getValue());
        }
    }
    public  CountKeywords() {
        File file = new File("source.txt");
        try {
            ReadFile(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        new CountKeywords();
    }
}
