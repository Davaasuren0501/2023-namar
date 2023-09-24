import java.util.Scanner;

public class FinancialApplication {
    public  FinancialApplication() {
        Scanner in = new Scanner(System.in);

        System.out.print("Loan Amount: ");
        double amount = Integer.parseInt(in.nextLine());
        System.out.print("Number of Years: ");
        int year = Integer.parseInt(in.nextLine());
        double total =amount;
        double interested_rate = 5;
//        System.out.printf( "%20s", "Interested Rate", "%20s", " Rate", "%20s", "Intetested");
        System.out.printf("%-20s%-20s%-20s\n","Interested Rate", "Monthly Payment", "Total Payment" );
        for (int i = 0; i< year*12; i++){
            System.out.printf("%-20.3f%s%-20.2f%-20.2f\n",interested_rate,"%", total/100*interested_rate, total/100*interested_rate + total );
//            System.out.printf( "%1.2f", interested_rate+ " %" + "%3.2f", total/100*interested_rate +  "%5.2f", total/100*interested_rate + total  );
            total+=total/100*interested_rate;
            interested_rate += 0.125;
        }

    }
    public static void main(String[] args) {
        new FinancialApplication();
    }
}
