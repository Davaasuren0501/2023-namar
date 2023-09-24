import java.util.Scanner;

public class ReadFileFromURL {
    public static void main(String[] args) {
        String URLString = "https://liveexample.pearsoncmg.com/data/Lincoln.txt";
        try {
            java.net.URL url = new java.net.URL(URLString);
            int count = 0;
            Scanner input = new Scanner(url.openStream());
            while (input.hasNext()) {
                input.next();
                count++;
            }
            System.out.println("word count = " + count );
        }
        catch (java.net.MalformedURLException ex) {
            System.out.println("aldaatai URL");
        }
        catch (java.io.IOException ex) {
            System.out.println("file undefined");
        }
    }
}
