// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class NotPrime extends General implements Runnable{

    public NotPrime(int a, int b, String name) {
        super(a, b, name);
    }

    @Override
    public void run() {
        for(int ind=a; ind<=b;ind++){
            if( !super.isPrime(ind)) {
                System.out.println( name + "not prime number = " + ind );
            }
        }
    }
}