import java.util.*;

public class Store {

    // Create a HashMap to store buyer and item information.
    Map<String, Map<String, Integer>> buyerData = new HashMap<>();

    public void Input() {
        Scanner scanner = new Scanner(System.in);

        // Task No. 1: Create a list of buyers and find out what goods they bought and how many units.
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                break;
            }

            String[] parts = line.split(" ");
            if (parts.length == 3) {
                String buyer = parts[0];
                String item = parts[1];
                int quantity = Integer.parseInt(parts[2]);

                buyerData.putIfAbsent(buyer, new HashMap<>());
                buyerData.get(buyer).merge(item, quantity, Integer::sum);
            }
        }
    }

    public void Output() {

        // Task No. 1: Sort buyers by name and print their purchases.
        TreeMap<String, Map<String, Integer>> sortedBuyers = new TreeMap<>(buyerData);
        for (Map.Entry<String, Map<String, Integer>> entry : sortedBuyers.entrySet()) {
            System.out.print(entry.getKey() + ": ");
            Map<String, Integer> purchases = entry.getValue();
            for (Map.Entry<String, Integer> purchase : purchases.entrySet()) {
                System.out.print(purchase.getKey() + " " + purchase.getValue() + " ");
            }
            System.out.println();
        }

        // Task No. 2: Print the order by item name and quantity.
        for (Map.Entry<String, Map<String, Integer>> entry : sortedBuyers.entrySet()) {
            Map<String, Integer> purchases = entry.getValue();
            for (Map.Entry<String, Integer> purchase : purchases.entrySet()) {
                System.out.println(entry.getKey() + " " + purchase.getKey() + " " + purchase.getValue());
            }
        }
    }

    public Store() {
        Input();
        Output();
    }
    public static void main(String[] args) {
        new Store();
    }
}
