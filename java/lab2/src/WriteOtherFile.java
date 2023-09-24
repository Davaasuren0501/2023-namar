import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class WriteOtherFile {

    public static void main(String[] args) throws java.io.IOException {
        java.io.File fileRead = new java.io.File("readFile.txt");
        java.io.File fileWrite = new java.io.File("writeFile.txt");
        if (fileRead.exists() && fileWrite.exists()) {
            System.out.println("File already exists");
        } else {
            System.out.println("File created");
        }

        System.out.println(fileRead.getAbsolutePath());
        java.io.PrintWriter output = new java.io.PrintWriter(fileRead);
        output.println("i love you");
        output.println("i hate you");
        output.println("i can it");
        output.println("i can't it");
        output.close();
        Scanner input = new Scanner(fileRead);
        java.io.PrintWriter outputWrite = new java.io.PrintWriter(fileWrite);
        ArrayList<String> arrayString = new ArrayList<>();
        while (input.hasNext()) {
            String string = input.nextLine();
            System.out.println( "\nstring " + string );
            arrayString.add(string);
            outputWrite.println(string);
        }
        outputWrite.close();;
        input.close();
        WriteReverse( arrayString);

    }

    private static void WriteReverse(ArrayList<String> arrayString) throws java.io.IOException {
        java.io.File fileWrite = new java.io.File("writeFile2.txt");
        if (fileWrite.exists() ) {
            System.out.println("File already exists");
        } else {
            System.out.println("File created");
        }
        java.io.PrintWriter outputWrite = new java.io.PrintWriter(fileWrite);
        Collections.reverse(arrayString);
        for( String element: arrayString){
            System.out.println( element );
            outputWrite.println( element );
        }
        outputWrite.close();
    }
}
