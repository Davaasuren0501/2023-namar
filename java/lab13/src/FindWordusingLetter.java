
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
public class FindWordusingLetter {

        public static void main(String[] args) {
            List<String> listword = Arrays.asList("Davaa", "alim", "Suvdaa", "Alimaa", "Java");

            char searchLetter = 'i';

            Optional<String> firstWord = listword.stream()
                    .filter(word -> word.contains(String.valueOf(searchLetter)))
                    .findFirst();

            firstWord.ifPresentOrElse(
                    word -> System.out.println("First word -> " + word)
                    , () -> System.out.println("Word undefined ")
            );


            Optional<String> longword = listword.stream()
                    .reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2);

            longword.ifPresentOrElse(
                    word -> System.out.println("Long word: " + word)
                    , () -> System.out.println("Word undefined")
            );
        }

}
