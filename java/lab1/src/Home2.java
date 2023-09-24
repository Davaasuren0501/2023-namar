import java.util.Scanner;

public class Home2 {
    public Home2() {
    //            |
    //            |
    //  muj 2     | muj 1
    //  ------------------------
    //  muj 3     | muj 4
    //            |

        Scanner scanner = new Scanner(System.in);

        System.out.print("A tsegiin x coordinate oruul: ");
        double x = scanner.nextDouble();

        System.out.print("A tsegiin y coordinate oruul: ");
        double y = scanner.nextDouble();
        System.out.print("A tseg ni : ");
        if( x > 0 && y > 0 ) {
            System.out.println("Muj 1 haryalagdana");
        } else {
            if( x < 0 && y > 0 ) {
                System.out.println("Muj 2 haryalagdana");
            } else {
                if( x < 0 && y < 0 ) {
                    System.out.println("Muj 3 haryalagdana");
                } else {
                    if( x > 0 && y < 0 ) {
                        System.out.println("Muj 4 haryalagdana");
                    } else {
                        if (x == 0 && y == 0) {
                            System.out.println("Tov tseg");
                        }
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        new Home2();
    }
}
