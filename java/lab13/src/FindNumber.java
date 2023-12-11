import java.util.Optional;
import java.util.OptionalLong;

public class FindNumber {
    public static void main(String[] args) {
        String inputString = "sjkhfjk790sfhskj33";
        OptionalLong creatednumber = inputString.chars()
                                    .filter(Character::isDigit)
                                    .mapToLong(Character::getNumericValue)
                                    .reduce((a, b) -> a * 10 + b);;

        creatednumber.ifPresent(number -> System.out.println("Extracted number: " + number));
    }
}
