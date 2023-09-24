import java.util.Scanner;

public class StudentMajorAndStatus {
    public StudentMajorAndStatus() {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter two char: ");

        String majorAndStatus = in.nextLine();

        if (majorAndStatus.length() == 2) {
            String[] majorChars = {"M", "C", "I"};
            String[] statusChars = {"1", "2", "3", "4"};

            if( isInclude(majorChars, majorAndStatus.substring(0, 1) ) && isInclude(statusChars, majorAndStatus.substring(1))) {

                System.out.println(getValue(majorAndStatus.substring(0, 1)) + " " + getValue(majorAndStatus.substring(1)) );
            }
        } else {
            System.out.println("Invalid input");
        }
    }
    public static boolean isInclude(String[] array, String value) {
        for (String element : array) {
            if (element.equals(value)) {
                return true;
            }
        }
        return false;
    }
    public static String getValue(String majorChar) {
        switch (majorChar) {
            case "M":
                return "Mathematics";
            case "C":
                return "Computer Science";
            case "I":
                return "Information Technology";
            case "1":
                return "freshman";
            case "2":
                return "sophomore";
            case "3":
                return "junior";
            case "4":
                return "senior";
            default:
                return "Unknown";
        }
    }
    public static void main(String[] args) {
        new StudentMajorAndStatus();
    }
}
