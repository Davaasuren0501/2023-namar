// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    static int a,b;
    public  Main() {

    }
    public static void main(String[] args) {

        if( args.length != 2) {
            System.out.println("Orolt buruu");
            System.out.println(args);
            System.exit(1);
        }
        a= Integer.parseInt(args[0]);
        b= Integer.parseInt(args[1]);

        System.out.print( a + " " + b );
        System.out.print( "\nsum= " + (a + b) );
    }
}