import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class BasketballPlayer {
    private String lastName;
    private String firstName;
    private String gender;
    private String ysUndes;
    private double bodyWeight;
    private Date dateOfBirth;
    private String teamName;
    private int playerNumber;
    private int totalPointsScored;
    private int totalGamesPlayed;

    private static final Random random = new Random();
    public BasketballPlayer () {
        // Define constraints for random values
        String[] lastNames = {"Smith", "Johnson", "Brown", "Davis", "Wilson"};
        String[] firstNames = {"John", "Jane", "Michael", "Emily", "David"};
        String[] genders = {"Male", "Female"};
        String[] ysUndesNer = {"Halh", "Oird", "Tsaatan", "Tuva", "Hotgoid"};
        double minBodyWeight = 60.0;
        double maxBodyWeight = 100.0;
        int minBirthYear = 1990;
        int maxBirthYear = 2000;
        int minPlayerNumber = 1;
        int maxPlayerNumber = 99;
        int minTotalPoints = 0;
        int maxTotalPoints = 1000;
        int minTotalGames = 0;
        int maxTotalGames = 81;

        // Generate random values
        this.lastName = lastNames[random.nextInt(lastNames.length)];
        this.firstName = firstNames[random.nextInt(firstNames.length)];
        this.ysUndes = ysUndesNer[random.nextInt(ysUndesNer.length)];
        this.gender = genders[random.nextInt(genders.length)];
        this.bodyWeight = minBodyWeight + (maxBodyWeight - minBodyWeight) * random.nextDouble();
        int birthYear = random.nextInt(maxBirthYear - minBirthYear + 1) + minBirthYear;
        int birthMonth = random.nextInt(12) + 1;
        int birthDay = random.nextInt(31) + 1;
        this.teamName = "Team One";
        this.playerNumber = random.nextInt(maxPlayerNumber - minPlayerNumber + 1) + minPlayerNumber;
        this.totalPointsScored = random.nextInt(maxTotalPoints - minTotalPoints + 1) + minTotalPoints;
        this.totalGamesPlayed = random.nextInt(maxTotalGames - minTotalGames + 1) + minTotalGames;

        this.dateOfBirth = new Date(birthYear - 1900, birthMonth - 1, birthDay);
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getTotalPointsScored() {
        return totalPointsScored;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public int getTotalGamesPlayed() {
        return totalGamesPlayed;
    }

    public static void main(String[] args) {
        BasketballPlayer[] players = new BasketballPlayer[10];
        for(int i=0;i<10;i++){
            BasketballPlayer basketballPlayer = new BasketballPlayer();
            players[i]=basketballPlayer;
        }
        System.out.println("150 deesh onoo avsan toglogchdiin ners: ");
        for (BasketballPlayer player : players) {
            if (player.getTotalPointsScored() > 150) {
                System.out.println(player.getFirstName() + " " + player.getLastName());
            }
        }
        System.out.println("Hamgiin zaluu bolon hogshin toglogch ner:");
        BasketballPlayer youngestPlayer = players[0];
        BasketballPlayer oldestPlayer = players[0];

        for (BasketballPlayer player : players) {
            if (player.getDateOfBirth().before(oldestPlayer.getDateOfBirth())) {
                oldestPlayer = player;
            }
            if (player.getDateOfBirth().after(youngestPlayer.getDateOfBirth())) {
                youngestPlayer = player;
            }
        }

        System.out.println("youngest player: " + youngestPlayer.getFirstName() + " " + youngestPlayer.getLastName());
        System.out.println("Oldest player: " + oldestPlayer.getFirstName() + " " + oldestPlayer.getLastName());
    }
}
