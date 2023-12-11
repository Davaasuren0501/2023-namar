import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrimeOrNotPrime {

    Prime prime;
    NotPrime prime2;
    General2 gen2, gen22;
    Thread tr1, tr2;
    public  PrimeOrNotPrime(){
//        prime=new Prime(14,100, "tr1");
//        prime2=new NotPrime(150,1000, "tr2");
        tr1=new Thread(prime);
        tr2=new Thread(prime2);
        gen2 = new General2(14,100, "tr: 1" , true);
        gen22 = new General2(150,1000, "tr: 2" , false);
        tr1=new Thread(gen2);
        tr2=new Thread(gen22);

        tr1.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        tr2.start();

//        ExecutorService executor = Executors.newFixedThreadPool(2);
//        executor.submit(prime);
//        executor.submit(prime2);
//        executor.shutdown();
//        tr1=new Thread(prime);
//        tr2=new Thread(prime2);
//        tr1.start();
//        tr2.start();
    }
    public static void main(String[] args) {
//        Prime prime =new Prime(2,50);
//        System.out.println( prime.isPrime(51));
        new PrimeOrNotPrime();
    }
}
