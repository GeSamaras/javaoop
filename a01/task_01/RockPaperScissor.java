import java.util.Random;
import java.util.Scanner;

public class RockPaperScissor {

    public void play() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in); 
        Random random = new Random();
        String[] choices = {"rock", "scissor", "paper"}; // using array lists for cleaner reading
        
        int userScore = 0;
        int avatarScore = 0;

        System.out.println("Welcome to a game of rock ✊, scissor ✂, paper ✋!");
        System.out.println("You will play against Marvin and we keep score.");

        // starts the game loop
        // user gets to enter one of the options, which is paired to the String[] choices
        // after that, the pc's choice is randomly generated and compared with the user's
        // game logic sees who's the winner, and then adds 1 to their respective score
        while (true) {
            System.out.println("\nScore: You " + userScore + " - Marvin " + avatarScore);
            System.out.print("Select rock ✊ [r], scissor ✂ [s], paper ✋ [p] or quit [q]: ");
            String userInput = scanner.nextLine().toLowerCase(); // makes every choice case-insensitive

            if (userInput.equals("q")) {
                System.out.println("Exiting game. Final score: You " + userScore + " - Marvin " + avatarScore);
                break;
            }

            // interface for the user's choices
            String userChoice = switch (userInput) {
                // arrow operator instead of case 'x', break statements
                case "r" -> "rock";
                case "s" -> "scissor";
                case "p" -> "paper";
                default -> null; // error handling for bad inputs
            };

            if (userChoice == null) {
                System.out.println("Invalid input! Please enter 'r', 's', 'p', or 'q'.");
                continue;
            }

            // rolls a random int for the oponent
            // gets the index of the list 1-3 and parses back to string
            String avatarChoice = choices[random.nextInt(3)];

            System.out.println("You did " + userChoice + " and Marvin did " + avatarChoice + ".");

            
            if (userChoice.equals(avatarChoice)) {
                System.out.println("You are equal! No points!");
            } else if ((userChoice.equals("rock") && avatarChoice.equals("scissor")) ||
                       (userChoice.equals("scissor") && avatarChoice.equals("paper")) ||
                       (userChoice.equals("paper") && avatarChoice.equals("rock"))) {
                System.out.println("You win this round!");
                userScore++;
            } else {
                System.out.println(avatarChoice + " beats " + userChoice + ", Marvin wins 1 point!");
                avatarScore++;
            }
        }
    }
}
