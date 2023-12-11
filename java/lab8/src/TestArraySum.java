import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestArraySum {

    public  TestArraySum() {
        int countThread = 4;
        int oneTheatNumber = SumArrayElement.array.length / countThread;

        Thread[] threads = new Thread[countThread];
        SumArrayElement[] tasks = new SumArrayElement[countThread];

        for( int i = 0; i < countThread; i++ ) {
            int start = i * oneTheatNumber;
            int end=0;

            if(i == countThread - 1) {
                end=  SumArrayElement.array.length;
            } else {
                end = (i + 1) * oneTheatNumber;
            }

            tasks[i] = new SumArrayElement( start, end);
            threads[i] = new Thread(tasks[i]);
            threads[i].start();
        }

        int sum = 0;

        for (int i = 0; i < countThread; i++) {
            try {
                threads[i].join();
                sum += tasks[i].getSum();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Sum: " + sum);
    }
    public static void main(String[] args) {
        new TestArraySum();
    }
}
