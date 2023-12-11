public class SumArrayElement implements  Runnable{
//    int[] arr;
    static  int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int start_index;
    int end_index;
    int array_sum;

    public SumArrayElement( int start, int end) {
        this.start_index = start;
        this.end_index = end;
    }

    public int getSum() {
        return array_sum;
    }
    @Override
    public void run() {
        array_sum = 0;
        for (int i = start_index; i < end_index; i++) {
            array_sum += array[i];
        }
    }
}
