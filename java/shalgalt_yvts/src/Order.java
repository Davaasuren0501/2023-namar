import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDateTime;

public class Order implements Serializable {

    public Order() {
        Input();
    }
    public void Input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ta zahialgiin medeelel harah bol 1 zahialga ogoh bol 2  une boduulah bol 3 gsen uidliig songono uu: ");
        int operation = scanner.nextInt();
        if(operation == 1) {
            Icecream lastorder = Restore();
            if( lastorder == null ) {
                System.out.println( "Error opening data file" );
            } else {
                System.out.println( "last order" );
                System.out.println( lastorder.toString() );
            }
        } else {
            if( operation ==2 ) {
                InputIceCream(2);
//                CreateOrder();
            } else {
                if (operation == 3) {
                    InputIceCream(3);
//                    CalculateCost(3);
                } else {
                    System.out.println("Buruu uildel songoson baina ");
                }
            }
        }
        scanner.close();
    }

    private Icecream Restore() {
        List<Icecream> icecreams = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("icecream.dat"))) {
            icecreams = (List<Icecream>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        Icecream lastobject = null;
        for (Icecream icecream : icecreams) {
            lastobject = icecream;
        }
        return  lastobject;
    }

    public  void CalculateCost(Icecream ice_c) {
        double total=2.25 +2.25;

        if( ice_c.getStatus_cherries().equals("With_Cherries")) {
            total += 0.5;
        }

        if( ice_c.getStatus_nuts().equals("With_Nuts")) {
            total += 0.5;
        }


        System.out.println("tanii une = " + total);
        System.out.println("NOAT = 6%");
        total += total /100 *6;
        System.out.println("tanii niit une = " + total);
        System.out.println("tanii zahialga ogoh uu? tiim bol 1 ugui bol 2  " );
        Scanner scanner = new Scanner(System.in);
        int is_save = scanner.nextInt();

        if(is_save == 1) {
            List<Icecream> ice_c2 = new ArrayList<>();
            ice_c2.add(ice_c);
            CreateOrder(ice_c2);
        } else {
            if(is_save == 2) {
                System.out.println("une boduulsand bayrlalaa" );
            }else {
                System.out.println( "Buruu uilder songoson baina " );
            }
        }

    }

    public void InputIceCream( int op) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ta zairmagnii amtaa songono uu? vanilla bol 1,chocolate bol 2 , strawberry bol 3 : ");
        int flavor = scanner.nextInt();
        System.out.println("ta nemelteer samar nemuuleh uu ? tiim bol 1,ugui bol bol 2  : ");
        int nuts = scanner.nextInt();
        System.out.println("ta nemelteer intoor nemuuleh uu ? tiim bol 1,ugui bol bol 2  : ");
        int cherry = scanner.nextInt();
        String order_flavor = null;
        String order_nurts = null;
        String order_cherry = null;
        if( flavor ==1) {
            order_flavor = "vanilla";
        } else {
            if( flavor ==2) {
                order_flavor = "chocolate";
            } else {
                if(flavor ==3) {
                    order_flavor = "strawberry";
                } else {
                    System.out.println( "Buruu zairmagnii amt songoson baina " );
                }
            }
        }

        if(nuts == 1) {
            order_nurts = "With_Nuts";
        } else {
            if(nuts == 2) {
                order_nurts = "Without_Nuts";
            }else {
                System.out.println( "Buruu uilder songoson baina " );
            }
        }

        if(cherry == 1) {
            order_cherry = "With_Cherries";
        } else {
            if(cherry == 2) {
                order_cherry = "Without_Cherries";
            }else {
                System.out.println( "Buruu uilder songoson baina " );
            }
        }

        if(order_flavor != null && order_nurts != null && order_cherry != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String formattedDate = LocalDateTime.now().format(formatter);
            Icecream ice_c2 = new Icecream(formattedDate,order_flavor, order_cherry, order_nurts);
            if(op==3) {
                CalculateCost(ice_c2);
            } else {
                List<Icecream> ice_c = new ArrayList<>();
                ice_c.add(ice_c2);
                CreateOrder(ice_c);
            }
        } else {
            System.out.println( "Zahialgiin orts dutuu baina " );
        }
        scanner.close();
    }

    public  void CreateOrder(List<Icecream> ice_c) {
        try (ObjectOutputStream outC = new ObjectOutputStream(new FileOutputStream("icecream.dat"))) {
            outC.writeObject(ice_c);
            System.out.println("Zahialgiig amjilttai hadgallaa. Ta zahialgiin medeellee harah bol 1 ugui bol 2");
            Scanner scanner = new Scanner(System.in);
            int uilder = scanner.nextInt();
            if( uilder == 1) {
                Icecream lastorder = Restore();
                if( lastorder == null ) {
                    System.out.println( "Error opening data file" );
                } else {
                    System.out.println( "last order" );
                    System.out.println( lastorder.toString() );
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Order();
    }
}