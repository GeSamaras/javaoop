import java.util.Scanner;

public class Menu {
    @SuppressWarnings("FieldMayBeFinal")
    private Scanner scanner;

    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        String choice;

        printMenu();
        while (true) { 
            choice = getChoice();
            if (choice.equalsIgnoreCase("q")) {
                break;
            }
            if (choice.equals("m")) {
                printMenu();
                break;
            }
            if (choice.equals("1")) {
                Fella.printFella();
            }
            if (choice.equals("2")) {
                Today.print();
            }
            if (choice.equals("3A")) {
                RockPaperScissor rpsGame = new RockPaperScissor();
                rpsGame.play();
                break;
            }
            if (choice.equals("3B")) {
                Dice die = new Dice(6);
                DiceGame21 diceGame = new DiceGame21(die);
                diceGame.play();
                break;
            }
            System.out.println("You entered: " + choice);
        }
    }

    private String getChoice() {
        System.out.println("Enter your choice: ");
        return scanner.nextLine();
    }

    // text block good :))
    public void printMenu() {
        String menuText = """
             -----------------
            | 1) Print my avatar
            | 2) Print today date/time
            | 3A) Rock, Paper, Scissor
            | 3B) Dice game 21
            | m) Print menu
            | qQ) Quit
             -----------------""";
        System.out.println(menuText);
    }

}