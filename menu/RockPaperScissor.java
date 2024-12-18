
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissor {
    String userChoice;
    String pcChoice;

    public void play() {
        Random random = new Random();

        String pick;
        System.out.println("Welcome to a game of rock ✊, scissor ✂, paper ✋!");

        pick = getPick();
    }

    public String getPick() {
        Scanner pickScanner = new Scanner(System.in);
        System.out.println("Enter your choice: ");
        return pickScanner.nextLine();
    }

    public void gameLogic() {
        int userScore = 0;
        int pcScore = 0;
        if (userChoice.equals("r")
        && (pcChoice.equals("s"))) {
            userScore +=1;
        } else if (userChoice.equals("r")
        && (pcChoice.equals("p"))) {
            pcScore++;
        }

        System.out.println("Score: You" + userScore + " - Marvin" + pcScore);
    }

    public int pcRandomRoll() {
        Random random = new Random();
        int randomRoll = random.nextInt(3) + 1;

        if (randomRoll == 1) {
        }
        return randomRoll;
    }

}