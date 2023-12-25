import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Bodlogo2 {
    private Set<String> wordsFile = new HashSet<>();

    public Bodlogo2() {
        try {
            readData("https://example-files.online-convert.com/document/txt/example.txt");
            System.out.println(wordsFile);
            String[] sentencesToCheck = {
                    "Text of Example content: Wikipedia (https://en.wikipedia.org/wiki/John_Doe)"
                    , "John Doe is sometimes used to refer to a typical male in other contexts as well"
                    , "Doe, along with a fictional address or other fictional information to provide an example of how to fill in the form"
                    , "The name John Doe."
                    , "My name Davaasuren."
            };

            for (String sentence : sentencesToCheck) {
                System.out.println("\"" + sentence + "\"=> ug oguulber ni text file aas " + (checkCreateSentence(sentence) ? "uusej bolno" : "uusej bolohgui "));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Bodlogo2();
    }

    public void readData(String path) throws IOException {
        URL url = new URL(path);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split(" ");
                for (String word : words) {
                    wordsFile.add(word);
                }
            }
        }
    }


    public boolean checkCreateSentence(String sentence) {
        String[] words = sentence.split(" ");
        int index = 0;
        for (String word : words) {
//            System.out.println(word);
            boolean found = false;
            while (index < sentence.length()) {
                if (wordsFile.contains(word)) {
                    found = true;
//                    System.out.println("founded");
                    break;
                }
                index++;
            }
//            System.out.println(found);
            if (!found) {
                return false;
            }
        }
        return true;
    }
}
