import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
public class SortStringByLength {
    public static void main(String[] args) {
        String[] cities = {};
        List<String> list = Arrays.asList("Atlanta", "Savannah", "New York", "Dallas");
        List<String> SortedList = list.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
        SortedList.forEach(System.out::println);
    }
}