import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestPooled {

//    SharedVar sharedValue;
    public  TestPooled(){
//        sharedValue = new SharedVar();
//        ExecutorService executor = Executors.newCachedThreadPool();
////        ExecutorService executor = Executors.newFixedThreadPool(2);
//        executor.submit(sharedValue);
//        System.out.println(SharedVar.getSum());
//        executor.submit(sharedValue);
//        System.out.println(SharedVar.getSum());
//        executor.submit(sharedValue);
//        System.out.println(SharedVar.getSum());
//        executor.shutdown();

        int countThread = 1;
        Thread[] threads = new Thread[countThread];

        for (int i = 0; i < countThread; i++) {
            threads[i] = new Thread(new SharedVar());
            threads[i].start();
        }

        try {
            for (int i = 0; i < countThread; i++) {
                threads[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(SharedVar.getSum());
    }
    public static void main(String[] args) {
        new TestPooled();
    }
}
