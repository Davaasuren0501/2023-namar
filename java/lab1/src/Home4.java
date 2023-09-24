import java.util.Scanner;

public class Home4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Discount rates
        double discount5to9Tickets = 0.05;
        double discount10PlusTickets = 0.10;

        System.out.println("Tanhim bolon kino uzeh huviar ");
        System.out.println("1. Ulaan");
        System.out.println("    1. 12 tsag une: 2500$");
        System.out.println("    2. 16 tsag une: 3500$");
        System.out.println("    3. 20 tsag une: 4500$");
        System.out.println("2. Huh");
        System.out.println("    1. 10 tsag une: 2500$");
        System.out.println("    2. 13 tsag une: 3500$");
        System.out.println("3. Nogoon");
        System.out.println("    1. 10 tsag une: 3500$");
        System.out.println("    2. 14 tsag une: 4500$");
        System.out.println("    3. 18 tsag une: 4500$");
        System.out.print("ta uzeh tanhimaa songono uu: ");
        int tanhim = scanner.nextInt();
        System.out.print("ta uzweriin tsagaa songono uu: ");
        int tsag = scanner.nextInt();

        int price = 0;

        switch (tanhim) {
            case 1:
                switch (tsag) {
                    case 1:
                        price = 2500;
                        break;
                    case 2:
                        price = 3500;
                        break;
                    case 3:
                        price = 4500;
                        break;
                    default:
                        System.out.println("Uzveriin tsagaa buruu oruulsan baina.");
                        return;
                }
                break;
            case 2:
                switch (tsag) {
                    case 1:
                        price = 2500;
                        break;
                    case 2:
                        price = 3500;
                        break;
                    default:
                        System.out.println("Uzveriin tsagaa buruu oruulsan baina.");
                        return;
                }
                break;
            case 3:
                switch (tsag) {
                    case 1:
                        price = 3500;
                        break;
                    case 2:
                        price = 4500;
                        break;
                    case 3:
                        price = 4500;
                        break;
                    default:
                        System.out.println("Uzveriin tsagaa buruu oruulsan baina.");
                        return;
                }
                break;
            default:
                System.out.println("Buruu tanhim songoson baina");
                return;
        }

        System.out.print("Zahialah tasalbariin too: ");
        int ticket = scanner.nextInt();

        if (ticket >= 5 && ticket <= 9) {
            price = price - price / 100 *5;
        } else {
            if (ticket >= 10) {
                price = price - price / 100 *10;
            }
        }

        System.out.println("Tanii niit toloh tulber  " + price * ticket + "$");

    }
}
