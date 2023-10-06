import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class ArrayIndexOutOfBoundsException extends Throwable {
    int[] array = new int[100];

    public ArrayIndexOutOfBoundsException(){
        RandomInteger();
        InputIndex();
    }
    public void RandomInteger() {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            array[i] = random.nextInt(1000);
        }
    }
    public void InputIndex() {
        Scanner in = new Scanner(System.in);
        System.out.print("Massiviin index oruul: ");
        try {
            int indexArray = in.nextInt();
            System.out.println("Tanii songoson index dexi elementiin utga = " +  array[indexArray]);
        } catch (java.lang.ArrayIndexOutOfBoundsException | InputMismatchException ex ){
            System.out.println(ex.toString());
        }

    }
    public static void main(String[] args) {
        ArrayIndexOutOfBoundsException arrayIndex = new ArrayIndexOutOfBoundsException();
    }

}
