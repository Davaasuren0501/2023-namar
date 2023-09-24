import java.util.Scanner;

public class FileWriter {

    public static  void ReadFile( java.io.File file) throws java.io.IOException {
        Scanner input = new Scanner(file);
        while (input.hasNext()) {
            String string = input.next();
            System.out.println( "\nstring length " + string.length() );
        }
        input.close();
    }
    public static  void ReadFileAndFirstChatT( java.io.File file) throws java.io.IOException {
        Scanner input = new Scanner(file);
        while (input.hasNext()) {
            String string = input.next();
            if( string.startsWith("T") ) {
                System.out.println( "\nFirst char == t string -> " + string );
            }
        }
        input.close();
    }

    public static void main(String[] args) throws java.io.IOException {
        java.io.File file = new java.io.File("fileWriter.txt");
        if (file.exists()) {
            System.out.println("File already exists");
        } else {
            System.out.println("File created");
        }

        System.out.println(file.getAbsolutePath());
        java.io.PrintWriter output = new java.io.PrintWriter(file);
        System.out.println("File ruu write hiih string oruulna uu: ");
        Scanner input = new Scanner(System.in);
        String  a = input.nextLine();
        output.print( a );
        input.close();
        output.close();
        ReadFile(file);
        ReadFileAndFirstChatT( file );
    }
}
