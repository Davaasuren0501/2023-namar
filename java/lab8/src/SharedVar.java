public class SharedVar implements Runnable{

    static Integer sum = 0;

    public static Integer getSum() {
        return sum;
    }

    public synchronized void increase() {
        sum += 1;
    }

    @Override
    public void run() {
        increase();
    }
}
