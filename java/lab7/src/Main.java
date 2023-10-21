import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Random;


public class Main {
    public static void main(String[] args) {
        int numbersofList = 5000000;
        List<Integer> list = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < numbersofList; i++) {
            list.add(rand.nextInt());
        }

        long time_start = System.nanoTime();

        for (int i = 0; i < numbersofList; i++) {
//            System.out.println(list.get(i));
        }
        System.out.println("For loop time is = " + (System.nanoTime() - time_start));
        time_start = System.nanoTime();
        Iterator<Integer> list_iterator = list.iterator();

//        for (int i = 0; i < numbersofList; i++) {
////            System.out.println(list.get(i));
//        }
        while(list_iterator.hasNext()) {
            Integer i = list_iterator.next();
        }
        System.out.println("Iterator loop time is = " + (System.nanoTime() - time_start));
    }
}