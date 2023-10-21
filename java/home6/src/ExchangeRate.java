import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExchangeRate {
    public static void main(String[] args) {
        String filePath = "exchange_rate.txt";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] columns = line.split("\t");

                if (columns.length >= 3) {
                    String bankName = columns[0];
                    double cashBuyRate = Double.parseDouble(columns[1]);
                    double nonCashBuyRate = Double.parseDouble(columns[2]);

                    double rateChange = nonCashBuyRate - cashBuyRate;

                    System.out.println("Bank: " + bankName);
                    System.out.println("Rate Change: " + rateChange);
                    System.out.println();
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
