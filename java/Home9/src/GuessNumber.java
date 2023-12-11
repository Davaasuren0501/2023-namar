import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GuessNumber {

    private static final int MAX_NUMBER = 100;
    private static int targetNumber;
    private static boolean numberGuessed = false;

    public static void main(String[] args) {
        targetNumber = new Random().nextInt(MAX_NUMBER);
        List<Thread> threads = new ArrayList<>();

        for (int i = 1; i <= 3; i++) { // Three trades in this example
            Thread tradeThread = new Thread(new Trade(i));
            threads.add(tradeThread);
            tradeThread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Game over! Target number was: " + targetNumber);
    }

    static class Trade implements Runnable {
        private final int tradeNumber;
        private List<Integer> guesses = new ArrayList<>();

        public Trade(int tradeNumber) {
            this.tradeNumber = tradeNumber;
        }

        @Override
        public void run() {
            int attempts = 0;

            while (!numberGuessed) {
                int guess = new Random().nextInt(MAX_NUMBER);
                attempts++;

                guesses.add(guess);

                if (guess == targetNumber) {
                    numberGuessed = true;
                    System.out.println("Trade " + tradeNumber + ": " +
                            formatGuesses() + " guesses were not guessed and guessed " +
                            attempts + " times.");
                } else {
                    System.out.println("Trade " + tradeNumber + ": " +
                            formatGuesses() + "did not guess and made " +
                            attempts + " attempts to guess.");
                    try {
                        Thread.sleep(100); // Simulating some processing time before the next attempt
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        private String formatGuesses() {
            return guesses.toString();
        }
    }
}
