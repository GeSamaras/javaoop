import java.util.Random;
import java.util.Scanner;

public class DiceGame21 {
    @SuppressWarnings("FieldMayBeFinal")
    private Dice dice;

    // points the "dice" object to this class' dice only
    // everytime dice is called, this is the reference to avoid errors
    public DiceGame21(Dice dice) {
        this.dice = dice;
    }

    @SuppressWarnings("ConvertToStringSwitch")
    public void play() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        @SuppressWarnings("unused")
        Random random = new Random();
        int userScore = 0, avatarScore = 0;

        System.out.println("Welcome to the Dice Game 21!");
        System.out.println("Roll the dice and try to get as close to 21 as possible without going over. Let's play!");

        while (true) {
            int playerTotal = 0;
            int avatarTotal = 0;

            // user's game loop
            // begins by asking if the user wants to roll, default 0
            // for every "y", calls the dice class method "roll"
            // "roll" returns an int from 1 to 6, that number is summed to playerTotal
            // if playerTotal is larger than 21, break out of the loop and give point
            // to the pc.
            System.out.println("\nYour turn:");
            while (true) {
                System.out.print("You have " + playerTotal + ". Roll another dice? (y/n): ");
                String userInput = scanner.nextLine().toLowerCase();

                if (userInput.equals("n")) {
                    break;
                } else if (userInput.equals("y")) {
                    int roll = dice.roll();
                    playerTotal += roll;
                    System.out.println("You rolled a " + roll + ". Your total is now " + playerTotal + ".");
                    if (playerTotal > 21) {
                        System.out.println("You went over 21! You lose this round.");
                        avatarScore++;
                        break;
                    }
                } else {
                    System.out.println("Invalid input! Please enter 'y' or 'n'.");
                }
            }

            if (playerTotal > 21) {
                continue;
            }

            System.out.println("\nMarvin's turn:");
            // Oponent will keep trying more rolls until it's at least on 17
            while (avatarTotal <= 17) {
                int roll = dice.roll();
                avatarTotal += roll;
                System.out.println("Marvin rolled a " + roll + ". Marvin's total is now " + avatarTotal + ".");
            }

            System.out.println("\nFinal Scores - You: " + playerTotal + " Marvin: " + avatarTotal);

            if (playerTotal > 21 || (avatarTotal <= 21 && avatarTotal >= playerTotal)) {
                System.out.println("Marvin wins this round!");
                avatarScore++;
            } else {
                System.out.println("You win this round!");
                userScore++;
            }

            System.out.println("Overall Score: You " + userScore + " - Marvin " + avatarScore);
            System.out.print("Play another round? (y/n): ");

            // loop conditional, if its anything other than "y", break.
            String continueInput = scanner.nextLine().toLowerCase();
            if (!continueInput.equals("y")) {
                break;
            }
        }

        System.out.println("Exiting game. Final score: You " + userScore + " - Marvin " + avatarScore);
    }
}
