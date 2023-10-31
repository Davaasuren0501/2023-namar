import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Analyze {

    public  Analyze(){
        List<Icecream> listicecream = new ArrayList<>();
        listicecream.add(new Icecream("2023-10-01", "Vanilla", "With_Cherries", "Without_Cherries"));
        listicecream.add(new Icecream("2023-10-01", "Chocolate", "Without_Cherries", "With_Nuts"));
        listicecream.add(new Icecream("2023-10-03", "Vanilla", "With_Cherries", "Without_Nuts"));
        listicecream.add(new Icecream("2023-10-03", "Vanilla", "With_Cherries", "Without_Nuts"));
        listicecream.add(new Icecream("2023-10-03", "Vanilla", "With_Cherries", "Without_Nuts"));
        listicecream.add(new Icecream("2023-10-03", "Strawberry", "With_Cherries", "Without_Nuts"));
        String highSaleDate = GetHighSaleDate(listicecream);
        GetHighFlavor(listicecream, highSaleDate);

    }

    public String GetHighSaleDate(List<Icecream> listicecream) {
        Map<String, Integer> sales = new HashMap<>();

        for (Icecream sale : listicecream) {
            String date = sale.getOrder_date();
            int hightCount = 1;

            if (sales.containsKey(date)) {
                hightCount += sales.get(date);
            }

            sales.put(date, hightCount);
        }

        String highDate = null;
        int hightCount = 0;

        for (Map.Entry<String, Integer> entry : sales.entrySet()) {
            if (entry.getValue() > hightCount) {
                highDate = entry.getKey();
                hightCount = entry.getValue();
            }
        }

        System.out.println("Highest sales Date: " + highDate);
        System.out.println("Highest Date sale count: " + hightCount);
        return highDate;
    }

    public void GetHighFlavor(List<Icecream> listicecream, String dateHigh){
        Map<String, Integer> sales = new HashMap<>();
        for (Icecream sale : listicecream) {
            if (sale.getOrder_date().equals(dateHigh)) {
                int hightCount = 1;
                String flavor = sale.getFlavor();
                if(sales.containsKey(flavor)){
                    hightCount += sales.get(flavor);
                }
                sales.put(flavor, hightCount);
            }
        }
        String mostFlavor = null;
        int countD = 0;

        for (Map.Entry<String, Integer> entry : sales.entrySet()) {
            if (entry.getValue() > countD) {
                mostFlavor = entry.getKey();
                countD = entry.getValue();
            }
        }

        System.out.println("Most sales flavor = " +mostFlavor);

    }
    public static void main(String[] args) {
        new Analyze();
    }
}
