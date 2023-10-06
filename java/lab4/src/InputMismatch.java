import java.util.InputMismatchException;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class InputMismatch {
    int a,b;
    public InputMismatch(){
        input();
    }
    public void input() {
        Scanner in = new Scanner(System.in);
        System.out.println("2 too oruul: ");
        try {
            a=in.nextInt();
            b= in.nextInt();
        } catch (InputMismatchException ex ){
            System.out.println(ex.toString());
        }
        System.out.println("niilber = " + (a+b));
    }
    public static void main(String[] args) {
        InputMismatch inputMismatch = new InputMismatch();
    }
}